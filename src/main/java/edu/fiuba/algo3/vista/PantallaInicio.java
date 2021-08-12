package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEmpezarControlador;
import edu.fiuba.algo3.controlador.BotonSalirControlador;
import edu.fiuba.algo3.controlador.EleccionDeJugadoresControlador;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URI;


public class PantallaInicio {


    double xOffset;
    double yOffset;
    Stage primaryStage = new Stage();
    private static AudioClip mediaPlayer;

    private void arrastrarVentana(Scene root, Stage primaryStage){

        //para arrastar la ventana.
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    public Stage initialize() {

        AudioClip musica;

        int alturaImagen = 640;
        int anchuraImagen = 640;
        int tamañoIcono = 30;

        //Imagenes e iconos
        Image icono = new Image((getClass().getResourceAsStream("/imagenes/iconos/globo.png")));
        Image iconoPlay = new Image((getClass().getResourceAsStream("/imagenes/iconos/start_48px.png")));
        Image iconoSalida = new Image((getClass().getResourceAsStream("/imagenes/iconos/exit_50px.png")));
        Image fondo = new Image((getClass().getResourceAsStream("/imagenes/inicio/globo_teg_3.png")));
        ImageView portada = new ImageView(fondo);
        ImageView imagenPlay = new ImageView(iconoPlay);
        ImageView imagenSalida = new ImageView(iconoSalida);

        imagenPlay.setFitHeight(tamañoIcono);
        imagenPlay.setFitWidth(tamañoIcono);
        imagenSalida.setFitHeight(tamañoIcono);
        imagenSalida.setFitWidth(tamañoIcono);

        Button botonEmpezar = new Button("Empezar Partida", imagenPlay);
        Button botonSalir = new Button("Salir", imagenSalida);

        Group panel = new Group(portada, botonEmpezar, botonSalir);
        Scene scene = new Scene(panel, alturaImagen, anchuraImagen);

        portada.setFitHeight(alturaImagen);
        portada.setFitWidth(anchuraImagen);

        primaryStage.getIcons().add(icono); //cambia el icono de ejecución

        //construcción de los botones
        botonEmpezar.setLayoutX(200);
        botonEmpezar.setLayoutY(310);
        botonEmpezar.setId("botonEmpezar");
        botonEmpezar.setPrefWidth(230);
        botonEmpezar.setPrefHeight(35);
        botonEmpezar.setScaleX(1.5);
        botonEmpezar.setScaleY(1.7);
        botonEmpezar.setScaleZ(1.5);

        botonEmpezar.setOnAction(new BotonEmpezarControlador(primaryStage));

        botonSalir.setLayoutX(400);
        botonSalir.setLayoutY(501);
        botonSalir.setId("botonSalir");
        botonSalir.setPrefWidth(120);
        botonSalir.setPrefHeight(18);
        botonSalir.setScaleX(1.2);
        botonSalir.setScaleY(1.3);

        botonSalir.setOnAction(new BotonSalirControlador());

        //transparencias
        primaryStage.initStyle(StageStyle.TRANSPARENT); //quita la vista de la ventana de windows.
        scene.setFill(Color.TRANSPARENT);

        //estilos
        String css = (getClass().getResource("/estilos/botones.css")).toExternalForm();
        scene.getStylesheets().add(css);

        arrastrarVentana(scene, primaryStage);
        //musica = reproductorDeMusica();
        primaryStage.setScene(scene);

        return primaryStage;
    }



    public AudioClip reproductorDeMusica(){

        String direccionMusicaInicio = "docs/battlefield-1942-soundtrack-main-theme-by-joel-eriksson.mp3";

        File dir = new File(direccionMusicaInicio);
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        mediaPlayer = new AudioClip(musica.getSource());

        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        reproducirMusica();
        mediaPlayer.setVolume(1);

        return mediaPlayer;
    }

    private void reproducirMusica(){
        mediaPlayer.play();
    }

    public static void pararMusica(){
        mediaPlayer.stop();
    }
}
