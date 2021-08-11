package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonCerrarPanelDados implements EventHandler {
    Stage stage;
    public BotonCerrarPanelDados(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        stage.close();
    }
}
