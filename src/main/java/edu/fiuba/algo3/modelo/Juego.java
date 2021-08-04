package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private int cantidadJugadores;
    private Tablero tablero;
    private Tarjetero tarjetero;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorEnTurno;
    private boolean conquistoUnPaisAlmenos = false;
    private Ronda ronda;
    private ModeloObservable modelo;

    public Juego(int cantidad) throws FileNotFoundException {

        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        jugadores = new ArrayList<>();
        cantidadJugadores = cantidad;
    }

    public void IniciarJuego(){
        ronda = new Ronda(jugadores);
        ronda.iniciarPrimeraRonda(cantidadJugadores);
        asignarPaises();
        modelo = new ModeloObservable(tablero);


    }

    public void asignarPaises(){
        tablero.asignarPaises(jugadores);
    }

    public void agregarJugadores(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        ronda = new Ronda(jugadores);
    }

    public Tarjetero getTarjetero(){
        return tarjetero;
    }

    public void iniciarTurno(){
        jugadorEnTurno = ronda.jugadorEnRonda();
        jugadorEnTurno.reiniciarTope(tablero);
    }


    public void atacar(String paisAtacante, String paisDefensor, int cantidadTropas, ArrayList<Integer> valoresDadosAtacante, ArrayList<Integer> valoresDadoDefensor) throws Exception {
        if(jugadorEnTurno.realizarAtaque(tablero.obtenerPais(paisAtacante),tablero.obtenerPais(paisDefensor) ,cantidadTropas,valoresDadosAtacante,valoresDadoDefensor)){
            conquistoUnPaisAlmenos = true;
        }
    }

    public boolean activarTarjeta(Tarjeta tarjeta){
        return jugadorEnTurno.activarTarjetaPais(tarjeta);
    }

    public boolean canjearTarjetas(ArrayList<Tarjeta> tarjetas){
        if(jugadorEnTurno.validarCanjes(tarjetas, tarjetero)){
            jugadorEnTurno.canjear();
            return true;
        }
        return false;
    }

    public void colocarEjercito(Pais pais, int cantidadAColocar){
        jugadorEnTurno.colocarEjercitos(cantidadAColocar, pais);
    }

    public int getTope(){
        return jugadorEnTurno.getTope();
    }

    public boolean terminarTurno() {
        if(conquistoUnPaisAlmenos){
            tarjetero.asignarTarjeta(jugadorEnTurno);
        }
        return ronda.pasarTurno();
    }

    public boolean moverEjercito(String origen, String destino, int cantidadEjercitos) throws Exception {
        return jugadorEnTurno.realizarMovimiento(tablero.obtenerPais(origen),tablero.obtenerPais(destino),cantidadEjercitos);
    }

    public String colorCodigoJugadorEnTurno() {
        return jugadorEnTurno.colorCodigo();
    }

    public String nombreJugadorEnTurno() {
        return jugadorEnTurno.nombre();
    }

    public String colorJugadorEnTurno() {
        return jugadorEnTurno.color();
    }


    public int cantidadDeEjercito(String nombre) {
        return tablero.obtenerPais(nombre).cantidadEjercitos();
    }


    public Pais obtenerPais(String unPais) {
        return tablero.obtenerPais(unPais);
    }

    public Tarjeta buscarTarjeta(Pais unPais) {
        return tarjetero.buscarTarjeta(unPais);
    }

    public void randomizarJugadores() {
        ArrayList<Jugador> nuevoOrden = new ArrayList<>();
        Random random = new Random();

        int primeroEnJugar = random.nextInt(jugadores.size()-1);

        for (int i = primeroEnJugar; i< jugadores.size(); i++){
            nuevoOrden.add(jugadores.get(i));
        }
        for(int i = 0; i < primeroEnJugar; i++){
            nuevoOrden.add(jugadores.get(i));
        }

        jugadores = nuevoOrden;
    }

    public String obtenerColorPais(String nombre) {
        return obtenerPais(nombre).getColor();
    }
}
