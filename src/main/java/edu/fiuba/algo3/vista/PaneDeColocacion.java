package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Observable;
import java.util.Observer;


public class PaneDeColocacion{
    private final Pane pane;

    public PaneDeColocacion(){
        Label cantidadRestante = new Label();
        cantidadRestante.setStyle("-fx-text-fill: black");
        cantidadRestante.setText("CANTIDAD RESTANTE");
        cantidadRestante.setLayoutX(920);
        cantidadRestante.setLayoutY(20); //70
        cantidadRestante.setPrefHeight(100);
        cantidadRestante.setPrefWidth(400);

        Label ejercitos = new Label();
        ejercitos.setStyle("-fx-text-fill: black");
        ejercitos.setLayoutX(1050);
        ejercitos.setLayoutY(60);
        ejercitos.setPrefHeight(90);
        ejercitos.setPrefWidth(200);

        TextField botonColocar = new TextField();
        botonColocar.setLayoutX(915);
        botonColocar.setLayoutY(180);
        botonColocar.setPrefHeight(94);
        botonColocar.setPrefWidth(259);

        Button paisDestino = new Button("COLOCAR EJERCITO");
        paisDestino.setLayoutX(920);
        paisDestino.setLayoutY(310);
        paisDestino.setPrefHeight(42);
        paisDestino.setPrefWidth(274);
        paisDestino.setId("paisDestino");

        pane = new Pane();
        pane.getChildren().addAll(cantidadRestante, ejercitos, botonColocar,paisDestino);
    }

    public Pane getPane() {
        return pane;
    }

    public void ocultar() {
        pane.setVisible(false);
    }

    public void mostrar() {
        pane.setVisible(true);
    }
}
