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

    public abstract boolean ejercitoVacio();

    public  int colocarEjercito(int ejercitosAColocar, ColorJugador otroColor){

        if(colorJugador.mismoColor(otroColor)){
            for(int i = 0; i < ejercitosAColocar; i++)
                agregarEjercito();
            return ejercitosAColocar;
        }
        return 0;
    }

    public  boolean activarTarjeta(ColorJugador color){
        if(colorJugador.mismoColor(color)){
            agregarEjercito();
            agregarEjercito();
            return true;
        }
        return false;
    }
}
