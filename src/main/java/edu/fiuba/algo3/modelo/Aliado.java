package edu.fiuba.algo3.modelo;

public class Aliado extends Validador{
    Pais paisDestino;
    Pais paisOrigen;


    Aliado(Pais origen, Pais destino) {
        paisOrigen = origen;
        paisDestino = destino;
    }

    @Override
    public void validar() throws Exception {
        if(!paisOrigen.mismoColor(paisDestino))
            throw new Exception();
        if (siguiente != null)
            siguiente.validar();
    }
}
