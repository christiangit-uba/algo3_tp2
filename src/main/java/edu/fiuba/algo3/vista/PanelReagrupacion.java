package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonMoverTropasControlador;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PanelReagrupacion {
    private final Pane pane;

    public PanelReagrupacion(){
        Label cantidadRestante = new Label();
        cantidadRestante.setStyle("-fx-text-fill: black");
        cantidadRestante.setText("REAGRUPAR TROPAS");
        cantidadRestante.setLayoutX(917);
        cantidadRestante.setLayoutY(20); //70
        cantidadRestante.setPrefHeight(100);
        cantidadRestante.setPrefWidth(400);

        ComboBox<Pais> paisOrigen = new ComboBox();
        paisOrigen.setLayoutX(915);
        paisOrigen.setLayoutY(180);
        paisOrigen.setPrefHeight(25);
        paisOrigen.setPrefWidth(250);

        ComboBox<Pais> paisDestino = new ComboBox();
        paisDestino.setLayoutX(915);
        paisDestino.setLayoutY(300);
        paisDestino.setPrefHeight(25);
        paisDestino.setPrefWidth(250);

        Button botonMover = new Button("MOVER");
        botonMover.setLayoutX(915);
        botonMover.setLayoutY(460); //380
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);
        botonMover.setId("paisDestino");
        botonMover.setOnAction(new BotonMoverTropasControlador());

        pane = new Pane();
        pane.getChildren().addAll(cantidadRestante, paisOrigen, paisDestino, botonMover);
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
