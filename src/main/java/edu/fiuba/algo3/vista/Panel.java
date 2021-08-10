package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;

import java.awt.*;

public abstract class Panel extends Component {

    protected Label paisOrigen = new Label("");
    protected Label paisDestino = new Label("");

    Panel(){
        paisOrigen.setLayoutX(915);
        paisOrigen.setLayoutY(180);
        paisOrigen.setPrefHeight(25);
        paisOrigen.setPrefWidth(250);

        paisDestino.setLayoutX(915);
        paisDestino.setLayoutY(300);
        paisDestino.setPrefHeight(25);
        paisDestino.setPrefWidth(250);
    }

    public Label crearLabelCabezera(String texto){
        Label cantidadRestante = new Label();
        cantidadRestante.setStyle("-fx-text-fill: black");
        cantidadRestante.setText(texto);
        cantidadRestante.setLayoutX(920);
        cantidadRestante.setLayoutY(20); //70
        cantidadRestante.setPrefHeight(100);
        cantidadRestante.setPrefWidth(400);
        return cantidadRestante;
    }

    public void limpiarPaises() {
        paisOrigen.setText("");
        paisDestino.setText("");
    }

    public void setPaisOrigen(String pais) {
        paisOrigen.setText(pais);
    }

    public void setPaisDestino(String pais) {
        paisDestino.setText(pais);
    }
}
