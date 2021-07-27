package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class PantallaDeJuegoControlador {
    private Juego juego;
    private int cantidadJugadores;


    public void recibirParametros(int cantidadElegida){
        cantidadJugadores = cantidadElegida;
    }

    @FXML
    private Label jugadorEnTurno;
    @FXML
    private Label PuntosJava;
    @FXML
    private Label PuntosFrancia;

    @FXML
    private Circle colorDeJugador;

    @FXML
    private Button atacar;
    @FXML
    private Button terminarTurno;
    @FXML
    private Button BotonJava;
    @FXML
    private Button BotonFrancia;
    @FXML
    private Button EmpezarJuego;

    @FXML
    void AccionEmperzar(ActionEvent event) throws FileNotFoundException {
        juego = new Juego(cantidadJugadores);
        colorDeJugador.setFill(Color.web(juego.colorCodigoJugadorEnTurno()));
        jugadorEnTurno.setText(juego.nombreJugadorEnTurno()+": "+ juego.colorJugadorEnTurno());

        PuntosJava.setText(String.valueOf(juego.cantidadDeEjercito(BotonJava.getText())));
        PuntosFrancia.setText(String.valueOf(juego.cantidadDeEjercito(BotonFrancia.getText())));

        BotonJava.setStyle("-fx-background-color: "+ juego.colorJugadorEnTurno());
        juego.terminarTurno();
        BotonFrancia.setStyle("-fx-background-color: "+ juego.colorJugadorEnTurno());
    }

    @FXML
    void AccionJava(ActionEvent event) {
        BotonJava.setStyle("-fx-background-color: grey");
        //paisAtaque = "Java";
    }

    @FXML
    void AccionFrancia(ActionEvent event) {
        BotonFrancia.setStyle("-fx-background-color: grey");
    }

    @FXML
    void RealizarAtaque(ActionEvent event) throws Exception {

        BotonFrancia.setStyle("-fx-background-color: "+ juego.colorJugadorEnTurno());
        juego.terminarTurno();
        BotonJava.setStyle("-fx-background-color: "+ juego.colorJugadorEnTurno());

        if (juego.ataqueSimulado(BotonJava.getText(),BotonFrancia.getText(),1)){
            BotonFrancia.setStyle("-fx-background-color: "+ juego.colorJugadorEnTurno());
        }

        PuntosJava.setText(String.valueOf(juego.cantidadDeEjercito(BotonJava.getText())));
        PuntosFrancia.setText(String.valueOf(juego.cantidadDeEjercito(BotonFrancia.getText())));
    }

    @FXML
    void TerminarTurno(ActionEvent event) {

    }
}
