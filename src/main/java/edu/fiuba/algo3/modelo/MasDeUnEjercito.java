package edu.fiuba.algo3.modelo;

public class MasDeUnEjercito extends Ejercito{

    public MasDeUnEjercito(int cantidadDeEjercitos){
        super(cantidadDeEjercitos);
    }

    public MasDeUnEjercito(int cantidadDeEjercitos, ColorJugador colorJugador){
        super(cantidadDeEjercitos);
        this.colorJugador = colorJugador;
    }

    @Override
    public boolean puedeAtacar(int cantidadEjecitosAUsar){
        return (cantidadDeEjercitos - cantidadEjecitosAUsar > 0 && cantidadEjecitosAUsar > 0 && cantidadEjecitosAUsar <= 3 );
    }

    @Override
    public Ejercito agregarEjercito() {

        cantidadDeEjercitos = cantidadDeEjercitos + 1;
        return this;
    }


    @Override
    public Ejercito sacarEjercito(){

        cantidadDeEjercitos = cantidadDeEjercitos - 1;
        if(cantidadDeEjercitos == 1)
            return(new UnoOMenosEjercito(cantidadDeEjercitos,this.colorJugador));
        return this;
    }

    @Override
    public boolean puedeMoverse(int cantidadEjercitosAMover){
        return (cantidadDeEjercitos > cantidadEjercitosAMover && cantidadEjercitosAMover > 0);
    }

    @Override
    public boolean ejercitoVacio() {
        return false;
    }

    @Override
    public int ejercitosDefensa() {
        return Math.min(cantidadDeEjercitos, 3);
    }

}