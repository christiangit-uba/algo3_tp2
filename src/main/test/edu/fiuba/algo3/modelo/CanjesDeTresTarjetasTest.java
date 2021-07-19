package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanjesDeTresTarjetasTest {
        //todos estos test suponen que el canje es valido, y solo prueban el correcto funcionamiento
        //de la funcion que devuelve los ejercitos correspondienes.
        @Test
        public void siUnJugadorNoHaRealizadoNingunCanjeYRealizaUnoEntoncesObtiene4ejercitos(){
            CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();
            assertEquals(canje.cantidadACanjear(1),4);
        }
        @Test
        public void siUnJugadorHaRealizadoUnCanjeYRealizaUnoEntoncesObtiene7ejercitos(){
            CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();
            assertEquals(canje.cantidadACanjear(2),7);
        }
        @Test
        public void siUnJugadorHaRealizadoDosCanjeYRealizaUnoEntoncesObtiene10ejercitos(){
            CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();
            assertEquals(canje.cantidadACanjear(3),10);
        }
        @Test
        public void siUnJugadorHaRealizadoTresCanjeYRealizaUnoEntoncesObtiene15ejercitos() {
            CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();
            assertEquals((canje).cantidadACanjear(4), 15);
        }
        @Test
        public void siUnJugadorHaRealizadoCuatroCanjeYRealizaUnoEntoncesObtiene20ejercitos(){
            CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();
            assertEquals(canje.cantidadACanjear(5),20);
        }

        //Test de integracion


}
