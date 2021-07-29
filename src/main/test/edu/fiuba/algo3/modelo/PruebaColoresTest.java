package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaColoresTest {

    @Test
    public void DosColoresConElMismoNombreSonElMismoColor(){
        ColorJugador unColorJugador = new ColorJugador("Azul","Azul");
        ColorJugador otroColorJugador = new ColorJugador("Azul","Azul");

        assertTrue(unColorJugador.mismoColor(otroColorJugador));
    }

    @Test
    public void creoElColorAzulSuCodigoEsAzul(){
        ColorJugador unColorJugador = new ColorJugador("Azul","FF0000");

        assertEquals(unColorJugador.codigo(),"FF0000");
    }

}

