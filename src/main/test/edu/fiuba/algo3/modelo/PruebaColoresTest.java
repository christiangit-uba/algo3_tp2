package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaColoresTest {

    @Test
    public void DosColoresConElMismoNombreSonElMismoColor(){
        Color unColor = new Color("Azul");
        Color otroColor = new Color("Azul");

        assertTrue(unColor.mismoColor(otroColor));
    }

    @Test
    public void creoElColorAzulSuCodigoEsAzul(){
        Color unColor = new Color("Azul");

        assertEquals(unColor.color(),"Azul");
    }

}