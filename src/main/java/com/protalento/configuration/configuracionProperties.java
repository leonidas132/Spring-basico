package com.protalento.configuration;

import com.protalento.bean.MiBeanConProperties;
import com.protalento.bean.MyBeanPropertiesImplementacion;
import com.protalento.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)//de esta manera habilitamos nuestra clase pojo
public class configuracionProperties {
    @Value("{value.name}")
    private String name;

    @Value("{value.apellido}")
    private String apellido;

    @Value("{value.random}")
    private String random;

    @Bean
    public MiBeanConProperties funcion(){
        return new MyBeanPropertiesImplementacion(name,apellido);
    }
}
