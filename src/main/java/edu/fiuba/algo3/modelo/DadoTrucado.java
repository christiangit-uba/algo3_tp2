package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class DadoTrucado extends Dado{
    public DadoTrucado() {
        super();
    }

    public void setValores(ArrayList<Integer> valores){
        dados = valores;
    }
}
