package com.protalento.configuration;

import com.protalento.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // le indica a spring que tendremos una configuracion adicional para nuestros bean
public class MyconfiguracionBean {


    @Bean
    public Mybeans beanOperation(){
        return new MybeanImplement2(); // selecionamos la implementacion que vamos a utilizar sin necesidad de hacer cambio en la logica
    }

    @Bean
    public Operacion operacionSum(){
        return new SumOperacion();
    }

    @Bean
    public BeanConDependencia sumImplemtacion(Operacion operacion){
        return new ImplementaBeanConDependencia(operacion);
    }

}
