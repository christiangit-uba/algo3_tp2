package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PruebaContinente {

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColor(){
      Continente continente = new Continente("asia",7);
      Pais paisUno = new Pais("china");
      paisUno.agregarColor("rojo");
      continente.agregarPais(paisUno);

      assertEquals(continente.conquistado("rojo"),7);

    }

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColorPeroLePasoColorDistinto(){
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        paisUno.agregarColor("rojo");
        continente.agregarPais(paisUno);

        assertEquals(continente.conquistado("verde"),0);

    }

    @Test
    public void ElContinenteTieneDentroDosPaisesDeDistintosColoresPorLoTantoNoHayConquista(){
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor("rojo");
        paisDos.agregarColor("verde");
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado("verde"),0);

    }

    @Test
    public void ElContinenteTieneDentroDosPaisesConMismosColoresPorLoTantoHayConquista(){
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor("verde");
        paisDos.agregarColor("verde");
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado("verde"),7);

    }
}
