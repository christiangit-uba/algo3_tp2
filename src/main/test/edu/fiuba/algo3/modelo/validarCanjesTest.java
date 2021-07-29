package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class validarCanjesTest {


    @Test
    public void segundaFormaDeValidar1() throws FileNotFoundException {
        Tarjetero tarjetero = new Tarjetero();
        ColorJugador colorJugador = new ColorJugador("Rojo","Rojo");
        Jugador jugador = new Jugador(colorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloGlobo);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);


        assertTrue(jugador.validarCanjes(tarjetas,tarjetero) );
        assertEquals(tarjetero.size(),3);

    }

    @Test
    public void segundaFormaDeValidar2() throws FileNotFoundException {
        Tarjetero tarjetero = new Tarjetero();
        ColorJugador colorJugador = new ColorJugador("Rojo","Rojo");
        Jugador jugador = new Jugador(colorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");
        Simbolo simbolocanon = new Simbolo("Cañon");
        Simbolo simboloBarco = new Simbolo("Barco");

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simbolocanon);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloBarco);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);


        assertTrue(jugador.validarCanjes(tarjetas,tarjetero) );
        assertEquals(tarjetero.size(),3);

    }

    @Test
    public void segundaFormaDeValidar3() throws FileNotFoundException {
        Tarjetero tarjetero = new Tarjetero();
        ColorJugador colorJugador = new ColorJugador("Rojo","rojo");
        Jugador jugador = new Jugador(colorJugador);
        Simbolo simboloGlobo = new Simbolo("Globo");
        Simbolo simbolocanon = new Simbolo("Cañon");


        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simbolocanon);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloGlobo);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        assertFalse(jugador.validarCanjes(tarjetas,tarjetero) );
        assertEquals(tarjetero.size(),0);
    }

}

