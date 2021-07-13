package edu.fiuba.algo3.modelo.colores;

public class ColorVerde extends Colores{
    private String colorActual = "009988";
    private int cantJugadores = 4;

    @Override
    public String color(){
        return colorActual;
    }

    @Override
    public Colores siguienteColor(){
        return (new ColorRosa());
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
