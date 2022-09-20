package com.protalento.bean;

public class MyBeanPropertiesImplementacion implements MiBeanConProperties{
    private String nombre;
    private String apellido;

    public MyBeanPropertiesImplementacion(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre +" - "+apellido;
    }
}
