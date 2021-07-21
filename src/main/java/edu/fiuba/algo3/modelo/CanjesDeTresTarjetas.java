package edu.fiuba.algo3.modelo;

public class CanjesDeTresTarjetas {

    private int cantidadDisponibleACanjear = 4;

    public int cantidadACanjear(ProximoCanje proximo){

        if(proximo.getProximo() < 3){
            cantidadDisponibleACanjear = cantidadDisponibleACanjear + 3*(proximo.getProximo() -1);
            proximo.pasarAProximo();
            return cantidadDisponibleACanjear;
        }
        return (this.canjearMasDe4veces(proximo));
    }

    private int canjearMasDe4veces(ProximoCanje proximo){
        cantidadDisponibleACanjear = (proximo.getProximo() -1)*5;
        proximo.pasarAProximo();
        return cantidadDisponibleACanjear;
    }
}
