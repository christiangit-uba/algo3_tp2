package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Ronda {
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<ColorJugador> colores;
    private final ArrayList<Objetivo> objetivos;
    private int iterador;

    public Ronda(ArrayList<Jugador> jugadores) {
        iterador = 0;
        this.jugadores = jugadores;
        colores = new ArrayList<>();
        objetivos = new ArrayList<>();
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
        inicializarObjetivos();
        inicializarJugadores(cantidadJUgadores);

    }

    private void inicializarObjetivos(){
        objetivos.add(new ObjetivoConquistarTreintaPaises());
    }

    private void inicializarColores() {
        //configurar colores validos
        colores.add(new ColorJugador("Azul","0000FF"));
        colores.add(new ColorJugador("Rojo","FF0000"));
        colores.add(new ColorJugador("Amarillo","FFFF00"));
        colores.add(new ColorJugador("Verde","00FF00"));
        colores.add(new ColorJugador("Rosa","FF0080"));
        colores.add(new ColorJugador("Negro","000000"));
    }

    private void inicializarJugadores(int cantidad) {
        Random random = new Random();
        int i = 0;
        while (i < cantidad){
            int objetivo = (random.nextInt(objetivos.size()));
            jugadores.add(new Jugador("JUGADOR "+(i+1),colores.get(i)));
            jugadores.get(i).agregarObjetivo(objetivos.get(objetivo));
            i++;
        }
    }
}

