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
        validar(!paisOrigen.mismoColor(paisDestino),"Error el pais de origen es de distinto color que el de destino");
    }
}
