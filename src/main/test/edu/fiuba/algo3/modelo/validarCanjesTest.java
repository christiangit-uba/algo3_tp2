package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class validarCanjesTest {
    @Test
    public void intentoRealizarUnCanjeTeniendoDosTarjetasDelMismoSimboloYUnaDistintaPorLoTantoNoPuedoCanjear(){
        Tarjetero tarjetero = new Tarjetero();
        Simbolo simboloGlobo = new Simbolo("Globo");
        Simbolo simbolocanon = new Simbolo("Cañon");
    Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
    Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simboloGlobo);
    Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simbolocanon);

    ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    tarjetas.add(tarjetaUno);
    tarjetas.add(tarjetaDos);
    tarjetas.add(tarjetaTres);

    ValidarCanje validador = new ValidarCanje();

     assertFalse(validador.validar(tarjetas,tarjetero));
     assertEquals(tarjetero.size(),1);
     assertEquals(tarjetas.size(),3);

    }

    @Test
    public void intentoRealizarUnCanjeTeniendoTresTarjetasDeDistintoSimboloPorLoTantoPuedoCanjear(){
        Tarjetero tarjetero = new Tarjetero();
        Simbolo simboloGlobo = new Simbolo("Globo");
        Simbolo simbolocanon = new Simbolo("Cañon");
        Simbolo simboloBarco = new Simbolo("Barco");

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simboloBarco);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simbolocanon);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje();

        assertTrue(validador.validar(tarjetas,tarjetero));
        assertEquals(tarjetero.size(),4);
        assertEquals(tarjetas.size(),0);



    }
    @Test
    public void intentoRealizarUnCanjeTeniendoTresTarjetasDelMismoSimboloYUnaDistintaPorLoTantoPuedoCanjear(){
        Tarjetero tarjetero = new Tarjetero();
        Simbolo simboloGlobo = new Simbolo("Globo");

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloGlobo);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje();

        assertTrue(validador.validar(tarjetas,tarjetero));
        assertEquals(tarjetero.size(),4);
        assertEquals(tarjetas.size(),0);
    }


}
