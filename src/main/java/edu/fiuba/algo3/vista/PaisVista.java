package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;
import java.awt.Component;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class PaisVista extends Component implements Observer{


    private final Circle circulo;
    private final Juego modelo;
    private final Text etiqueta;

    public PaisVista(Circle circulo, Juego modelo, Text etiqueta) {
        this.circulo = circulo;
        this.modelo = modelo;
        this.etiqueta = etiqueta;
    }

    @Override
    public void update(Observable o, Object arg) {
        etiqueta.setText(String.valueOf(modelo.cantidadDeEjercito(circulo.getId())));
        circulo.setFill(Color.web(modelo.obtenerColorPais(circulo.getId())));
        repaint();
    }
}
