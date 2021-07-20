package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.Random;

public class Juego {
    private Tablero tablero;
    private Tarjetero tarjetero;
    private Turno turno;

    Juego() throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
    }
    public Tarjetero getTarjetero(){
        return tarjetero;
    }
/*
    Juego(int cantidadDeJugadores) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);

        Random random = new Random();
        int jugadorInicial = random.nextInt(jugadores.size()-1);


        tablero.asignarPaises(jugadores);
    }

    public void jugar(){
        turno = new TurnoDeColocacion(jugadores.get(0));

        while (turno.sigueJuego()){
            while (turno.sigueTurno()){
                turno = turno.recibirOrden();
            }
            turno = turno.siguienteTurno(jugadores);
        }
    }*/
}
