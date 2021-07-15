package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Juego {
    Tablero tablero;
    ArrayList<Jugador> jugadores = new ArrayList<>();

    Juego(){
        try {
            this.tablero = new Tablero();
        } catch (FileNotFoundException ignored) {
        }
    }

    public void ataqueJugador(String paisAtacante, String paisDefensor, int cantidadEjercitosAUsar, Jugador jugador) throws Exception {
        Pais atacante = tablero.obtenerPais(paisAtacante);
        Pais defensor = tablero.obtenerPais(paisDefensor);
        jugador.realizarAtaque(atacante,defensor,cantidadEjercitosAUsar);
    }

    public void movimientoJugador(String paisOrigen, String paisDestino, int cantidadEjercitos, Jugador jugador) throws Exception {
        Pais origen = tablero.obtenerPais(paisOrigen);
        Pais destino = tablero.obtenerPais(paisDestino);
        jugador.realizarMovimiento(origen,destino,cantidadEjercitos);
    }

}
