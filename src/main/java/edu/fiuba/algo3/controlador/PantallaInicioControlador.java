package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class PantallaInicioControlador {

    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    private ImageView FondoInicio;

    @FXML
    private ImageView LogoTEG;


    @FXML
    private Button Elegir;


    @FXML
    private Button botonEmpezar;

    @FXML
    private Button botonSalir;

    @FXML
    void empezarJuego(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Paths.get("src/main/java/edu/fiuba/algo3/vista/EleccionJugadores.fxml").toUri().toURL());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setFullScreen(true);

        //centro la escena
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

        stage.show();
    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }

}

