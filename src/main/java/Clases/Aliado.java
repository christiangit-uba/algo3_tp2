package Clases;

public class Aliado extends Condicion{
    Pais paisDestino;
    Pais paisOrigen;

    Aliado(Pais origen, Pais destino, Condicion siguiente) {
        paisOrigen = origen;
        paisDestino = destino;
        siguienteCondicion = siguiente;
    }

    @Override
    public void ejecutar() throws Exception {
        if(!paisOrigen.mismoColor(paisDestino))
            throw new Exception();
        else
            siguienteCondicion.ejecutar();
    }
}
