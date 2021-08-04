package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class BotonCantidadDeJugadoresControlador implements EventHandler {
    @Override
    public void handle(Event event) {
        try {

            Stage tablero = EleccionDeJugadoresControlador.cargarTablero();
            //primaryStage.hide();
            tablero.show();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
