package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PruebaActivacionTarjetaTest {
    @Test
    public void PruebaActivacionTarjeta() throws FileNotFoundException {
        ColorJugador rojo = new ColorJugador("rojo");
        ColorJugador verde = new ColorJugador("verde");
        ColorJugador negro = new ColorJugador("negro");

        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(verde);
        Jugador jugadorAuxiliar =  new Jugador(negro);

        Tarjetero tarjetero = new Tarjetero();
        Tablero tablero = new Tablero(tarjetero);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorAuxiliar);
        tablero.asignarPaises(jugadores);
        jugadores.remove(jugadorAuxiliar);

        jugadores.add(jugador1);
        jugadores.add(jugador2);


        Pais Argentina = tablero.obtenerPais("Argentina");
        Pais Etiopia = tablero.obtenerPais("Etiopia");
        Pais chile = tablero.obtenerPais("Chile");
        Pais Turquia = tablero.obtenerPais("Turquia");
        Pais Francia = tablero.obtenerPais("Francia");

        Tarjeta tarjetaArgentina = tarjetero.buscarTarjeta(Argentina);
        Tarjeta tarjetaEtiopia = tarjetero.buscarTarjeta(Etiopia);
        Tarjeta tarjetaChile = tarjetero.buscarTarjeta(chile);
        Tarjeta tarjetaTurquia = tarjetero.buscarTarjeta(Turquia);
        Tarjeta tarjetaFrancia = tarjetero.buscarTarjeta(Francia);

        jugador1.agregarTarjeta(tarjetaArgentina);
        jugador1.agregarTarjeta(tarjetaEtiopia);
        jugador1.agregarTarjeta(tarjetaChile);
        jugador2.agregarTarjeta(tarjetaTurquia);
        jugador2.agregarTarjeta(tarjetaFrancia);

        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        chile.agregarColor(rojo);
        Turquia.agregarColor(verde);
        Francia.agregarColor(verde);

        TurnoDeColocacion turno = new TurnoDeColocacion(tablero,tarjetero);
        turno.turnoDe(jugador1);
        turno.calcularTope();

        assertEquals(Argentina.cantidadEjercitos(),1);
        assertEquals(Etiopia.cantidadEjercitos(),1);

        turno.activarTarjeta(tarjetaArgentina);
        turno.activarTarjeta(tarjetaEtiopia);

        assertEquals(Argentina.cantidadEjercitos(),3);
        assertEquals(Etiopia.cantidadEjercitos(),3);
        assertFalse(turno.activarTarjeta(tarjetaArgentina));

        //Usuario selecciona para canjear sus tres cartas que son de simbolo globo
        ArrayList<Tarjeta> tarjetasSeleccionadas = new ArrayList<>();
        tarjetasSeleccionadas.add(tarjetaArgentina);
        tarjetasSeleccionadas.add(tarjetaChile);
        tarjetasSeleccionadas.add(tarjetaEtiopia);

        turno.canjearTarjetas(tarjetasSeleccionadas);

        //tope equivale 4 ejercitos por el primer canjes mas 3 ejercitos por la cantidad de paises
        assertEquals(turno.getTope(),7);
        turno.colocarEjercito(Argentina,7);

        assertEquals(Argentina.cantidadEjercitos(),10);

        turno.terminarTurno();
        turno.turnoDe(jugador2);
        turno.calcularTope();

        assertEquals(Turquia.cantidadEjercitos(),1);
        assertEquals(Francia.cantidadEjercitos(),1);

        turno.activarTarjeta(tarjetaFrancia);
        turno.activarTarjeta(tarjetaTurquia);

        assertEquals(Francia.cantidadEjercitos(),3);
        assertEquals(Turquia.cantidadEjercitos(),3);
        assertFalse(turno.activarTarjeta(tarjetaTurquia));
        turno.terminarTurno();
    }
}
