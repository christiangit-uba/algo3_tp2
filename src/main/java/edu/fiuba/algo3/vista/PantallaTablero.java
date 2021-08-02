package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.EleccionDeJugadoresControlador;
import edu.fiuba.algo3.controlador.PantallaDeJuegoControlador;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;


public class PantallaTablero {

    private static Circle colorJugador = new Circle();

    private String[] lineaProcesada;
    Stage stage = new Stage();

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
        Button botonAtaque = new Button("ATACAR");
        botonAtaque.setLayoutX(915);
        botonAtaque.setLayoutY(50); //491
        botonAtaque.setPrefHeight(94);
        botonAtaque.setPrefWidth(259);

        Button botonMover = new Button("MOVER");
        botonMover.setLayoutX(915);
        botonMover.setLayoutY(180); //380
        botonMover.setPrefHeight(94);
        botonMover.setPrefWidth(259);

        Button botonTerminarTurno = new Button("TERMINAR TURNO");
        botonTerminarTurno.setLayoutX(925);
        botonTerminarTurno.setLayoutY(460);  //420
        botonTerminarTurno.setPrefHeight(80); //94
        botonTerminarTurno.setPrefWidth(234);
        botonTerminarTurno.setId("terminaTurno");

        Button siguienteFase = new Button("PASAR TURNO");
        siguienteFase.setLayoutX(643);
        siguienteFase.setLayoutY(588);
        siguienteFase.setPrefHeight(94);
        siguienteFase.setPrefWidth(234);
        siguienteFase.setId("pasaTurno");

        Button botonCartas = new Button("VER CARTAS");
        botonCartas.setLayoutX(7);
        botonCartas.setLayoutY(588);
        botonCartas.setPrefHeight(94);
        botonCartas.setPrefWidth(320);

        Label infoJugador = new Label("JUGADOR");
        infoJugador.setLayoutX(350);
        infoJugador.setLayoutY(588);
        infoJugador.setPrefHeight(94);
        infoJugador.setPrefWidth(349);
        infoJugador.setId("jugador");

        PantallaDeJuegoControlador.actualizarColorDelJugador("077bb", colorJugador);
        colorJugador.setLayoutX(594);
        colorJugador.setLayoutY(635);
        colorJugador.setRadius(25);

        Label ejercitos = new Label("EJERCITOS A MOVER");
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

        Group vista = new Group(panelPrincipal, botonAtaque, siguienteFase, botonCartas,
                infoJugador, colorJugador, botonTerminarTurno, botonMover, ejercitosAMover, ejercitos);

        //se añaden los circulos de los paises.
        try {
            Scanner input = new Scanner(new File("src/main/resources/archivos/circulos.txt"));

            while (input.hasNextLine()) {

                String linea = input.nextLine();
                lineaProcesada = linea.split(",");

                //etiquetado
                Label etiqueta = new Label();
                etiqueta.setText("1");
                etiqueta.setPrefHeight(10);
                etiqueta.setPrefWidth(3);

                etiqueta.setLayoutX( Integer.parseInt(lineaProcesada[1]) -10 ); //10
                etiqueta.setLayoutY( Integer.parseInt(lineaProcesada[2]) -22 ); //22
                etiqueta.setId("etiqueta" + lineaProcesada[0]); //etiquetaPais
                etiqueta.toFront();
                etiqueta.setVisible(false);

                Circle circulo = new Circle();
                PantallaDeJuegoControlador.actualizarColorDelJugador("077bb", circulo);

                //0-nombre, 1-posx, 2-posy.
                circulo.setId(lineaProcesada[0]);
                circulo.setLayoutX( Integer.parseInt(lineaProcesada[1]) );
                circulo.setLayoutY( Integer.parseInt(lineaProcesada[2]) );
                circulo.setRadius(14);
                circulo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        PantallaDeJuegoControlador.guardarPais(circulo.getId(), etiqueta);
                        mostrarEjercitos(etiqueta);
                    }
                });

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
}
