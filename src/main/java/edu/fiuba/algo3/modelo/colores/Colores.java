package edu.fiuba.algo3.modelo;

public abstract class Colores{
    protected short cantJugadores = 0;
    protected static short minimo = 2;
    protected Colores color;

    public Colores(){
        this.color = new ColorBlanco();
    }

    public Object sinColor(){
        return new ColorBlanco();
    }

    public Object asignarColor(){
        this.color = (Colores) (this.color).siguienteColor();
        return (this.color);
    }

    public short informarCantidadJugadores(){   //usada por Juego.
        return cantJugadores;
    }

    public boolean hayJugadoresSuficientes(){   //usada por Juego.
        return (cantJugadores >= minimo);
    }

    protected String color(){
        return (this.color).color();
    }

    protected Object siguienteColor(){
        return this.color.siguienteColor();
    }
}
