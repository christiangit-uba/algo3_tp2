package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonColocarControlador implements EventHandler {
    private final TextField cantidadIngresada;

    public BotonColocarControlador(TextField cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.colocarEjecito(Integer.parseInt(cantidadIngresada.getText()));
    }
}
