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
    private Panel siguiente;

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
        cantidadIngresada.setLayoutY(150);
        cantidadIngresada.setPrefHeight(94);
        cantidadIngresada.setPrefWidth(259);

        Button colocar = new Button("COLOCAR");
        colocar.setOnAction(new BotonColocarControlador(cantidadIngresada));
        colocar.setLayoutX(915);
        colocar.setLayoutY(500);
        colocar.setPrefHeight(42);
        colocar.setPrefWidth(280);
        colocar.setId("paisDestino");

        Label destino = new Label("DESTINO");
        destino.setStyle("-fx-text-fill: black");
        destino.setLayoutX(915);
        destino.setLayoutY(270);

        pane = new Pane();
        pane.getChildren().addAll(cabezera, ejercitos, paisOrigen,cantidadIngresada,colocar,destino);
    }

    public Pane getPane() {
        return pane;
    }

    @Override
    public void setContactos(Panel siguiente) {
        this.siguiente = siguiente;
    }

    public void ocultar() {
        pane.setVisible(false);
    }

    public void mostrar() {
        pane.setVisible(true);
    }

    @Override
    public Panel siguientePanel(boolean sigueRonda) {
        if (sigueRonda) return this;
        return siguiente;
    }

    @Override
    public void update(Observable o, Object arg) {
        ejercitos.setText(String.valueOf(modelo.getTope()));
        repaint();
    }
}