package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonMoverTropasControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PanelReagrupacion extends Panel{
    private final Pane pane;
    private Panel anterior;
    private Panel siguiente;

    public PanelReagrupacion(){
        super();
        Label cabezera = crearLabelCabezera("TURNO DE REAGRUPACION");

        Button botonMover = new Button("MOVER");
        botonMover.setOnAction(new BotonMoverTropasControlador());
        botonMover.setLayoutX(915);
        botonMover.setLayoutY(460); //380
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);

        pane = new Pane();
        pane.getChildren().addAll(cabezera, paisOrigen, paisDestino, botonMover);
    }

    @Override
    public void setContactos(Panel contacto) {
        if(anterior == null){
            anterior = contacto;
        }
        else {
            siguiente = contacto;
        }
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

    @Override
    public Panel siguientePanel(boolean sigueRonda) {
        if (!sigueRonda) return siguiente;
        return anterior;
    }
}
