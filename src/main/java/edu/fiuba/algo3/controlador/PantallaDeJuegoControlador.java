package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.vista.PanelDados;
import edu.fiuba.algo3.vista.PantallaTablero;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private static ArrayList<Integer> dadosAtacante;
    private static ArrayList<Integer> dadosDefensor;
    private static ArrayList<CheckBox> tarjetasSeleccionadas;

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
        vista.terminarTurno(sigueRonda,juego.juegoTerminado());

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
            dadosAtacante = new ArrayList<>();
            dadosDefensor = new ArrayList<>();
            juego.atacar(pais1,pais2, cantidad,dadosAtacante,dadosDefensor);
            PanelDados panelDados = new PanelDados(dadosAtacante,dadosDefensor);
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




    public static void guardarTarjeta(ArrayList<CheckBox> checkBoxs, Button botonCanje, Button botonActivacion){
        int contador = 0;
        int i = 0;
        ArrayList<CheckBox> checkBoxSeleccionados = new ArrayList<>();
        while (contador <= 3 && i < checkBoxs.size()) {
            if (checkBoxs.get(i).isSelected()) {
                contador++;
                checkBoxSeleccionados.add(checkBoxs.get(i));
            }
            i++;
        }

        if(contador > 3) {
            for (CheckBox j : checkBoxSeleccionados)
                j.setSelected(false);
            botonCanje.setVisible(false);
            botonActivacion.setVisible(false);
        }
        else if(contador == 3) {
            tarjetasSeleccionadas = checkBoxSeleccionados;
            botonCanje.setVisible(true);
            botonActivacion.setVisible(false);
        }
        else if(contador == 1){
            tarjetasSeleccionadas = checkBoxSeleccionados;
            botonActivacion.setVisible(true);
            botonCanje.setVisible(false);
        }
        else {
            botonActivacion.setVisible(false);
            botonCanje.setVisible(false);
        }

    }

    public static boolean realizarCanje(ArrayList<CheckBox> listaCheckBox){

        ArrayList<Tarjeta> tarjetasJugador = new ArrayList<>();
        for(CheckBox i: tarjetasSeleccionadas){
            String nombreTarjeta = i.getId();
            tarjetasJugador.add(juego.buscarTarjetaJugador(juego.obtenerPais(nombreTarjeta)));
        }
        boolean cond = juego.canjearTarjetas(tarjetasJugador);
        if(!cond) crearAlerta("Canje solo valido si los simbolos son diferentes/iguales");
        juego.notifyObservers();
        return cond;
    }

    public static boolean activarTarjeta(ArrayList<CheckBox> listaCheckBox) {
        String nombreTarjeta = tarjetasSeleccionadas.get(0).getId();
        Tarjeta tarjeta = juego.buscarTarjetaJugador(juego.obtenerPais(nombreTarjeta));
        tarjetasSeleccionadas.removeAll(tarjetasSeleccionadas);

        boolean cond = juego.activarTarjeta(tarjeta);
        if(!cond)crearAlerta("Usted no posee ese pais o la tarjeta ya fue activada");
        juego.notifyObservers();
        return cond;
    }
}
