package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class TarjetaDePaisTest {
    @Test
    public void unJugadorTieneUnaTarjetaDeUnPaisPropioPorLoTantoTieneDosEjercitosNuevos() throws FileNotFoundException {
        ColorJugador colorJugador = new ColorJugador("Rojo","001");
        Jugador jugador = new Jugador("Jugador1",colorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");

        ArrayList<Jugador> jugadors = new ArrayList<>();
        jugadors.add(jugador);
        Tablero tablero = new Tablero(new Tarjetero());
        Pais paisDeCarta = tablero.obtenerPais("Java");
        Tarjeta tarjeta = new Tarjeta(paisDeCarta,simboloGlobo);

        jugador.agregarTarjeta(tarjeta);
        tablero.asignarPaises(jugadors);


        assertEquals(paisDeCarta.cantidadEjercitos(),1);

        jugador.activarTarjetaPais(tarjeta);

        assertEquals(paisDeCarta.cantidadEjercitos(),3);

    }

    @Test
    public void unJugadorIntentaActivarUnaTarjetaDeUnPaisQueNoPoseeNoAsignaEjercitos() throws FileNotFoundException {
        ColorJugador colorJugador = new ColorJugador("Rojo","001");
        ColorJugador otroColorJugador = new ColorJugador("Azul","001");
        Jugador jugador = new Jugador("Jugador1",colorJugador);
        Jugador otroJugador = new Jugador("Jugador2",otroColorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(otroJugador);


        Tablero tablero = new Tablero(new Tarjetero());
        Pais paisDeCarta = tablero.obtenerPais("Java");

        Tarjeta tarjeta = new Tarjeta(paisDeCarta,simboloGlobo);

        //Le agrego la tarjeta del pais al jugador uno
        jugador.agregarTarjeta(tarjeta);

        tablero.asignarPaises(jugadores);

        //Le asigno el pais al jugador dos, asignandole el color de este
        paisDeCarta.agregarColor(otroColorJugador);

        assertFalse(jugador.activarTarjetaPais(tarjeta));
        assertEquals(paisDeCarta.cantidadEjercitos(),1);

    }

    @Test
    public void unJugadorIntentaActivarDosVecesUnaTarjetaSoloAsignaDosEjercitos(){
        ColorJugador colorJugador = new ColorJugador("Rojo","001");
        Jugador jugador = new Jugador("Jugador1",colorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");
        Pais unPais = new Pais("Brazil");
        Tarjeta tarjeta = new Tarjeta(unPais,simboloGlobo);

        jugador.asignarPais(unPais);
        jugador.agregarTarjeta(tarjeta);

        assertTrue(jugador.activarTarjetaPais(tarjeta));
        assertFalse(jugador.activarTarjetaPais(tarjeta));
        assertEquals(unPais.cantidadEjercitos(),3);
    }

}
