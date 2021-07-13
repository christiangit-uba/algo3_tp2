package edu.fiuba.algo3.modelo.colores;

public class ColorAzul extends Colores{
    private String colorActual = "077bb";	//Azul
    private int cantJugadores = 1;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorRojo());
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
