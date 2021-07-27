package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {
    private final ArrayList<Jugador> jugadores;
    private int iterador;

    public Ronda(ArrayList<Jugador> jugadores) {
        iterador = 0;
        this.jugadores = jugadores;
    }

    public Jugador jugadorEnRonda() {
        return jugadores.get(iterador);
    }

    public boolean pasarTurno() {
        iterador++;
        if (iterador == jugadores.size()){
            iterador = 0;
            return false;
        }
        return true;
    }
}

