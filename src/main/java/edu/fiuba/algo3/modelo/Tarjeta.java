package edu.fiuba.algo3.modelo;

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

    public boolean activarTarjeta(ColorJugador unColorJugador){

        if(!activada && pais.mismoColor(unColorJugador)){
            activada = true;
            pais.activarTarjeta();
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

    public String obtenerID(){
        return pais.nombre();
    }

    public String obtenerSimbolo(){
        return simbolo.nombreSimbolo();
    }


    public boolean tarjetaActivada() {
        return activada;
    }
}
