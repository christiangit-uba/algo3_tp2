package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class PruebaTablero {
    /*@Test
    public void UnJugadorTienePaisesEntoncesCantidadDePaisesEsLaCantidadDePaisesDisponibles() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("verde");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises("verde"), 50);
    }*/

    @Test
    public void DosJugadoresSeRepartenPaisesDisponiblesEntoncesJugadorDosTieneDosPaises() throws FileNotFoundException {
        /*Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("verde");
        Jugador jugadorDos = new Jugador("rojo");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises("rojo"), 25);*/


        Color rojo = new Color("cc3311");
        Color azul = new Color("077bb");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Tablero tablero = new Tablero();

        tablero.asignarPaises(jugadores);
        //when(tablero.cantidadDePaises(rojo)).thenReturn(25);

        assertEquals(25,tablero.cantidadDePaises(rojo));

    }
}
