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

    public void activarTarjeta(Color unColor){

        if(!activada && pais.mismoColor(unColor)){
            activada = true;
            pais.agregarEjercito();
            pais.agregarEjercito();
        }

    }

    public boolean mismaTarjeta(Tarjeta unaTarjeta){
        return unaTarjeta.mismaTarjeta(pais);
    }

    public boolean mismaTarjeta(Pais unPais){
        return (pais.mismoPais(unPais));
    }

    public void comprobarExistencia(Map<Simbolo, Integer> simbolosAuxiliar) {

        if(!simbolosAuxiliar.containsKey(simbolo)){
            simbolosAuxiliar.put(simbolo,1);
        }else{
            simbolosAuxiliar.put(simbolo,simbolosAuxiliar.get(simbolo) + 1);
        }

    }
}
