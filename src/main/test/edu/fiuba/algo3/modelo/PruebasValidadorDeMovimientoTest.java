package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
public class PruebasValidadorDeMovimientoTest {

    @Test
    public void unJugadorCompruebaSiElPaisVecinoEsAliadoEsteLoEsPorLoTantoLePasaUnEjercito() throws Exception {
        ColorJugador rojo = new ColorJugador("rojo");
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
        ColorJugador rojo = new ColorJugador("rojo");
        ColorJugador azul = new ColorJugador("azul");
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
        ColorJugador rojo = new ColorJugador("rojo");
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
        ColorJugador rojo = new ColorJugador("rojo");
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
        ColorJugador rojo = new ColorJugador("rojo");
        ColorJugador azul = new ColorJugador("azul");
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

 */
