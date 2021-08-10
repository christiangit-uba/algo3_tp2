package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonMoverTropasControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PanelReagrupacion extends Panel{
    private final Pane pane;

    public PanelReagrupacion(){
        super();
        Label cabezera = crearLabelCabezera("TURNO DE REAGRUPACION");

        Button botonMover = new Button("MOVER");
        botonMover.setLayoutX(915);
        botonMover.setLayoutY(460); //380
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);
        botonMover.setId("paisDestino");
        botonMover.setOnAction(new BotonMoverTropasControlador());

        pane = new Pane();
        pane.getChildren().addAll(cabezera, paisOrigen, paisDestino, botonMover);
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
