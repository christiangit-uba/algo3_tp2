package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private ColorJugador colorJugadorBlanco = new ColorJugador("blanco","ffffff");
    private ColorJugador colorJugadorNegro = new ColorJugador("negro","negro");
    private ColorJugador colorJugadorVerde = new ColorJugador("verde","verde");
    private ColorJugador colorJugadorRojo = new ColorJugador("rojo","verde");
    private ColorJugador colorJugadorAzul = new ColorJugador("azul","verde");
    private ColorJugador colorJugadorAmarillo = new ColorJugador("amarillo","verde");

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
        Juego nuevoJuego = new Juego(2);
        Jugador jugador1 = nuevoJuego.jugadores().get(0);
        Jugador jugador2 = nuevoJuego.jugadores().get(1);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);


        nuevoJuego.tablero().asignarPaises(jugadores);
        
        Pais pais = nuevoJuego.tablero().obtenerPais("Argentina");

        pais.agregarColor(jugador1.obtenerColor());

        assertEquals(1, pais.cantidadEjercitos());

        jugador1.calcularTope(nuevoJuego.tablero());
        jugador1.colocarEjercitos(5,pais); //el tope deberia ser <= ?
        assertEquals(6, pais.cantidadEjercitos());
    }

    @Test
    public void unJugador_No_PuedeColocarEnUnPaisMasDeLosEjercitosPermitidos(){
        jugador1 = new Jugador(colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        try {
            jugador1.colocarEjercitos(5,  pais1);
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
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo","rojo");
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
    public void con_6_jugadoresLaCantidadMinimaDeEjercitosQuePuedoColocarEnLaPrimeraRondaEs_4_() throws FileNotFoundException {
        Juego nuevoJuego = new Juego(6);

        nuevoJuego.tablero().asignarPaises(nuevoJuego.jugadores());
        nuevoJuego.jugadores().get(0).calcularTope(nuevoJuego.tablero());
        assertEquals(4, nuevoJuego.jugadores().get(0).tope());
    }
}

