package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonAtacarControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class PanelAtaque extends Panel{
    private final Pane pane;

    public PanelAtaque(){
        super();
        Label cabezera = crearLabelCabezera("TURNO DE ATAQUE");

        TextField cantidadIngresada = new TextField();
        cantidadIngresada.setLayoutX(915);
        cantidadIngresada.setLayoutY(180);
        cantidadIngresada.setPrefHeight(94);
        cantidadIngresada.setPrefWidth(259);

        Button botonAtacar = new Button("ATACAR");
        botonAtacar.setOnAction(new BotonAtacarControlador(cantidadIngresada));
        botonAtacar.setLayoutX(915);
        botonAtacar.setLayoutY(460); //380
        botonAtacar.setPrefHeight(94);
        botonAtacar.setPrefWidth(259);
        //botonAtacar.setId("paisDestino");

        pane = new Pane();
        pane.getChildren().addAll(cabezera,cantidadIngresada, paisOrigen, paisDestino, botonAtacar);
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
