package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PantallaDeJuegoControlador {

    private static String pais1 = "";
    private static String pais2 = "";
    private static int jugadores = 0;
    private static PantallaTablero vista;
    private static Juego juego;
    private static boolean colocacionDe5Terminada = false;
    private static boolean colocacionDe3Terminada = false;
    private boolean turno;

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
        turno = true;
        rondaDeColocacionFija(5);
        stage.show();

    }

    public static void pasarTurno(Boolean avanzaJugador) {
        boolean sigueRonda = juego.terminarTurno(avanzaJugador);
        vista.terminarTurno(sigueRonda);

        if (!sigueRonda & !colocacionDe5Terminada) {
            colocacionDe5Terminada = true;
            rondaDeColocacionFija(3);
            vista.ocultarAtaque();
            return;
        }

        if (sigueRonda & colocacionDe3Terminada){
            juego.iniciarTurno();
        }

        if (!sigueRonda & colocacionDe5Terminada) colocacionDe3Terminada = true;
        juego.notifyObservers();
    }

    private static void rondaDeColocacionFija(int i) {
        juego.topeDeRonda(i);
        vista.mostrarColocacion();
        juego.notifyObservers();
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
        borrarDatosPaises();
        juego.notifyObservers();
    }

    public static void Atacar(int cantidad) {
        try {
            juego.atacar(pais1,pais2, cantidad,new ArrayList<>(),new ArrayList<>());
        } catch (Exception e) {
            crearAlerta(e.getMessage());
        }
        borrarDatosPaises();
        juego.notifyObservers();
    }

    private static void crearAlerta(String error) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("My Title");
        a.setHeaderText(error);
        a.setResizable(true);
        a.showAndWait();
    }

    public static void moverTropas() {
        try {
            juego.moverEjercito(pais1,pais2,1);
        } catch (Exception e) {
            crearAlerta(e.getMessage());
        }
        borrarDatosPaises();
        juego.notifyObservers();
    }
}
