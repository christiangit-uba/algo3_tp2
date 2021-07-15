package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PruebaEjercito {
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoUna(){
        Ejercito ejercito = new MenosDeUnEjercito(0);
        ejercito.agregarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),1);
    }

    @Test
    public void creoEjercitoConCeroTropasYLeAgregoUnaYLeSaco1(){
        Ejercito ejercito = new MenosDeUnEjercito(0);
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),0);
    }
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoTresYLeSaco1(){
        Ejercito ejercito = new MenosDeUnEjercito(0);
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),2);
    }
    @Test
    public void creoEjercitoConCeroTropasYLeAgregoCincoYLeSaco1(){

        Ejercito ejercito = new MenosDeUnEjercito(0);
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
        Ejercito ejercito = new MenosDeUnEjercito(0);

        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.agregarEjercito();
        ejercito.sacarEjercito();
        ejercito.sacarEjercito();

        assertEquals(ejercito.getCantidadDeEjercitos(),3);

    }

}
