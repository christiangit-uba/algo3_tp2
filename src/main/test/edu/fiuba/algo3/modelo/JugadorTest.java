package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/*
public class JugadorTest {
    private ColorJugador colorJugadorBlanco = new ColorJugador("ffffff");
    private ColorJugador colorJugadorNegro = new ColorJugador("000000");
    private ColorJugador colorJugadorVerde = new ColorJugador("verde");
    private ColorJugador colorJugadorRojo = new ColorJugador("rojo");
    private ColorJugador colorJugadorAzul = new ColorJugador("azul");
    private ColorJugador colorJugadorAmarillo = new ColorJugador("amarillo");

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Jugador jugador4;
    private Jugador jugador5;
    private Jugador jugador6;

    private Pais pais1 = new Pais("Argentina");
    private Pais pais2 = new Pais("Chile");
    private Pais pais3 = new Pais("Alemania");
    private Pais pais4 = new Pais("Oregon");

    private ArrayList<Jugador> jugadores = new ArrayList<>();

    private Tablero tablero;
    {
        try {
            tablero = new Tablero(new Tarjetero());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unPaisAsignadoAUnJugadorTomaElColorDelJugador() {
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorJugadorBlanco));
    }

    @Test
    public void sePuedenAsignarVariosPaisesAUnJugador() {
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        jugador1.asignarPais(pais2);
        jugador1.asignarPais(pais3);
        jugador1.asignarPais(pais4);

        assert(pais1.mismoColor(colorJugadorBlanco));
        assert(pais2.mismoColor(colorJugadorBlanco));
        assert(pais3.mismoColor(colorJugadorBlanco));
        assert(pais4.mismoColor(colorJugadorBlanco));
    }

    //Inicializacion

    @Test
    public void unPaisQueSeAsignaAUnJugadorAumentaSuEjercitoEn_1_(){
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugadorPuedeColocarLos_5_EjercitosInicialesEnUnPais() throws Exception {
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        jugador1.colocarEjercitos(5, 6, pais1); //el tope deberia ser <= ?
        assertEquals(6, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugador_No_PuedeColocarEnUnPaisMasDeLosEjercitosPermitidos(){
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        try {
            jugador1.colocarEjercitos(5, 4, pais1);
        }catch (Exception e){
            assertEquals(1, pais1.cantidadEjercitos());
        }

        assertNotEquals(5, pais1.cantidadEjercitos());
    }

    @Test
    public void losPaisesEntregadosPorElTableroObtienenElColorDelJugador(){
        jugador1 = new Jugador(colorJugadorBlanco);
        pais1 = tablero.obtenerPais("Argentina");
        assert(pais1.mismoNombre("Argentina"));

        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorJugadorBlanco));
    }

    @Test
    public void sePuedenRepartirLos_50_PaisesDelTablero() throws FileNotFoundException{ //copiado de pruebasTablero

        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorJugadorDos);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);

        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorUno), 25);
        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorDos), 25); //agregado
    }

    @Test
    public void con_6_jugadoresLaCantidadMinimaDeEjercitosQuePuedoColocarEnLaPrimeraRondaEs_4_(){
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador2 = new Jugador(colorJugadorNegro);
        jugador3 = new Jugador(colorJugadorRojo);
        jugador4 = new Jugador(colorJugadorAmarillo);
        jugador5 = new Jugador(colorJugadorAzul);
        jugador6 = new Jugador(colorJugadorVerde);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);

        tablero.asignarPaises(jugadores);
        assertEquals(4, jugador6.cantidadEjercitosAColocar(tablero));
    }
}

 */