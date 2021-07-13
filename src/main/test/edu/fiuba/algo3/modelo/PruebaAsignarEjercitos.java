package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PruebaAsignarEjercitos {

    @Test
    public void AsignoDosEjercitosAUnPais(){
        Pais unPais = new Pais("Alemania");
        Jugador unJugador = new Jugador("azul");
        unJugador.asignarEjercito(unPais,2);
        assertEquals(unPais.cantidadEjercitos(),2);
    }
}
