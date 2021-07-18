package edu.fiuba.algo3.modelo;

public class CantidadDeEjercitos extends Validador {
    private final Pais paisAtacante;
    private final int cantidadEjecitosAUsar;
    Validador siguiente;


    public CantidadDeEjercitos(Pais paisAtacante, int cantidadEjercitosAUsar, Validador siguiente) {
        this.paisAtacante = paisAtacante;
        this.cantidadEjecitosAUsar = cantidadEjercitosAUsar;
        this.siguiente = siguiente;
    }

    public void validar() throws Exception{
        if (!paisAtacante.puedeAtacar(cantidadEjecitosAUsar)) {
            throw new Exception();
        }
        if (siguiente != null){
            siguiente.validar();
        }
    }
}
