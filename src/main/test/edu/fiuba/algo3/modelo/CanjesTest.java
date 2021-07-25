package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanjesTest {

    private Canje canje = new Canje();

    @Test
    public void siUnJugadorNoHaRealizadoNingunCanjeYRealizaUnoEntoncesObtiene4ejercitos(){

        assertEquals(canje.cantidadACanjear(),4);
    }
    @Test
    public void siUnJugadorHaRealizadoUnCanjeYRealizaUnoEntoncesObtiene7ejercitos(){

        canje.sumarCanje();

        assertEquals(canje.cantidadACanjear(),7);
    }
    @Test
    public void siUnJugadorHaRealizadoDosCanjeYRealizaUnoEntoncesObtiene10ejercitos(){

        canje.sumarCanje();
        canje.sumarCanje();

        assertEquals(canje.cantidadACanjear(),10);
    }
    @Test
    public void siUnJugadorHaRealizadoTresCanjeYRealizaUnoEntoncesObtiene15ejercitos() {

        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();

        assertEquals(canje.cantidadACanjear(), 15);
    }
    @Test
    public void siUnJugadorHaRealizadoCuatroCanjeYRealizaUnoEntoncesObtiene20ejercitos(){

        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();

        assertEquals(canje.cantidadACanjear(),20);
    }

    @Test
    public void siSeHacen_5_CanjesSucesivosSeObtieneUnTotalDe_56_Ejercitos(){

        //primero
        int ejercitos = canje.cantidadACanjear();
        assertEquals(4, ejercitos);

        //segundo
        ejercitos += canje.cantidadACanjear();
        assertEquals(11, ejercitos);

        //tercero
        ejercitos += canje.cantidadACanjear();
        assertEquals(21, ejercitos);

        //cuarto
        ejercitos += canje.cantidadACanjear();
        assertEquals(36, ejercitos);

        //quinto
        ejercitos += canje.cantidadACanjear();
        assertEquals(56, ejercitos);
    }

    //Integracion
    @Test
    public void unJugadorConCuatroTarjetasCanjeaTresAhoraTieneUna() throws FileNotFoundException {

        Tarjetero tarjetero = new Tarjetero();
        Color color = new Color("Azul");
        Jugador jugador = new Jugador(color);
        Simbolo simbolo = new Simbolo("Globo");

        Pais paisUno = new Pais("Peru");
        Pais paisDos = new Pais("Brazil");
        Pais paisTres = new Pais("China");
        Pais paisCuatro = new Pais("Chile");

        Tarjeta tarjetaUno = new Tarjeta(paisUno,simbolo);
        Tarjeta tarjetaDos = new Tarjeta(paisDos,simbolo);
        Tarjeta tarjetaTres = new Tarjeta(paisTres,simbolo);
        Tarjeta tarjetaCuatro = new Tarjeta(paisCuatro,simbolo);

        jugador.agregarTarjeta(tarjetaUno);
        jugador.agregarTarjeta(tarjetaDos);
        jugador.agregarTarjeta(tarjetaTres);
        jugador.agregarTarjeta(tarjetaCuatro);

        jugador.asignarPais(paisUno);
        jugador.asignarPais(paisDos);
        jugador.asignarPais(paisTres);
        jugador.asignarPais(paisCuatro);

        ArrayList<Tarjeta> tarjetasCanje = new ArrayList<>();
        tarjetasCanje.add(tarjetaUno);
        tarjetasCanje.add(tarjetaDos);
        tarjetasCanje.add(tarjetaTres);

        //Canjea las primeras 3 tarjetas
        assertTrue( jugador.validarCanjes(tarjetasCanje, tarjetero) != 0);
        //Le quedo 1 tarjeta
        assertEquals(jugador.cantidadTarjetas(),1);
        //Puede activar la tarjeta que deberia quedarle
        assertTrue(jugador.activarTarjetaPais(tarjetaCuatro));
        assertEquals(paisCuatro.cantidadEjercitos(),3);
    }



}
