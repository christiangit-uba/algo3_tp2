package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombre;
    private Ejercito ejercito;
    Limitrofes limitrofes;

    public Pais(String nombreNuevo) {
        nombre = nombreNuevo;
        limitrofes = new Limitrofes();
    }

    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public Ejercito ejercito() {
        return ejercito;
    }

    String nombre() {
        return nombre;
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

    public void agregarLimitrofe(Pais paisLimitrofeNuevo) {
        limitrofes.agregarLimitrofe(paisLimitrofeNuevo);
    }

    public boolean mismoNombre(String pais) {
        return nombre.equals(pais);
    }
}
