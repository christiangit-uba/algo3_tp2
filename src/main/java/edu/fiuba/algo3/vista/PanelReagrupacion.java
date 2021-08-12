package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonMoverTropasControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class PanelReagrupacion extends Panel{
    private final Pane pane;
    private Panel anterior;
    private Panel siguiente;

    public PanelReagrupacion(){
        super();
        Label cabezera = crearLabelCabezera("TURNO DE REAGRUPACION");

        Label cantidadEjercitos = new Label("CANTIDAD A MOVER:");
        cantidadEjercitos.setLayoutX(928);
        cantidadEjercitos.setLayoutY(140);

        TextField cantidadIngresada = new TextField();
        cantidadIngresada.setLayoutX(928);
        cantidadIngresada.setLayoutY(180);
        cantidadIngresada.setPrefHeight(94);
        cantidadIngresada.setPrefWidth(259);
        cantidadIngresada.setId("atacantes");
        cantidadIngresada.addEventFilter(KeyEvent.ANY, permitirNumeros);

        Label pais2 = new Label("País 2:");
        pais2.setLayoutX(928);
        pais2.setLayoutY(340);
        pais2.setId("pais2");

        Button botonMover = new Button("MOVER");
        botonMover.setOnAction(new BotonMoverTropasControlador(cantidadIngresada));
        botonMover.setLayoutX(928);
        botonMover.setLayoutY(460);
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);

        pane = new Pane();
        pane.getChildren().addAll(cabezera, paisOrigen, paisDestino, botonMover,
                cantidadIngresada, cantidadEjercitos, pais2);
    }

    @Override
    public void setContactos(Panel contacto) {
        if(anterior == null){
            anterior = contacto;
        } else {
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
