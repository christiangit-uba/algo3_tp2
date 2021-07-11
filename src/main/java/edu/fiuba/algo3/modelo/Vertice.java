package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
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

    public void agregarLimitrofes(String limitrofe, Tablero tablero) {
        Vertice paisLimitrofe = tablero.buscarPais(limitrofe);
        if (paisLimitrofe == null){
            tablero.agregregarPais(limitrofe, new ArrayList<>());
        }
        limitrofes.add(tablero.buscarPais(limitrofe));
    }
}
