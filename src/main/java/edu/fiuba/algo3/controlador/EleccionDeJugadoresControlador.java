package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaEleccionJugadores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;


public class EleccionDeJugadoresControlador {

    private static ObservableList<Integer> numeros = FXCollections.observableArrayList(2,3,4,5,6);
    private static final ComboBox<Integer> cantidadDeJugadores = new ComboBox<>(numeros);

    public Stage initialize() {
        return  (new PantallaEleccionJugadores()).initialize(cantidadDeJugadores);
    }

    private static int getCantidadJugadores() {
        return cantidadDeJugadores.getSelectionModel().getSelectedItem();
    }

    public static void cargarTablero() throws IOException {
        new PantallaDeJuegoControlador(getCantidadJugadores());
    }
}
