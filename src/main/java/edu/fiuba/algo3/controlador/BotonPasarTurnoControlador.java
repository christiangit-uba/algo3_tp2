package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonPasarTurnoControlador implements EventHandler {

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.pasarTurno(true);
    }
}
