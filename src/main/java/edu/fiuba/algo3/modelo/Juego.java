package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;

public class Juego {
    Tablero tablero;

    Juego(){
        try {
            tablero = new Tablero();
        }
        catch (FileNotFoundException ERROR){
            return;
        }
    }

    public void Jugada(String paisAtacante, String paisDefensor, int cantidadDeTropasAUsar){

    }
}
