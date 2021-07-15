package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dados {
    private final int MAXIMO = 6;
    private ArrayList<Integer> dados;

    public Dados(int cantidadDeDados) {
        ArrayList<Integer> dadosNuevos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidadDeDados; i++) {
            dadosNuevos.add(random.nextInt(MAXIMO) + 1 );
        }

        dadosNuevos.sort(Collections.reverseOrder());
        dados = dadosNuevos;
    }

    public void comparar(Dados defensa, Pais paisAtacante, Pais paisDefensor) {
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

    public void setDados(ArrayList<Integer> dados) {
        this.dados = dados;
    }
}
