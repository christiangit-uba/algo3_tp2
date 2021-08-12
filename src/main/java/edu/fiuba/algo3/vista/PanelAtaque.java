package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonAtacarControlador;
import edu.fiuba.algo3.controlador.BotonCartasControlador;
import edu.fiuba.algo3.controlador.BotonDesactivarControlador;
import edu.fiuba.algo3.controlador.BotonPasarTurnoEnAtaqueControlador;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class PanelAtaque extends Panel{
    private final Pane pane;
    private Panel siguiente;
    private Juego juego;

    public PanelAtaque(Juego modelo){
        super();
        this.juego = modelo;
        Label cabezera = crearLabelCabezera("TURNO DE ATAQUE");
        cabezera.setId("cabecera");

        Label cantidadEjercitos = new Label("CANTIDAD DE ATACANTES:");
        cantidadEjercitos.setLayoutX(908);
        cantidadEjercitos.setLayoutY(140);

        TextField cantidadIngresada = new TextField();
        cantidadIngresada.setLayoutX(928);
        cantidadIngresada.setLayoutY(180);
        cantidadIngresada.setPrefHeight(94);
        cantidadIngresada.setPrefWidth(259);
        cantidadIngresada.setId("atacantes");
        cantidadIngresada.addEventFilter(KeyEvent.ANY, permitirNumeros);

        Button botonAtacar = new Button("ATACAR");
        botonAtacar.setOnAction(new BotonAtacarControlador(cantidadIngresada));
        botonAtacar.setLayoutX(928);
        botonAtacar.setLayoutY(400);
        botonAtacar.setPrefHeight(94);
        botonAtacar.setPrefWidth(259);

        Button siguienteFase = new Button("PASAR TURNO");
        siguienteFase.setLayoutX(643);
        siguienteFase.setLayoutY(588);
        siguienteFase.setPrefHeight(94);
        siguienteFase.setPrefWidth(234);
        siguienteFase.setId("pasaTurno");
        siguienteFase.setOnAction(new BotonPasarTurnoEnAtaqueControlador());
        siguienteFase.toFront();

        Button botonCartas = new Button("VER CARTAS");
        botonCartas.setLayoutX(7);
        botonCartas.setLayoutY(588);
        botonCartas.setPrefHeight(94);
        botonCartas.setPrefWidth(320);
        botonCartas.setOnAction(new BotonCartasControlador(modelo));

        Button desactivarPais = new Button("DESACTIVAR PAIS");
        desactivarPais.setLayoutX(900);
        desactivarPais.setLayoutY(588);
        desactivarPais.setOnAction(new BotonDesactivarControlador());
        desactivarPais.toFront();

        Label pais2 = new Label("País 2:");
        pais2.setLayoutX(928);
        pais2.setLayoutY(340);
        pais2.setId("pais2");

        pane = new Pane();
        pane.getChildren().addAll(cabezera,cantidadIngresada, siguienteFase, paisOrigen, paisDestino,
                botonAtacar, botonCartas, desactivarPais , pais2, cantidadEjercitos);
    }

    @Override
    public void setContactos(Panel siguiente) {
        this.siguiente = siguiente;
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

    @Override
    public Panel siguientePanel(boolean sigueRonda) {
        return siguiente;
    }
}
