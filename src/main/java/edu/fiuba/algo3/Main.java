package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Paths.get("src/main/java/edu/fiuba/algo3/vista/PantallaInicio.fxml").toUri().toURL());
        primaryStage.setTitle("TEG");

        primaryStage.setScene(new Scene(root, 300, 275));

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}