package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dado {
    private final int MAXIMO = 6;
    protected ArrayList<Integer> dados;

    public Dado() {
    }

    public Dado(int cantidadDeDados, ArrayList<Integer> dados) {
        if(dados.isEmpty())
            lanzar(cantidadDeDados,dados);
        this.dados = dados;
    }

    public void lanzar(int cantidadDeDados, ArrayList<Integer> dados){
        Random random = new Random();

        for (int i = 0; i < cantidadDeDados; i++) {
            int num = (random.nextInt(MAXIMO) + 1);
            while(dados.contains(num))
                num = (random.nextInt(MAXIMO) + 1);
            dados.add(num);
        }

        dados.sort(Collections.reverseOrder());
    }

    public void comparar(Dado defensa, Pais paisAtacante, Pais paisDefensor) {
        defensa.comparar(dados, paisAtacante, paisDefensor);
    }

    public void comparar(ArrayList<Integer> dadoAtaque, Pais paisAtacante, Pais paisDefensor) {

        int i = 0;
        while (i < (dadoAtaque.size()) && i < (dados.size())) {
            if (dadoAtaque.get(i).intValue() <= dados.get(i).intValue()) {
                paisAtacante.perdioEjercito();
            } else {
                paisDefensor.perdioEjercito();
            }
            i++;
        }
    }
}
