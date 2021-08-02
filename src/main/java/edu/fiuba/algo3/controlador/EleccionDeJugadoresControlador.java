package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaEleccionJugadores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


public class EleccionDeJugadoresControlador {

    private static Stage stage = new Stage();
    private static ObservableList<Integer> numeros = FXCollections.observableArrayList(2,3,4,5,6);
    private static final ComboBox<Integer> cantidadDeJugadores = new ComboBox<>(numeros);

    public Stage initialize() {
        return  (new PantallaEleccionJugadores()).initialize(cantidadDeJugadores);
    }

    private static int getCantidadJugadores() {
        return cantidadDeJugadores.getSelectionModel().getSelectedItem();
    }

    public static Stage cargarTablero(ActionEvent event) throws IOException {


        PantallaDeJuegoControlador juego = new PantallaDeJuegoControlador();
        stage = juego.initialize();

        //le paso la cantidad de jugadores al tablero.
        juego.setCantidadDeJugadores(getCantidadJugadores());

        return stage;
    }

}
