package edu.fiuba.algo3.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class EleccionDeJugadoresControlador {
    private int cantidadElegida = 0;
    ObservableList<String> numeros = FXCollections.observableArrayList("2", "3","4","5","6");

    private double xOffset;
    private double yOffset;

    @FXML
    private Label Error;
    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    public void initialize() {
        CantidadDeJugadores.setItems(numeros);
    }

    @FXML
    private ImageView FondoInicio;

    @FXML
    private Menu reproductorMusica;

    @FXML
    private Menu ajustePantalla;

    @FXML
    private Menu ayudaUsuario;

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
    void ElegirCantidad(ActionEvent event) throws IOException {

        if (cantidadElegida != 0) {
            URL location = Paths.get("src/main/java/edu/fiuba/algo3/vista/PantallaDeJuego.fxml").toUri().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());

            PantallaDeJuegoControlador inicio = /*(PantallaDeJuegoControlador)*/ fxmlLoader.getController();
            inicio.recibirParametros(cantidadElegida);

            stage.setScene(scene);

            //centro la escena
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

            stage.show();
        }
        Error.setText("Ingrese una cantidad valida");
        Error.setTextFill(Color.RED);
    }
}
