package edu.fiuba.algo3.modelo;

import java.util.Observable;

public class ModeloObservable extends Observable {

    private final Tablero tablero;

    public ModeloObservable(Tablero tablero) {
        this.tablero = tablero;
        setChange();
    }

    public void setChange() {
        this.setChanged();
    }
}
