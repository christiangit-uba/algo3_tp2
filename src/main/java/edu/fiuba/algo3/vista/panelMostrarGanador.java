package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.awt.*;

public class panelMostrarGanador extends Panel {
    private final Pane pane;
    private final Juego modelo;



    public panelMostrarGanador(Juego modelo){
        this.modelo = modelo;
        pane = new Pane();
        pane.setPrefHeight(500.0);
        pane.setPrefWidth(650.0);

        Label ganador = new Label("GANO");
        ganador.setText(modelo.jugadorGanador());
        ganador.setStyle("-fx-text-fill: black");
        ganador.setLayoutX(915);
        ganador.setLayoutY(270);
        ganador.setFont(Font.font(30.0));


        pane.getChildren().addAll(ganador);
    }

    public Pane getPane(){
        return pane;
    }
    @Override
    public void setContactos(Panel panelAtaque) {

    }

    @Override
    public void ocultar() {
        pane.setVisible(false);
    }

    @Override
    public void mostrar() {
        pane.setVisible(true);
    }

    @Override
    public Panel siguientePanel(boolean sigueRonda) {
        return null;
    }
}
