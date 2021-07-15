package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.*;

public class PruebaPais {

    @Test
    public void unPaisInicialmenteTieneCeroEjercitos(){
        Pais unPais = new Pais("Rusia");

        assertEquals(unPais.cantidadEjercitos(),0);
    }
    @Test
    public void unPaisConCeroEjercitosEsOcupable(){
        Pais unPais = new Pais("Rusia");

        assertTrue(unPais.ocupable());
    }

    @Test
    public void DosPaisesAliadosTienenElMismoColorDeEjercito(){
        Color color = new Color("077bb");
        Pais unPais = new Pais("Rusia");
        Pais otroPais = new Pais("Mexico");
        unPais.agregarColor(color);
        otroPais.agregarColor(color);

        assertTrue(unPais.mismoColor(otroPais));
    }

    @Test
    public void unPaisEsLimitrofeAOtro(){
        Pais unPais = new Pais("Chile");
        Pais otroPais = new Pais("Argentina");

        unPais.agregarLimitrofe(otroPais);

        assertTrue(unPais.esLimitrofe(otroPais));

    }

    @Test
    public void unPaisConCeroEjercitosLeAgregoUnoYTieneUnEjercito(){
        Pais unPais = new Pais("Chile");
        unPais.agregarEjercito();
        assertEquals(unPais.cantidadEjercitos(),1);
    }

    @Test
    public void unPaisConCeroEjercitosNoPuedeAtacar(){
        Pais unPais = new Pais("Chile");

        assertFalse(unPais.puedeAtacar(1));
    }

    @Test
    public void unPaisOcupaOtroYAhoraSonAliados(){
        Pais unPais = new Pais("Chile");
        Pais otroPais = new Pais("Argentina");
        Color unColor = new Color("Azul");

        unPais.agregarColor(unColor);
        unPais.agregarEjercito();
        unPais.agregarEjercito();

        unPais.ocuparPais(otroPais,unColor);

        assertTrue(unPais.mismoColor(otroPais));
    }

    @Test
    public void unPaisInicialmenteNoPuedeMoverEjercitos(){
        Pais unPais = new Pais("Brazil");

        assertFalse(unPais.puedeMoverse(3));
    }

    @Test
    public void unPaisInicialmenteNoPuedeAtacar(){
        Pais unPais = new Pais("Brazil");

        assertFalse(unPais.puedeAtacar(3));
    }
}