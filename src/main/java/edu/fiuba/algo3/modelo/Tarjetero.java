package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tarjetero {
    private ArrayList<Tarjeta> tarjetas;

    public Tarjetero(){
        tarjetas = new ArrayList<>();
        tarjetas.add(new Tarjeta(new Pais("Java"),new Simbolo("Globo")));
    }

    public void vuelveAlTarjetero(Tarjeta unaTarjeta){
        unaTarjeta.reiniciarTarjeta();
        tarjetas.add(unaTarjeta);
    }

    public void asignarTarjeta(Jugador jugador){
        jugador.agregarTarjeta(tarjetas.get(0));
        tarjetas.remove(0);
    }

    public int size(){
        return tarjetas.size();
    }
}
