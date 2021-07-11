package edu.fiuba.algo3.modelo;

public interface Ejercito{
    boolean atacar(int cantidadEjecitosAUsar);

    Ejercito agregarEjercito();

    int cantidadDeEjercitos();

    Ejercito sacarEjercito();

    int cantidadDeDados();
}
