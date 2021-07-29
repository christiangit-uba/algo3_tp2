package edu.fiuba.algo3.modelo;

public abstract class Ejercito{
    protected int cantidadDeEjercitos;
    protected ColorJugador colorJugador;

    public Ejercito(int cantidadEjercitos){
        cantidadDeEjercitos = cantidadEjercitos;
    }

    public void agregarColor(ColorJugador unColorJugador){
        colorJugador = unColorJugador;
    }

    public boolean mismoColor(Pais otroPais) {
        return (otroPais.mismoColor(colorJugador));
    }

    public boolean mismoColor(ColorJugador colorJugador){
        return (this.colorJugador.mismoColor(colorJugador));
    }

    public int getCantidadDeEjercitos(){
        return cantidadDeEjercitos;
    }

    abstract boolean puedeAtacar(int cantidadEjecitosAUsar);

    abstract Ejercito agregarEjercito();

    abstract Ejercito sacarEjercito();

    abstract boolean puedeMoverse(int cantidadEjercitosAMover);

    public boolean ejercitoVacio(){
        return cantidadDeEjercitos == 0;
    }

    abstract int ejercitosAtaque();

    public int ejercitosDefensa(){
        if(cantidadDeEjercitos > 3)
            return 3;
        return cantidadDeEjercitos;
    }
}
