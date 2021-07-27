package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private static ArrayList<ColorJugador> colores;
    private Tablero tablero;
    private Tarjetero tarjetero;
    private ArrayList<Jugador> jugadores;
    private int jugadorEnTurno;
    private boolean conquistoUnPaisAlmenos = false;
    private Ronda ronda;

    public Juego(int cantidad) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        jugadores = new ArrayList<>();
        colores = new ArrayList<>();
        inicializarColores();
        inicializarJugadores(cantidad);
        ronda = new Ronda(jugadores);
    }

    private void inicializarColores() {
        //configurar colores validos
        colores.add(new ColorJugador("blue","0000FF"));
        colores.add(new ColorJugador("red","FF0000"));
        colores.add(new ColorJugador("Amarillo","0x0000FF"));
        colores.add(new ColorJugador("Verde","0x0000FF"));
        colores.add(new ColorJugador("Rosa","0x0000FF"));
        colores.add(new ColorJugador("Negro","0x0000FF"));
    }

    private void inicializarJugadores(int cantidad) {
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador("jugador"+(i+1),colores.get(i)));
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



    public void atacar(String paisAtacante, String paisDefensor, int cantidadTropas, ArrayList<Integer> valoresDadosAtacante, ArrayList<Integer> valoresDadoDefensor) throws Exception {
        if(ronda.jugadorEnRonda().realizarAtaque(tablero.obtenerPais(paisAtacante),tablero.obtenerPais(paisDefensor) ,cantidadTropas,valoresDadosAtacante,valoresDadoDefensor)){
            conquistoUnPaisAlmenos = true;
        }
    }

    public boolean activarTarjeta(Tarjeta tarjeta){
        return ronda.jugadorEnRonda().activarTarjetaPais(tarjeta);
    }

    public boolean canjearTarjetas(ArrayList<Tarjeta> tarjetas){
        if(ronda.jugadorEnRonda().validarCanjes(tarjetas, tarjetero)){
            ronda.jugadorEnRonda().canjear();
            return true;
        }
        return false;
    }

    public boolean colocarEjercito(Pais pais, int cantidadAColocar){
        return ronda.jugadorEnRonda().colocarEjercitos(cantidadAColocar, pais);
    }

    public int getTope(){
        return ronda.jugadorEnRonda().getTope();
    }

    public boolean terminarTurno() {
        if(conquistoUnPaisAlmenos){
            tarjetero.asignarTarjeta(ronda.jugadorEnRonda());
        }
        //ronda.jugadorEnRonda().reiniciarTope(tablero);
        return ronda.pasarTurno();
    }

    public boolean moverEjercito(String origen, String destino, int cantidadEjercitos) throws Exception {
        return ronda.jugadorEnRonda().realizarMovimiento(tablero.obtenerPais(origen),tablero.obtenerPais(destino),cantidadEjercitos);
    }

    public String colorCodigoJugadorEnTurno() {
        return ronda.jugadorEnRonda().colorCodigo();
    }

    public String nombreJugadorEnTurno() {
        return ronda.jugadorEnRonda().nombre();
    }

    public String colorJugadorEnTurno() {
        return ronda.jugadorEnRonda().color();
    }
}
