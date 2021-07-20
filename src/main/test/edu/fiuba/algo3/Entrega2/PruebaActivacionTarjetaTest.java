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
        Color rojo = new Color("rojo");
        Color verde = new Color("verde");

        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(verde);

        Tarjetero tarjetero = new Tarjetero();
        Tablero tablero = new Tablero(tarjetero);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        tablero.asignarPaises(jugadores);

        Pais Argentina = tablero.obtenerPais("Argentina");
        Pais Etiopia = tablero.obtenerPais("Etiopia");
        Pais Turquia = tablero.obtenerPais("Turquia");
        Pais Francia = tablero.obtenerPais("Francia");

        Tarjeta tarjetaArgentina = tarjetero.buscarTarjeta(Argentina);
        Tarjeta tarjetaEtiopia = tarjetero.buscarTarjeta(Etiopia);
        Tarjeta tarjetaTurquia = tarjetero.buscarTarjeta(Turquia);
        Tarjeta tarjetaFrancia = tarjetero.buscarTarjeta(Francia);

        jugador1.agregarTarjeta(tarjetaArgentina);
        jugador1.agregarTarjeta(tarjetaEtiopia);
        jugador2.agregarTarjeta(tarjetaTurquia);
        jugador2.agregarTarjeta(tarjetaFrancia);

        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        Turquia.agregarColor(verde);
        Francia.agregarColor(verde);

        TurnoDeColocacion turno = new TurnoDeColocacion(tablero,tarjetero);
        turno.turnoDe(jugador1);

        assertEquals(Argentina.cantidadEjercitos(),1);
        assertEquals(Etiopia.cantidadEjercitos(),1);

        turno.activarTarjeta(tarjetaArgentina);
        turno.activarTarjeta(tarjetaEtiopia);

        assertEquals(Argentina.cantidadEjercitos(),3);
        assertEquals(Etiopia.cantidadEjercitos(),3);
        assertFalse(turno.activarTarjeta(tarjetaArgentina));

        turno.terminarTurno();
        turno.turnoDe(jugador2);

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
