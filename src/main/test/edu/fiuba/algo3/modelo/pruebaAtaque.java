package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class pruebaAtaque {
    @Test
    public void prueboAtaqueDe1ronda() {

        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();


        PaisAtacante.atacaA(PaisDefensor, 1);
        assertTrue(PaisDefensor.cantidadEjercitos() > 0);
    }
}
