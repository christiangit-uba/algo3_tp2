package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanjesTest {
    @Test
    public void siUnJugadorNoHaRealizadoNingunCanjeYRealizaUnoEntoncesObtiene4ejercitos(){
        Canje canje = new TresCanjesOMenos();
        assertEquals(canje.cantidadACanjear(0),4);
    }
    @Test
    public void siUnJugadorHaRealizadoUnCanjeYRealizaUnoEntoncesObtiene7ejercitos(){
        Canje canje = new TresCanjesOMenos();
        assertEquals(canje.cantidadACanjear(1),7);
    }
    @Test
    public void siUnJugadorHaRealizadoDosCanjeYRealizaUnoEntoncesObtiene10ejercitos(){
        Canje canje = new TresCanjesOMenos();
        assertEquals(canje.cantidadACanjear(2),10);
    }
    @Test
    public void siUnJugadorHaRealizadoTresCanjeYRealizaUnoEntoncesObtiene15ejercitos() {
        Canje canje = new TresCanjesOMenos();
        assertEquals(canje.cantidadACanjear(3), 15);
    }
        @Test
        public void siUnJugadorHaRealizadoCuatroCanjeYRealizaUnoEntoncesObtiene20ejercitos(){
            Canje canje = new TresCanjesOMenos();
            assertEquals(canje.cantidadACanjear(4),20);
        }

}
