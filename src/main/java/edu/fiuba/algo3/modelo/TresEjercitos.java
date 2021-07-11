package edu.fiuba.algo3.modelo;

public class TresEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 2;
    static final int CANTIDADDEEJERCITOS = 3;
    private String color;

    TresEjercitos(String color){
        this.color = color;
    }

    @Override
    public boolean validar(int cantidadEjecitosAUsar){
        return (CANTIDADDADOS - cantidadEjecitosAUsar >= 0 && cantidadEjecitosAUsar > 0);
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new CuatroOMasEjercitos(this.color, 4));
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new DosEjercitos(this.color));
    }

    @Override
    public int cantidadDeDados(){
        return CANTIDADDADOS;
    }

    @Override
    public String color() {
        return this.color;
    }
}
