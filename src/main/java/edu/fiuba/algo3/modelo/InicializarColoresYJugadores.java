package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class InicializarColoresYJugadores {

    public static void inicializar(ArrayList<Jugador> jugadores, int cantidad) {
        inicializarJugadores(jugadores,inicializarColores(),cantidad);
    }

    private static ArrayList<ColorJugador> inicializarColores() {
        ArrayList<ColorJugador> colores = new ArrayList<>();
        colores.add(new ColorJugador("Azul","077bb"));
        colores.add(new ColorJugador("Rojo","cc3311"));
        colores.add(new ColorJugador("Amarillo","ee7733"));
        colores.add(new ColorJugador("Verde","009988"));
        colores.add(new ColorJugador("Rosa","ee3377"));
        colores.add(new ColorJugador("Negro","000000"));
        return colores;
    }

    private static void inicializarJugadores(ArrayList<Jugador> jugadores, ArrayList<ColorJugador> colores, int cantidad) {
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador("jugador"+(i+1),colores.get(i)));
            i++;
        }
    }
}
