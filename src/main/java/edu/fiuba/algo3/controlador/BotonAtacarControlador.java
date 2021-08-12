package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonAtacarControlador implements EventHandler {
    private final TextField cantidadIngresada;

    public BotonAtacarControlador(TextField cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.Atacar(Integer.parseInt(cantidadIngresada.getText()));
    }
}
