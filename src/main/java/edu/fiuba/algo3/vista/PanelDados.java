package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonCerrarPanelDados;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Paths;
import java.util.ArrayList;

public class PanelDados {

    double xOffset;
    double yOffset;

    private final AnchorPane pane;

    public PanelDados(ArrayList<Integer> dadosAtacante, ArrayList<Integer> dadosDefensor){
        Stage stage = new Stage();

        pane = new AnchorPane();
        pane.setPrefHeight(500.0);
        pane.setPrefWidth(650.0);

        Label textoDadosAtacante = new Label("DADOS ATACANTE");
        textoDadosAtacante.setStyle("-fx-text-fill: black");
        textoDadosAtacante.setLayoutX(66.0);
        textoDadosAtacante.setLayoutY(54.0);
        textoDadosAtacante.setFont(Font.font(20.0));
        pane.getChildren().add(textoDadosAtacante);



        Label textoDadosDefensor = new Label("DADOS DEFENSOR");
        textoDadosDefensor.setStyle("-fx-text-fill: black");
        textoDadosDefensor.setLayoutX(416.0);
        textoDadosDefensor.setLayoutY(54.0);
        textoDadosDefensor.setFont(Font.font(20.0));
        pane.getChildren().add(textoDadosDefensor);



        Button botonSalir = new Button("ACEPTAR");
        botonSalir.setOnAction(new BotonCerrarPanelDados(stage));
        botonSalir.setStyle("-fx-text-fill: black");
        botonSalir.setLayoutX(258.0);
        botonSalir.setLayoutY(56.0);
        botonSalir.setPrefHeight(48.0);
        botonSalir.setPrefWidth(134.0);
        pane.getChildren().add(botonSalir);


        setearImagenDados(dadosAtacante,91);
        setearImagenDados(dadosDefensor,440);


        stage.initStyle(StageStyle.TRANSPARENT); //quita la vista de la ventana de windows

        Scene scene = new Scene(pane);

        stage.setScene(scene);

        arrastrarVentana(scene,stage);

        stage.showAndWait();

    }

    private void setearImagenDados(ArrayList<Integer> dados,int posicionX){
        for(int i = 0; i < dados.size(); i++) {
            String path = "docs/dado" + dados.get(i) + ".png";
            ImageView dado = new ImageView(String.valueOf(Paths.get(path).toUri()));
            dado.setFitHeight(120);
            dado.setFitWidth(120);
            dado.setY(95 + (i * 130));
            dado.setX(posicionX);
            pane.getChildren().add(dado);
        }
    }

    private void arrastrarVentana(Scene root, Stage primaryStage){

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }
}
