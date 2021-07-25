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
        jugador1 = new Jugador(colorBlanco);
        jugador1.asignarPais(pais1);
        assert(pais1.mismoColor(colorBlanco));
    }

    @Test
    public void sePuedenAsignarVariosPaisesAUnJugador() {
        jugador1 = new Jugador(colorBlanco);
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
        jugador1 = new Jugador(colorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugadorPuedeColocarLos_5_EjercitosInicialesEnUnPais() throws Exception {
        jugador1 = new Jugador(colorBlanco);
        jugador1.asignarPais(pais1);
        assertEquals(1, pais1.cantidadEjercitos());

        jugador1.colocarEjercitos(5, 6, pais1); //el tope deberia ser <= ?
        assertEquals(6, pais1.cantidadEjercitos());
    }

    @Test
    public void unJugador_No_PuedeColocarEnUnPaisMasDeLosEjercitosPermitidos(){
        jugador1 = new Jugador(colorBlanco);
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
        jugador1 = new Jugador(colorBlanco);
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
        Jugador jugadorUno = new Jugador(colorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorDos);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);

        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 25);
        assertEquals(tablero.cantidadDePaises(colorJugadorDos), 25); //agregado
    }

    @Test
    public void con_6_jugadoresLaCantidadMinimaDeEjercitosQuePuedoColocarEnLaPrimeraRondaEs_4_(){
        jugador1 = new Jugador(colorBlanco);
        jugador2 = new Jugador(colorNegro);
        jugador3 = new Jugador(colorRojo);
        jugador4 = new Jugador(colorAmarillo);
        jugador5 = new Jugador(colorAzul);
        jugador6 = new Jugador(colorVerde);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);

        tablero.asignarPaises(jugadores);
        assertEquals(4, jugador6.cantidadEjercitosAColocar(tablero));
    }

    //canjes
    @Test
    public void elJugadorPuedeElegir_3_TarjetasDeLasQuePosee(){

        jugador1 = new Jugador(colorBlanco);
        Simbolo simbolo = new Simbolo("Globo");
        ArrayList<Tarjeta> elegidas = new ArrayList<>();

        Tarjeta tarjetaUno = new Tarjeta(pais1,simbolo);
        Tarjeta tarjetaDos = new Tarjeta(pais2,simbolo);
        Tarjeta tarjetaTres = new Tarjeta(pais3,simbolo);

        jugador1.agregarTarjeta(tarjetaUno);
        jugador1.agregarTarjeta(tarjetaDos);
        jugador1.agregarTarjeta(tarjetaTres);

        elegidas.add(jugador1.elegirTarjeta(tarjetaUno));
        elegidas.add(jugador1.elegirTarjeta(tarjetaDos));
        elegidas.add(jugador1.elegirTarjeta(tarjetaTres));

        assertEquals(3, elegidas.size());
    }

    @Test
    public void elJugadoElije_3_TarjetasConElMismoSimboloYLasIntercambiaPor_4_Ejercitos() throws FileNotFoundException {

        Tarjetero mazo = new Tarjetero();
        jugador1 = new Jugador(colorBlanco);
        Simbolo simbolo = new Simbolo("Globo");
        ArrayList<Tarjeta> elegidas = new ArrayList<>();
        int ejercitos = 0;

        Tarjeta tarjetaUno = new Tarjeta(pais1,simbolo);
        Tarjeta tarjetaDos = new Tarjeta(pais2,simbolo);
        Tarjeta tarjetaTres = new Tarjeta(pais3,simbolo);

        jugador1.agregarTarjeta(tarjetaUno);
        jugador1.agregarTarjeta(tarjetaDos);
        jugador1.agregarTarjeta(tarjetaTres);

        //el jugador elije 3 tarjetas de las mostradas.
        elegidas.add(jugador1.elegirTarjeta(tarjetaUno));
        elegidas.add(jugador1.elegirTarjeta(tarjetaDos));
        elegidas.add(jugador1.elegirTarjeta(tarjetaTres));

        assertEquals(3, elegidas.size());

        //las canjea y recibe 4 ejercitos.
        ejercitos = jugador1.validarCanjes(elegidas, mazo);

        assertEquals(4, ejercitos);
        assertEquals(3, mazo.size());
    }

    @Test
    public void elJugadoElijeUnTotalDe_6_TarjetasConElMismoSimboloYLasIntercambiaPor_11_Ejercitos() throws FileNotFoundException {

        Tarjetero mazo = new Tarjetero();
        jugador1 = new Jugador(colorBlanco);
        Simbolo simbolo = new Simbolo("Globo");
        ArrayList<Tarjeta> elegidas = new ArrayList<>();
        int ejercitos = 0;

        Tarjeta tarjetaUno = new Tarjeta(pais1,simbolo);
        Tarjeta tarjetaDos = new Tarjeta(pais2,simbolo);
        Tarjeta tarjetaTres = new Tarjeta(pais3,simbolo);
        Tarjeta tarjetaCuatro = new Tarjeta(pais4,simbolo);
        Tarjeta tarjetaCinco = new Tarjeta(pais1,simbolo);
        Tarjeta tarjetaSeis = new Tarjeta(pais2,simbolo);

        jugador1.agregarTarjeta(tarjetaUno);
        jugador1.agregarTarjeta(tarjetaDos);
        jugador1.agregarTarjeta(tarjetaTres);
        jugador1.agregarTarjeta(tarjetaCuatro);
        jugador1.agregarTarjeta(tarjetaCinco);
        jugador1.agregarTarjeta(tarjetaSeis);

        //para el primer canje.
        elegidas.add(jugador1.elegirTarjeta(tarjetaUno));
        elegidas.add(jugador1.elegirTarjeta(tarjetaDos));
        elegidas.add(jugador1.elegirTarjeta(tarjetaTres));
        assertEquals(3, elegidas.size());

        //las canjea y recibe 4 ejercitos.
        ejercitos += jugador1.validarCanjes(elegidas, mazo);

        assertEquals(4, ejercitos);
        assertEquals(3, mazo.size());
        assertEquals(3, jugador1.cantidadTarjetas());

        elegidas.clear();

        //para el segundo canje.
        elegidas.add(jugador1.elegirTarjeta(tarjetaCuatro));
        elegidas.add(jugador1.elegirTarjeta(tarjetaCinco));
        elegidas.add(jugador1.elegirTarjeta(tarjetaSeis));
        assertEquals(3, elegidas.size());

        //las canjea y recibe 7 ejercitos mas.
        ejercitos += jugador1.validarCanjes(elegidas, mazo);

        assertEquals(11, ejercitos);
        assertEquals(6, mazo.size());
        assertEquals(0, jugador1.cantidadTarjetas());
    }

    @Test
    public void elJugadoElijeUnTotalDe_6_Tarjetas_3_ConElMismoSimboloY_3_ConDistintoSimbolo_LasIntercambiaPor_11_Ejercitos() throws FileNotFoundException {

        Tarjetero mazo = new Tarjetero();
        jugador1 = new Jugador(colorBlanco);
        Simbolo simbolo = new Simbolo("Globo");
        Simbolo simbolo1 = new Simbolo("Barco");
        Simbolo simbolo2 = new Simbolo("cañon");

        ArrayList<Tarjeta> elegidas = new ArrayList<>();
        int ejercitos = 0;

        Tarjeta tarjetaUno = new Tarjeta(pais1,simbolo);
        Tarjeta tarjetaDos = new Tarjeta(pais2,simbolo);
        Tarjeta tarjetaTres = new Tarjeta(pais3,simbolo);
        Tarjeta tarjetaCuatro = new Tarjeta(pais4,simbolo);
        Tarjeta tarjetaCinco = new Tarjeta(pais1,simbolo1);
        Tarjeta tarjetaSeis = new Tarjeta(pais2,simbolo2);

        jugador1.agregarTarjeta(tarjetaUno);
        jugador1.agregarTarjeta(tarjetaDos);
        jugador1.agregarTarjeta(tarjetaTres);
        jugador1.agregarTarjeta(tarjetaCuatro);
        jugador1.agregarTarjeta(tarjetaCinco);
        jugador1.agregarTarjeta(tarjetaSeis);

        //para el primer canje.
        elegidas.add(jugador1.elegirTarjeta(tarjetaUno));
        elegidas.add(jugador1.elegirTarjeta(tarjetaDos));
        elegidas.add(jugador1.elegirTarjeta(tarjetaTres));
        assertEquals(3, elegidas.size());

        //las canjea las iguales y recibe 4 ejercitos.
        ejercitos += jugador1.validarCanjes(elegidas, mazo);

        assertEquals(4, ejercitos);
        assertEquals(3, mazo.size());
        assertEquals(3, jugador1.cantidadTarjetas());

        elegidas.clear();

        //para el segundo canje.
        elegidas.add(jugador1.elegirTarjeta(tarjetaCuatro));
        elegidas.add(jugador1.elegirTarjeta(tarjetaCinco));
        elegidas.add(jugador1.elegirTarjeta(tarjetaSeis));
        assertEquals(3, elegidas.size());

        //las canjea las distintas y recibe 7 ejercitos mas.
        ejercitos += jugador1.validarCanjes(elegidas, mazo);

        assertEquals(11, ejercitos);
        assertEquals(6, mazo.size());
        assertEquals(0, jugador1.cantidadTarjetas());
    }

}