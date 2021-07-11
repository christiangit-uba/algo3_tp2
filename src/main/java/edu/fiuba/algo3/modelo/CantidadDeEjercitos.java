package edu.fiuba.algo3.modelo;

public class CantidadDeEjercitos implements Validador{
    private final Ejercito ejercito;
    private int cantidadEjecitosAUsar;

    public CantidadDeEjercitos(Ejercito ejercito, int cantidadEjecitosAUsar) {
        this.ejercito = ejercito;
        this.cantidadEjecitosAUsar = cantidadEjecitosAUsar;
    }

    public boolean validar() throws Exception{
        if (!this.ejercito.validar(this.cantidadEjecitosAUsar)) {
            throw new Exception();
        }
        return true;
    }
}
