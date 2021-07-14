package edu.fiuba.algo3.modelo;

public abstract class Ejercito{
    protected int cantidadDeEjercitos;
    private Color color;

    public Ejercito(int cantidadEjercitos){
        cantidadDeEjercitos = cantidadEjercitos;
    }

    public void agregarColor(Color unColor){
        color = unColor;
    }

    public boolean mismoColor(Pais otroPais) {
        return (otroPais.mismoColor(color));
    }

    public boolean mismoColor(Color color){
        return (this.color.mismoColor(color));
    }

    public int getCantidadDeEjercitos(){
        return cantidadDeEjercitos;
    }

    abstract boolean puedeAtacar(int cantidadEjecitosAUsar);

    abstract Ejercito agregarEjercito();

    abstract Ejercito sacarEjercito();

    abstract boolean puedeMoverse(int cantidadEjercitosAMover);

    public abstract boolean ejercitoVacio();
}
