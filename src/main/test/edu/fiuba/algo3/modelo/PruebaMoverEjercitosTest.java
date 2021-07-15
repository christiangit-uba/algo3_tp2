package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PruebaMoverEjercitosTest {
    @Test
    public void muevoUnEjercitoDeUnPaisAOtroEntoncesPaisReceptorTiene1Ejercito(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        Pais paisReceptor = new Pais("Belgica");

        ejercito.agregarEjercito();
        ejercito.agregarEjercito();

        MoverPais.moverPais(1,ejercito,paisReceptor);

        assertEquals(paisReceptor.cantidadEjercitos(),1);
    }

    @Test
    public void muevoUnEjercitoDeUnPaisAOtroEntoncesEjercitoTieneUnaTropaMenos(){
        Ejercito ejercito = new UnoOMenosEjercito(0);
        Pais paisReceptor = new Pais("Belgica");

        ejercito.agregarEjercito();
        ejercito.agregarEjercito();

        MoverPais.moverPais(1,ejercito,paisReceptor);

        assertEquals(ejercito.getCantidadDeEjercitos(),1);
    }
}
