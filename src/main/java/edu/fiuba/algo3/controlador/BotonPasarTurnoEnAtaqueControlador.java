package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonPasarTurnoEnAtaqueControlador implements EventHandler {

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.pasarTurno(false);
    }
}
