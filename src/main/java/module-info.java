module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    exports edu.fiuba.algo3;
    opens edu.fiuba.algo3;
    exports edu.fiuba.algo3.controlador;
    opens edu.fiuba.algo3.controlador;
}