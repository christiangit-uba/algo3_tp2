package edu.fiuba.algo3.modelo;

public class CeroEjercitos implements Ejercito{
    static final int CANTIDADDEEJERCITOS = 0;
    private String color;

    CeroEjercitos(String color){
        this.color = color;
    }

    @Override
    public boolean validar(int cantidadEjecitosAUsar){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {
        return(new UnEjercito(this.color));
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

    @Override
    public String color() {
        return this.color;
    }

}
