package edu.fiuba.algo3.modelo;

public class MenosDeUnEjercito extends Ejercito{

    public MenosDeUnEjercito(int cantidad){
        super(cantidad);
    }

    public MenosDeUnEjercito(int cantidad, Color color){
        super(cantidad);
        this.color = color;
    }

    @Override
    public boolean puedeAtacar(int cantidadEjecitosAUsar){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {

        cantidadDeEjercitos = cantidadDeEjercitos + 1;
        if(cantidadDeEjercitos == 2)
            return (new MasDeUnEjercito(cantidadDeEjercitos,this.color));
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
    public boolean ejercitoVacio() {
        return cantidadDeEjercitos == 0;
    }
}