package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaContinente {

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColor(){
        Color color = new Color("Rojo");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        paisUno.agregarColor(color);
        continente.agregarPais(paisUno);

        assertEquals(continente.conquistado(color),7);

    }

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColorPeroLePasoColorDistinto(){
        Color color = new Color("Rojo");
        Color otroColor = new Color("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        paisUno.agregarColor(color);
        continente.agregarPais(paisUno);

        assertEquals(continente.conquistado(otroColor),0);

    }

    @Test
    public void ElContinenteTieneDentroDosPaisesDeDistintosColoresPorLoTantoNoHayConquista(){
        Color color = new Color("Rojo");
        Color otroColor = new Color("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor(color);
        paisDos.agregarColor(otroColor);
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado(otroColor),0);

    }

    @Test
    public void ElContinenteTieneDentroDosPaisesConMismosColoresPorLoTantoHayConquista(){
        Color color = new Color("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor(color);
        paisDos.agregarColor(color);
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado(color),7);

    }
}
