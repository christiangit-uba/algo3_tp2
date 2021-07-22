package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PruebaRondaJugadoresColocarTest {
    @Test
    public void PruebaActivacionTarjeta() throws FileNotFoundException {
        Color rojo = new Color("rojo");
        Color verde = new Color("verde");
        Color azul = new Color("azul");

        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(verde);
        Jugador jugadorAuxiliar = new Jugador(azul);

        Tarjetero tarjetero = new Tarjetero();
        Tablero tablero = new Tablero(tarjetero);
        ArrayList<Jugador> jugadores = new ArrayList<>();


        jugadores.add(jugadorAuxiliar);
        tablero.asignarPaises(jugadores);


        Pais Argentina = tablero.obtenerPais("Argentina");
        Pais Etiopia = tablero.obtenerPais("Etiopia");
        Pais Turquia = tablero.obtenerPais("Turquia");
        Pais Francia = tablero.obtenerPais("Francia");


        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        Turquia.agregarColor(verde);
        Francia.agregarColor(verde);


        TurnoDeColocacion turno = new TurnoDeColocacion(tablero,tarjetero);
        turno.turnoDe(jugador1);
        turno.calcularTope();

        /*Apenas entra el turno del jugador se calcula tope de colocacion de tropas, basado en su cantidad de
          paises y continentes conquistados
        */
        assertEquals(turno.getTope(),3);
        assertEquals(Argentina.cantidadEjercitos(),1);

        turno.colocarEjercito(Argentina,2);
        assertEquals(Argentina.cantidadEjercitos(),3);
        assertEquals(turno.getTope(),1);

        assertEquals(Etiopia.cantidadEjercitos(),1);

        turno.colocarEjercito(Etiopia,1);

        assertEquals(Etiopia.cantidadEjercitos(),2);
        assertFalse(turno.colocarEjercito(Argentina,1));

        turno.terminarTurno();
        turno.turnoDe(jugador2);
        turno.calcularTope();

        assertEquals(turno.getTope(),3);
        assertFalse(turno.colocarEjercito(Argentina,1));

        turno.colocarEjercito(Turquia,3);
        assertEquals(Turquia.cantidadEjercitos(),4);
        assertEquals(turno.getTope(),0);
        turno.terminarTurno();
    }
}
