package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tablero {
    Set<Vertice> paises;

    Tablero(){
        paises = new HashSet<>();
    }

    public void agregregarPais(String pais, ArrayList<String> limitrofes){
        Vertice paisNuevo = this.buscarPais(pais);
        if (paisNuevo == null){
            paisNuevo = new Vertice(pais);
            paises.add(paisNuevo);
        }
        for (String limitrofe : limitrofes) {
            paisNuevo.agregarLimitrofes(limitrofe, this);
        }
    }

    public boolean Limitrofes(String pais, String limitrofe){
        Vertice paisOrigen = this.buscarPais(pais);
        Vertice paisLimitrofe = this.buscarPais(pais);

        if (paisOrigen != null && paisLimitrofe != null){
            return paisOrigen.adyacenteA(paisLimitrofe);
        }
        return false;
    }

    public boolean existePais(String pais){
        return this.buscarPais(pais) != null;
    }

    public Vertice buscarPais(String pais){
        for (Vertice paisBuscado : paises){
            if (paisBuscado.nombre().equals(pais)){
                return paisBuscado;
            }
        }
        return null;
    }
}
