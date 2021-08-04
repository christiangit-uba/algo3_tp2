package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonSalirControlador implements EventHandler {
    @Override
    public void handle(Event event) {
        Platform.exit();
    }
}
