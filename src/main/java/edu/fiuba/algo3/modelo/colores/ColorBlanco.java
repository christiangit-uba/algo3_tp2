package edu.fiuba.algo3.modelo.colores;

public class ColorBlanco extends Colores{
    private String colorActual = "ffffff";    //Blanco - sin color
    private int cantJugadores = 0;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorAzul());
    }

    @Override
    public Boolean esElMismoColor(Colores otroColor){
        return (colorActual).equals(otroColor.color());
    }

    @Override
    public int informarCantidadJugadores() {
        return cantJugadores;
    }
}

