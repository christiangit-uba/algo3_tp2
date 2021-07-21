package edu.fiuba.algo3.modelo;

public class ProximoCanje {
    int proximo;

    public ProximoCanje(){
        this.proximo = 1;
    }

    public void pasarAProximo(){
        proximo +=1;
    }

    public int getProximo(){
        return proximo;
    }
}
