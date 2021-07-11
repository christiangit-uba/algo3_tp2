package edu.fiuba.algo3.modelo;

public interface Ejercito{
    boolean validar(int cantidadEjecitosAUsar);

    Ejercito agregarEjercito();

    int cantidadDeEjercitos();

    Ejercito sacarEjercito();

    int cantidadDeDados();

    String color();
}
