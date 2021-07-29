package edu.fiuba.algo3.modelo;

public class UnoOMenosEjercito extends Ejercito{

    public UnoOMenosEjercito(int cantidad){
        super(cantidad);
    }

    public UnoOMenosEjercito(int cantidad, ColorJugador colorJugador){
        super(cantidad);
        this.colorJugador = colorJugador;
    }

    @Override
    public boolean puedeAtacar(int cantidadEjecitosAUsar){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {

        cantidadDeEjercitos = cantidadDeEjercitos + 1;
        if(cantidadDeEjercitos == 2)
            return (new MasDeUnEjercito(cantidadDeEjercitos,this.colorJugador));
        return this;
    }

    @Override
    public Ejercito sacarEjercito(){
        cantidadDeEjercitos = cantidadDeEjercitos - 1;
        return this;
    }

    @Override
    public boolean puedeMoverse(int cantidadEjercitosAMover){
        return false;
    }

    @Override
    public int ejercitosAtaque(){
        return 0;
    }

}
