package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

public class ContinentesTest {
    private Continentes contienente = new Continentes();
    private String americaDelSur = "America Del Sur";
    private String americaDelNorte = "America Del Norte";
    private String americaCentral = "America Central";
    private String europa = "Europa";
    private String asia = "Asia";
    private String africa = "Africa";
    private String oceania = "Oceania";

    private Pais argentina = new Pais("Argentina");
    private Pais uruguay = new Pais("Uruguay");
    private Pais oregon = new Pais("Oregon");
    private Pais mexico = new Pais("Mexico");
    private Pais espania = new Pais("España");
    private Pais china = new Pais("China");
    private Pais egipto = new Pais("Egipto");
    private Pais australia = new Pais("Australia");

    @Test
    public void alMenosUnPaisPorContinenteEstaCargado(){
        assert(contienente.paisCargado(americaDelSur, argentina));
        assert(contienente.paisCargado(americaDelSur, uruguay));
        assert(contienente.paisCargado(americaCentral, mexico));
        assert(contienente.paisCargado(americaDelNorte, oregon));
        assert(contienente.paisCargado(europa, espania));
        assert(contienente.paisCargado(asia, china));
        assert(contienente.paisCargado(africa, egipto));
        assert(contienente.paisCargado(oceania, australia));
    }

    @Test
    public void losPaisesCargadosFuncionanComoPaises() {
        boolean estaCargado = false;
        ArrayList<Pais> aux = contienente.obtener(americaDelSur);
        assertEquals(6, aux.size());

        //chequeo que los paises estan en la lista.
        for (Pais unPais : aux) {
            if (unPais.esElMismoPais(argentina))
                estaCargado = true;
        }

        assert (estaCargado);
        estaCargado = false;

        for (Pais unPais : aux) {
            if (unPais.esElMismoPais(uruguay))
                estaCargado = true;
        }
        assert (estaCargado);
    }

    @Test
    public void laCantidadDePaisesPorContienteEsCorrecta() {
        ArrayList<Pais> aux = contienente.obtener(americaDelSur);
        assertEquals(6, aux.size());

        aux = contienente.obtener(americaCentral);
        assertEquals(1, aux.size());

        aux = contienente.obtener(americaDelNorte);
        assertEquals(9, aux.size());

        aux = contienente.obtener(europa);
        assertEquals(8, aux.size());

        aux = contienente.obtener(asia);
        assertEquals(19, aux.size());

        aux = contienente.obtener(africa);
        assertEquals(6, aux.size());

        aux = contienente.obtener(oceania);
        assertEquals(1, aux.size());
    }

    @Test
    public void enUnContinenteSoloSeEncuentranLosPaisesCorrectos(){
        ArrayList<Pais> aux = contienente.obtener(americaCentral);
        assertFalse(aux.contains(argentina));
        boolean estaCargado = true;

        for (Pais unPais : aux) {
            estaCargado = estaCargado && (unPais.esElMismoPais(argentina));
        }
        assertFalse(estaCargado);

        estaCargado = true;
        for (Pais unPais : aux) {
            estaCargado = estaCargado && (unPais.esElMismoPais(mexico));
        }
        assert(estaCargado);
    }
}