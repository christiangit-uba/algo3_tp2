package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.BreakIterator;

public class EleccionDeJugadoresControlador {
    private int cantidadElegida = 2;
    ObservableList<String> numeros = FXCollections.observableArrayList("2", "3","4","5","6");


    @FXML
    private Label Error;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    public void initialize() {
        CantidadDeJugadores.setItems(numeros);
        CantidadDeJugadores.setValue("2");
    }

    @FXML
    private ImageView FondoInicio;

    @FXML
    private ImageView LogoTEG;

    @FXML
    private Button Elegir;

    @FXML
    private ComboBox<String> CantidadDeJugadores;

    @FXML
    void Cantidad(ActionEvent event) {
        cantidadElegida = Integer.parseInt(CantidadDeJugadores.getSelectionModel().getSelectedItem());

    }


    @FXML
    void ElegirCantidad(ActionEvent event) throws Exception {

        URL location = Paths.get("src/main/java/edu/fiuba/algo3/vista/PantallaPartida.fxml").toUri().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(location);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        InicioJuego inicio = (InicioJuego)fxmlLoader.getController();
        inicio.initialize(cantidadElegida);

        stage.setScene(scene);
        stage.show();
    }
}
