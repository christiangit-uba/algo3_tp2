package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;
import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class PantallaDeJuegoControlador {

    private static String pais1 = "";
    private static String pais2 = "";
    private static int jugadores = 0;
    private Juego juego;

    public PantallaDeJuegoControlador(int cantidadJugadores) {
        jugadores = cantidadJugadores;
        try {
            juego = new Juego(cantidadJugadores);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar algun archivo del juego.");
        }
        tableroObservable modelo = juego.IniciarJuego();

        PantallaTablero vista = new PantallaTablero(modelo);
        Stage stage = vista.initialize();
        modelo.notifyObservers();
        stage.show();
    }

    private static void borrarDatosPaises(){
        pais1 = "";
        pais2 = "";
    }

    public static void guardarPais(String pais) {

        if( !pais1.isEmpty() && !pais2.isEmpty() ){
            borrarDatosPaises();
        }if (pais1.isEmpty()) {
            pais1 = pais;
        } else {
            pais2 = pais;
        }
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
