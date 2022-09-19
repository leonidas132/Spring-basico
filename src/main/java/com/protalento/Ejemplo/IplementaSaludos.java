package com.protalento.Ejemplo;

public class IplementaSaludos implements TipoSaludo{



    @Override
    public void saludoLlegada() {
        System.out.println("Hola buenos dias ");
    }

    @Override
    public void saludoDespedida() {
        System.out.println("hasta luego que esten bien ");
    }
}
