package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private Color colorBlanco = new Color("ffffff");
    private Color colorNegro = new Color("000000");
    private Color colorVerde = new Color("verde");
    private Color colorRojo = new Color("rojo");
    private Color colorAzul = new Color("azul");
    private Color colorAmarillo = new Color("amarillo");

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
    private Tarjetero mazo = new Tarjetero();
    private ValidarCanje validador = new ValidarCanje(mazo);

    private Tablero tablero;
    {
        try {
            tablero = new Tablero(mazo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public JugadorTest() throws FileNotFoundException {
    }

    @Test
    public void unPaisAsignadoAUnJugadorTomaElColorDelJugador() {
        jugador1 = new Jugador(colorBlanco, validador);
        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorBlanco));
    }

    @Test
    public void sePuedenAsignarVariosPaisesAUnJugador() {
        jugador1 = new Jugador(colorBlanco, validador);
        jugador1.asignarPais(pais1);
        jugador1.asignarPais(pais2);
        jugador1.asignarPais(pais3);
        jugador1.asignarPais(pais4);

        assert(pais1.mismoColor(colorBlanco));
        assert(pais2.mismoColor(colorBlanco));
        assert(pais3.mismoColor(colorBlanco));
        assert(pais4.mismoColor(colorBlanco));
    }

    //Inicializacion
    @Test
    public void unPaisQueSeAsignaAUnJugadorAumentaSuEjercitoEn_1_(){
        jugador1 = new Jugador(colorBlanco, validador);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugadorPuedeColocarLos_5_EjercitosInicialesEnUnPais() throws Exception {
        jugador1 = new Jugador(colorBlanco, validador);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        jugador1.colocarEjercitos(5, 6, pais1); //el tope deberia ser <= ?
        assertEquals(6, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugador_No_PuedeColocarEnUnPaisMasDeLosEjercitosPermitidos(){
        jugador1 = new Jugador(colorBlanco, validador);
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
        jugador1 = new Jugador(colorBlanco, validador);
        pais1 = tablero.obtenerPais("Argentina");
        assert(pais1.mismoNombre("Argentina"));

        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorBlanco));
    }

    @Test
    public void sePuedenRepartirLos_50_PaisesDelTablero() throws FileNotFoundException{ //copiado de pruebasTablero

        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
        Jugador jugadorDos = new Jugador(colorJugadorDos, validador);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);

        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 25);
        assertEquals(tablero.cantidadDePaises(colorJugadorDos), 25); //agregado
    }

    @Test
    public void con_6_jugadoresLaCantidadMinimaDeEjercitosQuePuedoColocarEnLaPrimeraRondaEs_4_(){
        jugador1 = new Jugador(colorBlanco, validador);
        jugador2 = new Jugador(colorNegro, validador);
        jugador3 = new Jugador(colorRojo, validador);
        jugador4 = new Jugador(colorAmarillo, validador);
        jugador5 = new Jugador(colorAzul, validador);
        jugador6 = new Jugador(colorVerde, validador);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);

        tablero.asignarPaises(jugadores);
        assertEquals(4, jugador6.cantidadEjercitosAColocar(tablero));
    }

    //Canjes
    @Test
    public void activar_3_TarjetasDePaisDeIgualSimboloPermiteCanjearlasPor_4_Ejercitos(){

        jugador1 = new Jugador(colorBlanco, validador);
        Simbolo simbolo = new Simbolo("barco");

        Pais pais1 = tablero.obtenerPais("Argentina");
        assertNotEquals(null, pais1);
        Pais pais2 = tablero.obtenerPais("Brazil");
        assertNotEquals(null, pais2);
        Pais pais3 = tablero.obtenerPais("Alemania");
        assertNotEquals(null, pais3);

        Tarjeta tarjeta1 = new Tarjeta(pais1, simbolo);
        Tarjeta tarjeta2 = new Tarjeta(pais2, simbolo);
        Tarjeta tarjeta3 = new Tarjeta(pais3, simbolo);

        jugador1.agregarTarjeta(tarjeta1);
        jugador1.agregarTarjeta(tarjeta2);
        jugador1.agregarTarjeta(tarjeta3);

        jugadores.add(jugador1);
        tablero.asignarPaises(jugadores);
        assertEquals(50, tablero.cantidadDePaises(colorBlanco));

        jugador1.activarTarjetaPais(tarjeta1);
        assertEquals(3, tablero.obtenerPais("Argentina").cantidadEjercitos());

        jugador1.activarTarjetaPais(tarjeta2);
        assertEquals(3, tablero.obtenerPais("Brazil").cantidadEjercitos());

        jugador1.activarTarjetaPais(tarjeta3);
        assertEquals(3, tablero.obtenerPais("Alemania").cantidadEjercitos());

        assertEquals(4, jugador1.hacerCanjes());
    }
}