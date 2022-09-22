package com.protalento.configuration;

import com.protalento.bean.MiBeanConProperties;
import com.protalento.bean.MyBeanPropertiesImplementacion;
import com.protalento.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conexion.properties") // para haceder a lo0s atributos de nuestro archivos properties
@EnableConfigurationProperties(UserPojo.class)//de esta manera habilitamos nuestra clase pojo
public class configuracionProperties {
    @Value("luis")
    private String name;

    @Value("rocha")
    private String apellido;

    @Value("{value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String url;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String clave;



    @Bean
    public MiBeanConProperties funcion(){
        return new MyBeanPropertiesImplementacion(name,apellido);
    }
    @Bean


    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(clave);
        return dataSourceBuilder.build();
    }


}
