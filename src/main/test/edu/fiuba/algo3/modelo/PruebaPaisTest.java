package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.*;

public class PruebaPaisTest {

    private Pais argentina = new Pais("Argentina");
    private Pais chile = new Pais("Chile");
    private Pais uruguay = new Pais("Uruguay");
    private Pais brasil = new Pais("Brasil");

    private Pais otroChile = new Pais("Chile");
    private Color colorBlanco = new Color ("ffffff");
    private Color colorNegro = new Color ("000000");

    //Inicializacion
    @Test
    public void unPaisSeCreaInicilizadoConCeroEjercitos() {
        assertEquals(0, argentina.cantidadEjercitos());
    }

    @Test
    public void unPaisInicializado_NO_TienePaisesLimitrofes() {
        assertFalse(argentina.esLimitrofe(chile));
    }

    @Test
    public void unPaisNoEsLimitrofeDeSiMismo(){
        assertFalse(argentina.esLimitrofe(argentina));
    }

    @Test
    public void unPaisConElMismoNombreEsElMismoPais(){
        assert(chile.mismoNombre("Chile"));
    }

    //Limitrofes
    @Test
    public void agregarUnPaisLimitrofeEnUnPaisLoVuelveLimitrofeDelPais(){
        assertFalse(argentina.esLimitrofe(chile));
        argentina.agregarLimitrofe(chile);
        assert(argentina.esLimitrofe(chile));
    }

    @Test
    public void todosLosPaisesLimitrofesAgregadosEnUnPaisSonLimitrofesDelMismo(){
        argentina.agregarLimitrofe(chile);
        argentina.agregarLimitrofe(uruguay);
        argentina.agregarLimitrofe(brasil);

        assert(argentina.esLimitrofe(chile));
        assert(argentina.esLimitrofe(uruguay));
        assert(argentina.esLimitrofe(brasil));
    }

    //****************Pruebas de Integracion********************
    //Ejercitos
    @Test
    public void agregarUnEjercitoEnUnPaisAumentaLaCantidadDeFichasEnUno(){
        assertEquals(0, argentina.cantidadEjercitos());
        argentina.agregarEjercito();
        assertEquals(1, argentina.cantidadEjercitos());
    }

    @Test
    public void sacarUnEjercitoEnUnPaisReduceLaCantidadDeFichasEnUno(){
        argentina.agregarEjercito();
        assertEquals(1, argentina.cantidadEjercitos());

        argentina.perdioEjercito();
        assertEquals(0, argentina.cantidadEjercitos());
    }


    @Test
    public void sePuedenAgregarVariosEjercitosEnUnPais(){
        int tope = 25;
        int i;

        for (i = 0; i < tope; i++) {
            argentina.agregarEjercito();
        }
        assertEquals(tope, argentina.cantidadEjercitos());
    }

    @Test
    public void sePuedenAgergarVariosEjercitosYSacarlosTodosDeUnPais(){
        int tope = 25;
        int i;

        for (i = 0; i < tope; i++) {
            argentina.agregarEjercito();
        }
        assertEquals(tope, argentina.cantidadEjercitos());

        for (int j = 0; j < tope; j++) {
            argentina.perdioEjercito();
        }
        assertEquals(0, argentina.cantidadEjercitos());
    }

    //MoverPais
    @Test
    public void sePuedenMoverSoloUnEjercitoAUnPaisLimitrofeVacio(){
        argentina.agregarEjercito();
        argentina.agregarEjercito();
        assertEquals(2, argentina.cantidadEjercitos());
        argentina.agregarLimitrofe(chile);

        assertEquals(0, chile.cantidadEjercitos());
        argentina.moverEjercitoA(chile, 1);
        assertEquals(1, chile.cantidadEjercitos());
    }

    @Test
    public void sePuedenMoverUnMaximoDe_2_EjercitosDeUnPaisCon_3_EjercitosAOtroPaisVacio() {
        argentina.agregarEjercito();
        argentina.agregarEjercito();
        argentina.agregarEjercito();
        assertEquals(3, argentina.cantidadEjercitos());
        argentina.agregarLimitrofe(chile);

        assertEquals(0, chile.cantidadEjercitos());
        argentina.moverEjercitoA(chile, 2);
        assertEquals(2, chile.cantidadEjercitos());
    }

    //Colores
    @Test
    public void elColorDeUnPaisInicializadoPuedeCambiarse(){
        argentina.agregarColor(colorBlanco);
        assert(argentina.mismoColor(colorBlanco));
    }

    @Test
    public void dosPaisesDelMismoColorSonAliados(){
        argentina.agregarColor(colorBlanco);
        chile.agregarColor(colorBlanco);
        assert(argentina.mismoColor(chile));
    }

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