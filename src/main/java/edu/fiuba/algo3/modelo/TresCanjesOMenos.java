package edu.fiuba.algo3.modelo;

public class TresCanjesOMenos implements Canje{

    private int cantidadDisponibleACanjear = 4;

    public int cantidadACanjear(int numeroCanjesRealizados){

        if(numeroCanjesRealizados <= 3){

            cantidadDisponibleACanjear = cantidadDisponibleACanjear + 3*(numeroCanjesRealizados-1);
            return cantidadDisponibleACanjear;
        }
        return ((new MasDeTresCanjes().cantidadACanjear(numeroCanjesRealizados)));
    }
}
