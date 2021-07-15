package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaDadosTest {


    @Test
    public void PrueboDadosDefensorGanador1Ronda(){
        Dados defensor = new Dados(1);
        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");
        ArrayList<Integer> atacante = new ArrayList<>();
        ArrayList<Integer> dadoDefensor = new ArrayList<>();

        atacante.add(1);
        dadoDefensor.add(4);

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();

        defensor.setDados(dadoDefensor);

        defensor.comparar(atacante,PaisAtacante,PaisDefensor);

        assertEquals(PaisAtacante.cantidadEjercitos(),0);
    }

    @Test
    public void PrueboDadosAtacanteGanador1Ronda(){
        Dados defensor = new Dados(1);
        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");
        ArrayList<Integer> atacante = new ArrayList<>();
        ArrayList<Integer> dadoDefensor = new ArrayList<>();

        atacante.add(5);
        dadoDefensor.add(0);

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();

        defensor.setDados(dadoDefensor);

        defensor.comparar(atacante,PaisAtacante,PaisDefensor);

        assertEquals(PaisAtacante.cantidadEjercitos(),1);
    }

    @Test
    public void PrueboDadosAtacanteGanadorEn2RondaYDefensorUnaRonda(){
        Dados defensor = new Dados(3);
        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");
        ArrayList<Integer> atacante = new ArrayList<>();
        ArrayList<Integer> dadoDefensor = new ArrayList<>();

        atacante.add(5);
        atacante.add(4);
        atacante.add(3);
        dadoDefensor.add(6);
        dadoDefensor.add(2);
        dadoDefensor.add(1);

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();


        defensor.setDados(dadoDefensor);

        defensor.comparar(atacante,PaisAtacante,PaisDefensor);

        assertEquals(PaisAtacante.cantidadEjercitos(),2);
    }
    @Test
    public void PrueboDadosAtacanteGanadorEn1RondaYDefensorEnDosRondas(){
        Dados defensor = new Dados(3);
        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");
        ArrayList<Integer> atacante = new ArrayList<>();
        ArrayList<Integer> dadoDefensor = new ArrayList<>();

        atacante.add(6);
        atacante.add(2);
        atacante.add(1);
        dadoDefensor.add(5);
        dadoDefensor.add(2);
        dadoDefensor.add(1);

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();

        defensor.setDados(dadoDefensor);

        defensor.comparar(atacante,PaisAtacante,PaisDefensor);

        assertEquals(PaisAtacante.cantidadEjercitos(),1);
    }
    @Test
    public void PrueboDadosAtacanteGanadorEn3RondaYDefensorEn0Rondas(){
        Dados defensor = new Dados(3);
        Pais PaisAtacante = new Pais("Estonia");
        Pais PaisDefensor = new Pais("Albania");
        ArrayList<Integer> atacante = new ArrayList<>();
        ArrayList<Integer> dadoDefensor = new ArrayList<>();

        atacante.add(6);
        atacante.add(5);
        atacante.add(4);
        dadoDefensor.add(3);
        dadoDefensor.add(2);
        dadoDefensor.add(1);

        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();
        PaisAtacante.agregarEjercito();
        PaisDefensor.agregarEjercito();

        defensor.setDados(dadoDefensor);

        defensor.comparar(atacante,PaisAtacante,PaisDefensor);

        assertEquals(PaisAtacante.cantidadEjercitos(),3);
    }
}
