package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TarjeteroTest {
    @Test
    public void agregoUnaTarjetaDelTarjeteroAUnJugadorPorLoTantoElTarjeteroTieneUnaTarjetaMenos() throws FileNotFoundException {
        Juego juego = new Juego();
        Tarjetero tarjetero = juego.getTarjetero();
        Color color = new Color("morado");
        Jugador jugador = new Jugador(color);
        assertEquals(tarjetero.size(),50);
        tarjetero.asignarTarjeta(jugador);
        assertEquals(tarjetero.size(),49);
    }
}
