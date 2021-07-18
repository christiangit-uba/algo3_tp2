package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TarjeteroTest {
    @Test
    public void agregoUnaTarjetaDelTarjeteroAUnJugadorPorLoTantoElTarjeteroTieneUnaTarjetaMenos(){
        Tarjetero tarjetero = new Tarjetero();
        Color color = new Color("morado");
        Jugador jugador = new Jugador(color);
        assertEquals(tarjetero.size(),1);
        tarjetero.asignarTarjeta(jugador);
        assertEquals(tarjetero.size(),0);
    }
}
