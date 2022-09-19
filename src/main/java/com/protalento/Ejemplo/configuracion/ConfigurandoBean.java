package com.protalento.Ejemplo.configuracion;

import com.protalento.Ejemplo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurandoBean {

    @Bean
    public CRUD crud(OpercionMatematica OP){
        return new ImplementaCrud(OP);
    }

    @Bean
    public OpercionMatematica matematica(){
        return new ImplementacionOperaciones();
    }

    @Bean
    public TipoSaludo tipoSaludo(){
        return new IplementaSaludos();
    }
}
