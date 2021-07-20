package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TurnoDeColocacion{
    Jugador jugador;
    boolean sigueTurno = true;
    Tablero tablero;
    Tarjetero tarjetero;
    int tope;

    public TurnoDeColocacion(Tablero tablero, Tarjetero tarjetero) {
        this.tablero = tablero;
        this.tarjetero = tarjetero;
    }

    public boolean sigueJuego() {
        return true;
    }

    public boolean sigueTurno() {
        return sigueTurno;
    }

    public void turnoDe(Jugador jugador) {
        this.jugador = jugador;
        tope = jugador.cantidadEjercitosAColocar(tablero);
    }

    public void terminarTurno(){
        sigueTurno = false;
    }

    public boolean activarTarjeta(Tarjeta tarjeta){
        return jugador.activarTarjetaPais(tarjeta);
    }

    public boolean canjearTarjetas(ArrayList<Tarjeta> tarjetas){
        if(jugador.validarCanjes(tarjetas, tarjetero)){
            tope += jugador.canjear(tarjetas,tarjetero);
            return true;
        }
        return false;
    }

    public boolean colocarEjercito(Pais pais, int cantidadAColocar){
        if(jugador.colocarEjercitos(cantidadAColocar, tope,pais)){
            tope -= cantidadAColocar;
            return true;
        }
        return false;
    }

    public int getTope(){
        return tope;
    }
}
