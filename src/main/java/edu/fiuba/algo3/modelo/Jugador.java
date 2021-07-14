package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Color color;
    public Jugador(Color color){
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

    public void realizarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar) throws Exception{
        CadenaDeResponsabilidad.confirmarAtaque(atacante, defensor, cantidadEjercitosAUsar, color);

        atacante.atacaA(defensor,cantidadEjercitosAUsar);
        atacante.ocuparPais(defensor,color);
    }

    public void realizarMovimiento(Pais origen,Pais destino, int cantidadEjercitos) throws Exception {
        CadenaDeResponsabilidad.confirmarMovimiento(origen,destino,cantidadEjercitos,color);

        origen.moverEjercitoA(destino,cantidadEjercitos);
    }
}