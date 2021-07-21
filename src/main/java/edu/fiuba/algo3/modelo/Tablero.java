package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tablero {
    ArrayList<Pais> paises;
    ArrayList<Continente> continentes;

    Tablero(Tarjetero tarjetero) throws FileNotFoundException {
        this.paises = new ArrayList<>();
        this.continentes = new ArrayList<>();
        new Inicializador(paises, continentes, tarjetero);
    }

    public void asignarPaises(ArrayList<Jugador> jugadores) {

        (new Distribucion(jugadores, paises)).asignarEjercitosAPaises();

    }

    public int cantidadEjercitosAColocar(Color color){
        int cantidadPorPais =  cantidadDePaises(color);
        int cantidadPorContinente = cantidadEjercitosPorContinente(color);
        return cantidadPaisesAColocar(cantidadPorPais,cantidadPorContinente);
    }

    public int cantidadEjercitosPorContinente(Color color){
        int continentesConquistados = 0;
        for(Continente continente: continentes){
            if(continente.conquistado(color) != 0)
                continentesConquistados = continentesConquistados + continente.conquistado(color);
        }
        return continentesConquistados;
    }

    public int cantidadDePaises(Color color){
        int cantidadPaises = 0;

        for(Pais pais: paises){
            if(pais.mismoColor(color))
                cantidadPaises = cantidadPaises + 1;
        }
        return cantidadPaises;
    }

    public int cantidadPaisesAColocar(int cantidadPaisesConquistados, int continenteConquistados){
        if(cantidadPaisesConquistados < 6)
            return 3 + continenteConquistados;
        return (cantidadPaisesConquistados/2) + continenteConquistados;
    }

    public Pais obtenerPais(String nombre) {
        for (Pais pais: paises){
            if (pais.mismoNombre(nombre))
                return pais;
        }
        return null;
    }
}
