package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    String nombre;
    int premioPorConquista;
    ArrayList<Pais> paises;

    public Continente(String nombre , int premioPorConquista){
        paises = new ArrayList<>();
        this.nombre = nombre;
        this.premioPorConquista = premioPorConquista;
    }

    public void agregarPais(Pais unPais){
        paises.add(unPais);
    }

    public int conquistado(ColorJugador colorJugador){
        for(Pais pais: paises){
            if(!pais.mismoColor(colorJugador))
                return 0;
        }
        return premioPorConquista;
    }

    public boolean mismoNombre(String continenteNombre) {
        return nombre.equals(continenteNombre);
    }
}
