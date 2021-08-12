package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonDesactivarControlador implements EventHandler {
    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.desactivarPais();
    }
}
