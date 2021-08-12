package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonMoverTropasControlador implements EventHandler {

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.moverTropas();
    }
}
