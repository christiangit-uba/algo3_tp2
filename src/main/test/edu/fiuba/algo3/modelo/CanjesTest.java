package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanjesTest {
    @Test
    public void siUnJugadorNoHaRealizadoNingunCanjeYRealizaUnoEntoncesObtiene4ejercitos(){
        Canje canje = new Canje();
        canje.sumarCanje();
        assertEquals(canje.cantidadACanjear(),4);
    }
    @Test
    public void siUnJugadorHaRealizadoUnCanjeYRealizaUnoEntoncesObtiene7ejercitos(){
        Canje canje = new Canje();
        canje.sumarCanje();
        canje.sumarCanje();
        assertEquals(canje.cantidadACanjear(),7);
    }
    @Test
    public void siUnJugadorHaRealizadoDosCanjeYRealizaUnoEntoncesObtiene10ejercitos(){
        Canje canje = new Canje();
        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();
        assertEquals(canje.cantidadACanjear(),10);
    }
    @Test
    public void siUnJugadorHaRealizadoTresCanjeYRealizaUnoEntoncesObtiene15ejercitos() {
        Canje canje = new Canje();
        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();
        canje.sumarCanje();

        assertEquals(canje.cantidadACanjear(), 15);
    }
        @Test
        public void siUnJugadorHaRealizadoCuatroCanjeYRealizaUnoEntoncesObtiene20ejercitos(){
            Canje canje = new Canje();
            canje.sumarCanje();
            canje.sumarCanje();
            canje.sumarCanje();
            canje.sumarCanje();
            canje.sumarCanje();
            assertEquals(canje.cantidadACanjear(),20);
        }

}
