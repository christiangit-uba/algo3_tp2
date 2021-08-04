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
            ColorJugador rojo = new ColorJugador("rojo","001");
            ColorJugador negro = new ColorJugador("negro","002");
            ColorJugador verde = new ColorJugador("verde","003");
            ColorJugador azul = new ColorJugador("azul","004");

            Jugador jugador1 = new Jugador("Jugador1",rojo);
            Jugador jugador2 = new Jugador("Jugador2",negro);
            Jugador jugador3 = new Jugador("Jugador3",verde);
            Jugador jugadorAuxiliar = new Jugador("JugadorAuxiliar",azul);

            Juego juego = new Juego(3);
            ArrayList<Jugador> jugadores = new ArrayList<>();

            jugadores.add(jugadorAuxiliar);
            juego.agregarJugadores(jugadores);
            juego.asignarPaises();

            jugadores.remove(jugadorAuxiliar);
            jugadores.add(jugador1);
            jugadores.add(jugador2);
            jugadores.add(jugador3);
            juego.agregarJugadores(jugadores);

            Pais Argentina = juego.obtenerPais("Argentina");
            Pais Etiopia =juego.obtenerPais("Etiopia");
            Pais australia = juego.obtenerPais("Australia");
            Pais Francia = juego.obtenerPais("Francia");
            Pais tartaria = juego.obtenerPais("Tartaria");
            Pais mongolia = juego.obtenerPais("Mongolia");
            Pais turquia = juego.obtenerPais("Turquia");
            Pais iran = juego.obtenerPais("Iran");
            Pais israel = juego.obtenerPais("Israel");
            Pais aral = juego.obtenerPais("Aral");
            Pais taymir = juego.obtenerPais("Taymir");
            Pais siberia = juego.obtenerPais("Siberia");
            Pais japon = juego.obtenerPais("Japon");
            Pais gobi = juego.obtenerPais("Gobi");
            Pais malasia = juego.obtenerPais("Malasia");
            Pais arabia = juego.obtenerPais("Arabia");
            Pais india = juego.obtenerPais("India");
            Pais china = juego.obtenerPais("China");
            Pais kamtchatka = juego.obtenerPais("Kamtchatka");


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

          juego.iniciarTurno();

        /*Apenas entra el turno del jugador se calcula tope de colocacion de tropas, basado en su cantidad de
          paises y continentes conquistados
          */

            assertEquals(juego.getTope(), 3);
            assertEquals(Argentina.cantidadEjercitos(), 1);

            juego.colocarEjercito(Argentina, 3);
            assertEquals(Argentina.cantidadEjercitos(), 4);
            assertEquals(juego.getTope(), 0);

            juego.terminarTurno();
            juego.iniciarTurno();

            //15 paises /2 + 7 ejercitos por continente en asia son 14 a colocar
            assertEquals(juego.getTope(),14);
            juego.colocarEjercito(kamtchatka,14);
            assertEquals(kamtchatka.cantidadEjercitos(),15);

           juego.terminarTurno();
           juego.iniciarTurno();

            juego.colocarEjercito(Francia,2);
            assertEquals(Francia.cantidadEjercitos(),3);

            juego.terminarTurno();

        }

}
