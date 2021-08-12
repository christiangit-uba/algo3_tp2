package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PruebaActivacionTarjetaTest {
    /*
    @Test
    public void PruebaActivacionTarjeta() throws FileNotFoundException {
        ColorJugador rojo = new ColorJugador("rojo","0001");
        ColorJugador verde = new ColorJugador("verde","002");
        ColorJugador negro = new ColorJugador("negro","003");

        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",verde);
        Jugador jugadorAuxiliar =  new Jugador("JugadorAuxiliar",negro);

        Juego juego = new Juego(2);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorAuxiliar);

        juego.agregarJugadores(jugadores);

        juego.asignarPaises();
        jugadores.remove(jugadorAuxiliar);

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        juego.agregarJugadores(jugadores);

        Pais Argentina = juego.obtenerPais("Argentina");
        Pais Etiopia = juego.obtenerPais("Etiopia");
        Pais chile = juego.obtenerPais("Chile");
        Pais Turquia = juego.obtenerPais("Turquia");
        Pais Francia = juego.obtenerPais("Francia");

        Tarjeta tarjetaArgentina = juego.buscarTarjeta(Argentina);
        Tarjeta tarjetaEtiopia = juego.buscarTarjeta(Etiopia);
        Tarjeta tarjetaChile = juego.buscarTarjeta(chile);
        Tarjeta tarjetaTurquia = juego.buscarTarjeta(Turquia);
        Tarjeta tarjetaFrancia = juego.buscarTarjeta(Francia);

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

        juego.iniciarTurno();

        assertEquals(Argentina.cantidadEjercitos(),1);
        assertEquals(Etiopia.cantidadEjercitos(),1);

        juego.activarTarjeta(tarjetaArgentina);
        juego.activarTarjeta(tarjetaEtiopia);

        assertEquals(Argentina.cantidadEjercitos(),3);
        assertEquals(Etiopia.cantidadEjercitos(),3);


        //Usuario selecciona para canjear sus tres cartas que son de simbolo globo.

        ArrayList<Tarjeta> tarjetasSeleccionadas = new ArrayList<>();
        tarjetasSeleccionadas.add(tarjetaArgentina);
        tarjetasSeleccionadas.add(tarjetaChile);
        tarjetasSeleccionadas.add(tarjetaEtiopia);

        juego.canjearTarjetas(tarjetasSeleccionadas);

        //tope equivale 4 ejercitos por el primer canjes mas 3 ejercitos por la cantidad de paises
        assertEquals(juego.getTope(),7);
        juego.colocarEjercito(Argentina,7);

        assertEquals(Argentina.cantidadEjercitos(),10);

        juego.terminarTurno();
        juego.iniciarTurno();


        assertEquals(Turquia.cantidadEjercitos(),1);
        assertEquals(Francia.cantidadEjercitos(),1);

        juego.activarTarjeta(tarjetaFrancia);
        juego.activarTarjeta(tarjetaTurquia);

        assertEquals(Francia.cantidadEjercitos(),3);
        assertEquals(Turquia.cantidadEjercitos(),3);

        juego.terminarTurno();
    }
     */
}
