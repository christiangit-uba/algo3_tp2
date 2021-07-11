package edu.fiuba.algo3.modelo;

public class DiplomaciaEnemiga extends Diplomacia{
    Tablero tablero;
    String paisAtacante;
    String paisDefensor;
    Ejercito siguiente;
    int cantidadDeEjercitosAUsar;

    DiplomaciaEnemiga(String paisAtacante, String paisDefensor, Tablero tablero, int cantidadDeEjercitosAUsar){
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
        this.tablero = tablero;
        this.cantidadDeEjercitosAUsar = cantidadDeEjercitosAUsar;
    }

    public void siguiente(Ejercito siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar() throws Exception{
        if(!this.tablero.limitrofes(paisAtacante,paisDefensor)){
            throw new Exception();
        }
        else{
            return siguiente.validar(cantidadDeEjercitosAUsar);
        }

    }
}