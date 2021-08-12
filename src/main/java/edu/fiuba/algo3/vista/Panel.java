package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.*;

public abstract class Panel extends Component {

    protected Label ejercitos = new Label();
    protected Label paisOrigen = new Label("");
    protected Label paisDestino = new Label("");

    Panel(){
        paisOrigen.setStyle("-fx-text-fill: black");
        paisOrigen.setLayoutX(915);
        paisOrigen.setLayoutY(300);
        paisOrigen.setPrefHeight(25);
        paisOrigen.setPrefWidth(250);

        paisDestino.setStyle("-fx-text-fill: black");
        paisDestino.setLayoutX(915);
        paisDestino.setLayoutY(400);
        paisDestino.setPrefHeight(25);
        paisDestino.setPrefWidth(250);

        ejercitos.setStyle("-fx-text-fill: black");
        ejercitos.setLayoutX(1050);
        ejercitos.setLayoutY(60);
        ejercitos.setPrefHeight(90);
        ejercitos.setPrefWidth(200);




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

    public abstract void setContactos(Panel panelAtaque);

    public abstract void ocultar();

    public abstract void mostrar();

    public abstract Panel siguientePanel(boolean sigueRonda);
}
