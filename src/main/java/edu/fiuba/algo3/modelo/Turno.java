package edu.fiuba.algo3.modelo;

public abstract class Turno {
    protected Jugador jugador;
    protected boolean sigueTurno = true;

    boolean sigueJuego(){
        return true;
    }

    boolean sigueTurno(){
        return sigueTurno;
    }

    public abstract void terminarTurno();

    public abstract void recibirOrden();

    public void turnoDe(Jugador jugador1){
        this.jugador = jugador1;
    }

}
