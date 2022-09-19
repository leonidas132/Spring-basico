package com.protalento.bean;


//implementado dependecias dentro de otra

public class ImplementaBeanConDependencia implements BeanConDependencia{
    private  Operacion operacion;

    public ImplementaBeanConDependencia(Operacion operacion) {
        this.operacion = operacion;
    }

    @Override
    public void resultadoSuma() {
        int sum = 2;
        System.out.println("el resultado de la suma es "+ operacion.suma(sum));
    }
}
