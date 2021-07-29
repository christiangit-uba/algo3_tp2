package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private Tablero tablero;
    private Tarjetero tarjetero;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<ColorJugador> colores = new ArrayList<>();
    private int jugadorEnTurno;
    private boolean conquistoUnPaisAlmenos = false;

    public Juego(int cantidad) throws FileNotFoundException {
        tarjetero = new Tarjetero();
        tablero = new Tablero(tarjetero);
        inicializarColores();
        inicializarJugadores(cantidad);
    }

    private void inicializarColores() {
        colores.add(new ColorJugador("Rojo","0000FF"));
        colores.add(new ColorJugador("Azul","FF0000"));
        colores.add(new ColorJugador("Amarillo","FFFF00"));
        colores.add(new ColorJugador("Verde","00FF00"));
        colores.add(new ColorJugador("Rosa","FF0080"));
        colores.add(new ColorJugador("Negro","000000"));
    }

    private void inicializarJugadores(int cantidad) {
        Random random = new Random();
        int i = 0;
        while (i < cantidad){
            jugadores.add(new Jugador(colores.get(i)));
            i++;
        }
        jugadorEnTurno = random.nextInt(cantidad - 1);
    }

    public Tarjetero getTarjetero(){
        return tarjetero;
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
            //topeJugadorEnTurno = topeJugadorEnTurno + jugadores.get(jugadorEnTurno).canjear();
        }
        else
            throw new Exception();
    }

    public void colocarEjercito(String pais, int cantidadAColocar) throws Exception {
        Pais paisAColocar = obtenerPais(pais);
        if(!jugadores.get(jugadorEnTurno).colocarEjercitos(cantidadAColocar,paisAColocar)) {
            throw new Exception();
        }
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

    public Jugador jugadorEnTurno(){
        return jugadores.get(jugadorEnTurno);
    }

    public int obtenerTopeJugador(){
        return jugadorEnTurno().tope();
    }

    public void calcularTopeJugador(){
        jugadorEnTurno().calcularTope(tablero);
    }

}
