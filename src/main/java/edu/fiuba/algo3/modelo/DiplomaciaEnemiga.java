/*package edu.fiuba.algo3.modelo;

public class DiplomaciaEnemiga extends Diplomacia{
    Grafo grafo;
    String paisAtacante;
    String paisDefensor;
    CantidadDeEjercitos siguiente;
    int cantidadDeEjercitosAUsar;

    DiplomaciaEnemiga(String paisAtacante, String paisDefensor, Grafo grafo, int cantidadDeEjercitosAUsar){
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
        this.grafo = grafo;
        this.cantidadDeEjercitosAUsar = cantidadDeEjercitosAUsar;
        this.siguiente =
    }

    public void siguiente(Validador siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar() throws Exception{
        if(!this.grafo.limitrofes(paisAtacante,paisDefensor)){
            throw new Exception();
        }
        else{
            return siguiente.validar(cantidadDeEjercitosAUsar);
        }

    }
}*/