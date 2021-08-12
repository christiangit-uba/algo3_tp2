package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonActivarTarjeta implements EventHandler {

    private ArrayList<CheckBox> listaCheckBox;
    private Stage stage;
    public BotonActivarTarjeta(ArrayList<CheckBox> listaCheckBox,Stage stage) {
        this.stage = stage;
        this.listaCheckBox = listaCheckBox;
    }

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.activarTarjeta(listaCheckBox);


    }
}
