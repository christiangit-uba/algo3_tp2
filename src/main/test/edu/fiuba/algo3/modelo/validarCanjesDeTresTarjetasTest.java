package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class validarCanjesDeTresTarjetasTest {

    private Tarjetero tarjetero = new Tarjetero();
    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();

    private Simbolo simboloGlobo = new Simbolo("Globo");
    private Simbolo simboloCanon = new Simbolo("Cañon");
    private Simbolo simboloBarco = new Simbolo("Barco");

    private Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"), simboloGlobo);
    private Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"), simboloGlobo);
    private Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"), simboloCanon);
    private Tarjeta tarjetaCuatro = new Tarjeta(new Pais("Etiopia"), simboloBarco);

    public validarCanjesDeTresTarjetasTest() throws FileNotFoundException {
    }

    @Test
    public void intentoRealizarUnCanjeTeniendoDosTarjetasDelMismoSimboloYUnaDistintaPorLoTantoNoPuedoCanjear() {

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje();

        assertEquals(0, validador.validar(tarjetas, tarjetero, 1));
        assertEquals(0, tarjetero.size());
        assertEquals(3, tarjetas.size());
    }

    @Test
    public void intentoRealizarUnCanjeTeniendoTresTarjetasDelMismoSimboloYUnaDistintaPorLoTantoPuedoCanjear() {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"), simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"), simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"), simboloGlobo);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje();

        assertEquals(0, validador.validar(tarjetas, tarjetero, 0));
        assertEquals(3, tarjetero.size());

        //assertEquals(tarjetas.size(), 0);
    }

    @Test
    public void intentoRealizarUnCanjeTeniendoTresTarjetasDeDistintoSimboloPorLoTantoPuedoCanjear() {

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaTres);
        tarjetas.add(tarjetaCuatro);

        ValidarCanje validador = new ValidarCanje();

        assertEquals(4, validador.validar(tarjetas, tarjetero, 1));
        assertEquals(0, tarjetas.size());
        assertEquals(3, tarjetero.size());
    }
}
