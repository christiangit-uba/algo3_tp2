package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PanelAtaque extends Panel{
    private final Pane pane;

    public PanelAtaque(){
        Label cabezera = crearLabelCabezera("TURNO DE ATAQUE");

        /*ComboBox<> paisOrigen = new ComboBox<>;

        ComboBox<> paisDestino = new ComboBox<>;*/

        /*ComboBox<Pais> paisAtacante = new ComboBox();
        paisAtacante.setLayoutX(915);
        paisAtacante.setLayoutY(180);
        paisAtacante.setPrefHeight(25);
        paisAtacante.setPrefWidth(250);

        ComboBox<Pais> paisObjetivo = new ComboBox();
        paisObjetivo.setLayoutX(915);
        paisObjetivo.setLayoutY(300);
        paisObjetivo.setPrefHeight(25);
        paisObjetivo.setPrefWidth(250);*/

        Button botonAtacar = new Button("ATACAR");
        botonAtacar.setLayoutX(915);
        botonAtacar.setLayoutY(460); //380
        botonAtacar.setPrefHeight(94);
        botonAtacar.setPrefWidth(259);
        //botonAtacar.setId("paisDestino");

        pane = new Pane();
        pane.getChildren().addAll(cabezera, paisOrigen, paisDestino, botonAtacar);
    }

    public Pane getPane() {
        return pane;
    }

    public void ocultar() {
        pane.setVisible(false);
    }

    public void mostrar() {
        pane.setVisible(true);
    }
}
