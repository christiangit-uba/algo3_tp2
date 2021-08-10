package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonColocarControlador;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;


public class PanelDeColocacion extends Panel implements Observer {
    private final Pane pane;
    private final Juego modelo;
    protected Label ejercitos;

    public PanelDeColocacion(Juego modelo){
        super();
        this.modelo = modelo;
        Label cabezera = crearLabelCabezera("TURNO DE COLOCACION");

        ejercitos = new Label();
        ejercitos.setStyle("-fx-text-fill: black");
        ejercitos.setLayoutX(1050);
        ejercitos.setLayoutY(60);
        ejercitos.setPrefHeight(90);
        ejercitos.setPrefWidth(200);

        TextField cantidadIngresada = new TextField();
        cantidadIngresada.setLayoutX(915);
        cantidadIngresada.setLayoutY(180);
        cantidadIngresada.setPrefHeight(94);
        cantidadIngresada.setPrefWidth(259);

        Button colocar = new Button("COLOCAR");
        colocar.setOnAction(new BotonColocarControlador(cantidadIngresada));
        colocar.setLayoutX(920);
        colocar.setLayoutY(310);
        colocar.setPrefHeight(42);
        colocar.setPrefWidth(280);
        colocar.setId("paisDestino");

        pane = new Pane();
        pane.getChildren().addAll(cabezera, ejercitos, paisOrigen,cantidadIngresada,colocar);
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
    public void update(Observable o, Object arg) {
        ejercitos.setText(String.valueOf(modelo.getTope()));
        repaint();
    }
}
