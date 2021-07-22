package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TurnoDeColocacion extends Turno{
    Tablero tablero;
    Tarjetero tarjetero;
    int tope;

    public TurnoDeColocacion(Tablero tablero, Tarjetero tarjetero) {
        this.tablero = tablero;
        this.tarjetero = tarjetero;
        tope = 0;
    }

    public void calcularTope(){
        tope = jugador.cantidadEjercitosAColocar(tablero);
    }

    @Override
    public void terminarTurno(){
        sigueTurno = false;
    }

    @Override
    public void recibirOrden() {

    }

    public boolean activarTarjeta(Tarjeta tarjeta){
        return jugador.activarTarjetaPais(tarjeta);
    }

    public boolean canjearTarjetas(ArrayList<Tarjeta> tarjetas){
        if(jugador.validarCanjes(tarjetas, tarjetero)){
            tope = tope + jugador.canjear();
            return true;
        }
        return false;
    }

    public boolean colocarEjercito(Pais pais, int cantidadAColocar){
        if(jugador.colocarEjercitos(cantidadAColocar, tope,pais)){
            tope = tope - cantidadAColocar;
            return true;
        }
        return false;
    }

    public int getTope(){
        return tope;
    }
}
