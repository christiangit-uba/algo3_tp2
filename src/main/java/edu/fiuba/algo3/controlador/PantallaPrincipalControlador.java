package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PantallaPrincipalControlador {


    @FXML
    private AnchorPane empezar;

    @FXML
    private Button botonEmpezar;

    @FXML
    private Button botonSalir;

    @FXML
    void empezarJuego(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }
}
