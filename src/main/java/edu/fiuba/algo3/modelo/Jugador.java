package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Color color;
    private int canjes;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(Color color){
        tarjetas = new ArrayList<>();
        this.color = color;
    }

    public void asignarPais(Pais unPais){
        unPais.agregarColor(color);
        unPais.agregarEjercito();
    }

    public void activarTarjetaPais(Tarjeta unaTarjeta){

         for(Tarjeta tarjeta : tarjetas){
             if(tarjeta.mismaTarjeta(unaTarjeta))
               tarjeta.activarTarjeta(color);
         }
    }

    public int cantidadEjercitosAColocar(Tablero tablero){
        return tablero.cantidadEjercitosAColocar(color);
    }


    public void colocarEjercitos(int ejercitosAColocar,int ejercitosTope, Pais unPais) throws Exception {

        if(ejercitosAColocar > ejercitosTope) {
            throw new Exception();
        }else {
            for (int i = 0; i < ejercitosAColocar; i++) {
                unPais.agregarEjercito();
            }
        }
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


    public void agregarTarjeta(Tarjeta unaTarjeta){

        tarjetas.add(unaTarjeta);
    }
}