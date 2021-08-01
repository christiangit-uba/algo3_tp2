package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaEleccionJugadores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class EleccionDeJugadoresControlador {

    private Stage primaryStage = new Stage();
    private static ObservableList<Integer> numeros = FXCollections.observableArrayList(2,3,4,5,6);
    private static final ComboBox<Integer> cantidadDeJugadores = new ComboBox<>(numeros);

    public Stage initialize() {
        return  (new PantallaEleccionJugadores()).initialize(cantidadDeJugadores);
    }

    private static int getCantidadJugadores() {
        return cantidadDeJugadores.getSelectionModel().getSelectedItem();
    }

    public static Stage cargarTablero(ActionEvent event) throws IOException {

        // le pasa la cantidad de jugadores a la siguiente escena.
        URL location = Paths.get("src/main/java/edu/fiuba/algo3/vista/PantallaDeJuego.fxml").toUri().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        int cantidadElegida = getCantidadJugadores();

        PantallaDeJuegoControlador inicio = fxmlLoader.getController();
        inicio.recibirParametros(cantidadElegida);

        stage.setScene(scene);

        //centro la escena
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

        return stage;
    }
}
