package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebasValidadorDeAtaqueTest {
    private Tarjetero mazo = new Tarjetero();
    private ValidarCanje validador = new ValidarCanje(mazo);

    public PruebasValidadorDeAtaqueTest() throws FileNotFoundException {
    }

    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigo() throws Exception {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo, validador);
        Jugador jugador2 = new Jugador(azul, validador);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Brazil);

        Argentina.agregarEjercito();

        jugador1.realizarAtaque(Argentina,Brazil,1);

        assertEquals(1,Brazil.cantidadEjercitos());
        assertEquals(1,Argentina.cantidadEjercitos());
    }

    @Test
    public void unJugadorAtacaAUnPaisVecinoAliadoLanzaExeption() {
        Color rojo = new Color("rojo");
        Jugador jugador1 = new Jugador(rojo, validador);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador1.asignarPais(Brazil);

        Argentina.agregarEjercito();

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Argentina,Brazil,1));

    }

    @Test
    public void unJugadorAtacaAUnPaisQueNoEsLimitrofeLanzaExeption() {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo, validador);
        Jugador jugador2 = new Jugador(azul, validador);

        Pais Argentina = new Pais("Argentina");
        Pais Rusia = new Pais("Rusia");

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Rusia);

        Argentina.agregarEjercito();

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Argentina,Rusia,1));

    }

    @Test
    public void PaisAtacaAOtroPaisConUnPaisNoConquistadoLanzoExepcion() {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
        Jugador jugador1 = new Jugador(rosa, validador);
        Jugador jugador2 = new Jugador(negro, validador);

        Pais Espana = new Pais("España");
        Pais Francia = new Pais("Francia");

        Espana.agregarLimitrofe(Francia);
        Francia.agregarLimitrofe(Espana);

        jugador1.asignarPais(Espana);
        jugador2.asignarPais(Francia);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Francia,Espana,1));

    }

    @Test
    public void PaisAtacaAOtroPaisConNingunaTropaLanzoExepcion() {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
        Jugador jugador1 = new Jugador(rosa, validador);
        Jugador jugador2 = new Jugador(negro, validador);

        Pais Espana = new Pais("España");
        Pais Francia = new Pais("Francia");

        Espana.agregarLimitrofe(Francia);
        Francia.agregarLimitrofe(Espana);

        jugador1.asignarPais(Espana);
        jugador2.asignarPais(Francia);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Espana,Francia,1));

    }

    @Test
    public void PaisAtacaAOtroPaisCon3Ejercitos() throws Exception {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
        Jugador jugador1 = new Jugador(rosa, validador);
        Jugador jugador2 = new Jugador(negro, validador);

        Pais Espana = new Pais("España");
        Pais Francia = new Pais("Francia");

        Espana.agregarLimitrofe(Francia);
        Francia.agregarLimitrofe(Espana);

        jugador1.asignarPais(Espana);
        jugador2.asignarPais(Francia);

        Espana.agregarEjercito();
        Espana.agregarEjercito();
        Espana.agregarEjercito();

        jugador1.realizarAtaque(Espana,Francia,3);

        assertEquals(3,Espana.cantidadEjercitos());
    }
}