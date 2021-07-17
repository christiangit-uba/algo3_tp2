package edu.fiuba.algo3.modelo;

public class EjercitoMovible extends Validador{
    int cantidadEjercitos;
    Pais paisOrigen;

    EjercitoMovible(Pais origen,int cantidadEjercitos) {
        paisOrigen = origen;
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
