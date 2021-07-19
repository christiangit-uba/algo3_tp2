package edu.fiuba.algo3.modelo;

public class MasDeTresCanjes implements Canje{
    private int cantidadDisponibleACanjear = 15;

    public int cantidadACanjear(int numeroCanjesRealizados){

        cantidadDisponibleACanjear = (numeroCanjesRealizados-1)*5;

        return cantidadDisponibleACanjear;

    }
}
