package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaDeAtaqueDeJugadoresYObtencionDeTarjetasDePaisesTest {

    @Test
    public void PruebaDeAtaqueDeJugadoresYObtencionDeTarjetasDePaises() throws Exception {
        //---------------inicializacion jugadores, tablero y tarjetero-----------------------
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Color negro = new Color("negro");

        Jugador jugador1 = new Jugador(rojo);
        Jugador jugadorAuxiliar = new Jugador(azul);

        Tarjetero tarjetero = new Tarjetero();
        Tablero tablero = new Tablero(tarjetero);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugadorAuxiliar);
        tablero.asignarPaises(jugadores);
        //------------------asignacion de paises---------------------
        Pais Argentina = tablero.obtenerPais("Argentina");
        Pais Brazil = tablero.obtenerPais("Brazil");
        Pais Chile = tablero.obtenerPais("Chile");

        Argentina.agregarColor(rojo);
        Chile.agregarColor(negro);
        Brazil.agregarColor(negro);

        Argentina.agregarEjercito();
        Argentina.agregarEjercito();
        Argentina.agregarEjercito();

        assertTrue(Argentina.mismoColor(rojo));
        assertTrue(Chile.mismoColor(negro));
        assertTrue(Brazil.mismoColor(negro));

        //-----------------creacion y uso de un dado cargado---------------------------
        DadoCargado dadoAtacante = new DadoCargado();
        DadoCargado dadoDefensor = new DadoCargado();

        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        dadoAtacante.setValores(valoresDadoAtacante);
        dadoDefensor.setValores(valoresDadoDefensor);

        //--------------------ataque y ocupacion de chile----------------------------
        dadoAtacante.comparar(dadoDefensor,Argentina,Chile);

        Argentina.ocuparPais(Chile,rojo);

        jugador1.agregarTarjeta(tarjetero.buscarTarjeta(Chile));

        assertEquals(jugador1.cantidadTarjetas(),1);
        assertEquals(Argentina.cantidadEjercitos(),3);
        assertTrue(Chile.mismoColor(rojo));

        //-------------------recarga de dados para segundo ataque---------------------
        valoresDadoAtacante.clear();
        valoresDadoDefensor.clear();

        valoresDadoAtacante.add(4);
        valoresDadoDefensor.add(1);

        dadoAtacante.setValores(valoresDadoAtacante);
        dadoDefensor.setValores(valoresDadoDefensor);

        //--------------------ataque y ocupacion de brazil-----------------------------
        dadoAtacante.comparar(dadoDefensor,Argentina,Brazil);

        Argentina.ocuparPais(Brazil,rojo);

        jugador1.agregarTarjeta(tarjetero.buscarTarjeta(Brazil));

        assertEquals(jugador1.cantidadTarjetas(),2);
        assertEquals(Argentina.cantidadEjercitos(),2);
        assertTrue(Brazil.mismoColor(rojo));
    }
}
