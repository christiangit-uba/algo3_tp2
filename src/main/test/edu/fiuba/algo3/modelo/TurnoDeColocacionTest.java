package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoDeColocacionTest {

    //Integracion
    @Test
    public void unJugadorPuedeCanjear_3_TarjetasDelMismoSimboloEnElTurnoDeColocacion() throws FileNotFoundException {

        Color rojo = new Color("rojo");
        Color negro = new Color("negro");

        Jugador jugador1 = new Jugador(rojo);
        Jugador jugadorAuxiliar =  new Jugador(negro);

        Tarjetero tarjetero = new Tarjetero();
        Tablero tablero = new Tablero(tarjetero);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorAuxiliar);
        tablero.asignarPaises(jugadores);
        jugadores.remove(jugadorAuxiliar);

        jugadores.add(jugador1);

        Pais Argentina = tablero.obtenerPais("Argentina");
        Pais Etiopia = tablero.obtenerPais("Etiopia");
        Pais chile = tablero.obtenerPais("Chile");

        Tarjeta tarjetaArgentina = tarjetero.buscarTarjeta(Argentina);
        Tarjeta tarjetaEtiopia = tarjetero.buscarTarjeta(Etiopia);
        Tarjeta tarjetaChile = tarjetero.buscarTarjeta(chile);

        jugador1.agregarTarjeta(tarjetaArgentina);
        jugador1.agregarTarjeta(tarjetaEtiopia);
        jugador1.agregarTarjeta(tarjetaChile);

        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        chile.agregarColor(rojo);

        TurnoDeColocacion turno = new TurnoDeColocacion(tablero,tarjetero);

        turno.turnoDe(jugador1);
        turno.calcularTope();

        //Usuario selecciona para canjear sus tres cartas que son de simbolo globo.
        turno.canjearTarjetas();

        //tope equivale 4 ejercitos por el primer canjes mas 3 ejercitos por la cantidad de paises
        assertEquals(turno.getTope(),7);
        turno.colocarEjercito(Argentina,7);

        assertEquals(Argentina.cantidadEjercitos(),8);

        turno.terminarTurno();
    }

    @Test
    public void jugador1Canjea_3_TarjetasDeMismoSimboloYJugador2NoPuedeCanjear_2_TarjetasDeMismoSimboloY_1_Distinta() throws FileNotFoundException {

        Color rojo = new Color("rojo");
        Color verde = new Color("verde");
        Color negro = new Color("negro");

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
        Pais zaire = tablero.obtenerPais("Zaire");

        Tarjeta tarjetaArgentina = tarjetero.buscarTarjeta(Argentina);
        Tarjeta tarjetaEtiopia = tarjetero.buscarTarjeta(Etiopia);
        Tarjeta tarjetaChile = tarjetero.buscarTarjeta(chile);

        Tarjeta tarjetaTurquia = tarjetero.buscarTarjeta(Turquia);
        Tarjeta tarjetaFrancia = tarjetero.buscarTarjeta(Francia);
        Tarjeta tarjetaZaire = tarjetero.buscarTarjeta(zaire);

        jugador1.agregarTarjeta(tarjetaArgentina);
        jugador1.agregarTarjeta(tarjetaEtiopia);
        jugador1.agregarTarjeta(tarjetaChile);

        jugador2.agregarTarjeta(tarjetaTurquia); //barco
        jugador2.agregarTarjeta(tarjetaFrancia); //globo
        jugador2.agregarTarjeta(tarjetaZaire);  //barco

        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        chile.agregarColor(rojo);
        Turquia.agregarColor(verde);
        Francia.agregarColor(verde);

        TurnoDeColocacion turno = new TurnoDeColocacion(tablero,tarjetero);

        turno.turnoDe(jugador1);
        turno.calcularTope();

        //Usuario selecciona para canjear sus tres cartas que son de simbolo globo.
        turno.canjearTarjetas();

        //tope equivale 4 ejercito por el primer canjes mas 3 ejercitos por la cantidad de paises
        assertEquals(turno.getTope(),7);
        assertEquals(Argentina.cantidadEjercitos(),1);

        turno.colocarEjercito(Argentina,7);
        assertEquals(Argentina.cantidadEjercitos(),8);

        turno.terminarTurno();
        turno.turnoDe(jugador2);
        turno.calcularTope();

        //el jugador2 selecciona sus dos tarjetas, pero no puede canjearlas.
        turno.canjearTarjetas();

        assertEquals(turno.getTope(),3); //tope minimo

        turno.terminarTurno();
    }
}