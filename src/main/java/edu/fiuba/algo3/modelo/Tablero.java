package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tablero {
    ArrayList<Pais> paises;
    ArrayList<Continente> continentes;

    Tablero() throws FileNotFoundException {
        this.paises = new ArrayList<>();
        (new Inicializador()).inicializar(this.paises);
    }

    public void asignarPaises(ArrayList<Jugador> jugadores){
            new Distribucion(jugadores,paises);
        }

        public int cantidadEjercitosAColocar(String color){
            int cantidadPorPais =  cantidadDePaises(color);
            int cantidadPorContinente = cantidadEjercitosPorContinente(color);
            return cantidadPaisesAColocar(cantidadPorPais,cantidadPorContinente);

        }

        public int cantidadEjercitosPorContinente(String color){
            int continentesConquistados = 0;
            for(Continente continente: continentes){
                if(continente.conquistado(color) != 0)
                    continentesConquistados = continentesConquistados + continente.conquistado(color);
            }
            return continentesConquistados;

        }

        public int cantidadDePaises(String color){
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

    public boolean existePais(String nombre) {
        Pais pais = buscarPais(nombre);
        return pais != null;
    }

    public boolean limitrofes(String paisAtacante, String paisDefensor) {
        Pais paisOrigen = buscarPais(paisAtacante);
        Pais paisDestino = buscarPais(paisDefensor);
        if (paisOrigen != null && paisDestino != null){
            return paisOrigen.esLimitrofe(paisDestino);
        }
        return false;
    }

    private Pais buscarPais(String nombre) {
        for (Pais pais: paises){
            if (pais.mismoNombre(nombre))
                return pais;
        }
        return null;
    }
}
