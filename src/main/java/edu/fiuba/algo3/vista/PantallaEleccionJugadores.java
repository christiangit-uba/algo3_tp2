package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.EleccionDeJugadoresControlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PantallaEleccionJugadores {

    private Stage primaryStage = new Stage();

    public Stage initialize(ComboBox<Integer> cantidadDeJugadores) {

        int alturaImagen = 640;
        int anchuraImagen = 640;

        //imagenes
        Image fondo = new Image((getClass().getResourceAsStream("/imagenes/inicio/globo_teg_2.png")));
        Image icono = new Image((getClass().getResourceAsStream("/imagenes/iconos/globo.png")));
        ImageView portada = new ImageView(fondo);
        portada.setFitHeight(alturaImagen);
        portada.setFitWidth(anchuraImagen);

        Button botonElegir = new Button("Confirmar");

        Group panel = new Group(portada, botonElegir, cantidadDeJugadores);
        Scene scene = new Scene(panel);

        botonElegir.setLayoutX(260);
        botonElegir.setLayoutY(350);
        botonElegir.setScaleX(1.5);
        botonElegir.setScaleY(1.7);
        botonElegir.setScaleZ(1.5);

        botonElegir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                try {
                    Stage tablero = EleccionDeJugadoresControlador.cargarTablero(evento);
                    primaryStage.hide();
                    tablero.show();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        });

        cantidadDeJugadores.setLayoutX(250);
        cantidadDeJugadores.setLayoutY(250);
        cantidadDeJugadores.setPrefWidth(150);
        cantidadDeJugadores.getSelectionModel().selectFirst();

        //estilos
        String css = (getClass().getResource("/estilos/botones.css")).toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.getIcons().add(icono); //cambia el icono en la barra de tareas.
        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setScene(scene);
        return primaryStage;
    }
}
