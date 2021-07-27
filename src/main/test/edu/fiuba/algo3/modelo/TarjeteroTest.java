package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class TarjeteroTest {
    @Test
    public void agregoUnaTarjetaDelTarjeteroAUnJugadorPorLoTantoElTarjeteroTieneUnaTarjetaMenos() throws FileNotFoundException {
        Juego juego = new Juego(6);
        Tarjetero tarjetero = juego.getTarjetero();
        ColorJugador colorJugador = new ColorJugador("morado","001");
        Jugador jugador = new Jugador("Jugaddor1",colorJugador);
        assertEquals(tarjetero.size(),50);
        tarjetero.asignarTarjeta(jugador);
        assertEquals(tarjetero.size(),49);

    }

    @Test
    public void agregoUnaTarjetaAUnJugadorYEsaTarjetaYaNoEstaEnElMazo() throws FileNotFoundException {
        Tarjetero tarjetero = new Tarjetero();
        ColorJugador colorJugador = new ColorJugador("morado","001");
        Jugador jugador = new Jugador("JUgador1",colorJugador);
        Pais chile = new Pais("Chile");
        Simbolo globo = new Simbolo("Globo");
        Tarjeta tarjetaChile = new Tarjeta(chile,globo);

        tarjetero.agregarTarjeta(tarjetaChile);
        //Inicialmente la tarjeta esta en el mazo
        assertEquals(tarjetero.buscarTarjeta(chile),tarjetaChile);

        tarjetero.asignarTarjeta(jugador);
        //Luego de asignarla ya no se encuentra en el mazo
        assertNull(tarjetero.buscarTarjeta(chile));

    }

}
