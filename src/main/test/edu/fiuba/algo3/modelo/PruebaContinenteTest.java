package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
public class PruebaContinenteTest {

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColor(){
        ColorJugador colorJugador = new ColorJugador("Rojo");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        paisUno.agregarColor(colorJugador);
        continente.agregarPais(paisUno);

        assertEquals(continente.conquistado(colorJugador),7);
    }

    @Test
    public void creoUnContinenteQueDevuelve7EjercitosPorPaisesConMismoColorPeroLePasoColorDistinto(){
        ColorJugador colorJugador = new ColorJugador("Rojo");
        ColorJugador otroColorJugador = new ColorJugador("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        paisUno.agregarColor(colorJugador);
        continente.agregarPais(paisUno);

        assertEquals(continente.conquistado(otroColorJugador),0);
    }

    @Test
    public void ElContinenteTieneDentroDosPaisesDeDistintosColoresPorLoTantoNoHayConquista(){
        ColorJugador colorJugador = new ColorJugador("Rojo");
        ColorJugador otroColorJugador = new ColorJugador("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor(colorJugador);
        paisDos.agregarColor(otroColorJugador);
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado(otroColorJugador),0);
    }

    @Test
    public void ElContinenteTieneDentroDosPaisesConMismosColoresPorLoTantoHayConquista(){
        ColorJugador colorJugador = new ColorJugador("Verde");
        Continente continente = new Continente("asia",7);
        Pais paisUno = new Pais("china");
        Pais paisDos = new Pais("japon");
        paisUno.agregarColor(colorJugador);
        paisDos.agregarColor(colorJugador);
        continente.agregarPais(paisUno);
        continente.agregarPais(paisDos);

        assertEquals(continente.conquistado(colorJugador),7);
    }
}


 */