package edu.fiuba.algo3.modelo;

public class Jugador {
    private String color;
    public Jugador(String color){
        this.color = color;
    }

    public void asignarPais(Pais unPais){
        unPais.agregarColor(color);
        unPais.agregarEjercito();
    }

    public int cantidadEjercitosAColocar(Tablero tablero){
        return tablero.cantidadEjercitosAColocar(color);
    }

    public void asignarEjercito(Pais unPais , int cantidadEjercitos){

        for(int i = 0; i < cantidadEjercitos ; i++)
            unPais.agregarEjercito();
    }
}