package edu.fiuba.algo3.modelo;

public class MasDeTresCanjes implements Canje{
    private int cantidadDisponibleACanjear = 15;

    public int cantidadACanjear(int numeroCanjesRealizados){

        for(int i = 1; i < (numeroCanjesRealizados - 2);i++){

            cantidadDisponibleACanjear = cantidadDisponibleACanjear + 5;
        }

        return cantidadDisponibleACanjear;

    }
}
