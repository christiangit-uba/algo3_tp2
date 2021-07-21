package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private ProximoCanje proximoCanje = new ProximoCanje();

    public validarCanjesDeTresTarjetasTest() throws FileNotFoundException {
    }

    //Canjes unitarios
    @Test
    public void noPuedoCanjearDosTarjetasConElMismoSimboloYUnaConDistintoSimbolo() {

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(0, validador.validar(tarjetas, proximoCanje));
        assertEquals(0, tarjetero.size());
        assertEquals(3, tarjetas.size());

        assertEquals(1, proximoCanje.getProximo());
    }

    @Test
    public void canjear_3_TarjetasConElMismoSimboloOtorga_4_Ejercitos() {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"), simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"), simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"), simboloGlobo);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(4, validador.validar(tarjetas, proximoCanje));
        assertEquals(0, tarjetas.size());
        assertEquals(3, tarjetero.size());

        assertEquals(2, proximoCanje.getProximo());
    }

    @Test
    public void canjear_3_TarjetasConDistintoSimboloOtorga_4_Ejercitos() {

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaTres);
        tarjetas.add(tarjetaCuatro);

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(4, validador.validar(tarjetas, proximoCanje));
        assertEquals(3, tarjetero.size());
        assertEquals(0, tarjetas.size());

        assertEquals(2, proximoCanje.getProximo());
    }

    @Test
    public void canjear_3_TarjetasConElMismoSimboloOtorga_4_EjercitosTeniendo_4_TarjetasIguales() {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"), simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"), simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"), simboloGlobo);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);
        tarjetas.add(new Tarjeta(new Pais("Australia"), simboloGlobo));

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(4, validador.validar(tarjetas, proximoCanje));
        assertEquals(3, tarjetero.size());
        assertEquals(1, tarjetas.size());

        assertEquals(2, proximoCanje.getProximo());
    }

    //canje Mixto
    @Test
    public void canjear_3_TarjetasDeIgualSimboloY_3_DeDistintoSimboloOtorga_11_Ejercitos(){

        //distintas
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaTres);
        tarjetas.add(tarjetaCuatro);

        //Iguales
        tarjetas.add( new Tarjeta(new Pais("Oregon"), simboloGlobo) );
        tarjetas.add( new Tarjeta(new Pais("Argentina"), simboloGlobo) );
        tarjetas.add( new Tarjeta(new Pais("Brasil"), simboloGlobo) );

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(11, validador.validar(tarjetas, proximoCanje));
        assertEquals(0, tarjetas.size());
        assertEquals(6, tarjetero.size());

        assertEquals(3, proximoCanje.getProximo());
    }

    //canjes dobles Iguales
    @Test
    public void canjear_6_TarjetasConElMismoSimboloOtorga_11_Ejercitos() {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"), simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"), simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"), simboloGlobo);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        tarjetas.add(new Tarjeta(new Pais("Java"), simboloGlobo));
        tarjetas.add(new Tarjeta(new Pais("Etiopia"), simboloGlobo));
        tarjetas.add(new Tarjeta(new Pais("Australia"), simboloGlobo));

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(11, validador.validar(tarjetas, proximoCanje));
        assertEquals(0, tarjetas.size());
        assertEquals(6, tarjetero.size());

        assertEquals(3, proximoCanje.getProximo());
    }

    @Test
    public void canjear_6_TarjetasConDistintoSimboloOtorga_11_Ejercitos() {

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaCuatro);
        tarjetas.add(tarjetaTres);

        tarjetas.add(new Tarjeta(new Pais("Java"), simboloGlobo));
        tarjetas.add(new Tarjeta(new Pais("Etiopia"), simboloCanon));
        tarjetas.add(new Tarjeta(new Pais("Australia"), simboloBarco));

        ValidarCanje validador = new ValidarCanje(tarjetero);

        assertEquals(11, validador.validar(tarjetas, proximoCanje));
        assertEquals(0, tarjetas.size());
        assertEquals(6, tarjetero.size());

        assertEquals(3, proximoCanje.getProximo());
    }
}
