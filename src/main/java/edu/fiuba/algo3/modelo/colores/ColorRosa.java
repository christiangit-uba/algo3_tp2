package edu.fiuba.algo3.modelo.colores;

public class ColorRosa extends Colores{
    private String colorActual = "ee3377";
    private int cantJugadores = 5;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorNegro());
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
