package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaInicio;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonEmpezarControlador implements EventHandler {
    private final Stage stage;

    public BotonEmpezarControlador(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        Stage jugadores = new EleccionDeJugadoresControlador().initialize();
        stage.hide();
        jugadores.show();
    }
}
