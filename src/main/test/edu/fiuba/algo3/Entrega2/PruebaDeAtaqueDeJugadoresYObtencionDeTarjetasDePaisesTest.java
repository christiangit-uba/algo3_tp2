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
        ColorJugador rojo = new ColorJugador("rojo","001");
        ColorJugador azul = new ColorJugador("azul","002");
        ColorJugador negro = new ColorJugador("negro","003");

        Juego juego = new Juego(2);

        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugadorAuxiliar = new Jugador("JugadorAuxiliar",azul);

        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugadorAuxiliar);
        jugadores.add(jugador1);
        juego.agregarJugadores(jugadores);
        juego.asignarPaises();

        jugadores.remove(jugadorAuxiliar);

        //------------------asignacion de paises---------------------
        Pais Argentina = juego.obtenerPais("Argentina");
        Pais Brazil = juego.obtenerPais("Brazil");
        Pais Chile = juego.obtenerPais("Chile");

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

       juego.iniciarTurno();
        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);


        //--------------------ataque y ocupacion de chile----------------------------

        juego.atacar("Argentina","Chile",2,valoresDadoAtacante,valoresDadoDefensor);

        assertEquals(Argentina.cantidadEjercitos(),3);
        assertTrue(Chile.mismoColor(rojo));

        //-------------------recarga de dados para segundo ataque---------------------
        valoresDadoAtacante.clear();
        valoresDadoDefensor.clear();

        valoresDadoAtacante.add(4);
        valoresDadoDefensor.add(1);

        //--------------------ataque y ocupacion de brazil-----------------------------
        juego.atacar("Argentina","Brazil",1,valoresDadoAtacante,valoresDadoDefensor);

        assertEquals(Argentina.cantidadEjercitos(),2);
        assertTrue(Brazil.mismoColor(rojo));

        juego.terminarTurno(false);

        assertEquals(jugador1.cantidadTarjetas(),1);
    }
}
