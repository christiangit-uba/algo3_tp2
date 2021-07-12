package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tablero {
    ArrayList<Pais> paises;

    Tablero() throws FileNotFoundException {
        this.paises = new ArrayList<>();
        (new Inicializador()).inicializar(this.paises);
    }

    public Pais buscarPais(String buscado) {
        for (Pais pais : paises){
            if (pais.mismoNombre(buscado)){
                return pais;
            }
        }
        return null;
    }

    public boolean existePais(String buscado) {
        return (buscarPais(buscado)).mismoNombre(buscado);
    }

    public boolean limitrofes(String origen, String destino) {
        Pais paisOrigen = buscarPais(origen);
        Pais paisDestino = buscarPais(destino);
        if (paisOrigen != null && paisDestino != null){
            return paisOrigen.esLimitrofe(paisDestino);
        }
        return false;
    }
}
