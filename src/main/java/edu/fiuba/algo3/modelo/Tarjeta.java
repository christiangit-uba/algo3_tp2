package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Map;

public class Tarjeta{

    private Pais pais;
    private Simbolo simbolo;
    private boolean activada = false;

    public  Tarjeta(Pais pais,Simbolo simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public boolean mismoSimbolo(Simbolo otroSimbolo){
        return simbolo.mismoSimbolo(otroSimbolo);
    }

    public void reiniciarTarjeta(){
        activada = false;
    }

    public boolean activarTarjeta(Color unColor){

        if(!activada && pais.mismoColor(unColor)){
            activada = true;
            pais.agregarEjercito();
            pais.agregarEjercito();
            return true;
        }
        return false;
    }

    public boolean mismaTarjeta(Pais unPais){
        return (pais.mismoPais(unPais));
    }

    public boolean mismoSimbolo(Tarjeta otraTarjeta){
        return otraTarjeta.mismoSimbolo(simbolo);
    }


}
