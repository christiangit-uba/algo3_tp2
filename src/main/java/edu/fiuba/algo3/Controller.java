package edu.fiuba.algo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller {

    @FXML
    private ImageView imagen;

    @FXML
    private Button boton;


    void mostrarImagen(MouseEvent event){
        imagen.setVisible(true);
    }
}