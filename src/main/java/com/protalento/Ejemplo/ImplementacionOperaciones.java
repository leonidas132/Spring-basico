package com.protalento.Ejemplo;

public class ImplementacionOperaciones implements OpercionMatematica{


    @Override
    public int suma(int sum, int sum1) {
        int total= sum + sum1;
        return (total);
    }

    @Override
    public int resta(int r, int r1) {
        int total= r - r1;
        return total;
    }

    @Override
    public int multiplicar(int m, int m1) {
        int total= m * m1;
        return total;
    }
}
