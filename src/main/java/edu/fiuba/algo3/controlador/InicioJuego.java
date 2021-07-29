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
    ObservableList<String> cantidadEjercitosColocacion = FXCollections.observableArrayList();

    private String paisAtacante;
    private String paisDefensor;
    private String paisDestino;
    private String paisOrigen;
    private int ejercitosAtaque;
    private int ejercitosReagrucacion;
    private boolean circulosVisibles = true;



    public void initialize(int cantidad) throws Exception {
        asignarCirculosYEjercitos();
        juego = new Juego(cantidad);
        juego.tablero().asignarPaises(juego.jugadores());
        cambiarMenuAtaque();
    }


    public void actualizarFichas(){
        for (Map.Entry<String, Circle> entry : listaCirculosPaises.entrySet()){
            Pais pais = juego.tablero().obtenerPais(entry.getKey());
            entry.getValue().setFill(Color.web(pais.color().codigo()));
            Label ejercitos = ejercitosPaises.get(entry.getKey());
            ejercitos.setText(Integer.toString(pais.cantidadEjercitos()));
        }
    }

    private void asignarPaisesSeleccion(ComboBox<String> seleccionPaises){
        ArrayList<String> paisesJugador;
        Jugador jugadorEnTurno = juego.jugadorEnTurno();
        paisesJugador = juego.tablero().paisesDelJugador(jugadorEnTurno.obtenerColor());
        paises.setAll(paisesJugador);
        seleccionPaises.setItems(paises);
    }

    private void asignarEjercitosSeleccion(ComboBox<String> seleccionEjercitos,String unPais){
        ArrayList<String> cantidades = new ArrayList<>();
        Pais pais = juego.tablero().obtenerPais(unPais);
        for(int i = 1; i <= pais.ejercitosAtaque(); i++){
            cantidades.add(Integer.toString(i));
        }
        cantidadEjercitosAtaque.setAll(cantidades);
        seleccionEjercitos.setItems(cantidadEjercitosAtaque);
    }

    private ArrayList<String> obtenerLimitrofesEnemigos(ArrayList<String> limitrofes){
        ArrayList<String> limitrofesEnemigos = new ArrayList<>();
        for(String limitrofe: limitrofes){
            if(!juego.tablero().obtenerPais(limitrofe).mismoColor(juego.jugadorEnTurno().obtenerColor()))
                limitrofesEnemigos.add(limitrofe);
        }
        return limitrofesEnemigos;
    }

    private ArrayList<String> obtenerLimitrofesAliados(ArrayList<String> limitrofes){
        ArrayList<String> limitrofesAliados = new ArrayList<>();
        for(String limitrofe: limitrofes){
            if(juego.tablero().obtenerPais(limitrofe).mismoColor(juego.jugadorEnTurno().obtenerColor()))
                limitrofesAliados.add(limitrofe);
        }
        return limitrofesAliados;
    }

    @FXML
    void elegirAtacante(ActionEvent event) {
        ArrayList<String> nombresLimitrofes;
        String paisAtaque = SeleccionPaisAtacante.getSelectionModel().getSelectedItem();
        if(juego.tablero().obtenerPais(paisAtaque) != null) {
            nombresLimitrofes = obtenerLimitrofesEnemigos(juego.tablero().obtenerPais(paisAtaque).obtenerLimitrofes());
            paisesLimitrofes.setAll(nombresLimitrofes);
            SeleccionPaisDefensor.setItems(paisesLimitrofes);
            paisAtacante = paisAtaque;
            asignarEjercitosSeleccion(SeleccionEjercitosAtaque,paisAtaque);
        }
    }

    @FXML
    void elegirDefensor(ActionEvent event) {
        paisDefensor = SeleccionPaisDefensor.getSelectionModel().getSelectedItem();
    }

    @FXML
    void elegirOrigen(ActionEvent event){
        ArrayList<String> nombresLimitrofes;
        String paisDeOrigen = SeleccionPaisOrigen.getSelectionModel().getSelectedItem();
        if(juego.tablero().obtenerPais(paisDeOrigen) != null){
            nombresLimitrofes = obtenerLimitrofesAliados(juego.tablero().obtenerPais(paisDeOrigen).obtenerLimitrofes());
            paisesLimitrofes.setAll(nombresLimitrofes);
            SeleccionPaisDestino.setItems(paisesLimitrofes);
            paisOrigen = paisDeOrigen;
            asignarEjercitosSeleccion(SeleccionEjercitosReagrupar,paisDeOrigen);
        }
    }

    @FXML
    void elegirDestino(ActionEvent event){
        paisDestino = SeleccionPaisDestino.getSelectionModel().getSelectedItem();
    }

    @FXML
    void elegirCantidadEjercitos(ActionEvent event) {
        if(!SeleccionEjercitosAtaque.getSelectionModel().getSelectedItem().equals(""))
            ejercitosAtaque = Integer.parseInt(SeleccionEjercitosAtaque.getSelectionModel().getSelectedItem());
    }
    @FXML
    void elegirCantidadEjercitosReagrupar(ActionEvent event) {
        if(!SeleccionEjercitosReagrupar.getSelectionModel().getSelectedItem().equals(""))
            ejercitosReagrucacion = Integer.parseInt(SeleccionEjercitosReagrupar.getSelectionModel().getSelectedItem());
    }

    @FXML
    void realizarAtaque(ActionEvent event) throws Exception {

        if(!opcionVacia(SeleccionPaisAtacante, errorOpcionAtaque) && !opcionVacia(SeleccionPaisDefensor, errorOpcionDefensa) && !opcionVacia(SeleccionEjercitosAtaque, errorOpcionEjercitos)) {
            ArrayList<Integer> dadosAtaque = new ArrayList<>();
            ArrayList<Integer> dadosDefensa = new ArrayList<>();
            juego.atacar(paisAtacante, paisDefensor, ejercitosAtaque, dadosAtaque, dadosDefensa);
            actualizarFichas();
            asignarPaisesSeleccion(SeleccionPaisAtacante);
            SeleccionPaisAtacante.getSelectionModel().select("");
            SeleccionPaisDefensor.getSelectionModel().select("");
        }
    }

    @FXML
    void realizarMovimiento(ActionEvent event) throws Exception {
        if(!opcionVacia(SeleccionPaisOrigen, errorOpcionAtaque) && !opcionVacia(SeleccionPaisDestino, errorOpcionDefensa) && !opcionVacia(SeleccionEjercitosReagrupar, errorOpcionEjercitos)) {
            juego.mover(paisOrigen, paisDestino, ejercitosReagrucacion);
            actualizarFichas();
            SeleccionPaisOrigen.getSelectionModel().select("");
            SeleccionPaisDestino.getSelectionModel().select("");
        }
    }

    @FXML
    void realizarColocacion(ActionEvent event) throws Exception{
        if(!opcionVacia(SeleccionPaisDestino,errorOpcionDefensa) && juego.obtenerTopeJugador() != 0){
            juego.colocarEjercito(paisDestino,1);
            actualizarFichas();
            String tope = Integer.toString(juego.obtenerTopeJugador());
            textoCantidadEjercitos.setText(tope);
        }

    }

    private boolean opcionVacia(ComboBox<String> opcion, Label label){
        if(opcion.getSelectionModel().getSelectedItem().equals("")) {
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
    void pasarATurnoReagrupacion(ActionEvent event) {
        cambiarMenuReagrupacion();
    }

    @FXML
    void pasarATurnoColocacion(ActionEvent event) {
        cambiarMenuColocacion();
    }
    @FXML
    void terminarTurno(ActionEvent event){
        juego.siguienteJugador();
        cambiarMenuAtaque();
    }

    private void resetearSelecciones(){
        SeleccionPaisAtacante.getSelectionModel().select("");
        SeleccionPaisDefensor.getSelectionModel().select("");
        SeleccionPaisOrigen.getSelectionModel().select("");
        SeleccionPaisDestino.getSelectionModel().select("");
        SeleccionEjercitosAtaque.getSelectionModel().select("");
        SeleccionEjercitosReagrupar.getSelectionModel().select("");
    }

    private void cambiarMenuColocacion(){
        botonPasarATurnoColocacion.setVisible(false);
        botonPasarATurnoReagrupacion.setVisible(false);
        botonTerminarTurno.setVisible(true);
        SeleccionEjercitosReagrupar.setVisible(false);
        SeleccionPaisOrigen.setVisible(false);

        BotonDeAtaque.setVisible(false);
        BotonDeMovimiento.setVisible(false);
        BotonDeColocacion.setVisible(true);

        textoPaisDefensor.setVisible(true);
        textoPaisAtacante.setVisible(false);
        textoCantidadEjercitos.setVisible(true);
        errorOpcionAtaque.setVisible(false);
        textoMenuAtaque.setText("MENU COLOCACION");
        textoPaisDefensor.setText("PAIS DESTINO");
        textoEjercitosAtaque.setText("EJERCITOS A COLOCAR");

        resetearSelecciones();
        asignarPaisesSeleccion(SeleccionPaisDestino);
        juego.calcularTopeJugador();
        String tope = Integer.toString(juego.obtenerTopeJugador());
        textoCantidadEjercitos.setText(tope);
    }

    private void cambiarMenuReagrupacion(){
        botonPasarATurnoColocacion.setVisible(true);
        botonPasarATurnoReagrupacion.setVisible(false);
        SeleccionPaisDestino.setVisible(true);
        SeleccionPaisDefensor.setVisible(false);
        SeleccionPaisAtacante.setVisible(false);
        SeleccionPaisOrigen.setVisible(true);
        SeleccionEjercitosAtaque.setVisible(false);
        SeleccionEjercitosReagrupar.setVisible(true);

        BotonDeAtaque.setVisible(false);
        BotonDeMovimiento.setVisible(true);
        BotonDeColocacion.setVisible(false);


        textoMenuAtaque.setText("MENU REAGRUPACION");
        textoPaisAtacante.setText("PAIS ORIGEN");
        textoPaisDefensor.setText("PAIS DESTINO");
        textoEjercitosAtaque.setText("EJERCITOS A MOVER");

        resetearSelecciones();

        asignarPaisesSeleccion(SeleccionPaisOrigen);

    }

    private void cambiarMenuAtaque(){
        botonTerminarTurno.setVisible(false);
        botonPasarATurnoColocacion.setVisible(false);
        botonPasarATurnoReagrupacion.setVisible(true);

        textoPaisDefensor.setVisible(true);
        textoPaisAtacante.setVisible(true);
        SeleccionPaisAtacante.setVisible(true);
        SeleccionPaisDefensor.setVisible(true);
        SeleccionEjercitosAtaque.setVisible(true);
        SeleccionEjercitosReagrupar.setVisible(false);
        SeleccionPaisDestino.setVisible(false);
        SeleccionPaisOrigen.setVisible(false);

        BotonDeColocacion.setVisible(false);
        BotonDeMovimiento.setVisible(false);
        BotonDeAtaque.setVisible(true);

        textoMenuAtaque.setText("MENU DE ATAQUE");
        textoPaisAtacante.setText("PAIS ATACANTE");
        textoPaisDefensor.setText("PAIS DEFENSOR");
        textoEjercitosAtaque.setText("EJERCITOS PARA USAR");
        textoCantidadEjercitos.setVisible(false);
        errorOpcionAtaque.setVisible(true);

        SeleccionPaisAtacante.getSelectionModel().select("");
        SeleccionPaisDefensor.getSelectionModel().select("");
        SeleccionPaisOrigen.getSelectionModel().select("");
        SeleccionPaisDestino.getSelectionModel().select("");
        SeleccionEjercitosAtaque.getSelectionModel().select("");
        SeleccionEjercitosReagrupar.getSelectionModel().select("");

        CirculoColorJugador.setFill(Color.web(juego.jugadorEnTurno().obtenerColor().codigo()));
        asignarPaisesSeleccion(SeleccionPaisAtacante);
        actualizarFichas();
    }







    @FXML
    private ComboBox<String> SeleccionPaisAtacante;
    @FXML
    private ComboBox<String> SeleccionPaisDefensor;
    @FXML
    private ComboBox<String> SeleccionPaisDestino;
    @FXML
    private ComboBox<String> SeleccionEjercitosAtaque;
    @FXML
    private ComboBox<String> SeleccionEjercitosReagrupar;
    @FXML
    private ComboBox<String> SeleccionPaisOrigen;
    @FXML
    private Label errorOpcionAtaque;
    @FXML
    private Label errorOpcionDefensa;
    @FXML
    private Label errorOpcionEjercitos;
    @FXML
    private Button BotonVerMapa;
    @FXML
    private Button botonPasarATurnoReagrupacion;
    @FXML
    private Button botonPasarATurnoColocacion;
    @FXML
    private Button botonTerminarTurno;
    @FXML
    private Label textoMenuAtaque;
    @FXML
    private Label textoPaisAtacante;
    @FXML
    private Label textoPaisDefensor;
    @FXML
    private Label textoEjercitosAtaque;
    @FXML
    private Label textoCantidadEjercitos;
    @FXML
    private Button BotonDeAtaque;
    @FXML
    private Button BotonDeMovimiento;
    @FXML
    private Button BotonDeColocacion;
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
    private Circle CirculoMexico;
    @FXML
    private Circle CirculoCalifornia;
    @FXML
    private Circle CirculoNuevaYork;
    @FXML
    private Circle CirculoTerranova;
    @FXML
    private Circle CirculoLabrador;
    @FXML
    private Circle CirculoOregon;
    @FXML
    private Circle CirculoAlaska;
    @FXML
    private Circle CirculoYukon;
    @FXML
    private Circle CirculoCanada;
    @FXML
    private Circle CirculoGroenlandia;
    @FXML
    private Circle CirculoIslandia;
    @FXML
    private Circle CirculoEspana;
    @FXML
    private Circle CirculoGranBretana;
    @FXML
    private Circle CirculoSuecia;
    @FXML
    private Circle CirculoRusia;
    @FXML
    private Circle CirculoPolonia;
    @FXML
    private Circle CirculoAlemania;
    @FXML
    private Circle CirculoFrancia;
    @FXML
    private Circle CirculoSahara;
    @FXML
    private Circle CirculoEtiopia;
    @FXML
    private Circle CirculoZaire;
    @FXML
    private Circle CirculoEgipto;
    @FXML
    private Circle CirculoSudafrica;
    @FXML
    private Circle CirculoMadagascar;
    @FXML
    private Circle CirculoArabia;
    @FXML
    private Circle CirculoItalia;
    @FXML
    private Circle CirculoIsrael;
    @FXML
    private Circle CirculoTurquia;
    @FXML
    private Circle CirculoIran;
    @FXML
    private Circle CirculoAral;
    @FXML
    private Circle CirculoTartaria;
    @FXML
    private Circle CirculoTaymir;
    @FXML
    private Circle CirculoSiberia;
    @FXML
    private Circle CirculoKamtchatka;
    @FXML
    private Circle CirculoGobi;
    @FXML
    private Circle CirculoMongolia;
    @FXML
    private Circle CirculoChina;
    @FXML
    private Circle CirculoIndia;
    @FXML
    private Circle CirculoMalasia;
    @FXML
    private Circle CirculoJapon;
    @FXML
    private Circle CirculoSumatra;
    @FXML
    private Circle CirculoBorneo;
    @FXML
    private Circle CirculoJava;
    @FXML
    private Circle CirculoAustralia;
    @FXML
    private Label CantidadEjercitosMexico;
    @FXML
    private Label CantidadEjercitosCalifornia;
    @FXML
    private Label CantidadEjercitosOregon;
    @FXML
    private Label CantidadEjercitosAlaska;
    @FXML
    private Label CantidadEjercitosYukon;
    @FXML
    private Label CantidadEjercitosCanada;
    @FXML
    private Label CantidadEjercitosNuevaYork;
    @FXML
    private Label CantidadEjercitosTerranova;
    @FXML
    private Label CantidadEjercitosLabrador;
    @FXML
    private Label CantidadEjercitosGroenlandia;
    @FXML
    private Label CantidadEjercitosIslandia;
    @FXML
    private Label CantidadEjercitosGranBretana;
    @FXML
    private Label CantidadEjercitosEspana;
    @FXML
    private Label CantidadEjercitosFrancia;
    @FXML
    private Label CantidadEjercitosItalia;
    @FXML
    private Label CantidadEjercitosSahara;
    @FXML
    private Label CantidadEjercitosSuecia;
    @FXML
    private Label CantidadEjercitosRusia;
    @FXML
    private Label CantidadEjercitosAlemania;
    @FXML
    private Label CantidadEjercitosPolonia;
    @FXML
    private Label CantidadEjercitosZaire;
    @FXML
    private Label CantidadEjercitosEtiopia;
    @FXML
    private Label CantidadEjercitosEgipto;
    @FXML
    private Label CantidadEjercitosSudafrica;
    @FXML
    private Label CantidadEjercitosMadagascar;
    @FXML
    private Label CantidadEjercitosAustralia;
    @FXML
    private Label CantidadEjercitosSumatra;
    @FXML
    private Label CantidadEjercitosArabia;
    @FXML
    private Label CantidadEjercitosIsrael;
    @FXML
    private Label CantidadEjercitosTurquia;
    @FXML
    private Label CantidadEjercitosChina;
    @FXML
    private Label CantidadEjercitosMalasia;
    @FXML
    private Label CantidadEjercitosGobi;
    @FXML
    private Label CantidadEjercitosIran;
    @FXML
    private Label CantidadEjercitosMongolia;
    @FXML
    private Label CantidadEjercitosSiberia;
    @FXML
    private Label CantidadEjercitosJapon;
    @FXML
    private Label CantidadEjercitosAral;
    @FXML
    private Label CantidadEjercitosTaymir;
    @FXML
    private Label CantidadEjercitosTartaria;
    @FXML
    private Label CantidadEjercitosKamtchatka;
    @FXML
    private Label CantidadEjercitosIndia;
    @FXML
    private Label CantidadEjercitosBorneo;
    @FXML
    private Label CantidadEjercitosJava;


    private void asignarCirculosYEjercitos(){
        //Agrego al diccionario fichas
        listaCirculosPaises.put("Argentina",CirculoArgentina);
        listaCirculosPaises.put("Brazil",CirculoBrasil);
        listaCirculosPaises.put("Chile",CirculoChile);
        listaCirculosPaises.put("Peru",CirculoPeru);
        listaCirculosPaises.put("Colombia",CirculoColombia);
        listaCirculosPaises.put("Uruguay",CirculoUruguay);

        listaCirculosPaises.put("Mexico",CirculoMexico);
        listaCirculosPaises.put("California",CirculoCalifornia);
        listaCirculosPaises.put("Oregon",CirculoOregon);
        listaCirculosPaises.put("Alaska",CirculoAlaska);
        listaCirculosPaises.put("Yukon",CirculoYukon);
        listaCirculosPaises.put("Nueva York",CirculoNuevaYork);
        listaCirculosPaises.put("Canada",CirculoCanada);
        listaCirculosPaises.put("Terranova",CirculoTerranova);
        listaCirculosPaises.put("Labrador",CirculoLabrador);
        listaCirculosPaises.put("Groenlandia",CirculoGroenlandia);

        listaCirculosPaises.put("Islandia",CirculoIslandia);
        listaCirculosPaises.put("Gran Bretaña", CirculoGranBretana);
        listaCirculosPaises.put("España", CirculoEspana);
        listaCirculosPaises.put("Italia", CirculoItalia);
        listaCirculosPaises.put("Francia",CirculoFrancia);
        listaCirculosPaises.put("Alemania",CirculoAlemania);
        listaCirculosPaises.put("Polonia",CirculoPolonia);
        listaCirculosPaises.put("Rusia",CirculoRusia);
        listaCirculosPaises.put("Suecia",CirculoSuecia);

        listaCirculosPaises.put("Sahara",CirculoSahara);
        listaCirculosPaises.put("Zaire",CirculoZaire);
        listaCirculosPaises.put("Sudafrica",CirculoSudafrica);
        listaCirculosPaises.put("Etiopia",CirculoEtiopia);
        listaCirculosPaises.put("Egipto",CirculoEgipto);
        listaCirculosPaises.put("Madagascar",CirculoMadagascar);

        listaCirculosPaises.put("Sumatra",CirculoSumatra);
        listaCirculosPaises.put("Australia",CirculoAustralia);
        listaCirculosPaises.put("Borneo",CirculoBorneo);
        listaCirculosPaises.put("Java",CirculoJava);

        listaCirculosPaises.put("Arabia",CirculoArabia);
        listaCirculosPaises.put("Israel",CirculoIsrael);
        listaCirculosPaises.put("Turquia",CirculoTurquia);
        listaCirculosPaises.put("Iran",CirculoIran);
        listaCirculosPaises.put("Aral",CirculoAral);
        listaCirculosPaises.put("Tartaria",CirculoTartaria);
        listaCirculosPaises.put("Taymir",CirculoTaymir);
        listaCirculosPaises.put("Siberia",CirculoSiberia);
        listaCirculosPaises.put("Mongolia",CirculoMongolia);
        listaCirculosPaises.put("Gobi",CirculoGobi);
        listaCirculosPaises.put("India",CirculoIndia);
        listaCirculosPaises.put("Malasia",CirculoMalasia);
        listaCirculosPaises.put("China",CirculoChina);
        listaCirculosPaises.put("Japon",CirculoJapon);
        listaCirculosPaises.put("Kamtchatka",CirculoKamtchatka);

        //Agrego al diccionario indicador de cantidad de ejercitos
        ejercitosPaises.put("Argentina",CantidadEjercitosArgentina);
        ejercitosPaises.put("Brazil",CantidadEjercitosBrasil);
        ejercitosPaises.put("Chile",CantidadEjercitosChile);
        ejercitosPaises.put("Peru",CantidadEjercitosPeru);
        ejercitosPaises.put("Colombia",CantidadEjercitosColombia);
        ejercitosPaises.put("Uruguay",CantidadEjercitosUruguay);

        ejercitosPaises.put("Mexico",CantidadEjercitosMexico);
        ejercitosPaises.put("California",CantidadEjercitosCalifornia);
        ejercitosPaises.put("Oregon",CantidadEjercitosOregon);
        ejercitosPaises.put("Alaska",CantidadEjercitosAlaska);
        ejercitosPaises.put("Yukon",CantidadEjercitosYukon);
        ejercitosPaises.put("Nueva York",CantidadEjercitosNuevaYork);
        ejercitosPaises.put("Canada",CantidadEjercitosCanada);
        ejercitosPaises.put("Terranova",CantidadEjercitosTerranova);
        ejercitosPaises.put("Labrador",CantidadEjercitosLabrador);
        ejercitosPaises.put("Groenlandia",CantidadEjercitosGroenlandia);

        ejercitosPaises.put("Islandia",CantidadEjercitosIslandia);
        ejercitosPaises.put("Gran Bretaña", CantidadEjercitosGranBretana);
        ejercitosPaises.put("España", CantidadEjercitosEspana);
        ejercitosPaises.put("Italia", CantidadEjercitosItalia);
        ejercitosPaises.put("Francia",CantidadEjercitosFrancia);
        ejercitosPaises.put("Alemania", CantidadEjercitosAlemania);
        ejercitosPaises.put("Polonia", CantidadEjercitosPolonia);
        ejercitosPaises.put("Rusia", CantidadEjercitosRusia);
        ejercitosPaises.put("Suecia", CantidadEjercitosSuecia);

        ejercitosPaises.put("Sahara",CantidadEjercitosSahara);
        ejercitosPaises.put("Zaire",CantidadEjercitosZaire);
        ejercitosPaises.put("Sudafrica",CantidadEjercitosSudafrica);
        ejercitosPaises.put("Etiopia",CantidadEjercitosEtiopia);
        ejercitosPaises.put("Egipto",CantidadEjercitosEgipto);
        ejercitosPaises.put("Madagascar",CantidadEjercitosMadagascar);

        ejercitosPaises.put("Sumatra",CantidadEjercitosSumatra);
        ejercitosPaises.put("Australia",CantidadEjercitosAustralia);
        ejercitosPaises.put("Borneo",CantidadEjercitosBorneo);
        ejercitosPaises.put("Java",CantidadEjercitosJava);

        ejercitosPaises.put("Arabia",CantidadEjercitosArabia);
        ejercitosPaises.put("Israel",CantidadEjercitosIsrael);
        ejercitosPaises.put("Turquia",CantidadEjercitosTurquia);
        ejercitosPaises.put("Iran",CantidadEjercitosIran);
        ejercitosPaises.put("Aral",CantidadEjercitosAral);
        ejercitosPaises.put("Tartaria",CantidadEjercitosTartaria);
        ejercitosPaises.put("Taymir",CantidadEjercitosTaymir);
        ejercitosPaises.put("Siberia",CantidadEjercitosSiberia);
        ejercitosPaises.put("Mongolia",CantidadEjercitosMongolia);
        ejercitosPaises.put("Gobi",CantidadEjercitosGobi);
        ejercitosPaises.put("India",CantidadEjercitosIndia);
        ejercitosPaises.put("Malasia",CantidadEjercitosMalasia);
        ejercitosPaises.put("China",CantidadEjercitosChina);
        ejercitosPaises.put("Japon",CantidadEjercitosJapon);
        ejercitosPaises.put("Kamtchatka",CantidadEjercitosKamtchatka);

    }

}
