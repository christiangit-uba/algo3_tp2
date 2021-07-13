package edu.fiuba.algo3.modelo.colores;

public class ColorAmarillo extends Colores{
    private String colorActual = "ee7733";
    private int cantJugadores = 3;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorVerde());
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
