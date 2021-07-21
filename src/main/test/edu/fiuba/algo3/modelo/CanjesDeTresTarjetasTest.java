package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanjesDeTresTarjetasTest {

        //todos estos test suponen que el canje es valido, y solo prueban el correcto funcionamiento
        //de la funcion que devuelve los ejercitos correspondienes.
        ProximoCanje proximo = new ProximoCanje();
        CanjesDeTresTarjetas canje = new CanjesDeTresTarjetas();

        @Test
        public void siUnJugadorNoHaRealizadoNingunCanjeYRealizaUnoEntoncesObtiene4ejercitos(){
            assertEquals(4, canje.cantidadACanjear(proximo));
            assertEquals(2, proximo.getProximo());
        }

        @Test
        public void siUnJugadorHaRealizadoUnCanjeYRealizaUnoEntoncesObtiene7ejercitos(){
            proximo.pasarAProximo();

            assertEquals(7,canje.cantidadACanjear(proximo));
            assertEquals(3, proximo.getProximo());
        }

        @Test
        public void siUnJugadorHaRealizadoDosCanjeYRealizaUnoEntoncesObtiene10ejercitos(){
            proximo.pasarAProximo();
            proximo.pasarAProximo();

            assertEquals(10,canje.cantidadACanjear(proximo));
            assertEquals(4, proximo.getProximo());
        }

        @Test
        public void siUnJugadorHaRealizadoTresCanjeYRealizaUnoEntoncesObtiene15ejercitos() {
            proximo.pasarAProximo();
            proximo.pasarAProximo();
            proximo.pasarAProximo();

            assertEquals(15, canje.cantidadACanjear(proximo));
            assertEquals(5, proximo.getProximo());
        }

        @Test
        public void siUnJugadorHaRealizadoCuatroCanjeYRealizaUnoEntoncesObtiene20ejercitos(){
            proximo.pasarAProximo();
            proximo.pasarAProximo();
            proximo.pasarAProximo();
            proximo.pasarAProximo();

            assertEquals(20,canje.cantidadACanjear(proximo));
            assertEquals(6, proximo.getProximo());
        }

        @Test
        public void siSeHacen_5_CanjesSucesivosSeObtieneUnTotalDe_56_Ejercitos(){
            int ejercitos = canje.cantidadACanjear(proximo);

            assertEquals(4, ejercitos);
            assertEquals(2, proximo.getProximo());

            ejercitos += canje.cantidadACanjear(proximo);
            assertEquals(11, ejercitos);
            assertEquals(3, proximo.getProximo());

            ejercitos += canje.cantidadACanjear(proximo);
            assertEquals(21, ejercitos);
            assertEquals(4, proximo.getProximo());

            ejercitos += canje.cantidadACanjear(proximo);
            assertEquals(36, ejercitos);
            assertEquals(5, proximo.getProximo());

            ejercitos += canje.cantidadACanjear(proximo);
            assertEquals(56, ejercitos);
            assertEquals(6, proximo.getProximo());
        }
}
