package com.protalento.bean;


//implementado dependecias dentro de otra

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImplementaBeanConDependencia implements BeanConDependencia{
    Log LOGGER = LogFactory.getLog(ImplementaBeanConDependencia.class);
    private  Operacion operacion;

    public ImplementaBeanConDependencia(Operacion operacion) {
        this.operacion = operacion;
    }

    @Override
    public void resultadoSuma() {
        LOGGER.info("ingresaste al metodo resultadoSuma");
        int sum = 2;
        LOGGER.debug("numero enviado es" + sum);
        System.out.println("el resultado de la suma es "+ operacion.suma(sum));
    }
}
