package edu.fiuba.algo3.modelo;

public class ColorBlanco extends Colores{
    private final String colorActual = "ffffff"; //Blanco - sin color

    protected String color(){
        return colorActual;
    }

    protected Colores siguienteColor(){
        cantJugadores += 1;     //J1
        return (new ColorAzul());
    }

    public boolean esElMismoColor(Colores otroColor){
        return (this.color).equals(otroColor.color());
    }
}

