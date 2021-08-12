package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaColoresTest {

    @Test
    public void DosColoresConElMismoNombreSonElMismoColor(){
        ColorJugador unColorJugador = new ColorJugador("Azul","0001");
        ColorJugador otroColorJugador = new ColorJugador("Azul","0001");

        assertTrue(unColorJugador.mismoColor(otroColorJugador));
    }

    @Test
    public void creoElColorAzulSuNombreEsAzul(){
        ColorJugador unColorJugador = new ColorJugador("Azul","0001");

        assertEquals(unColorJugador.nombre(),"Azul");
    }

}