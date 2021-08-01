package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.PantallaInicio;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class Main extends Application {

    public static void salir() {
        Platform.exit();
        System.exit(0);    //le envía un 0 al S.O.
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage inicio = (new PantallaInicio()).initialize(); //construye la escena inicial
        inicio.show();
    }
}
