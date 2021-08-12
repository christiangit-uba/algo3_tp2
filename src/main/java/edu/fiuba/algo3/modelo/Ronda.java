package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<ColorJugador> colores;
    private int iterador;

    public Ronda(ArrayList<Jugador> jugadores) {
        iterador = 0;
        this.jugadores = jugadores;
        colores = new ArrayList<>();
    }

    public Jugador jugadorEnRonda() {
        return jugadores.get(iterador);
    }

    public boolean pasarTurno() {
        iterador++;
        if (iterador == jugadores.size()){
            iterador = 0;
            return false;
        }
        return true;
    }

    public void iniciarPrimeraRonda(int cantidadJUgadores) {
        inicializarColores();
        inicializarJugadores(cantidadJUgadores);

    }

    //modificado
    private void inicializarColores() {
        //configurar colores validos
        colores.add(new ColorJugador("azul","0077bb"));
        colores.add(new ColorJugador("rojo","cc3311"));
        colores.add(new ColorJugador("Amarillo","ee7733"));
        colores.add(new ColorJugador("Verde","009988"));
        colores.add(new ColorJugador("Rosa","ee3377"));
        colores.add(new ColorJugador("Negro","000000"));
    }

    private void inicializarJugadores(int cantidad) {
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador("jugador"+(i+1),colores.get(i)));
            i++;
        }
    }
}

