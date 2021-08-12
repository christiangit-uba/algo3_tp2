package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BotonPaisControlador implements EventHandler {
    @Override
    public void handle(Event event) {
        Circle circulo = (Circle) event.getSource();
        PantallaDeJuegoControlador.guardarPais(circulo.getId());
        circulo.setFill(Color.web("808080"));
    }
}
