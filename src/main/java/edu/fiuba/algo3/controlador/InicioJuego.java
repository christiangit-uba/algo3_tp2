package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class InicioJuego {
    private Juego juego;
    Hashtable<String, Circle> listaCirculosPaises = new Hashtable<>();
    Hashtable<String, Label> ejercitosPaises = new Hashtable<>();

    ObservableList<String> paises = FXCollections.observableArrayList();
    ObservableList<String> paisesLimitrofes = FXCollections.observableArrayList();
    ObservableList<String> cantidadEjercitosAtaque = FXCollections.observableArrayList();

    private String paisAtacante = "0";
    private String paisDefensor = "0";
    private int ejercitosAtaque = 0;
    private boolean circulosVisibles = true;




    public void initialize(int cantidad) throws Exception {
        cambiarMenuAtaque();
        //Agrego al diccionario fichas
        listaCirculosPaises.put("Argentina",CirculoArgentina);
        listaCirculosPaises.put("Brazil",CirculoBrasil);
        listaCirculosPaises.put("Chile",CirculoChile);
        listaCirculosPaises.put("Peru",CirculoPeru);
        listaCirculosPaises.put("Colombia",CirculoColombia);
        listaCirculosPaises.put("Uruguay",CirculoUruguay);

        //Agrego al diccionario indicador de cantidad de ejercitos
        ejercitosPaises.put("Argentina",CantidadEjercitosArgentina);
        ejercitosPaises.put("Brazil",CantidadEjercitosBrasil);
        ejercitosPaises.put("Chile",CantidadEjercitosChile);
        ejercitosPaises.put("Peru",CantidadEjercitosPeru);
        ejercitosPaises.put("Colombia",CantidadEjercitosColombia);
        ejercitosPaises.put("Uruguay",CantidadEjercitosUruguay);

        juego = new Juego(cantidad);

        juego.tablero().asignarPaises(juego.jugadores());
        juego.tablero().asignarPaises(juego.jugadores());
        juego.tablero().asignarPaises(juego.jugadores());

        CirculoColorJugador.setFill(Color.web(juego.jugadores().get(0).obtenerColor().codigo()));

        asignarPaisesSeleccion();

        actualizarFichas();

        SeleccionPaisDefensor.setValue("");
        SeleccionPaisDefensor.setValue("");
        SeleccionEjercitosAtaque.setValue("");

    }


    public void actualizarFichas(){
        for (Map.Entry<String, Circle> entry : listaCirculosPaises.entrySet()){
            Pais pais = juego.tablero().obtenerPais(entry.getKey());
            entry.getValue().setFill(Color.web(pais.color().codigo()));
            Label ejercitos = ejercitosPaises.get(entry.getKey());
            ejercitos.setText(Integer.toString(pais.cantidadEjercitos()));
        }
    }

    private void asignarPaisesSeleccion(){
        ArrayList<String> paisesJugador;
        Jugador jugadorEnTurno = juego.jugadores().get(0);
        paisesJugador = juego.tablero().paisesDelJugador(jugadorEnTurno.obtenerColor());

        paises.setAll(paisesJugador);
        SeleccionPaisAtacante.setItems(paises);

    }

    private void asignarEjercitosSeleccion(String paisAtaque){
        ArrayList<String> cantidades = new ArrayList<>();
        Pais pais = juego.tablero().obtenerPais(paisAtaque);
        for(int i = 1; i < pais.cantidadEjercitos(); i++){
            cantidades.add(Integer.toString(i));
        }
        cantidadEjercitosAtaque.setAll(cantidades);
        SeleccionEjercitosAtaque.setItems(cantidadEjercitosAtaque);
    }


    @FXML
    private ComboBox<String> SeleccionPaisAtacante;

    @FXML
    private ComboBox<String> SeleccionPaisDefensor;

    @FXML
    private ComboBox<String> SeleccionEjercitosAtaque;


    @FXML
    void elegirAtacante(ActionEvent event) {
        ArrayList<String> nombresLimitrofes;

        String paisAtaque = SeleccionPaisAtacante.getSelectionModel().getSelectedItem();
        nombresLimitrofes = juego.tablero().obtenerPais(paisAtaque).obtenerLimitrofes();
        paisesLimitrofes.setAll(nombresLimitrofes);
        SeleccionPaisDefensor.setItems(paisesLimitrofes);

        paisAtacante = paisAtaque;
        asignarEjercitosSeleccion(paisAtacante);
    }

    @FXML
    void elegirDefensor(ActionEvent event) {
        paisDefensor = SeleccionPaisDefensor.getSelectionModel().getSelectedItem();
    }

    @FXML
    void elegirCantidadEjercitos(ActionEvent event) {
        ejercitosAtaque = Integer.parseInt(SeleccionEjercitosAtaque.getSelectionModel().getSelectedItem());

    }

    @FXML
    private Label errorOpcionAtaque;
    @FXML
    private Label errorOpcionDefensa;
    @FXML
    private Label errorOpcionEjercitos;
    @FXML
    private Button BotonVerMapa;
    @FXML
    private Button botonPasarTurno;
    @FXML
    private Label textoMenuAtaque;

    @FXML
    private Label textoPaisAtacante;

    @FXML
    private Label textoPaisDefensor;

    @FXML
    private Label textoEjercitosAtaque;





    @FXML
    private Button BotonDeAtaque;
    @FXML
    private Button BotonDeMovimiento;

    @FXML
    private Circle CirculoColorJugador;

    @FXML
    private Circle CirculoArgentina;

    @FXML
    private Label CantidadEjercitosArgentina;

    @FXML
    private Circle CirculoUruguay;

    @FXML
    private Circle CirculoBrasil;

    @FXML
    private Circle CirculoChile;

    @FXML
    private Circle CirculoPeru;

    @FXML
    private Circle CirculoColombia;

    @FXML
    private Label CantidadEjercitosUruguay;

    @FXML
    private Label CantidadEjercitosBrasil;

    @FXML
    private Label CantidadEjercitosChile;

    @FXML
    private Label CantidadEjercitosPeru;

    @FXML
    private Label CantidadEjercitosColombia;

    @FXML
    void realizarAtaque(ActionEvent event) throws Exception {

        if(opcionVacia(paisAtacante, errorOpcionAtaque) && opcionVacia(paisDefensor, errorOpcionDefensa) && opcionVacia(Integer.toString(ejercitosAtaque), errorOpcionEjercitos)) {

            ArrayList<Integer> dadosAtaque = new ArrayList<>();
            ArrayList<Integer> dadosDefensa = new ArrayList<>();

            /*
            dadosAtaque.add(6);
            dadosDefensa.add(1);
             */

            juego.atacar(paisAtacante, paisDefensor, ejercitosAtaque, dadosAtaque, dadosDefensa);




            actualizarFichas();
            asignarPaisesSeleccion();

        }
        SeleccionPaisDefensor.setValue("");
        SeleccionPaisDefensor.setValue("");
        SeleccionEjercitosAtaque.setValue("");
    }

    @FXML
    void realizarMovimiento(ActionEvent event) throws Exception {
        if(opcionVacia(paisAtacante, errorOpcionAtaque) && opcionVacia(paisDefensor, errorOpcionDefensa) && opcionVacia(Integer.toString(ejercitosAtaque), errorOpcionEjercitos)) {
            juego.mover(paisAtacante,paisDefensor,ejercitosAtaque);
            actualizarFichas();
            asignarPaisesSeleccion();

        }
        SeleccionPaisDefensor.setValue("");
        SeleccionPaisDefensor.setValue("");
        SeleccionEjercitosAtaque.setValue("");

    }

    private boolean opcionVacia(String opcion, Label label){
        if(opcion.equals("")) {
            label.setText("Ingrese una opcion");
            return true;
        }
        label.setText("");
        return false;
    }

    @FXML
    void mostrarMapaCompleto(ActionEvent event) {
        boolean visibilidad = !circulosVisibles;

        for (Map.Entry<String, Circle> entry : listaCirculosPaises.entrySet()){
            entry.getValue().setVisible(visibilidad);
            ejercitosPaises.get(entry.getKey()).setVisible(visibilidad);
        }
        circulosVisibles = visibilidad;
    }

    @FXML
    void pasarTurno(ActionEvent event) {
        cambiarMenuReagrupacion();


    }

    private void cambiarMenuReagrupacion(){
        textoMenuAtaque.setText("MENU REAGRUPACION");
        textoPaisAtacante.setText("PAIS ORIGEN");
        textoPaisDefensor.setText("PAIS DESTINO");
        textoEjercitosAtaque.setText("EJERCITOS A MOVER");
        BotonDeAtaque.setVisible(false);
        BotonDeMovimiento.setVisible(true);
    }

    private void cambiarMenuAtaque(){
        textoMenuAtaque.setText("MENU DE ATAQUE");
        textoPaisAtacante.setText("PAIS ATACANTE");
        textoPaisDefensor.setText("PAIS DEFENSOR");
        textoEjercitosAtaque.setText("EJERCITOS PARA USAR");
        BotonDeMovimiento.setVisible(false);
        BotonDeAtaque.setVisible(true);
    }
}
