package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebasValidadorDeAtaqueTest {

    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigo() throws Exception {
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


        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        jugador1.realizarAtaque(Argentina,Brazil,1,valoresDadoAtacante,valoresDadoDefensor);

        assertEquals(1,Brazil.cantidadEjercitos());
        assertEquals(1,Argentina.cantidadEjercitos());
    }

    @Test
    public void unJugadorAtacaAUnPaisVecinoAliadoLanzaExeption() {
        Color rojo = new Color("rojo");
        Jugador jugador1 = new Jugador(rojo);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador1.asignarPais(Brazil);

        Argentina.agregarEjercito();

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Argentina,Brazil,1,valoresDadoAtacante,valoresDadoDefensor));

    }

    @Test
    public void unJugadorAtacaAUnPaisQueNoEsLimitrofeLanzaExeption() {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);

        Pais Argentina = new Pais("Argentina");
        Pais Rusia = new Pais("Rusia");

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Rusia);

        Argentina.agregarEjercito();

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Argentina,Rusia,1,valoresDadoAtacante,valoresDadoDefensor));

    }

    @Test
    public void PaisAtacaAOtroPaisConUnPaisNoConquistadoLanzoExepcion() {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
        Jugador jugador1 = new Jugador(rosa);
        Jugador jugador2 = new Jugador(negro);

        Pais Espana = new Pais("España");
        Pais Francia = new Pais("Francia");

        Espana.agregarLimitrofe(Francia);
        Francia.agregarLimitrofe(Espana);

        jugador1.asignarPais(Espana);
        jugador2.asignarPais(Francia);

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Francia,Espana,1,valoresDadoAtacante,valoresDadoDefensor));

    }

    @Test
    public void PaisAtacaAOtroPaisConNingunaTropaLanzoExepcion() {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
        Jugador jugador1 = new Jugador(rosa);
        Jugador jugador2 = new Jugador(negro);

        Pais Espana = new Pais("España");
        Pais Francia = new Pais("Francia");

        Espana.agregarLimitrofe(Francia);
        Francia.agregarLimitrofe(Espana);

        jugador1.asignarPais(Espana);
        jugador2.asignarPais(Francia);

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        assertThrows(Exception.class,
                ()-> jugador1.realizarAtaque(Espana,Francia,1, valoresDadoAtacante,valoresDadoDefensor));

    }

    @Test
    public void PaisAtacaAOtroPaisCon3Ejercitos() throws Exception {
        Color rosa = new Color("rosa");
        Color negro = new Color("negro");
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

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        jugador1.realizarAtaque(Espana,Francia,3,valoresDadoAtacante,valoresDadoDefensor);

        assertEquals(3,Espana.cantidadEjercitos());
    }
}