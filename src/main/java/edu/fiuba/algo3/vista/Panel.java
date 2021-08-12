package edu.fiuba.algo3.vista;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public abstract class Panel extends Component {

    protected Label ejercitos = new Label();
    protected Label paisOrigen = new Label("");
    protected Label paisDestino = new Label("");

    Panel(){
        paisOrigen.setLayoutX(1030);
        paisOrigen.setLayoutY(300);
        paisOrigen.setPrefHeight(25);
        paisOrigen.setPrefWidth(250);
        paisOrigen.toFront();

        paisDestino.setLayoutX(1030);
        paisDestino.setLayoutY(350);
        paisDestino.setPrefHeight(25);
        paisDestino.setPrefWidth(250);

        //ejercitos.setStyle("-fx-text-fill: black");
        ejercitos.setLayoutX(900);
        ejercitos.setLayoutY(60);
        ejercitos.setPrefHeight(90);
        ejercitos.setPrefWidth(200);
    }

    public Label crearLabelCabezera(String texto){
        Label cantidadRestante = new Label();
        cantidadRestante.setStyle("-fx-text-fill: black");
        cantidadRestante.setText(texto);
        cantidadRestante.setLayoutX(920);
        cantidadRestante.setLayoutY(20);
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

    EventHandler<KeyEvent> permitirNumeros = new EventHandler<>(){

        @Override
        public void handle(KeyEvent event){
            TextField textoEjercitos = (TextField) event.getSource();
            textoEjercitos.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    textoEjercitos.setText(oldValue);
                }
            });
        }
    };
}
