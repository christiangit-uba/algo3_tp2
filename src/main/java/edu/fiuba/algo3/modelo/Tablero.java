package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;

public class Tablero {
    ArrayList<Pais> paises;
    ArrayList<Continente> continentes;

    public Tablero(Tarjetero tarjetero) throws FileNotFoundException {
        this.paises = new ArrayList<>();
        this.continentes = new ArrayList<>();
        new Inicializador(paises, continentes, tarjetero);
    }

    public void asignarPaises(ArrayList<Jugador> jugadores) {

        (new Distribucion(jugadores, paises)).asignarEjercitosAPaises();

    }

    public int cantidadEjercitosAColocar(ColorJugador colorJugador){
        int cantidadPorPais =  cantidadDePaises(colorJugador);
        int cantidadPorContinente = cantidadEjercitosPorContinente(colorJugador);
        return cantidadPaisesAColocar(cantidadPorPais,cantidadPorContinente);
    }

    public int cantidadEjercitosPorContinente(ColorJugador colorJugador){
        int continentesConquistados = 0;
        for(Continente continente: continentes){
            if(continente.conquistado(colorJugador) != 0)
                continentesConquistados = continentesConquistados + continente.conquistado(colorJugador);
        }
        return continentesConquistados;
    }

    public int cantidadDePaises(ColorJugador colorJugador){
        int cantidadPaises = 0;

        for(Pais pais: paises){
            if(pais.mismoColor(colorJugador))
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
