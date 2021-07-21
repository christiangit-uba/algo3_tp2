package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TarjetaDePaisTest {
    private Tarjetero mazo = new Tarjetero();
    private ValidarCanje validador = new ValidarCanje(mazo);

    public TarjetaDePaisTest() throws FileNotFoundException {
    }

    @Test
    public void unJugadorTieneUnaTarjetaDeUnPaisPropioPorLoTantoTieneDosEjercitosNuevos() throws FileNotFoundException {
        Color color = new Color("Rojo");
        Simbolo simboloGlobo = new Simbolo("Globo");

        Tablero tablero = new Tablero(mazo);
        Jugador jugador = new Jugador(color, validador);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);

        Pais paisDeCarta = tablero.obtenerPais("Java");
        Tarjeta tarjeta = new Tarjeta(paisDeCarta, simboloGlobo);

        jugador.agregarTarjeta(tarjeta);

        tablero.asignarPaises(jugadores);

        assertEquals(paisDeCarta.cantidadEjercitos(),1);

        jugador.activarTarjetaPais(tarjeta);
        assertEquals(paisDeCarta.cantidadEjercitos(),3);
    }
}
