package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class PantallaDeJuegoControlador {

    private static String pais1 = "";
    private static String pais2 = "";
    private static Label etiqueta1 = new Label();
    private static Label etiqueta2 = new Label();
    private static int jugadores = 0;

    private static final String azul = "077bb";
    private static final String rojo = "cc3311";
    private static final String amarillo = "ee7733";
    private static final String verde = "009988";
    private static final String rosa = "ee3377";

    public Stage initialize() throws FileNotFoundException {
        return (new PantallaTablero()).initialize();
    }

    private static void borrarDatosPaises(){
        pais1 = "";
        PantallaTablero.ocultarEjercitos(etiqueta1);
        pais2 = "";
        PantallaTablero.ocultarEjercitos(etiqueta2);
    }

    public static void guardarPais(String pais, Label etiqueta) {

        if( !pais1.isEmpty() && !pais2.isEmpty() ){
            borrarDatosPaises();
        }if (pais1.isEmpty()) {
            pais1 = pais;
            etiqueta1 = etiqueta;
        } else {
            pais2 = pais;
            etiqueta2 = etiqueta;
        }
    }

    public void setCantidadDeJugadores(int cantidadJugadores){
        jugadores = cantidadJugadores;
        System.out.println(jugadores);
    }

    public static void actualizarEjercitosDelPais(Label ejercitosPais, int cantidad){
        ejercitosPais.setText( Integer.toString(cantidad));
    }

    private static void printPaises(){

        System.out.println(pais1);
        System.out.println(pais2);
    }

    public static void actualizarColorDelJugador(String color, Circle circulo) {

        int r = 0, g = 0, b = 0;

        switch(color){
            case rosa:
                r = 238; g = 51; b = 119;
                break;
            case verde:
                r = 0; g = 153; b = 136;
                break;
            case amarillo:
                r = 238; g = 119; b = 51;
                break;
            case rojo:
                r = 204; g = 51; b = 17;
                break;
            case azul:
                r = 0; g = 119; b = 187;
                break;
        }
        circulo.setFill(Color.rgb(r, g, b));
    }

    /*
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

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }
     */
}
