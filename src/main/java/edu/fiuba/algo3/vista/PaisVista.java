package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;

import java.awt.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class PaisVista extends Component implements Observer{


    private final Circle circulo;
    private final Juego modelo;
    private final Label etiqueta;

    public PaisVista(Circle circulo, Juego modelo, Label numeros) {
        this.circulo = circulo;
        this.modelo = modelo;
        this.etiqueta = numeros;

        this.etiqueta.setId("numeros");
    }

    @Override
    public void update(Observable o, Object arg) {
        etiqueta.setText(String.valueOf(modelo.cantidadDeEjercito(circulo.getId())));
        circulo.setFill(Color.web(modelo.obtenerColorPais(circulo.getId())));
        repaint();
    }
}
