package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebasValidadorDeAtaque {
    @Test
    public void unJugadorAtacaAUnPaisVecinoAliadoLanzaExeption() {
        Color rojo = new Color("cc3311");
        Jugador jugador1 = new Jugador(rojo);

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
        Color rojo = new Color("cc3311");
        Color azul = new Color("077bb");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);

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
        Color rosa = new Color("ee3377");
        Color negro = new Color("000000");
        Jugador jugador1 = new Jugador(rosa);
        Jugador jugador2 = new Jugador(negro);

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
        Color rosa = new Color("ee3377");
        Color negro = new Color("000000");
        Jugador jugador1 = new Jugador(rosa);
        Jugador jugador2 = new Jugador(negro);

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
        Color rosa = new Color("ee3377");
        Color negro = new Color("000000");
        Jugador jugador1 = new Jugador(rosa);
        Jugador jugador2 = new Jugador(negro);

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