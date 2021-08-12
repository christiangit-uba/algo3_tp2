package edu.fiuba.algo3.modelo;

public class EjercitoMovible extends Validador {
    int cantidadEjercitos;
    Pais paisOrigen;


    EjercitoMovible(Pais origen,int cantidadEjercitos) {
        paisOrigen = origen;
        this.cantidadEjercitos = cantidadEjercitos;
    }

    @Override
    public void validar() throws Exception {
        validar(!paisOrigen.puedeMoverse(cantidadEjercitos),"Error no se posee la cantidad de tropas disponibles para moverse");
    }

}