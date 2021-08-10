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
    private static PantallaTablero vista;
    private static tableroObservable modelo;
    private Juego juego;

    public PantallaDeJuegoControlador(int cantidadJugadores) {
        jugadores = cantidadJugadores;
        try {
            juego = new Juego(cantidadJugadores);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar algun archivo del juego.");
        }
        modelo = juego.IniciarJuego();

        vista = new PantallaTablero(modelo);
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
            vista.limpiarPaises();
            modelo.notifyObservers();
        }
        if (pais1.isEmpty()) {
            pais1 = pais;
            vista.setPaisOrigen(pais);
        } else {
            pais2 = pais;
            vista.setPaisDestino(pais);
        }
        modelo.setChange();
    }

}
