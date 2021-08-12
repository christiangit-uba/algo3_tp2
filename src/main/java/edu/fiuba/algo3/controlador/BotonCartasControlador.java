package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.PanelCartas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonCartasControlador implements EventHandler<ActionEvent> {
    private PanelCartas panelCartas;
    private Juego juego;
    private Stage stage;
    private ArrayList<CheckBox> listaCheckBox = new ArrayList<>();

    public BotonCartasControlador(Juego modelo){
        this.juego = modelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage = new Stage();
        panelCartas = new PanelCartas(juego,stage);
        juego.addObserver(panelCartas);
        Scene scene = new Scene(panelCartas.getPane());
        stage.setScene(scene);
        stage.showAndWait();
    }

}
