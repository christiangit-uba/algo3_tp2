package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebasValidadorDeAtaqueTest {

    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigo() throws Exception {
        ColorJugador rojo = new ColorJugador("rojo","0001");
        ColorJugador azul = new ColorJugador("azul","0002");
        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",azul);

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
        ColorJugador rojo = new ColorJugador("rojo","0001");
        Jugador jugador1 = new Jugador("Jugador1",rojo);

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
        ColorJugador rojo = new ColorJugador("rojo","0001");
        ColorJugador azul = new ColorJugador("azul","0002");
        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",azul);

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
        ColorJugador rosa = new ColorJugador("rosa","0001");
        ColorJugador negro = new ColorJugador("negro","0002");
        Jugador jugador1 = new Jugador("Jugador1",rosa);
        Jugador jugador2 = new Jugador("Jugador2",negro);

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
        ColorJugador rosa = new ColorJugador("rosa","0001");
        ColorJugador negro = new ColorJugador("negro","0002");
        Jugador jugador1 = new Jugador("Jugador1",rosa);
        Jugador jugador2 = new Jugador("Jugador2",negro);

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
        ColorJugador rosa = new ColorJugador("rosa","0001");
        ColorJugador negro = new ColorJugador("negro","0002");
        Jugador jugador1 = new Jugador("Jugador1",rosa);
        Jugador jugador2 = new Jugador("Jugador2",negro);

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

    @Test
    public void unPaisAtacaSiempreLeQuedaUnEjercitoEnOrigen() throws Exception {
        ColorJugador rojo = new ColorJugador("rojo","0001");
        ColorJugador azul = new ColorJugador("azul","0001");
        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",azul);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Brazil);

        Argentina.agregarEjercito();


        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        jugador1.realizarAtaque(Argentina,Brazil,1,valoresDadoAtacante,valoresDadoDefensor);

        assertEquals(1,Brazil.cantidadEjercitos());
        assertEquals(1,Argentina.cantidadEjercitos());
    }
}