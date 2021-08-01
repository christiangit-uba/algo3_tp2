package edu.fiuba.algo3.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BotonEmpezarControlador implements EventHandler<ActionEvent> {
    private int cantidadElegida = 2;
    ObservableList<String> numeros = FXCollections.observableArrayList("2", "3","4","5","6");
    private final Stage stage;

    public BotonEmpezarControlador(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Scene scene = crearPantallaSeleccionCantidadJugadores();

        stage.setScene(scene);
        stage.show();
    }

    private Scene crearPantallaSeleccionCantidadJugadores() {
        ComboBox<String> cantidadDeJugadores = new ComboBox<>();

        cantidadDeJugadores.setItems(numeros);
        cantidadDeJugadores.setValue("2");
        cantidadDeJugadores.setOnAction(new CantidadDeJugadorContolador(cantidadElegida));

        Button botonElegirCantidad = new Button("Elegir cantidad");
        botonElegirCantidad.setOnAction(new BotonElegirCantidadControlador());

        HBox contenedorHorizontal = new HBox(cantidadDeJugadores, botonElegirCantidad);
        contenedorHorizontal.setSpacing(10);

        return new Scene(contenedorHorizontal);
    }
}
