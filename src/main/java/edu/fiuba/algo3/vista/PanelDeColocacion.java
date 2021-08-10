package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class PanelDeColocacion extends Panel{
    private final Pane pane;

    public PanelDeColocacion(){
        super();
        Label cabezera = crearLabelCabezera("TURNO DE COLOCACION");

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

        /*Button paisDestino = new Button("COLOCAR");
        paisDestino.setLayoutX(920);
        paisDestino.setLayoutY(310);
        paisDestino.setPrefHeight(42);
        paisDestino.setPrefWidth(280);
        paisDestino.setId("paisDestino");*/

        pane = new Pane();
        pane.getChildren().addAll(cabezera, ejercitos, paisOrigen);
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
