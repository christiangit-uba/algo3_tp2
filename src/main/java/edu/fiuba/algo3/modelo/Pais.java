package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombre;
    private Ejercito ejercito;

    public Pais(String nombreNuevo) {
        this.nombre = nombreNuevo;
        }

    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public Ejercito ejercito() {
        return ejercito;
    }

    String nombre() {
        return this.nombre;
    }

    private int cantidadDeDados(){
        return ejercito.cantidadDeDados();
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }

    public String colorDeEjercito() {
        return ejercito.color();
    }
}
