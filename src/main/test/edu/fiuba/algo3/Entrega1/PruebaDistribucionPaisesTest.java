/*package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaDistribucionPaisesTest {

    @Test
    public void ColocacionDeEjercitos() throws Exception {
        Juego juego = new Juego(2);

        Jugador jugador1 = juego.jugadores().get(0);
        Jugador jugador2 = juego.jugadores().get(1);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        juego.tablero().asignarPaises(jugadores);
        jugador1.calcularTope(juego.tablero());
        jugador2.calcularTope(juego.tablero());

        assertEquals(12,jugador1.tope());
        assertEquals(12,jugador2.tope());

        Pais paisJugador1 = juego.tablero().obtenerPais("Argentina");
        Pais paisJugador2 = juego.tablero().obtenerPais("Chile");

        paisJugador1.agregarColor(jugador1.obtenerColor());
        paisJugador2.agregarColor(jugador2.obtenerColor());
        jugador1.colocarEjercitos(5,paisJugador1);
        jugador2.colocarEjercitos(5,paisJugador2);
        jugador1.colocarEjercitos(3,paisJugador1);
        jugador2.colocarEjercitos(3,paisJugador2);

        assertEquals(9,paisJugador1.cantidadEjercitos());
        assertEquals(9,paisJugador2.cantidadEjercitos());

    }
}
*/
