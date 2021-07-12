package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Limitrofes {
    ArrayList<Pais> paisesLimitrofes = new ArrayList<>();

    public boolean esAdyacente(Pais unPais) {
        return (paisesLimitrofes.contains(unPais));
    }

    public void agregarLimitrofe(Pais paisLimitrofeNuevo) {
        paisesLimitrofes.add(paisLimitrofeNuevo);
    }
}
