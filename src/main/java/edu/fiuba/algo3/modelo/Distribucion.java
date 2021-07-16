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
    }

    public void asignarEjercitosAPaises(){
        Random random = new Random();
        while(paises.size()>SINPAISES){
            for(Jugador y:jugadores) {
                generadorNumeroAleatorio(random,y);
            }
        }
    }

    public void generadorNumeroAleatorio(Random random, Jugador jugador){
        if (paises.size()> SINPAISES) {
            int numeroRandom = random.nextInt(paises.size());
            asignarEjercito(numeroRandom, jugador);
        }
    }

    public void asignarEjercito(int random, Jugador unJugador){
        unJugador.asignarPais(paises.get(random));
        paises.remove(random);
    }
}
