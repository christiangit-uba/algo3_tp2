package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.awt.*;

public class panelMostrarGanador extends Panel {
    private final AnchorPane pane;
    private final Juego modelo;



    public panelMostrarGanador(Juego modelo){
        this.modelo = modelo;
        pane = new AnchorPane();
        pane.setPrefHeight(400.0);
        pane.setPrefWidth(600.0);

        Label juegoTerminado = new Label("JUEGO TERMINADO");
        juegoTerminado.setFont(new Font(45.0));
        juegoTerminado.setStyle("-fx-text-fill: black");
        juegoTerminado.setLayoutX(100.0);
        juegoTerminado.setLayoutY(14.0);

        Label objetivo = new Label(modelo.jugadorGanador() + " CUMPLIO SU OBJETIVO");
        objetivo.setFont(new Font(25.0));
        objetivo.setStyle("-fx-text-fill: black");
        objetivo.setLayoutX(112.0);
        objetivo.setLayoutY(94.0);

        Label mostrarObjetivo = new Label("OBJETIVO: " + modelo.objetivoJugador());
        mostrarObjetivo.setFont(new Font(20.0));
        mostrarObjetivo.setStyle("-fx-text-fill: black");
        mostrarObjetivo.setLayoutX(112.0);
        mostrarObjetivo.setLayoutY(170.0);

        Label ganador = new Label("GANADOR");
        ganador.setFont(new Font(50.0));
        ganador.setStyle("-fx-text-fill: black");
        ganador.setLayoutX(181.0);
        ganador.setLayoutY(222.0);

        Circle circuloGanador = new Circle();
        circuloGanador.setLayoutX(301.0);
        circuloGanador.setLayoutY(331.0);
        circuloGanador.setRadius(42.0);
        circuloGanador.setFill(Color.web(modelo.colorCodigoJugadorEnTurno()));


        pane.getChildren().addAll(juegoTerminado,objetivo,mostrarObjetivo,ganador,circuloGanador);
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
