package edu.fiuba.algo3.modelo.colores;

public class ColorRojo extends Colores{
    private String colorActual = "cc3311";
    private int cantJugadores = 2;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorAmarillo());
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
