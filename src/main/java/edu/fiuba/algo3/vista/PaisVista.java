package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;
import java.awt.Component;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class PaisVista extends Component implements Observer{

    private final Circle circulo;
    private final Juego modelo;
    private final Label etiqueta;

    public PaisVista(Circle circuloPais, Juego modelo, Label numero) {
        this.circulo = circuloPais;
        this.modelo = modelo;
        this.etiqueta = numero;

        etiqueta.setId("numeros");
    }

    @Override
    public void update(Observable o, Object arg) {
        //etiqueta.setText(String.valueOf(modelo.cantidadDeEjercito(circulo.getId())));
        int ejercitos = (modelo.cantidadDeEjercito(circulo.getId()));
        etiqueta.setText(String.valueOf(ejercitos));
        circulo.setFill(Color.web(modelo.obtenerColorPais(circulo.getId())));
        repaint();
    }
}



/*
package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;

import java.awt.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class PaisVista extends Component implements Observer{

    private final Circle circulo;
    private final Juego modelo;
    private final Label etiqueta = new Label();

    public PaisVista(Circle circulo, Juego modelo, Text ejercitos) {
        this.circulo = circulo;
        this.modelo = modelo;
        this.etiqueta.setText(ejercitos.getText());

        //this.etiqueta.setId("numeros");

    }

    @Override
    public void update(Observable o, Object arg) {
        etiqueta.setText(String.valueOf(modelo.cantidadDeEjercito(circulo.getId())));
        circulo.setFill(Color.web(modelo.obtenerColorPais(circulo.getId())));
        repaint();
    }
}
 */
