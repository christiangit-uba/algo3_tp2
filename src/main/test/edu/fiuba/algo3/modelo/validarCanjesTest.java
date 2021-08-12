package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class validarCanjesTest {

    private Tarjetero tarjetero = new Tarjetero();
    private ColorJugador colorJugador = new ColorJugador("Rojo","001");
    private Jugador jugador = new Jugador("Jugador1",colorJugador);
    private Simbolo simboloGlobo = new Simbolo("Globo");
    private Simbolo simbolocanon = new Simbolo("Cañon");
    private Simbolo simboloBarco = new Simbolo("Barco");

    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    public validarCanjesTest() throws FileNotFoundException {
    }

    @Test
    public void cajear_3_TarjetasIgualesDeuelve_4_Ejercitos()  {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simboloGlobo);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloGlobo);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);


        jugador.validarCanjes(tarjetas,tarjetero);
        jugador.canjear();

        assertEquals(4,jugador.getTope());
        assertEquals(3, tarjetero.size());
    }

    @Test
    public void canjear_3_TarjetasDistintasDevuelve_4_Ejercitos() {

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simbolocanon);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloBarco);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        jugador.validarCanjes(tarjetas,tarjetero);
        jugador.canjear();

        assertEquals(4, jugador.getTope() );
        assertEquals(3, tarjetero.size());

    }

    @Test
    public void canjear_2_TarjetasIgualesY_1_DistintaDevuelve_0_Ejercitos(){

        Tarjeta tarjetaUno = new Tarjeta(new Pais("Java"),simboloGlobo);
        Tarjeta tarjetaDos = new Tarjeta(new Pais("Etiopia"),simbolocanon);
        Tarjeta tarjetaTres = new Tarjeta(new Pais("Australia"),simboloGlobo);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);

        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);

        assertFalse( jugador.validarCanjes(tarjetas,tarjetero) );
        assertEquals(tarjetero.size(),0);
    }

}
