package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.colores.*;

public class PaisTest {
    private String nombre = "Argentina";
    private String blanco = "ffffff";
    private String azul = "077bb";
    private Colores colorAzul = new ColorAzul();

    private Pais pais = new Pais(nombre);
    private Pais pais2 = new Pais("Brasil");
    private Pais pais3 = new Pais("Chile");
    private Pais pais4 = new Pais("Uruguay");

    @Test
    public void unPaisPorDefaultTiene0EjercitosYEsDeColorBlanco() {
        assertEquals((pais.color()).color(), blanco);
        assertEquals(pais.cantidadDeEjercitos(), 0);
    }

    //Limitrofes
    @Test
    public void unPaisLimitrofeEsLimitrofe() {
        pais.agregarLimitrofe(pais2);
        assert(pais.esLimitrofe(pais2));
    }

    @Test
    public void unPaisNoLimitrofeNoEsLimitrofe() {
        assertFalse(pais.esLimitrofe(pais2));
    }

    @Test
    public void unPaisNoEsLimitrofeDeSiMismo() {
        assertFalse(pais.esLimitrofe(pais));
    }

    @Test
    public void unPaisLimitrofeEsLimitrofeConVariosLimitrofes() {
        pais.agregarLimitrofe(pais2);
        pais.agregarLimitrofe(pais3);
        pais.agregarLimitrofe(pais4);

        assert(pais.esLimitrofe(pais3));
    }

    @Test
    public void TodoslosPaisesLimitrofeSonLimitrofes() {
        ArrayList <Pais> lista = new ArrayList<Pais>();
        lista.add(pais2);
        lista.add(pais3);
        lista.add(pais4);

        pais.agregarLimitrofes(lista);

        assert(pais.esLimitrofe(pais3));
        assert(pais.esLimitrofe(pais2));
        assert(pais.esLimitrofe(pais4));
    }

    @Test
    public void dosPaisesConElMismoNombreSonIguales(){
        Pais unPais = new Pais("Argentina");
        assert (pais.esElMismoPais(unPais));
    }

    //Colores
    @Test
    public void unPaisPuedeCambiarDeColor(){
        assertEquals((pais.color()).color(), blanco);
        pais.cambiarColor(colorAzul);
        assertEquals((pais.color()).color(), azul);
    }

    //Ejercitos

}