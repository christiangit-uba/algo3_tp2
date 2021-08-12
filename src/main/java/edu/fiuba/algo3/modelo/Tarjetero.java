package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Tarjetero {
    private ArrayList<Tarjeta> tarjetas;

    public Tarjetero() throws FileNotFoundException {
        tarjetas = new ArrayList<>();
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

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public Tarjeta buscarTarjeta(Pais pais) {
        for (Tarjeta tarjeta : tarjetas){
            if (tarjeta.mismaTarjeta(pais))
                return tarjeta;
        }
        return null;
    }

    public void mezclarMazo(){
        Collections.shuffle(tarjetas);
    }
}
