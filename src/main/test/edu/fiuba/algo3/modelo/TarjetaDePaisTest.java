package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TarjetaDePaisTest {
    @Test
    public void unJugadorTieneUnaTarjetaDeUnPaisPropioPorLoTantoTieneDosEjercitosNuevos() throws FileNotFoundException {
        Color color = new Color("Rojo");
        Jugador jugador = new Jugador(color);
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
}
