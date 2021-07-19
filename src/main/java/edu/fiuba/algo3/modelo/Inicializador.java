package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Inicializador {
    ArrayList<Pais> paises;
    ArrayList<Continente> continentes;
    Tarjetero tarjetero;

    Inicializador(ArrayList<Pais> paises, ArrayList<Continente> continentes, Tarjetero tarjetero) throws FileNotFoundException{
        this.paises = paises;
        this.continentes = continentes;
        this.tarjetero = tarjetero;
        inicializarPaisesYContinentes();
        inicializarTarjetas();
    }

    private void inicializarTarjetas() throws FileNotFoundException {
        String[] lineaProcesada;
        String nombrePais;
        String simbolo;
        Pais pais;
        ArrayList<Simbolo> simbolosCreados = new ArrayList<>();
        Simbolo simboloBuscado;

        Scanner input = new Scanner(new File("docs/Teg - Cartas.csv"));
        while (input.hasNextLine()) {
            String linea = input.nextLine();

            lineaProcesada = linea.split(",");

            nombrePais = lineaProcesada[0];

            simbolo = lineaProcesada[1];

            pais = buscarPais(nombrePais);

            simboloBuscado = buscarSimbolo(simbolo, simbolosCreados);

            tarjetero.agregarTarjeta(new Tarjeta(pais, simboloBuscado));
        }
        input.close();
    }

    private Simbolo buscarSimbolo(String simbolo, ArrayList<Simbolo> simbolosCreados) {
        for (Simbolo simboloBuscado : simbolosCreados){
            if (simboloBuscado.mismoSimbolo(simbolo))
                return simboloBuscado;
        }
        return new Simbolo(simbolo);
    }

    public void inicializarPaisesYContinentes() throws FileNotFoundException {
        String[] lineaProcesada;
        String[] limitrofes;
        Pais paisLimitrofeNuevo;
        Pais paisNuevo;
        String[] continente;
        String continenteNombre;
        String continentePuntaje;
        Continente continenteNuevo;

        Scanner input = new Scanner(new File("docs/Teg - Fronteras.csv"));
        while (input.hasNextLine()) {
            String linea = input.nextLine();
            lineaProcesada = linea.split(";");
            continente = lineaProcesada[1].split(",");
            continenteNombre = continente[0];
            continentePuntaje = continente[1];
            limitrofes = lineaProcesada[2].split(",");

            paisNuevo = buscarPais(lineaProcesada[0]);

            paisNuevo = crearPais(paisNuevo, lineaProcesada[0]);

            continenteNuevo = buscarContinente(continenteNombre);

            continenteNuevo = crearContinente(continenteNuevo,continenteNombre,Integer.parseInt(continentePuntaje));

            continenteNuevo.agregarPais(paisNuevo);


            for (String limitrofe : limitrofes) {

                paisLimitrofeNuevo = buscarPais(limitrofe);

                paisLimitrofeNuevo = crearPais(paisLimitrofeNuevo, limitrofe);

                paisNuevo.agregarLimitrofe(paisLimitrofeNuevo);
            }
        }
        input.close();
    }

    public Pais buscarPais(String pais){
        for (Pais paisBuscado : this.paises){
            if (paisBuscado.mismoNombre(pais)) {
                return paisBuscado;
            }
        }
        return null;
    }

    public Pais crearPais(Pais pais, String nombrePais){
        if (pais == null) {
            pais = new Pais(nombrePais);
            paises.add(pais);
        }
        return pais;
    }

    private Continente buscarContinente(String continenteNombre) {
        for (Continente continenteBuscado : this.continentes){
            if (continenteBuscado.mismoNombre(continenteNombre)) {
                return continenteBuscado;
            }
        }
        return null;
    }

    private Continente crearContinente(Continente continenteNuevo,String nombre, int valor) {
        if (continenteNuevo == null) {
            continenteNuevo = new Continente(nombre, valor);
            continentes.add(continenteNuevo);
            return continenteNuevo;
        }
        return continenteNuevo;
    }

}
