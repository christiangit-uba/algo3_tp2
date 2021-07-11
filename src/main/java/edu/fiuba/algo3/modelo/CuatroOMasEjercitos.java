package edu.fiuba.algo3.modelo;

public class CuatroOMasEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 3;
    public int cantidadDeEjercitos;
    private String color;

    public CuatroOMasEjercitos(String color,int cantidad) {
        cantidadDeEjercitos = cantidad;
        this.color = color;
    }

    @Override
    public boolean validar(int cantidadEjecitosAUsar){
        return (CANTIDADDADOS - cantidadEjecitosAUsar >= 0 && cantidadEjecitosAUsar > 0);
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new CuatroOMasEjercitos(this.color,cantidadDeEjercitos+1));
    }

    @Override
    public int cantidadDeEjercitos() {
        return cantidadDeEjercitos;
    }

    @Override
    public Ejercito sacarEjercito(){
        if (cantidadDeEjercitos > 4) {
            return (new CuatroOMasEjercitos(this.color,cantidadDeEjercitos-1));
        }
        else {
            return (new TresEjercitos(this.color));
        }
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
