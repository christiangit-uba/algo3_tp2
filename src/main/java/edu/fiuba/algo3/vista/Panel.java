package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public abstract class Panel extends Component {

    protected Label ejercitos = new Label();
    protected Label paisOrigen = new Label("");
    protected Label paisDestino = new Label("");

    Panel(){
        paisOrigen.setLayoutX(1030);  //915
        paisOrigen.setLayoutY(300);  //180
        paisOrigen.setPrefHeight(25);
        paisOrigen.setPrefWidth(250);
        paisOrigen.toFront();

        paisDestino.setLayoutX(1030); //915
        paisDestino.setLayoutY(350); //300
        paisDestino.setPrefHeight(25);
        paisDestino.setPrefWidth(250);
        //paisDestino.toFront();

        ejercitos.setStyle("-fx-text-fill: black");
        ejercitos.setLayoutX(900); //1050
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

    EventHandler<KeyEvent> filtarNumeros = new EventHandler<>(){

        private boolean mostrarTecla = false;
        private int digitosMaximos = 3;

        @Override
        public void handle(KeyEvent event){
            javafx.scene.control.TextField temp = (TextField) event.getSource();
            if(mostrarTecla){ event.consume(); }

            if( (!(event.getText().matches("[0-9]")) )){
                mostrarTecla = true;
            } else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                mostrarTecla = false;
            }

            /*
            if (( temp.getText().length() > digitosMaximos -1) ){
                mostrarTecla = true;
            }else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                mostrarTecla = false;
            }

             */
        }
    };
}
