package edu.fiuba.algo3.modelo;

public class TresEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 2;
    static final int CANTIDADDEEJERCITOS = 3;

    @Override
    public boolean atacar(int cantidadEjecitosAUsar){
        return (CANTIDADDADOS - cantidadEjecitosAUsar >= 0 && cantidadEjecitosAUsar > 0);
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new CuatroOMasEjercitos(4));
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new DosEjercitos());
    }

    @Override
    public int cantidadDeDados(){
        return CANTIDADDADOS;
    }
}
