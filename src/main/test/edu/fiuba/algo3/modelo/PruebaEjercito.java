package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PruebaEjercito {
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoUna(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        ejercito.agregarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),1);
    }

    @Test
    public void creoEjercitoConCeroTropasYLeAgregoUnaYLeSaco1(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),0);
    }
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoTresYLeSaco1(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),2);
    }
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoCincoYLeSaco1(){

        Ejercito ejercito = new UnoOMenosEjercito(0);
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),4);
    }
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoCincoYLeSaco2(){
        Ejercito ejercito = new UnoOMenosEjercito(0);

        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),3);
    }
 @Test
    public void SiHayMenosDeUnEjercitoEntoncesNoPuedeAtacar(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        assertFalse(ejercito.puedeAtacar(0));
 }

    @Test
    public void SiHayDosEjercitosYSeQuiereAtacarConUnoSePuedeAtacar(){
        Ejercito ejercito = new MasDeUnEjercito(2);
        assertTrue(ejercito.puedeAtacar(1));
    }

    @Test
    public void SiHayTresEjercitosYSeQuiereAtacarConDosSePuedeAtacar(){
        Ejercito ejercito = new MasDeUnEjercito(3);
        assertTrue(ejercito.puedeAtacar(2));
    }
    @Test
    public void SiHayCuatroEjercitosYSeQuiereAtacarConTresSePuedeAtacar(){
        Ejercito ejercito = new MasDeUnEjercito(2);
        assertTrue(ejercito.puedeAtacar(1));
    }
    @Test
    public void SiHayDosEjercitosYSeQuiereAtacarConDosNoSePuedeAtacar(){
        Ejercito ejercito = new MasDeUnEjercito(2);
        assertFalse(ejercito.puedeAtacar(2));
    }

    @Test
    public void SiHayCincoEjercitosYSeQuiereAtacarConCuatroNoSePuedeAtacar(){
        Ejercito ejercito = new MasDeUnEjercito(5);
        assertFalse(ejercito.puedeAtacar(4));
    }

    @Test
    public  void siHayUnEjercitoOMasEntoncesElEJercitoNoEstaVacio(){
        Ejercito ejercito = new MasDeUnEjercito(1);
        assertFalse(ejercito.ejercitoVacio());
    }
    @Test
    public  void siHayCeroEjercitoOMasEntoncesElEJercitoEstaVacio(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        assertTrue(ejercito.ejercitoVacio());
    }
    @Test
    public  void siHayMasDeUnEjercitoYLaCantidadAMoverEsUnoEntoncesElEJercitoSePuedeMover(){
        Ejercito ejercito = new MasDeUnEjercito(2);
        assertTrue(ejercito.puedeMoverse(1));
    }
    @Test
    public  void siHayMasDeUnEjercitoYLaCantidadAMoverEsDosEntoncesElEJercitoNoSePuedeMover(){
        Ejercito ejercito = new MasDeUnEjercito(2);
        assertFalse(ejercito.puedeMoverse(2));
    }
    @Test
    public  void siHayMenosDeUnEjercitoEntoncesElEJercitoNoSePuedeMover(){
        Ejercito ejercito = new UnoOMenosEjercito(1);
        assertFalse(ejercito.puedeMoverse(2));
    }
}
