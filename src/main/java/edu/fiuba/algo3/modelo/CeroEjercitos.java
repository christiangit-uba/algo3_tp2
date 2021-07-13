package edu.fiuba.algo3.modelo;

public class CeroEjercitos implements Ejercito{
    static final int CANTIDADDEEJERCITOS = 0;

    @Override
    public boolean atacar(int cantidadEjecitosAUsar){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {
        return(new UnEjercito());
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return null;
    }

    @Override
    public int cantidadDeDados(){
        return 0;
    }

}
