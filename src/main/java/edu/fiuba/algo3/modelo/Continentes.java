package edu.fiuba.algo3.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Continentes {
    private Hashtable<String, ArrayList<Pais>> continentes;

    public Continentes(){
        continentes = new Hashtable<String, ArrayList<Pais>>();

        String separadorContinentes = "=";
        String separadorPaises = ",";
        String nombreContinente;

        try{
            String rutaAbsoluta = new File("src/main/java/edu/fiuba/algo3/archivos/continentesTEG.txt").getAbsolutePath();
            File archivo = new File(rutaAbsoluta);
            Scanner lector = new Scanner(archivo);
            ArrayList<Pais> lista;

            while(lector.hasNextLine()){
                lista = new ArrayList<Pais>();
                String leido = lector.nextLine();

                String[] linea = leido.split(separadorContinentes);
                nombreContinente = linea[0];

                String[] paises = linea[1].split(separadorPaises);

                for (String pais : paises) {
                    Pais aux = new Pais(pais);
                    lista.add(aux);
                }

                continentes.put(nombreContinente, lista);
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo de los continentes no existe…");
        }
    }

    public Boolean paisCargado(String clave, Pais unPais)
    {
        for(Pais pais: continentes.get(clave)){
            if (pais.esElMismoPais(unPais))
                return true;
        }
        return false;
    }

    //Solamente usado por las pruebas
    public ArrayList<Pais> obtener (String clave){
        return continentes.get(clave);
    }
}
