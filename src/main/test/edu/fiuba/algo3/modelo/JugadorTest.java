package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private ColorJugador colorJugadorBlanco = new ColorJugador("blanco","ffffff");
    private ColorJugador colorJugadorNegro = new ColorJugador("negro","000000");
    private ColorJugador colorJugadorVerde = new ColorJugador("verde","0000");
    private ColorJugador colorJugadorRojo = new ColorJugador("rojo","0000");
    private ColorJugador colorJugadorAzul = new ColorJugador("azul","0000");
    private ColorJugador colorJugadorAmarillo = new ColorJugador("amarillo","0000");

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
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorJugadorBlanco));
    }

    @Test
    public void sePuedenAsignarVariosPaisesAUnJugador() {
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
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
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugadorPuedeColocarLos_5_EjercitosInicialesEnUnPais() throws Exception {
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        jugador1.setTope(6);
        jugador1.colocarEjercitos(5,  pais1); //el tope deberia ser <= ?
        assertEquals(6, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugador_No_PuedeColocarEnUnPaisMasDeLosEjercitosPermitidos(){
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
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
        jugador1 = new Jugador("Jugador1",colorJugadorBlanco);
        pais1 = tablero.obtenerPais("Argentina");
        assert(pais1.mismoNombre("Argentina"));

        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorJugadorBlanco));
    }

    @Test
    public void sePuedenRepartirLos_50_PaisesDelTablero() throws FileNotFoundException{ //copiado de pruebasTablero

        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","000");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo","000");
        Jugador jugadorUno = new Jugador("Jugador1",colorJugadorJugadorUno);
        Jugador jugadorDos = new Jugador("Jugador2",colorJugadorJugadorDos);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);

        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorUno), 25);
        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorDos), 25); //agregado
    }



}