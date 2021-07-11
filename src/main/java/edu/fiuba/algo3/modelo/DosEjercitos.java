package edu.fiuba.algo3.modelo;

public class DosEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 1;
    static final int CANTIDADDEEJERCITOS = 2;
    private String color;

    DosEjercitos(String color){
        this.color = color;
    }

    @Override
    public boolean validar(int cantidadEjecitosAUsar){
        return (cantidadEjecitosAUsar == CANTIDADDADOS);
    }

    @Override
    public Ejercito agregarEjercito() { return (new TresEjercitos(this.color)); }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new UnEjercito(this.color));
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