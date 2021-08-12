package edu.fiuba.algo3.modelo;

public class Simbolo {
    private String simbolo;

    public Simbolo(String simbolo){
        this.simbolo = simbolo;
    }

    public boolean mismoSimbolo(Simbolo otroSimbolo){
        return otroSimbolo.mismoSimbolo(simbolo);
    }

    public boolean mismoSimbolo(String simbolo){
        return (this.simbolo.equals(simbolo));
    }

    public String nombreSimbolo(){
        return simbolo;
    }

}
