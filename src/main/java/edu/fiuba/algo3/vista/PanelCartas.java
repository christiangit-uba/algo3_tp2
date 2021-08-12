package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonActivarTarjeta;
import edu.fiuba.algo3.controlador.BotonRealizarCanje;
import edu.fiuba.algo3.controlador.BotonSeleccionTarjetas;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PanelCartas implements Observer {
    private Juego juego;
    private Stage stage;
    private Pane panelCartas;
    private Button botonCanje;
    private Button botonActivacion;
    private ArrayList<CheckBox> listaCheckBox = new ArrayList<>();

    public PanelCartas(Juego juego,Stage stage) {
        this.juego = juego;
        this.stage = stage;

        panelCartas = new Pane();
        panelCartas.setPrefHeight(600.0);
        panelCartas.setPrefWidth(600.0);

        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());
        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());
        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());
        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());
        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());
        juego.getTarjetero().asignarTarjeta(juego.jugadorEnTurno());

        setearTarjetasSeleccion();

    }

    public void setearTarjetasSeleccion(){
        Label textoPais = new Label("PAIS");
        textoPais.setStyle("-fx-text-fill: black");
        textoPais.setLayoutX(95.0);
        textoPais.setLayoutY(36.0);
        textoPais.setFont(Font.font(28.0));
        panelCartas.getChildren().add(textoPais);

        Label textoSimbolo = new Label("SIMBOLO");
        textoSimbolo.setStyle("-fx-text-fill: black");
        textoSimbolo.setLayoutX(415.0);
        textoSimbolo.setLayoutY(36.0);
        textoSimbolo.setFont(Font.font(28.0));
        panelCartas.getChildren().add(textoSimbolo);

        botonCanje = new Button("CANJEAR");
        botonCanje.setStyle("-fx-text-fill: black");
        botonCanje.setLayoutX(225.0);
        botonCanje.setLayoutY(27.0);
        botonCanje.setFont(Font.font(28.0));
        botonCanje.setVisible(false);
        panelCartas.getChildren().add(botonCanje);
        botonCanje.setOnAction(new BotonRealizarCanje(listaCheckBox,stage));

        botonActivacion = new Button("ACTIVAR");
        botonActivacion.setStyle("-fx-text-fill: black");
        botonActivacion.setLayoutX(225.0);
        botonActivacion.setLayoutY(27.0);
        botonActivacion.setFont(Font.font(28.0));
        botonActivacion.setVisible(false);
        panelCartas.getChildren().add(botonActivacion);
        botonActivacion.setOnAction(new BotonActivarTarjeta(listaCheckBox,stage));

        ArrayList<Tarjeta> tarjetasJugador;
        tarjetasJugador = juego.tarjetasJugador();
        for(int i = 0; i < tarjetasJugador.size(); i++){
            Label nombrePais = new Label("NOMBRE PAIS");
            nombrePais.setText(tarjetasJugador.get(i).obtenerID());
            nombrePais.setStyle("-fx-text-fill: black");
            nombrePais.setLayoutX(95.0);
            nombrePais.setLayoutY(91.0 + (i * 28.0));
            nombrePais.setFont(Font.font(15.0));
            panelCartas.getChildren().add(nombrePais);

            Line lineaDivisora = new Line();
            lineaDivisora.setLayoutX(196.0);
            lineaDivisora.setLayoutY(112.0 + (i * 28.0));
            lineaDivisora.setStartX(-196.0);
            lineaDivisora.setEndX(400.0);
            panelCartas.getChildren().add(lineaDivisora);

            Label nombreSimbolo = new Label("SIMBOLO");
            nombreSimbolo.setText(tarjetasJugador.get(i).obtenerSimbolo());
            nombreSimbolo.setStyle("-fx-text-fill: black");
            nombreSimbolo.setLayoutX(415.0);
            nombreSimbolo.setLayoutY(91.0 + (i * 28.0));
            nombreSimbolo.setFont(Font.font(15.0));
            panelCartas.getChildren().add(nombreSimbolo);

            Label estadoTarjeta = new Label("NO ACTIVADA");
            estadoTarjeta.setStyle("-fx-text-fill: red");
            estadoTarjeta.setLayoutX(258.0);
            estadoTarjeta.setLayoutY(91.0 + (i * 28.0));
            estadoTarjeta.setFont(Font.font(15.0));
            if(tarjetasJugador.get(i).tarjetaActivada()) {
                estadoTarjeta.setText("ACTIVADA");
                estadoTarjeta.setStyle("-fx-text-fill: green");
            }
            panelCartas.getChildren().add(estadoTarjeta);



            CheckBox checkBox = new CheckBox();
            checkBox.setId(tarjetasJugador.get(i).obtenerID());
            checkBox.setLayoutX(44.0);
            checkBox.setLayoutY(93.0 + (i * 28.0));
            checkBox.setOnAction(new BotonSeleccionTarjetas(listaCheckBox,botonCanje,botonActivacion));
            listaCheckBox.add(checkBox);
            panelCartas.getChildren().add(checkBox);
        }

    }


    public Parent getPane() {
        return panelCartas;
    }

    @Override
    public void update(Observable o, Object arg) {
        panelCartas.getChildren().setAll();
        listaCheckBox.removeAll(listaCheckBox);
        setearTarjetasSeleccion();
    }
}
