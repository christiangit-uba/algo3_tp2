package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Inicializador {
    ArrayList<Pais> paises;
    ArrayList<Continente> continentes;

    Inicializador(ArrayList<Pais> paises, ArrayList<Continente> continentes) throws FileNotFoundException{
        this.paises = paises;
        this.continentes = continentes;
        inicializarPaises();
        inicializarContinentes();
    }

    public void inicializarPaises() throws FileNotFoundException {
        String[] lineaProcesada;
        String[] limitrofes;
        Pais paisLimitrofeNuevo;
        Pais paisNuevo;

        Scanner input = new Scanner(new File("C:\\Users\\Christian\\Desktop\\algo3\\algo3_tp2\\docs\\mapamundiTEG.txt"));
        while (input.hasNextLine()) {
            String linea = input.nextLine();

            lineaProcesada = linea.split(" = ", 0);

            paisNuevo = buscarPais(lineaProcesada[0]);

            paisNuevo = crearPais(paisNuevo, lineaProcesada[0]);

            limitrofes = lineaProcesada[1].split(", ", 0);

            for (String limitrofe : limitrofes) {

                paisLimitrofeNuevo = buscarPais(limitrofe);

                paisLimitrofeNuevo = crearPais(paisLimitrofeNuevo, limitrofe);

                paisNuevo.agregarLimitrofe(paisLimitrofeNuevo);
            }
        }
        input.close();
    }

    private void inicializarContinentes() throws FileNotFoundException {
        String rutaAbsoluta = new File("C:\\Users\\Christian\\Desktop\\algo3\\algo3_tp2\\docs\\Continentes.txt").getAbsolutePath();
        File archivo = new File(rutaAbsoluta);
        Scanner lector = new Scanner(archivo);
        String nombreContinente;
        String[] linea;
        String[] paises;
        String leido;
        String puntajes;
        Continente continente;
        Pais paisBuscado;

        while(lector.hasNextLine()){
            leido = lector.nextLine();

            linea = leido.split(";", 0);
            nombreContinente = linea[0];

            puntajes = linea[1];

            continente = new Continente(nombreContinente, Integer.parseInt(puntajes));

            paises = linea[3].split(", ",0);

            for (String pais : paises) {
                paisBuscado = buscarPais(pais);
                continente.agregarPais(paisBuscado);
            }
        }
    }

    public Pais crearPais(Pais pais, String nombrePais){
        if (pais == null) {
            pais = new Pais(nombrePais);
            this.paises.add(pais);
        }
        return pais;
    }

    public Pais buscarPais(String pais){
        for (Pais paisBuscado : this.paises){
            if (paisBuscado.mismoNombre(pais)) {
                return paisBuscado;
            }
        }
        return null;
    }

}
