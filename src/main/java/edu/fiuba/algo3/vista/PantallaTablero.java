package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.tableroObservable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

public class PantallaTablero {

    private static Circle colorJugador = new Circle();
    private final Juego modelo;

    private String[] lineaProcesada;
    Stage stage = new Stage();
    private ArrayList<Circle> paises;
    private PanelAtaque panelAtaque;
    private PanelReagrupacion panelReagrupacion;
    private PanelDeColocacion panelDeColocacion;
    private Panel panelEnUso;

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
        Button botonTerminarTurno = new Button("TERMINAR TURNO");
        botonTerminarTurno.setLayoutX(925);
        botonTerminarTurno.setLayoutY(588);  //420
        botonTerminarTurno.setPrefHeight(80); //94
        botonTerminarTurno.setPrefWidth(234);
        botonTerminarTurno.setId("terminaTurno");
        botonTerminarTurno.setOnAction(new BotonFinTurnoContorlador(this));

        Button siguienteFase = new Button("PASAR TURNO");
        siguienteFase.setLayoutX(643);
        siguienteFase.setLayoutY(588);
        siguienteFase.setPrefHeight(94);
        siguienteFase.setPrefWidth(234);
        siguienteFase.setId("pasaTurno");
        siguienteFase.setOnAction(new BotonFinFaseContorlador(this));

        Button botonCartas = new Button("VER CARTAS");
        botonCartas.setLayoutX(7);
        botonCartas.setLayoutY(588);
        botonCartas.setPrefHeight(94);
        botonCartas.setPrefWidth(320);
        botonCartas.setOnAction(new BotonCartasContorlador(this));

        /*Label infoJugador = new Label("JUGADOR");
        infoJugador.setLayoutX(350);
        infoJugador.setLayoutY(588);
        infoJugador.setPrefHeight(94);
        infoJugador.setPrefWidth(349);
        infoJugador.setId("jugador"+color);

        colorJugador.setLayoutX(594);
        colorJugador.setLayoutY(635);
        colorJugador.setRadius(25);*/

        Label ejercitos = new Label("EJERCITOS A COLOCAR");
        ejercitos.setLayoutX(920);
        ejercitos.setLayoutY(310);
        ejercitos.setPrefHeight(42);
        ejercitos.setPrefWidth(274);
        ejercitos.setId("ejercitos");

        TextArea ejercitosAMover = new TextArea();
        ejercitosAMover.setLayoutX(915);
        ejercitosAMover.setLayoutY(350);
        ejercitosAMover.setPrefHeight(56);
        ejercitosAMover.setPrefWidth(259);
        ejercitosAMover.setId("textoEjercitos");

        panelDeColocacion = new PanelDeColocacion(modelo);
        modelo.addObserver(panelDeColocacion);

        panelAtaque = new PanelAtaque();
        panelReagrupacion = new PanelReagrupacion();

        Group vista = new Group(panelPrincipal, siguienteFase, botonCartas,panelDeColocacion.getPane(),panelAtaque.getPane(),panelReagrupacion.getPane(), colorJugador, botonTerminarTurno);
        panelAtaque.mostrar();
        panelReagrupacion.ocultar();
        panelDeColocacion.ocultar();
        panelEnUso = panelAtaque;

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
}
