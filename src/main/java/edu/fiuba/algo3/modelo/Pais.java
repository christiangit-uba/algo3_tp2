package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private Ejercito ejercito;

    public Pais(String nombreNuevo) {
        this.nombre = nombreNuevo;
        }

    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public Validador ejercito() {
        return ejercito;
    }

    String nombre() {
        return this.nombre;
    }

    public void atacaA(Pais pais2) throws Exception {
        Limitrofe limitrofe = new Limitrofe(this, pais2);
        limitrofe.validar();
        while ((this.cantidadDeEjercitos() != 0) && (pais2.cantidadDeEjercitos() != 0)) {
            Dados dados1 = new Dados(this.cantidadDeDados());
            Dados dados2 = new Dados(pais2.cantidadDeDados());

            ArrayList comparacion = Dados.comparar(dados1,dados2,this,pais2);
        }
    }

    private int cantidadDeDados(){
        return ejercito.cantidadDeDados();
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }
}
