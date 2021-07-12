package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tablero {
    ArrayList<Pais> paises;

    Tablero() throws FileNotFoundException {
        this.paises = new ArrayList<>();
        (new Inicializador()).inicializar(this.paises);
    }
}
