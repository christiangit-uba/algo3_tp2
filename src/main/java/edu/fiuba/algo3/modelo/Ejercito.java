package edu.fiuba.algo3.modelo;

public abstract class Ejercito{
    protected int cantidadDeEjercitos;
    private String color = "sin color";

    public Ejercito(int cantidadEjercitos){
        cantidadDeEjercitos = cantidadEjercitos;
    }

    public void agregarColor(String unColor){
        color = unColor;
    }

    public boolean mismoColor(Pais otroPais) {
        return (otroPais.mismoColor(color));
    }

    public boolean mismoColor(String color){
        return (this.color.equals(color));
    }

    public int getCantidadDeEjercitos(){
        return cantidadDeEjercitos;
    }

    abstract boolean puedeAtacar(int cantidadEjecitosAUsar);

    abstract Ejercito agregarEjercito();

    abstract Ejercito sacarEjercito();

    abstract boolean mover(int cantidadEjercitosAMover);

}
