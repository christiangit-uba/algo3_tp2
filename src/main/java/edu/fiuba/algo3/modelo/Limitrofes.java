package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Limitrofes {
    ArrayList<Pais> paisesLimitrofes = new ArrayList<>();

    public boolean esAdyacente(Pais unPais) {
        for (Pais buscado : paisesLimitrofes){
            if (unPais.nombre().equals(buscado.nombre())){
                return true;
            }
        }
        return false;
    }

    public void agregarLimitrofe(Pais paisLimitrofeNuevo) {
        paisesLimitrofes.add(paisLimitrofeNuevo);
    }
}
