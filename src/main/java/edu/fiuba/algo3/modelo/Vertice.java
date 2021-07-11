package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.Set;

public class Vertice {
    Pais pais;
    Set<Vertice> limitrofes;

    Vertice(String pais) {
        this.pais = new Pais(pais);
        limitrofes = new HashSet<>();
    }

    public String nombre() {
        return pais.nombre();
    }

    public boolean adyacenteA(Vertice limitrofe) {
        return limitrofes.contains(limitrofe);
    }

    public void agregarLimitrofes(Vertice limitrofe) {
        limitrofes.add(limitrofe);
    }

    public boolean mismoColor(Vertice paisLimitrofe) {
        return (this.pais.colorDeEjercito()).equals(paisLimitrofe.pais.colorDeEjercito());
    }

    public Ejercito ejercito() {
        return pais.ejercito();
    }
}
