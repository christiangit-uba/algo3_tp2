package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class PantallaDeJuegoControlador {
    private Juego juego;
    private int cantidadJugadores;
    Button[] botones;
    private String atacante;
    private String defensor;
    private int cantiadaAUsar;
    private Button botonDefensor;
    private Button botonAtacante;
    private boolean partidaEmpezada = false;


    public void recibirParametros(int cantidadElegida){
        cantidadJugadores = cantidadElegida;
    }

    @FXML
    private Label jugadorEnTurno;

    @FXML
    private Circle colorDeJugador;

    @FXML
    private TextField cantidadDeTropas;

    @FXML
    private Button atacar;
    @FXML
    private Button terminarTurno;
    @FXML
    private Button EmpezarJuego;
    @FXML
    private Button botonArgentina;
    @FXML
    private Button botonChile;
    @FXML
    private Button botonUruguay;
    @FXML
    private Button botonBrazil;
    @FXML
    private Button botonPeru;
    @FXML
    private Button botonColombia;
    @FXML
    private Button botonSahara;
    @FXML
    private Button botonZaire;
    @FXML
    private Button botonEtiopia;
    @FXML
    private Button botonEgipto;
    @FXML
    private Button botonEspana;
    @FXML
    private Button botonFrancia;
    @FXML
    private Button botonItalia;
    @FXML
    private Button botonAlemania;
    @FXML
    private Button botonPolonia;
    @FXML
    private Button botonRusia;
    @FXML
    private Button botonGranBretana;
    @FXML
    private Button botonArabia;
    @FXML
    private Button botonIsrael;
    @FXML
    private Button botonTurquia;
    @FXML
    private Button botonIran;
    @FXML
    private Button botonGobi;
    @FXML
    private Button botonMongolia;
    @FXML
    private Button botonSiberia;
    @FXML
    private Button botonChina;
    @FXML
    private Button botonMalasia;
    @FXML
    private Button botonIndia;
    @FXML
    private Button botonSumatra;
    @FXML
    private Button botonBorneo;
    @FXML
    private Button botonJava;
    @FXML
    private Button botonAustralia;
    @FXML
    private Button botonSuecia;
    @FXML
    private Button botonAral;
    @FXML
    private Button botonTartaria;
    @FXML
    private Button botonTaymir;
    @FXML
    private Button botonKamtchatka;
    @FXML
    private Button botonJapon;
    @FXML
    private Button botonMexico;
    @FXML
    private Button botonGroenlandia;
    @FXML
    private Button botonIslandia;
    @FXML
    private Button botonLabrador;
    @FXML
    private Button botonTerranova;
    @FXML
    private Button botonNuevaYork;
    @FXML
    private Button botonCalifornia;
    @FXML
    private Button botonOregon;
    @FXML
    private Button botonAlaska;
    @FXML
    private Button botonYukon;
    @FXML
    private Button botonCanada;
    @FXML
    private Button botonSudafrica;
    @FXML
    private Button botonMadagascar;

    private boolean setearAccion(Button boton) {
        String textoBoton = boton.getText();
        String[] textoProcesado = textoBoton.split(" : ");
        String pais = textoProcesado[0];
        if (atacante == null){
            botonAtacante = boton;
            boton.setStyle("-fx-background-color: grey");
            atacante = pais;
            return true;
        }
        else if (defensor == null){
            botonDefensor = boton;
            boton.setStyle("-fx-background-color: grey");
            defensor = pais;
            return true;
        }
        return false;
    }

    @FXML
    void AccionBrazil(ActionEvent event) {
        setearAccion(botonBrazil);
    }

    @FXML
    void accionAlaska(ActionEvent event) {

    }

    @FXML
    void accionAlemania(ActionEvent event) {

    }

    @FXML
    void accionArabia(ActionEvent event) {

    }

    @FXML
    void accionAral(ActionEvent event) {

    }

    @FXML
    void accionArgentina(ActionEvent event) {
        setearAccion(botonArgentina);
    }

    @FXML
    void accionAustralia(ActionEvent event) {

    }

    @FXML
    void accionBorneo(ActionEvent event) {

    }

    @FXML
    void accionCalifornia(ActionEvent event) {

    }

    @FXML
    void accionCanada(ActionEvent event) {

    }

    @FXML
    void accionChile(ActionEvent event) {

    }

    @FXML
    void accionChina(ActionEvent event) {

    }

    @FXML
    void accionColombia(ActionEvent event) {

    }

    @FXML
    void accionEgipto(ActionEvent event) {

    }

    @FXML
    void accionEspana(ActionEvent event) {

    }

    @FXML
    void accionEtiopia(ActionEvent event) {

    }

    @FXML
    void accionFrancia(ActionEvent event) {

    }

    @FXML
    void accionGobi(ActionEvent event) {

    }

    @FXML
    void accionGranBretana(ActionEvent event) {

    }

    @FXML
    void accionGroenlandia(ActionEvent event) {

    }

    @FXML
    void accionIndia(ActionEvent event) {

    }

    @FXML
    void accionIran(ActionEvent event) {

    }

    @FXML
    void accionIslandia(ActionEvent event) {

    }

    @FXML
    void accionIsrael(ActionEvent event) {

    }

    @FXML
    void accionItalia(ActionEvent event) {

    }

    @FXML
    void accionJapon(ActionEvent event) {

    }

    @FXML
    void accionKamtchatka(ActionEvent event) {

    }

    @FXML
    void accionLabrador(ActionEvent event) {

    }

    @FXML
    void accionMadagascar(ActionEvent event) {

    }

    @FXML
    void accionMalasia(ActionEvent event) {

    }

    @FXML
    void accionMexico(ActionEvent event) {

    }

    @FXML
    void accionMongolia(ActionEvent event) {

    }

    @FXML
    void accionNuevaYork(ActionEvent event) {

    }

    @FXML
    void accionOregon(ActionEvent event) {

    }

    @FXML
    void accionPeru(ActionEvent event) {

    }

    @FXML
    void accionPolonia(ActionEvent event) {

    }

    @FXML
    void accionRusia(ActionEvent event) {

    }

    @FXML
    void accionSahara(ActionEvent event) {

    }

    @FXML
    void accionSiberia(ActionEvent event) {

    }

    @FXML
    void accionSudafrica(ActionEvent event) {

    }

    @FXML
    void accionSuecia(ActionEvent event) {

    }

    @FXML
    void accionSumatra(ActionEvent event) {

    }

    @FXML
    void accionTartaria(ActionEvent event) {

    }

    @FXML
    void accionTaymir(ActionEvent event) {

    }

    @FXML
    void accionTerranova(ActionEvent event) {

    }

    @FXML
    void accionTurquia(ActionEvent event) {

    }

    @FXML
    void accionUruguay(ActionEvent event) {

    }

    @FXML
    void accionYukon(ActionEvent event) {

    }

    @FXML
    void accionZaire(ActionEvent event) {

    }

    @FXML
    void accionJava(ActionEvent event) {

    }

    @FXML
    void AccionEmperzar(ActionEvent event) throws FileNotFoundException {
        if (!partidaEmpezada) {
            juego = new Juego(cantidadJugadores);
            botones = new Button[]{botonArgentina, botonChile, botonUruguay, botonBrazil, botonPeru, botonColombia, botonSahara, botonZaire, botonEtiopia, botonEgipto, botonEspana, botonFrancia, botonItalia, botonAlemania, botonPolonia, botonRusia, botonGranBretana, botonArabia, botonIsrael, botonTurquia, botonIran, botonGobi, botonMongolia, botonSiberia, botonChina, botonMalasia, botonIndia, botonSumatra, botonBorneo, botonJava, botonAustralia, botonSuecia, botonAral, botonTartaria, botonTaymir, botonKamtchatka, botonJapon, botonMexico, botonGroenlandia, botonIslandia, botonLabrador, botonTerranova, botonNuevaYork, botonCalifornia, botonOregon, botonAlaska, botonYukon, botonCanada, botonSudafrica, botonMadagascar};
            juego.asignarPaises();
            actualizarJugador();

            for (Button boton : botones) {
                actualizarBoton(boton, boton.getText().split(" : ")[0]);
            }
            partidaEmpezada = true;
        }
    }

    private void actualizarJugador() {
        colorDeJugador.setStyle("-fx-color: "+(juego.colorCodigoJugadorEnTurno()));
        jugadorEnTurno.setText(juego.nombreJugadorEnTurno() + ": " + juego.colorJugadorEnTurno());
    }

    public boolean esInt(String s){
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    @FXML
    void RealizarAtaque(ActionEvent event) throws Exception {
        if (atacante != null & defensor != null & esInt(cantidadDeTropas.getText())){
            juego.atacar(atacante,defensor,Integer.parseInt(cantidadDeTropas.getText()),new ArrayList<>(),new ArrayList<>());
        }
        actualizarBoton(botonAtacante, atacante);
        actualizarBoton(botonDefensor, defensor);
    }

    private void actualizarBoton(Button boton, String nombre) {
        boton.setStyle("-fx-text-fill: "+ juego.colorPais(nombre));
        //boton.setStyle("-fx-background-color: White");
        boton.setText(nombre + " : " + juego.cantidadDeEjercito(nombre) + " : " +juego.colorPais(nombre));
    }

    @FXML
    void TerminarTurno(ActionEvent event) {
        juego.terminarTurno();
        actualizarJugador();
    }
}
