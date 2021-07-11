package edu.fiuba.algo3.modelo;

public class DosEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 1;
    static final int CANTIDADDEEJERCITOS = 2;

    @Override
    public boolean atacar(int cantidadEjecitosAUsar){
        return (cantidadEjecitosAUsar == CANTIDADDADOS);
    }

    @Override
    public Ejercito agregarEjercito() { return (new TresEjercitos()); }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new UnEjercito());
    }

    @Override
    public int cantidadDeDados(){
        return CANTIDADDADOS;
    }
}