package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;


public class TableroTest {
    private Tablero mapa;
    { try {
            mapa = new Tablero();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String nombreArg = "Argentina";
    private String nombreAus = "Australia";
    private String nombreMon = "Mongolia";
    private String nombreMex = "Mexico";
    private String nombreEsp = "España";
    private String nombreChi = "China";
    private String nombreJava = "Java";
    private String nombreUru = "Uruguay";
    private String nombreBra = "Brazil";
    private String nombreChile = "Chile";
    private String nombrePer = "Peru";

    private Pais argentina = new Pais("Argentina");
    private Pais australia = new Pais(nombreAus);
    private Pais mongolia = new Pais(nombreMon);
    private Pais mexico = new Pais(nombreMex);
    private Pais espania = new Pais(nombreEsp);
    private Pais china = new Pais(nombreChi);
    private Pais java = new Pais(nombreJava);

    private Pais uruguay = new Pais(nombreUru);
    private Pais brasil = new Pais(nombreBra);
    private Pais chile = new Pais(nombreChile);
    private Pais peru = new Pais(nombrePer);

    private Pais aux;
    private Pais pais1;
    private Pais pais2;
    private Pais pais3;
    private Pais pais4;
    private Pais pais5;

    private Color colorBlanco = new Color("ffffff");

    //Inicializacion de Tablero
    @Test
    public void unPaisEstaCargadoEnElTablero(){
        aux = mapa.obtenerPais(nombreArg);
        assert(aux.mismoNombre(argentina));
    }

    @Test
    public void variosPaisesEstanCargadosEnElTablero(){
        aux = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(australia));

        aux = mapa.obtenerPais(nombreMon);
        assert(aux.mismoNombre(mongolia));

        aux = mapa.obtenerPais(nombreMex);
        assert(aux.mismoNombre(mexico));

        aux = mapa.obtenerPais(nombreEsp);
        assert(aux.mismoNombre(espania));

        aux = mapa.obtenerPais(nombreChi);
        assert(aux.mismoNombre(china));

        aux = mapa.obtenerPais(nombreJava);
        assert(aux.mismoNombre(java));
    }

    @Test
    public void unPaisEntregadoPorElTableroSeComportaComoUnPais(){
        aux = mapa.obtenerPais(nombreArg);
        assert(aux.mismoNombre(nombreArg));

        pais1 = mapa.obtenerPais(nombreUru);
        pais2 = mapa.obtenerPais(nombreBra);
        pais3 = mapa.obtenerPais(nombreChile);
        pais4 = mapa.obtenerPais(nombrePer);

        assertEquals(0, aux.cantidadEjercitos());

        assert(aux.esLimitrofe(pais1));
        assert(aux.esLimitrofe(pais2));
        assert(aux.esLimitrofe(pais3));
        assert(aux.esLimitrofe(pais4));
    }

    @Test
    public void losPaisesLimitrofesDeUnPaisSonLimitrofesEntreSi(){
        aux = mapa.obtenerPais(nombreArg);
        pais1 = mapa.obtenerPais(nombreUru);
        pais2 = mapa.obtenerPais(nombreBra);
        pais3 = mapa.obtenerPais(nombreChile);
        pais4 = mapa.obtenerPais(nombrePer);

        assert(aux.esLimitrofe(pais1));
        assert(aux.esLimitrofe(pais2));
        assert(aux.esLimitrofe(pais3));
        assert(aux.esLimitrofe(pais4));

        assert(pais1.esLimitrofe(aux));
        assert(pais2.esLimitrofe(aux));
        assert(pais3.esLimitrofe(aux));
        assert(pais4.esLimitrofe(aux));

        assert(pais3.esLimitrofe(pais4));
        assert(pais1.esLimitrofe(pais2));
    }

    @Test
    public void unPaisInicializadoDelTableroPuedeCambiarDecolor(){
        aux = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(australia));

        aux.agregarColor(colorBlanco);
        assert(aux.mismoColor(colorBlanco));

        pais1 = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(australia));
        assert(pais1.mismoColor(colorBlanco));
    }

/*
    @Test
    public void seCargaronLos_49_PaisesEnElTablero(){   //para saber si se cargaron todos, test de integracion con 1 jugador
        assertEquals(49, mapa.cantidadDePaises(color));
    }

 */

/*
    private Tablero mapa = new Tablero();
    private Pais argentina = new Pais("Argentina");
    private int paisesTotales = 49;

    private String blanco = "ffffff";

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
 */
}