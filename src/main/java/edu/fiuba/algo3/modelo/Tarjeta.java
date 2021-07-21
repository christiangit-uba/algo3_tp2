package edu.fiuba.algo3.modelo;

public class Tarjeta{

    private Pais pais;
    private Simbolo simbolo;
    private boolean activada = false;

    public Tarjeta(Pais pais, Simbolo simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public boolean mismoSimbolo(Simbolo otroSimbolo){
        return simbolo.mismoSimbolo(otroSimbolo);
    }

    public boolean mismaTarjeta(Tarjeta unaTarjeta){
        return unaTarjeta.mismoPais(pais);
    }

    public boolean mismoPais(Pais unPais){
        return (pais.mismoPais(unPais));
    } //modificado.

    public void activarTarjeta(Color unColor){ //canje normal... ver si debe meterse en Canje.

        if(!activada && pais.mismoColor(unColor)){
            activada = true;
            pais.agregarEjercito();
            pais.agregarEjercito();
        }
    }

    public void reiniciarTarjeta(){
        activada = false;
    }

    //------------Agregado---------//
    public Simbolo simbolo(){
        return simbolo;
    }
}
