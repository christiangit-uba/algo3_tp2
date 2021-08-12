package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonMoverTropasControlador implements EventHandler {

    private final TextField cantidadIngresada;

    public BotonMoverTropasControlador(TextField cantidadIngresada){
        this.cantidadIngresada = cantidadIngresada;
    }

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.moverTropas(Integer.parseInt(cantidadIngresada.getText()));
    }
}
