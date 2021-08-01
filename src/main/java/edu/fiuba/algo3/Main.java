package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonEmpezarControlador;
import edu.fiuba.algo3.controlador.BotonSalirControlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main extends Application {
    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage stage) throws Exception{

        Pane root = new Pane();

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        File archivoIcono = new File("docs/imagenes/iconos/globo.png");
        InputStream imagen = new FileInputStream(archivoIcono);
        stage.getIcons().add(new Image(imagen));

        stage.setTitle("TEG");
        Image img = new Image("file:docs/imagenes/inicio/globo_teg_3.png",640,800,true,false);
        ImageView fondo = new ImageView(img);
        fondo.setLayoutX(-64);
        fondo.setLayoutY(-64);
        fondo.setPickOnBounds(true);
        fondo.setScaleX(0.8);
        fondo.setScaleY(0.8);
        fondo.setScaleZ(0.8);

        Button botonEmpezar = new Button("Empezar partida");
        botonEmpezar.relocate(73,351);
        botonEmpezar.setStyle("-fx-font: 14 'Algerian'");
        botonEmpezar.setOnAction(new BotonEmpezarControlador(stage));

        Button botonSalir = new Button("Salir");
        botonSalir.relocate(382,351);
        botonSalir.setStyle("-fx-font: 14 'Algerian'");
        botonSalir.setOnAction(new BotonSalirControlador());

        root.getChildren().addAll(fondo,botonEmpezar,botonSalir);
        root.setStyle("-fx-background-color: transparent;");

        Scene scene = new Scene(root, Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); //quita la vista de la ventana de windows

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*public AudioClip reproductorDeMusica(){

        String direccionMusicaInicio = "docs/battlefield-1942-soundtrack-main-theme-by-joel-eriksson.mp3";

        File dir = new File(direccionMusicaInicio);
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(2);
        return mediaPlayer;
    }*/
}