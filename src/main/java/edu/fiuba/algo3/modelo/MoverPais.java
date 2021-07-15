package edu.fiuba.algo3.modelo;

public class MoverPais {

    public static void moverPais(int cantidadEjercitos, Ejercito partida, Pais destino){

        for(int i = 0 ; i < cantidadEjercitos ; i++){
            partida.sacarEjercito();
            destino.agregarEjercito();
        }
    }
}
