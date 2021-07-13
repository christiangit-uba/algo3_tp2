package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PruebaTablero {
    @Test
    public void UnJugadorTienePaisesEntoncesCantidadDePaisesEsLaCantidadDePaisesDisponibles() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("verde");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises("verde"), 50);
    }

    @Test
    public void DosJugadoresSeRepartenPaisesDisponiblesEntoncesJugadorDosTieneDosPaises() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("verde");
        Jugador jugadorDos = new Jugador("rojo");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises("rojo"), 25);
    }
}
