package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RondaDeColocacionConTresJugadoresTest {

        @Test
        public void rondaConTresJugadoresConJugadorDosConAsiaConquistado() throws FileNotFoundException {
            Color rojo = new Color("rojo");
            Color verde = new Color("verde");
            Color azul = new Color("azul");
            Color negro = new Color("negro");

            Jugador jugador1 = new Jugador(rojo);
            Jugador jugador2 = new Jugador(negro);
            Jugador jugador3 = new Jugador(verde);
            Jugador jugadorAuxiliar = new Jugador(azul);

            Tarjetero tarjetero = new Tarjetero();
            Tablero tablero = new Tablero(tarjetero);
            ArrayList<Jugador> jugadores = new ArrayList<>();

            jugadores.add(jugadorAuxiliar);
            tablero.asignarPaises(jugadores);

            Pais Argentina = tablero.obtenerPais("Argentina");
            Pais Etiopia = tablero.obtenerPais("Etiopia");
            Pais australia = tablero.obtenerPais("Australia");
            Pais Francia = tablero.obtenerPais("Francia");
            Pais tartaria = tablero.obtenerPais("Tartaria");
            Pais mongolia = tablero.obtenerPais("Mongolia");
            Pais turquia = tablero.obtenerPais("Turquia");
            Pais iran = tablero.obtenerPais("Iran");
            Pais israel = tablero.obtenerPais("Israel");
            Pais aral = tablero.obtenerPais("Aral");
            Pais taymir = tablero.obtenerPais("Taymir");
            Pais siberia = tablero.obtenerPais("Siberia");
            Pais japon = tablero.obtenerPais("Japon");
            Pais gobi = tablero.obtenerPais("Gobi");
            Pais malasia = tablero.obtenerPais("Malasia");
            Pais arabia = tablero.obtenerPais("Arabia");
            Pais india = tablero.obtenerPais("India");
            Pais china = tablero.obtenerPais("China");
            Pais kamtchatka = tablero.obtenerPais("Kamtchatka");


            Argentina.agregarColor(rojo);
            Etiopia.agregarColor(rojo);
            australia.agregarColor(verde);
            Francia.agregarColor(verde);
            tartaria.agregarColor(negro);
            mongolia.agregarColor(negro);
            turquia.agregarColor(negro);
            iran.agregarColor(negro);
            israel.agregarColor(negro);
            aral.agregarColor(negro);
            taymir.agregarColor(negro);
            siberia.agregarColor(negro);
            japon.agregarColor(negro);
            gobi.agregarColor(negro);
            malasia.agregarColor(negro);
            arabia.agregarColor(negro);
            china.agregarColor(negro);
            india.agregarColor(negro);
            kamtchatka.agregarColor(negro);

            TurnoDeColocacion turno = new TurnoDeColocacion(tablero, tarjetero);
            turno.turnoDe(jugador1);

        /*Apenas entra el turno del jugador se calcula tope de colocacion de tropas, basado en su cantidad de
          paises y continentes conquistados
        */
            assertEquals(turno.getTope(), 3);
            assertEquals(Argentina.cantidadEjercitos(), 1);

            turno.colocarEjercito(Argentina, 3);
            assertEquals(Argentina.cantidadEjercitos(), 4);
            assertEquals(turno.getTope(), 0);

            turno.terminarTurno();
            turno.turnoDe(jugador2);

            //15 paises /2 + 7 ejercitos por continente en asia son 14 a colocar
            assertEquals(turno.getTope(),14);
            turno.colocarEjercito(kamtchatka,14);
            assertEquals(kamtchatka.cantidadEjercitos(),15);

            turno.terminarTurno();
            turno.turnoDe(jugador3);

            turno.colocarEjercito(Francia,2);
            assertEquals(Francia.cantidadEjercitos(),3);

            turno.terminarTurno();

        }

}
