package edu.fiuba.algo3.modelo.colores;

public class ColorNegro extends Colores{
    private String colorActual = "000000";
    private int cantJugadores = 6;

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