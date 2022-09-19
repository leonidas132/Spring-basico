package com.protalento.Ejemplo;

public class ImplementaCrud implements CRUD{

    private OpercionMatematica matematica; //inyectando dependencia dentro de otra

    public ImplementaCrud(OpercionMatematica matematica) {
        this.matematica = matematica;
    }

    @Override
    public void guardar() {
        System.out.println("se guardo la suma " + matematica.suma(8,10));

    }

    @Override
    public void modificar() {
        System.out.println("se modifico la suma "+matematica.suma(10,10));

    }

    @Override
    public void eliminar() {
        System.out.println("se elimino la suma ");

    }
}
