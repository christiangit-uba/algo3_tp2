package edu.fiuba.algo3.modelo;

public class UnEjercito implements Ejercito {
    static final int CANTIDADDEEJERCITOS = 1;
    private String color;

    UnEjercito(String color){
        this.color = color;
    }

    @Override
    public boolean validar(int cantidadEjecitosAUsar){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new DosEjercitos(this.color));
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new CeroEjercitos(this.color));
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
