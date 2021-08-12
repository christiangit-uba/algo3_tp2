package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Objetivo {

    String objetivo;

    boolean validarObjetivo(Tablero tablero, ColorJugador colorJugador) {
        return false;
    }

    String mostrarObjetivo(){
        return objetivo;
    }
}
