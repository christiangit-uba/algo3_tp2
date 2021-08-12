package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Limitrofes {
    ArrayList<Pais> paisesLimitrofes = new ArrayList<>();

    public boolean esAdyacente(Pais unPais) {
        return paisesLimitrofes.contains(unPais);
    }

    public void agregarLimitrofe(Pais paisLimitrofeNuevo) {
        paisesLimitrofes.add(paisLimitrofeNuevo);
    }

    public Ejercito darEjercitos(Ejercito ejercito) {
        for (Pais pais : paisesLimitrofes){

            if (!ejercito.ejercitoVacio() & ejercito.mismoColor(pais)){
                pais.agregarEjercito();
                ejercito = ejercito.sacarEjercito();
            }
        }
        return ejercito;
    }
}
