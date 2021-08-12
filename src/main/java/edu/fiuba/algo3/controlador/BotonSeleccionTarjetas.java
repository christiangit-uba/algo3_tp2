package edu.fiuba.algo3.controlador;



import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class BotonSeleccionTarjetas implements EventHandler {
    private ArrayList<CheckBox> checkBoxs;
    private Button botonCanje;
    private Button botonActivacion;
    public BotonSeleccionTarjetas(ArrayList<CheckBox> checkBoxs, Button botonCanje, Button botonActivacion){
        this.checkBoxs = checkBoxs;
        this.botonCanje = botonCanje;
        this.botonActivacion = botonActivacion;
    }

    @Override
    public void handle(Event event) {
        PantallaDeJuegoControlador.guardarTarjeta(checkBoxs,botonCanje,botonActivacion);
    }
}
