package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Inicializador {
    ArrayList<Pais> paises;

    public void inicializar(ArrayList<Pais> paises) throws FileNotFoundException {
        this.paises = paises;
        String[] lineaProcesada;
        String[] limitrofes;
        Pais paisLimitrofeNuevo;
        Pais paisNuevo;

        Scanner input = new Scanner(new File("C:\\Users\\Christian\\Desktop\\algo3\\algo3_tp2\\docs\\Paises.txt"));
        while (input.hasNextLine()) {
            String linea = input.nextLine();

            lineaProcesada = linea.split("=", 0);

            paisNuevo = buscarPais(lineaProcesada[0]);

            crearPais(paisNuevo, lineaProcesada[0]);

            limitrofes = lineaProcesada[1].split(", ", 0);

            for (String limitrofe : limitrofes) {
                paisLimitrofeNuevo = buscarPais(limitrofe);

                crearPais(paisLimitrofeNuevo, limitrofe);

                paisNuevo.agregarLimitrofe(paisLimitrofeNuevo);
            }
            input.close();
        }
    }

    public void crearPais(Pais pais, String nombrePais){
        if (pais == null) {
            pais = new Pais(nombrePais);
            paises.add(pais);
        }
    }

    public Pais buscarPais(String pais){
        for (Pais paisBuscado : paises){
            if (paisBuscado.mismoNombre(pais));
                return paisBuscado;
        }
        return null;
    }

}
