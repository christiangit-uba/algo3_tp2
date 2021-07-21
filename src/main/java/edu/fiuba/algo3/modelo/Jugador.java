package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Color color;
    private ProximoCanje proximoCanje;
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Tarjeta> tarjetasActivadas;
    private ValidarCanje canje;

    public Jugador(Color color, ValidarCanje validadorCanje){
        tarjetas = new ArrayList<>();
        tarjetasActivadas = new ArrayList<>();
        this.color = color;
        proximoCanje = new ProximoCanje();
        canje = validadorCanje;  //porque viene con una instancia del mazo.
    }

    public void asignarPais(Pais unPais){
        unPais.agregarColor(color);
        unPais.agregarEjercito();
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

    //Tarjetas
    public void agregarTarjeta(Tarjeta unaTarjeta){
        tarjetas.add(unaTarjeta);
    }

    public void activarTarjetaPais(Tarjeta unaTarjeta){ //OK
        ArrayList<Tarjeta> aux = new ArrayList<>();
        aux.addAll(tarjetas);

        for(Tarjeta tarjeta : aux){
            if(tarjeta.mismaTarjeta(unaTarjeta))
                tarjeta.activarTarjeta(color);
                tarjetasActivadas.add(tarjeta); //se prepara para hacer canjes de 3 tarjetas.

                //tarjetas.remove(tarjeta);
        }
    }
//---------------------------------------------------------------------//
    public int hacerCanjes(){
       return canje.validar(tarjetasActivadas, proximoCanje);
    }

}