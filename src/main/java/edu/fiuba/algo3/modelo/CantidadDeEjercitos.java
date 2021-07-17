package edu.fiuba.algo3.modelo;

public class CantidadDeEjercitos extends Validador{
    private final Pais paisAtacante;
    private final int cantidadEjecitosAUsar;



    public CantidadDeEjercitos(Pais paisAtacante, int cantidadEjercitosAUsar) {
        this.paisAtacante = paisAtacante;
        this.cantidadEjecitosAUsar = cantidadEjercitosAUsar;
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
