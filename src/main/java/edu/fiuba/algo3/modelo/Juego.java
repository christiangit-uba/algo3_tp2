package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private Tablero tablero;
    private Tarjetero tarjetero;
    private Turno turno;
    private ArrayList<Jugador> jugadores;
    private ArrayList<ColorJugador> colores;
    private int jugadorEnTurno;

    public Juego(int cantidad) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        inicializarColores();
        inicializarJugadores(cantidad);
    }

    private void inicializarColores() {
        colores.add(new ColorJugador("Azul","077bb"));
        colores.add(new ColorJugador("Rojo","cc3311"));
        colores.add(new ColorJugador("Amarillo","ee7733"));
        colores.add(new ColorJugador("Verde","009988"));
        colores.add(new ColorJugador("Rosa","ee3377"));
        colores.add(new ColorJugador("Negro","000000"));
    }

    private void inicializarJugadores(int cantidad) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador(colores.get(i)));
            i++;
        }
        this.jugadores = jugadores;
    }

    public Tarjetero getTarjetero(){
        return tarjetero;
    }

    public Jugador primerJugador(){
        Random random = new Random();
        jugadorEnTurno = random.nextInt(jugadores.size()-1);
        return jugadores.get(jugadorEnTurno);
    }

    public ArrayList<Jugador> jugadores() {
        return jugadores;
    }

    /*public Jugador siguienteJugador(){
        if (jugadorEnTurno == jugadores.size()-1){

        }

    }*/



/*
    Juego(int cantidadDeJugadores) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);

        Random random = new Random();
        int jugadorInicial = random.nextInt(jugadores.size()-1);


        tablero.asignarPaises(jugadores);
    }

    public void jugar(){
        turno = new TurnoDeColocacion(jugadores.get(0));

        while (turno.sigueJuego()){
            while (turno.sigueTurno()){
                turno = turno.recibirOrden();
            }
            turno = turno.siguienteTurno(jugadores);
        }
    }*/
}
