package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;
import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PantallaDeJuegoControlador {

    private static String pais1 = "";
    private static String pais2 = "";
    private static int jugadores = 0;
    private static PantallaTablero vista;
    private static Juego juego;

    public PantallaDeJuegoControlador(int cantidadJugadores) {
        jugadores = cantidadJugadores;
        try {
            juego = new Juego(cantidadJugadores);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar algun archivo del juego.");
        }
        juego.IniciarJuego();

        vista = new PantallaTablero(juego);
        Stage stage = vista.initialize();
        juego.notifyObservers();
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
            juego.notifyObservers();
        }
        if (pais1.isEmpty()) {
            pais1 = pais;
            vista.setPaisOrigen(pais);
        } else {
            pais2 = pais;
            vista.setPaisDestino(pais);
        }
        juego.setChange();
    }

    public static void colocarEjecito(int cantidadAColocar) {
        juego.colocarEjercito(pais1,cantidadAColocar);
        juego.notifyObservers();
    }

    public static void Atacar(int cantidad) {
        try {
            juego.atacar(pais1,pais2, cantidad,new ArrayList<>(),new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
