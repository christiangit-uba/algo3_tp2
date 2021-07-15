package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PruebasValidadorDeMovimiento {

    @Test
    public void unJugadorCompruebaSiElPaisVecinoEsAliadoEsteLoEsPorLoTantoLePasaUnEjercito() throws Exception {
        Color rojo = new Color("rojo");
        Jugador jugador1 = new Jugador(rojo);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador1.asignarPais(Brazil);

        Argentina.agregarEjercito();

        jugador1.realizarMovimiento(Argentina,Brazil,1);

        assertEquals(2,Brazil.cantidadEjercitos());

    }
    @Test
    public void unJugadorCompruebaSiElPaisVecinoEsAliadoEsteNoLoEsPorLoTantoLanzaExeption() {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Brazil);

        Argentina.agregarEjercito();

        assertThrows(Exception.class,
                ()-> jugador1.realizarMovimiento(Argentina,Brazil,1));

    }
    @Test
    public void unPaisCon1EjercitoMueveUnEjercitoAUnPaisVecinoLanzaExepcion() {
        Color rojo = new Color("rojo");
        Jugador jugador1 = new Jugador(rojo);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador1.asignarPais(Brazil);

        assertThrows(Exception.class,
                ()-> jugador1.realizarMovimiento(Argentina,Brazil,1));

    }
    @Test
    public void PasoUnEjercitoAOtroPaisEsteNoEsLimitrofeLanzoExepcion() {
        Color rojo = new Color("rojo");
        Jugador jugador1 = new Jugador(rojo);

        Pais Argentina = new Pais("Argentina");
        Pais Africa = new Pais("Africa");

        jugador1.asignarPais(Argentina);
        jugador1.asignarPais(Africa);

        assertThrows(Exception.class,
                ()-> jugador1.realizarMovimiento(Argentina,Africa,1));

    }
    @Test
    public void PaisLimitrofeNoEstaConquistadoLanzoExepcion() {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Brazil);

        assertThrows(Exception.class,
                ()-> jugador1.realizarMovimiento(Brazil,Argentina,1));

    }

}
