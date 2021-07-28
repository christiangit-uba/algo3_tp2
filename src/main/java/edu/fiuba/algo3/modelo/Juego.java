package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private Tablero tablero;
    private Tarjetero tarjetero;
    private Turno turno;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<ColorJugador> colores = new ArrayList<>();
    private int jugadorEnTurno;
    private int topeJugadorEnTurno;
    private boolean conquistoUnPaisAlmenos = false;

    public Juego(int cantidad) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        inicializarColores();
        inicializarJugadores(cantidad);
    }

    private void inicializarColores() {
        colores.add(new ColorJugador("red","0000FF"));
        colores.add(new ColorJugador("blue","FF0000"));
        colores.add(new ColorJugador("Yellow","FFFF00"));
        colores.add(new ColorJugador("Verde","009988"));
        colores.add(new ColorJugador("Rosa","ee3377"));
        colores.add(new ColorJugador("Negro","000000"));
    }

    private void inicializarJugadores(int cantidad) {
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador(colores.get(i)));
            i++;
        }
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

    private Pais obtenerPais(String paisBuscado){
        return tablero.obtenerPais(paisBuscado);
    }


    public void atacar(String paisAtacante, String paisDefensor, int cantidadTropas, ArrayList<Integer> valoresDadosAtacante, ArrayList<Integer> valoresDadoDefensor) throws Exception {
        Pais atacante = obtenerPais(paisAtacante);
        Pais defensor = obtenerPais(paisDefensor);
        if(jugadores.get(jugadorEnTurno).realizarAtaque(atacante,defensor,cantidadTropas,valoresDadosAtacante,valoresDadoDefensor)){
            conquistoUnPaisAlmenos = true;
        }
    }

    public void mover(String paisOrigen, String paisDestino, int cantidadTropas) throws Exception {
        Pais origen = obtenerPais(paisOrigen);
        Pais destino = obtenerPais(paisDestino);
        jugadores().get(jugadorEnTurno).realizarMovimiento(origen,destino,cantidadTropas);
    }


    public void activarTarjeta(Tarjeta tarjeta) throws Exception {
        if(!jugadores.get(jugadorEnTurno).activarTarjetaPais(tarjeta))
            throw new Exception();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetas) throws Exception {
        if(jugadores.get(jugadorEnTurno).validarCanjes(tarjetas, tarjetero)){
            topeJugadorEnTurno = topeJugadorEnTurno + jugadores.get(jugadorEnTurno).canjear();
        }
        else
            throw new Exception();
    }

    public void colocarEjercito(String pais, int cantidadAColocar) throws Exception {
        Pais paisAColocar = obtenerPais(pais);
        topeJugadorEnTurno = topeJugadorEnTurno + jugadores.get(jugadorEnTurno).cantidadEjercitosAColocar(tablero);

        if(jugadores.get(jugadorEnTurno).colocarEjercitos(cantidadAColocar, topeJugadorEnTurno,paisAColocar)){
            topeJugadorEnTurno = topeJugadorEnTurno - cantidadAColocar;
        }
        else
            throw new Exception();
    }

    public Tablero tablero(){
        return tablero;
    }

    public boolean jugadorConquistoPais(){
        return conquistoUnPaisAlmenos;
    }

    public void siguienteJugador(){
        if(jugadorEnTurno == jugadores.size() - 1)
            jugadorEnTurno = 0;
        else
            jugadorEnTurno++;
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
