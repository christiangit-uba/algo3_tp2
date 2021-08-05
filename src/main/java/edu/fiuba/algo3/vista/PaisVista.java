package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.tableroObservable;
import java.awt.Component;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class PaisVista extends Component implements Observer{


    private final Circle circulo;
    private final tableroObservable modelo;
    private final Label etiqueta;

    public PaisVista(Circle circulo, tableroObservable modelo, Label etiqueta) {
        this.circulo = circulo;
        this.modelo = modelo;
        this.etiqueta = etiqueta;
    }

    @Override
    public void update(Observable o, Object arg) {
        etiqueta.setText(String.valueOf(modelo.cantidadDeEjercitos(circulo.getId())));
        circulo.setFill(Color.web(modelo.colorPais(circulo.getId())));
        repaint();
    }
}
