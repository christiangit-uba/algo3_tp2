package edu.fiuba.algo3.modelo;

public class CanjesDeTresTarjetas {

    private int cantidadDisponibleACanjear = 4;

    public int cantidadACanjear(int numeroCanjesRealizados){

        if(numeroCanjesRealizados <= 3){
            cantidadDisponibleACanjear = cantidadDisponibleACanjear + 3*(numeroCanjesRealizados-1);
            return cantidadDisponibleACanjear;
        }
        return (this.canjearMasDe4veces(numeroCanjesRealizados));
    }

    private int canjearMasDe4veces(int numeroCanjesRealizados){
        cantidadDisponibleACanjear = (numeroCanjesRealizados-1)*5;
        return cantidadDisponibleACanjear;
    }
}
