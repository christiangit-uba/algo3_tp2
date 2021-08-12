package edu.fiuba.algo3.modelo;

import java.util.Observable;

public class tableroObservable extends Observable {

    private final Tablero tablero;

    public tableroObservable(Tablero tablero) {
        this.tablero = tablero;
        setChange();
    }

    public void setChange() {
        this.setChanged();
    }

    public String colorPais(String nombre) {
        return tablero.obtenerPais(nombre).getColor();
    }

    public int cantidadDeEjercitos(String nombre) {
        return tablero.obtenerPais(nombre).cantidadEjercitos();
    }
}
