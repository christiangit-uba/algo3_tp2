package edu.fiuba.algo3.modelo;

public class Canje {
    private int cantidadDeCanjes;
    private final int CANJEMINIMO = 4;

    public Canje(){
        cantidadDeCanjes = 0;
    }

    public void sumarCanje(){
        cantidadDeCanjes++;
    }

    public int cantidadACanjear(){
        if(cantidadDeCanjes == 0) return cantidadDeCanjes;
        if(cantidadDeCanjes < 3)
            return CANJEMINIMO + 3*(cantidadDeCanjes-1);
        return  (cantidadDeCanjes-1)*5;
    }
}
