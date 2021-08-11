package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PantallaTablero implements Observer {

    private static Circle colorJugador = new Circle();
    private Label jugador;
    private final Juego modelo;

    private String[] lineaProcesada;
    Stage stage = new Stage();
    private ArrayList<Circle> paises;
    private PanelAtaque panelAtaque;
    private PanelReagrupacion panelReagrupacion;
    private PanelDeColocacion panelDeColocacion;
    private Panel panelEnUso;
    private int iterador = 0;

    public PantallaTablero(Juego modelo) {
        this.modelo = modelo;
    }

    public Stage initialize() {

        //imagenes
        Image mapamundi= new Image((EleccionDeJugadoresControlador.class.getResourceAsStream("/imagenes/juego/MapaTEG.jpg")));
        Image icono = new Image((getClass().getResourceAsStream("/imagenes/iconos/globo.png")));
        ImageView tablero = new ImageView(mapamundi);

        tablero.setFitHeight(584);
        tablero.setFitWidth(898);

        AnchorPane panelPrincipal = new AnchorPane(tablero);
        panelPrincipal.setPrefSize(1200, 700);
        panelPrincipal.setId("panel");

        //botones

        Button siguienteFase = new Button("PASAR TURNO");
        siguienteFase.setLayoutX(643);
        siguienteFase.setLayoutY(588);
        siguienteFase.setPrefHeight(94);
        siguienteFase.setPrefWidth(234);
        siguienteFase.setId("pasaTurno");
        siguienteFase.setOnAction(new BotonPasarTurnoControlador());
        siguienteFase.toBack();

        jugador = new Label("JUGADOR");
        jugador.setLayoutX(350);
        jugador.setLayoutY(588);
        jugador.setPrefHeight(94);
        jugador.setPrefWidth(349);

        colorJugador.setLayoutX(594);
        colorJugador.setLayoutY(635);
        colorJugador.setRadius(25);

        Button botonCartas = new Button("VER CARTAS");
        botonCartas.setLayoutX(7);
        botonCartas.setLayoutY(588);
        botonCartas.setPrefHeight(94);
        botonCartas.setPrefWidth(320);
        botonCartas.setOnAction(new BotonCartasContorlador(this));

        panelDeColocacion = new PanelDeColocacion(modelo);
        modelo.addObserver(panelDeColocacion);

        panelAtaque = new PanelAtaque();
        panelReagrupacion = new PanelReagrupacion();

        panelDeColocacion.setContactos(panelAtaque);
        panelAtaque.setContactos(panelReagrupacion);
        panelReagrupacion.setContactos(panelAtaque);
        panelReagrupacion.setContactos(panelDeColocacion);

        Group vista = new Group(panelPrincipal, siguienteFase, botonCartas, jugador,panelDeColocacion.getPane(),panelAtaque.getPane(),panelReagrupacion.getPane(), colorJugador);
        panelAtaque.ocultar();
        panelReagrupacion.ocultar();
        panelDeColocacion.ocultar();
        //panelEnUso = panelReagrupacion;

        //se añaden los circulos de los paises.
        try {
            Scanner input = new Scanner(new File("src/main/resources/archivos/circulos.txt"));

            paises = new ArrayList<>();
            Text etiqueta;

            while (input.hasNextLine()) {

                String linea = input.nextLine();
                lineaProcesada = linea.split(",");

                //manejo de los paises.
                Circle circulo = new Circle();
                //paises.add(circulo);

                //0-nombre, 1-posx, 2-posy.
                circulo.setId(lineaProcesada[0]);
                circulo.setLayoutX( Integer.parseInt(lineaProcesada[1]));
                circulo.setLayoutY( Integer.parseInt(lineaProcesada[2]));
                circulo.setRadius(14);

                etiqueta = new Text();

                //etiqueta.setPrefHeight(10);
                //etiqueta.setPrefWidth(3);
                etiqueta.setFont(new Font(30));
                etiqueta.setBoundsType(TextBoundsType.VISUAL);
                etiqueta.setLayoutX( Integer.parseInt(lineaProcesada[1]) -8); //10
                etiqueta.setLayoutY( Integer.parseInt(lineaProcesada[2]) +9); //22
                etiqueta.toFront();

                //etiqueta.setVisible(true);


                circulo.setOnMouseClicked(new BotonPaisControlador());

                PaisVista paisVista = new PaisVista(circulo,modelo,etiqueta);
                modelo.addObserver(paisVista);

                vista.getChildren().add(circulo);
                vista.getChildren().add(etiqueta);
            }
            input.close();

        }catch (Exception e){
            System.out.println("no se pudo abrir el archivo: '/resources/archivos/circulos.txt'");
        }

        Scene scene = new Scene(vista);
        String css = (EleccionDeJugadoresControlador.class.getResource("/estilos/paises.css")).toExternalForm();
        scene.getStylesheets().add(css);

        //paro la musica
        PantallaInicio.pararMusica();

        //centro la escena
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

        stage.getIcons().add(icono); //cambia el icono de ejecución
        stage.setScene(scene);
        modelo.addObserver(this);
        return stage;
    }

    public static void mostrarEjercitos(Label etiqueta){
        etiqueta.setVisible(true);
    }

    public static void ocultarEjercitos(Label etiqueta){
        etiqueta.setVisible(false);
    }
    public ArrayList<Circle> getPaises(){
        return paises;
    }

    public void limpiarPaises() {
        panelEnUso.limpiarPaises();
    }

    public void setPaisOrigen(String pais) {
        panelEnUso.setPaisOrigen(pais);
    }

    public void setPaisDestino(String pais) {
        panelEnUso.setPaisDestino(pais);
    }

    public void mostrarColocacion() {
        panelEnUso = panelDeColocacion;
        panelDeColocacion.mostrar();
    }

    public void terminarTurno(boolean sigueRonda) {
        panelEnUso.ocultar();
        panelEnUso = panelEnUso.siguientePanel(sigueRonda);
        panelEnUso.mostrar();
    }

    @Override
    public void update(Observable o, Object arg) {
        jugador.setText(modelo.nombreJugadorEnTurno());
        colorJugador.setFill(Color.web(modelo.colorCodigoJugadorEnTurno()));
    }
}
