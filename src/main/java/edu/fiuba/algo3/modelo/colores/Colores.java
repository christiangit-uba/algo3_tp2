package edu.fiuba.algo3.modelo.colores;

public abstract class Colores{
    protected static short minimo = 2;

    public Colores sinColor(){
        return new ColorBlanco();
    }

    public boolean hayJugadoresSuficientes(int cantJugadores){   //usada por Juego.
        return (cantJugadores >= minimo);
    }

    public abstract String color();

    public abstract Colores siguienteColor();

    public abstract Boolean esElMismoColor(Colores color);

    public abstract int informarCantidadJugadores();   //usada por Juego.
}
