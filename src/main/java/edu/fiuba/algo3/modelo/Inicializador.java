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

        String rutaMapamundi = "docs/mapamundiTEG.txt";
        try{
            Scanner input = new Scanner(new File(rutaMapamundi));   //Prueba relativa OK.

            while (input.hasNextLine()) {
                String linea = input.nextLine();

                lineaProcesada = linea.split(" = ", 0);

                paisNuevo = buscarPais(lineaProcesada[0]);

                paisNuevo = crearPais(paisNuevo, lineaProcesada[0]);

                limitrofes = lineaProcesada[1].split(", ", 0);

                for (String limitrofe : limitrofes) {

                    paisLimitrofeNuevo = buscarPais(limitrofe); //busca la instancia creada

                    paisLimitrofeNuevo = crearPais(paisLimitrofeNuevo, limitrofe); //sobrescribe...

                    paisNuevo.agregarLimitrofe(paisLimitrofeNuevo);
                }
            }
            input.close();
        }catch( FileNotFoundException e) {
            System.out.println("NO se encontro el archivo del mapamundi...");
        }
    }

    private void inicializarContinentes() throws FileNotFoundException {
        String rutaContienentes = "docs/Continentes.txt";

        try {
            String rutaAbsoluta = rutaContienentes;

            File archivo = new File(rutaAbsoluta);
            Scanner lector = new Scanner(archivo);
            String nombreContinente;
            String[] linea;
            String[] paises;
            String leido;
            String puntajes;
            Continente continente;
            Pais paisBuscado;

            while (lector.hasNextLine()) {
                leido = lector.nextLine();

                linea = leido.split(";", 0);
                nombreContinente = linea[0];

                puntajes = linea[1];

                continente = new Continente(nombreContinente, Integer.parseInt(puntajes));
                paises = linea[2].split(", ", 0);

                for (String pais : paises) {
                    paisBuscado = buscarPais(pais);
                    continente.agregarPais(paisBuscado);
                } //cuando se agrega a la lista???
            }
        }catch (FileNotFoundException e){
            System.out.println("NO se encontro el archivo de continentes...");
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
