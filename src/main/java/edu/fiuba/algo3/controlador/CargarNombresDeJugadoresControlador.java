package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class CargarNombresDeJugadoresControlador {
    private ArrayList<Jugador> jugadores;
    private Juego juego;
    private int jugadorANombrar = 0;

    public CargarNombresDeJugadoresControlador(Juego juego) {
        this.juego = juego;
        jugadores = juego.jugadores();
        Jugador.setText("Jugador: " + jugadores.get(jugadorANombrar).color());
        ColorNombre.setFill(Color.web(jugadores.get(jugadorANombrar).colorCodigo()));
    }

    @FXML
    private Button Aceptar;

    @FXML
    private TextField ColocarNombre;

    @FXML
    private Label Jugador;

    @FXML
    private Circle ColorNombre;

    /*@FXML
    void AceptarNombre(ActionEvent event) {
        if (ColocarNombre.)

    }*/
}
