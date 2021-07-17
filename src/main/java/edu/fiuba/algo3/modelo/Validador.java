package edu.fiuba.algo3.modelo;

abstract class Validador {
    protected Validador siguiente;

    public void siguiente(Validador siguiente){
        this.siguiente = siguiente;
    }
    abstract void validar() throws Exception;
}



