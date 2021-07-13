package edu.fiuba.algo3.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
    ArrayList<Pais> mapamundi;
    ArrayList<Pais> copiaMapamundi;

    public Tablero(){
        mapamundi = new ArrayList<Pais>();
        copiaMapamundi = new ArrayList<Pais>();

        String separadorPais = "=";
        String separadorLimitrofes = ",";

        try{
            String rutaAbsoluta = new File("src/main/java/edu/fiuba/algo3/archivos/mapamundiTEG.txt").getAbsolutePath();
            File archivo = new File(rutaAbsoluta);
            Scanner lector = new Scanner(archivo);

            while(lector.hasNextLine()){
                String leido = lector.nextLine();

                String[] linea = leido.split(separadorPais);
                Pais unPais = new Pais(linea[0]);

                String[] limitrofes = linea[1].split(separadorLimitrofes);

                for (String paises : limitrofes) {
                    Pais aux = new Pais(paises);
                    unPais.agregarLimitrofe(aux);
                }

                mapamundi.add(unPais);
                copiaMapamundi.add(unPais);
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo del mapamundi no existe…");
        }
    }

    public Boolean elPaisEstaCargado(Pais unPais)
    {
        for(Pais pais: mapamundi){
            if (pais.esElMismoPais(unPais))
                return true;
        }
        return false;
    }

    private int elegirIndiceAleatorio(int tope){
        return (int) (Math.random() * tope);
    }

    public Pais darUnPais()
    {
        int tope = copiaMapamundi.size();
        int indice = elegirIndiceAleatorio(tope);

        Pais paisAleatorio = copiaMapamundi.get(indice);
        copiaMapamundi.remove(indice);

        return paisAleatorio;
    }

    //Solo se usan para pruebas.
    public int size(){
        return mapamundi.size();
    }
    public int sizeCopia() {return copiaMapamundi.size();}
}
