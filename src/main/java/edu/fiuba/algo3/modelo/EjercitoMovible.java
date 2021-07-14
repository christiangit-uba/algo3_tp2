package edu.fiuba.algo3.modelo;

public class EjercitoMovible implements Validador{
    int cantidadEjercitos;
    Pais paisOrigen;
    Validador siguiente;

    EjercitoMovible(Pais origen,int cantidadEjercitos, Validador siguiente) {
        paisOrigen = origen;
        this.siguiente = siguiente;
        this.cantidadEjercitos = cantidadEjercitos;
    }

    @Override
    public void validar() throws Exception {
        if(!paisOrigen.puedeMoverse(cantidadEjercitos))
            throw new Exception();
        if (siguiente != null)
            siguiente.validar();
    }
}
