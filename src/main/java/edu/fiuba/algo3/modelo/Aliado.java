package edu.fiuba.algo3.modelo;

public class Aliado implements Validador{
    Pais paisDestino;
    Pais paisOrigen;
    Validador siguiente;

    Aliado(Pais origen, Pais destino, Validador siguiente) {
        paisOrigen = origen;
        paisDestino = destino;
        this.siguiente = siguiente;
    }

    @Override
    public void validar() throws Exception {
        if(!paisOrigen.mismoColor(paisDestino))
            throw new Exception();
        if (siguiente != null)
            siguiente.validar();
    }
}
