package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;

public class TableroTest {
    private Tablero mapa = new Tablero();
    private Pais argentina = new Pais("Argentina");
    private int paisesTotales = 49;

    private String blanco = "ffffff";

    @Test
    public void seCargoUnPais(){
       assert(mapa.elPaisEstaCargado(argentina));
    }

    @Test
    public void seCargaronVariosPaises(){
        Pais pais1 = new Pais("Polonia");
        Pais pais2 = new Pais("Gran Bretaña");
        Pais pais3 = new Pais("Japon");
        Pais pais4 = new Pais("Java");

        assert(mapa.elPaisEstaCargado(pais1));
        assert(mapa.elPaisEstaCargado(pais2));
        assert(mapa.elPaisEstaCargado(pais3));
        assert(mapa.elPaisEstaCargado(pais4));
    }

    @Test
    public void seCargaronLos_49_Paises(){
        assertEquals(paisesTotales, mapa.size());
    }

    @Test
    public void elTableroEntregaUnPaisInicializadoAlJugador(){
        Pais pais = mapa.darUnPais();

        assertEquals((pais.color()).color(), blanco);
        assertEquals(pais.cantidadDeEjercitos(), 0);

        assertEquals(mapa.sizeCopia(), paisesTotales -1);
    }

    @Test
    public void sePuedenRepartirTodosLosPaises(){
        LinkedHashSet<Pais> set = new LinkedHashSet<Pais>();
        Pais aux = new Pais("algo");
        int i = 0;

        for (; i < paisesTotales; i++) {
            aux = mapa.darUnPais();
            set.add(aux);
        }

        assertEquals(set.size(), paisesTotales);
    }
}