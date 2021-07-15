package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Distribucion {
    static final int SINPAISES = 0;
    private List<Pais> paises;
    private ArrayList<Jugador> jugadores;

    public Distribucion(ArrayList<Jugador> jugadores, ArrayList<Pais> paises){
        this.jugadores = jugadores;
        this.paises = new ArrayList<>(paises);
        asignarEjercitosAPaises();
    }

    public void asignarEjercitosAPaises(){
        Random random = new Random();
        while(paises.size()>SINPAISES){
            for(Jugador y:jugadores)
                asignarEjercito(random,y);
        }
    }
    public void asignarEjercito(Random random, Jugador unJugador){
        if (paises.size()> SINPAISES) {
            int numeroRandom = random.nextInt(paises.size());
            unJugador.asignarPais(paises.get(numeroRandom));
            paises.remove(numeroRandom);
        }
    }

}
