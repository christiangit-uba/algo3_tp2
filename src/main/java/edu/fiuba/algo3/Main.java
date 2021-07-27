package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

public class Main extends Application {

    private double xOffset;
    private double yOffset;

    @FXML
    private Button BotonEmpezar;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Paths.get("src/main/java/edu/fiuba/algo3/vista/PantallaInicio.fxml").toUri().toURL());

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

        //transparencias
        root.setStyle("-fx-background-color: transparent;");

        File archivoIcono = new File("docs/imagenes/iconos/globo.png");
        InputStream imagen = (InputStream) new FileInputStream(archivoIcono);

        primaryStage.getIcons().add(new Image(imagen));  //cambia el icono del juego

        Scene scene = new Scene(root, Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT); //quita la vista de la ventana de windows

        //File estiloboton = new File("src/main/java/edu/fiuba/algo3/estilos/botones.css");
        //InputStream hojaCss = (InputStream) new FileInputStream(estiloboton);

        //URL stylesheet = Main.class.getResource("src/main/java/edu/fiuba/algo3/estilos/botones.css");
        //String css = Main.class.getResource("src/main/java/edu/fiuba/algo3/estilos/botones.css").toExternalForm();
        //scene.getStylesheets().add( css );

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}