package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class BotonElegirCantidadControlador implements EventHandler {
    private Stage stage;

    public BotonElegirCantidadControlador(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        try {
            stage.hide();
            EleccionDeJugadoresControlador.cargarTablero();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
