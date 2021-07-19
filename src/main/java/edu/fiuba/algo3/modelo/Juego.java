package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;

public class Juego {
    private Tablero tablero;
    private Tarjetero tarjetero;

    Juego() throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
    }
    public Tarjetero getTarjetero(){
        return tarjetero;
    }
}
