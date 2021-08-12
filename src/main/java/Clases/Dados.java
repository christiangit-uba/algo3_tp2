package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dados {
    static final int DADOMAXIMO = 6;
    private final int rondas;
    private final int maxDadosAtaque;
    private final int maxDadosDefensa;
    private final ArrayList<Integer> dadosAtacante;
    private final ArrayList<Integer> dadosDefensor;


    public Dados(ArrayList<Integer> dadosAtacante, ArrayList<Integer> dadosDefensor, int maxDadosAtaque, int maxDadosDefensa) {
        this.dadosAtacante = dadosAtacante;
        this.dadosDefensor = dadosDefensor;
        this.maxDadosAtaque = maxDadosAtaque;
        this.maxDadosDefensa = maxDadosDefensa;
        rondas = Math.min(maxDadosAtaque,maxDadosDefensa);
    }

    public void lanzarDados(){
        Random random = new Random();
        int i = 1;
        while(i <= Math.max(maxDadosAtaque,maxDadosDefensa)){
            if(maxDadosAtaque >= i)
                dadosAtacante.add(random.nextInt(DADOMAXIMO) + 1);
            if(maxDadosDefensa >= i)
                dadosDefensor.add(random.nextInt(DADOMAXIMO) + 1);
            i++;
        }
    }

    private void ordenarDados(){
        dadosAtacante.sort(Collections.reverseOrder());
        dadosDefensor.sort(Collections.reverseOrder());
    }

    public void combatir(Pais paisAtacante, Pais paisDefensor) {
        this.ordenarDados();

        for(int i = 0; i < rondas; i++){
            if(dadosAtacante.get(i) <= dadosDefensor.get(i))
                paisAtacante.sacarEjercito();
            else
                paisDefensor.sacarEjercito();
        }
        paisAtacante.ocupar(paisDefensor);
    }

}


