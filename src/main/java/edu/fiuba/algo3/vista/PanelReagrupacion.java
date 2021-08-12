package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonMoverTropasControlador;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PanelReagrupacion extends Panel{
    private final Pane pane;
    private Panel anterior;
    private Panel siguiente;
    private Juego modelo;

    public PanelReagrupacion(Juego modelo){
        super();
        this.modelo = modelo;
        Label cabezera = crearLabelCabezera("TURNO DE REAGRUPACION");

        Button botonMover = new Button("MOVER");
        botonMover.setOnAction(new BotonMoverTropasControlador());
        botonMover.setLayoutX(915);
        botonMover.setLayoutY(150); //380
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);

        Label origen = new Label("ORIGEN");
        origen.setStyle("-fx-text-fill: black");
        origen.setLayoutX(915);
        origen.setLayoutY(270);

        Label destino = new Label("DESTINO");
        destino.setStyle("-fx-text-fill: black");
        destino.setLayoutX(915);
        destino.setLayoutY(370);

        pane = new Pane();
        pane.getChildren().addAll(cabezera, paisOrigen, paisDestino, botonMover,origen,destino);
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
