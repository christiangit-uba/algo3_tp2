package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaDeInicializacionDeJuego {
    @Test
    public void pruebaDeInicializacionDeJuego() throws FileNotFoundException {
        Tablero tablero = new Tablero();

        assertTrue(tablero.existePais("Argentina"));

        assertTrue(tablero.limitrofes("Argentina","Chile"));
    }
}
