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
        if (this.existePais(pais)){
            return;
        }
        Vertice paisNuevo = new Vertice(pais);
        paises.add(paisNuevo);
        for (String limitrofe : limitrofes) {
            paisNuevo.agregarLimitrofes(limitrofe, this);
        }
    }

    public boolean Limitrofes(String pais, String limitrofe){
        if (this.existePais(pais) && this.existePais(limitrofe)){
            for (Vertice paisBuscado: paises){
                if (paisBuscado.nombre().equals(pais)){
                    if (paisBuscado.adyacenteA(this.buscarPais(limitrofe))){
                        return true;
                    }
                }
            }
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
