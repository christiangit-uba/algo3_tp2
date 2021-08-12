package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonRealizarCanje implements EventHandler {

    private ArrayList<CheckBox> listaCheckBox;
    private Stage stage;

    public BotonRealizarCanje(ArrayList<CheckBox> listaCheckBox, Stage stage) {
        this.listaCheckBox = listaCheckBox;
        this.stage = stage;
    }


    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.realizarCanje(listaCheckBox);
            //stage.close();
    }
}
