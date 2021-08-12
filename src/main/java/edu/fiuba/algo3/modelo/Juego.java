package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Juego extends Observable {
    private int cantidadJugadores;
    private Tablero tablero;
    private Tarjetero tarjetero;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorEnTurno;
    private boolean conquistoUnPaisAlmenos = false;
    private Ronda ronda;
    private tableroObservable modelo;
    private String jugadorGanador;

    public Juego(int cantidad)  throws FileNotFoundException {

        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        jugadores = new ArrayList<>();
        cantidadJugadores = cantidad;
    }

    public void IniciarJuego(){
        ronda = new Ronda(jugadores);
        ronda.iniciarPrimeraRonda(cantidadJugadores);
        asignarPaises();
        iniciarTurno();
        this.setChanged();
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
        this.setChanged();
    }

    public boolean activarTarjeta(Tarjeta tarjeta){
        this.setChanged();
        return jugadorEnTurno.activarTarjetaPais(tarjeta);
    }

    public boolean canjearTarjetas(ArrayList<Tarjeta> tarjetas){
        if(jugadorEnTurno.validarCanjes(tarjetas, tarjetero)){
            jugadorEnTurno.canjear();
            this.setChanged();
            return true;
        }
        return false;
    }

    public void colocarEjercito(String pais, int cantidadAColocar){
        jugadorEnTurno.colocarEjercitos(cantidadAColocar, tablero.obtenerPais(pais));
        this.setChanged();
    }

    public int getTope(){
        return jugadorEnTurno.getTope();
    }

    public boolean terminarTurno(Boolean avanzaJugador) {
        this.setChanged();
        if(conquistoUnPaisAlmenos){
            tarjetero.asignarTarjeta(jugadorEnTurno);
            conquistoUnPaisAlmenos = false;
        }
        
        if (avanzaJugador){
            boolean cond = ronda.pasarTurno();
            jugadorEnTurno = ronda.jugadorEnRonda();
            return cond;
        }
        return true;
    }

    public void moverEjercito(String origen, String destino, int cantidadEjercitos) throws Exception {
        jugadorEnTurno.realizarMovimiento(tablero.obtenerPais(origen), tablero.obtenerPais(destino), cantidadEjercitos);
        this.setChanged();
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

    public Tarjeta buscarTarjetaJugador(Pais unPais){
        return jugadorEnTurno.buscarTarjeta(unPais);
    }

    public void randomizarJugadores() {
        ArrayList<Jugador> nuevoOrden = new ArrayList<>();
        Random random = new Random();

        int primeroEnJugar = random.nextInt(jugadores.size());

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

    public void setChange() {
        this.setChanged();
    }

    public void topeDeRonda(int i) {
        for(Jugador jugador : jugadores){
            jugador.setTope(i);
        }
    }






    public ArrayList<Tarjeta> tarjetasJugador(){
        return ronda.jugadorEnRonda().obtenerTarjetas();
    }

    public Jugador jugadorEnTurno(){
        return ronda.jugadorEnRonda();
    }


    public boolean juegoTerminado() {
        if(jugadorEnTurno.cumplioObjetivo(tablero)){
            jugadorGanador = this.nombreJugadorEnTurno();
            return true;
        }
        return false;
    }

    public String jugadorGanador() {
        return jugadorGanador;
    }

    public int cantidadPaisesConquistados() {
        return tablero.cantidadDePaises(jugadorEnTurno.getColor());
    }
}
