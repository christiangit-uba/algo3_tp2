package Clases;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AtaqueTest {
    @Test
    public void AtaqueEntreDosPaisesConDosEjercitoYDefensorComoGanador() {
        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();
        limitrofes1.add("Chile");
        limitrofes2.add("Argentina");

        Pais atacante = new Pais("Argentina","Azul",limitrofes1);
        Pais defensor = new Pais("Chile","Rojo",limitrofes2);
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        defensor.agregarEjercito();
        defensor.agregarEjercito();

        ArrayList<Integer> dadosAtacante = new ArrayList<>();
        ArrayList<Integer> dadosDefensor = new ArrayList<>();
        dadosAtacante.add(1);
        dadosAtacante.add(1);
        dadosDefensor.add(6);
        dadosDefensor.add(6);

        Dados dados = new Dados(dadosAtacante,dadosDefensor,2,2);
        dados.combatir(atacante,defensor);

        assertEquals(1,atacante.cantidadDeEjercitos());
    }

    @Test
    public void AtaqueEntreDosPaisesConUnEjercitoYEmpatanGanaDefensor() {

        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();
        limitrofes1.add("Chile");
        limitrofes2.add("Argentina");

        Pais atacante = new Pais("Argentina","Azul",limitrofes1);
        Pais defensor = new Pais("Chile","Rojo",limitrofes2);
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        defensor.agregarEjercito();

        ArrayList<Integer> dadosAtacante = new ArrayList<>();
        ArrayList<Integer> dadosDefensor = new ArrayList<>();
        dadosAtacante.add(6);
        dadosDefensor.add(6);

        Dados dados = new Dados(dadosAtacante,dadosDefensor,1,1);
        dados.combatir(atacante,defensor);

        assertEquals(1, atacante.cantidadDeEjercitos());
    }

    @Test
    public void AtaqueEntreDosPaisesConTresEjercitosConElAtacanteComoGanadorYOcupaElPaisConUnEjercito() {
        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();
        limitrofes1.add("Chile");
        limitrofes2.add("Argentina");

        Pais atacante = new Pais("Argentina","Azul",limitrofes1);
        Pais defensor = new Pais("Chile","Rojo",limitrofes2);
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        atacante.agregarEjercito();
        defensor.agregarEjercito();
        defensor.agregarEjercito();
        defensor.agregarEjercito();

        ArrayList<Integer> dadosAtacante = new ArrayList<>();
        ArrayList<Integer> dadosDefensor = new ArrayList<>();
        dadosAtacante.add(6);
        dadosAtacante.add(5);
        dadosAtacante.add(3);
        dadosDefensor.add(1);
        dadosDefensor.add(2);
        dadosDefensor.add(2);

        Dados dados = new Dados(dadosAtacante,dadosDefensor,3,3);
        dados.combatir(atacante,defensor);

        assertEquals(1, defensor.cantidadDeEjercitos());

        assertTrue(atacante.mismoColor(defensor));

        assertEquals(3,atacante.cantidadDeEjercitos());
    }
    @Test
    public void unJugadorMueveEjercitosAUnPaisNoLimitrofeLanzaExcepcion() {
        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();

        Pais origen = new Pais("Argentina","Azul",limitrofes1);
        Pais destino = new Pais("España","Rojo",limitrofes2);
        origen.agregarEjercito();
        origen.agregarEjercito();
        origen.agregarEjercito();

        assertThrows(Exception.class, ()-> origen.moverEjercitoA(destino,1));

    }
    @Test
    public void unJugadorMueveEjercitosAUnPaisLimitrofeOcupadoPorEnemigoLanzaExcepcion(){
        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();
        limitrofes1.add("Chile");
        limitrofes2.add("Argentina");

        Pais origen = new Pais("Argentina", "Azul", limitrofes1);
        Pais destino = new Pais("Chile", "Rojo", limitrofes2);
        origen.agregarEjercito();
        origen.agregarEjercito();
        origen.agregarEjercito();
        destino.agregarEjercito();

        assertThrows(Exception.class, ()-> origen.moverEjercitoA(destino,1));


    }
    @Test
    public void unJugadorMueveUnEjercitoAUnPaisLimitrofeAliadoDejandoCeroEjercitosLanzaUnaExcepcion(){
        ArrayList<String> limitrofes1 = new ArrayList<>();
        ArrayList<String> limitrofes2 = new ArrayList<>();
        limitrofes1.add("Chile");
        limitrofes2.add("Argentina");

        Pais origen = new Pais("Argentina", "Azul", limitrofes1);
        Pais destino = new Pais("Chile", "Azul", limitrofes2);
        origen.agregarEjercito();
        origen.agregarEjercito();
        origen.agregarEjercito();

        assertThrows(Exception.class, ()-> origen.moverEjercitoA(destino,3));
    }
}