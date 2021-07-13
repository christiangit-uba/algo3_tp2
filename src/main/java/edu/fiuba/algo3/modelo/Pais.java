package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.colores.*;
import java.util.ArrayList;

public class Pais {
    private String nombre;
    private ArrayList<Pais> limitrofes;
    private Ejercito ejercito;
    private Colores color;
    private Pais aux;

    public Pais(String nombreNuevo){
        this.nombre = nombreNuevo;
        this.color = new ColorBlanco();
        this.ejercito = new CeroEjercitos();
        this.limitrofes = new ArrayList<Pais>();
    }

    //Limitrofes
    public void agregarLimitrofe(Pais paisLimitrofe){
        limitrofes.add(paisLimitrofe);
    }

    public void agregarLimitrofes(ArrayList <Pais> paisesLimitrofes){
        int tope = paisesLimitrofes.size();
        for (int i = 0; i < tope; i++) {
            this.agregarLimitrofe(paisesLimitrofes.get(i));
        }
    }

    public boolean esLimitrofe(Pais otroPais){
        return (this.limitrofes).contains(otroPais);
    }

    private String nombre(){
        return this.nombre;
    }

    public boolean esElMismoPais(Pais otroPais){
        return (nombre.equals(otroPais.nombre()));
    }


    //Colores
    public boolean mismoColor(Pais otroPais) {
        return (this.color).esElMismoColor(otroPais.color());
    }

    public Colores color() {
        return (this.color);
    }

    public void cambiarColor(Colores otroColor){
        this.color = otroColor;
    }


    //Ejercitos
    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public Ejercito ejercito() {
        return ejercito;
    }

    public void atacaA(Pais pais2) throws Exception {
        Limitrofe limitrofe = new Limitrofe(this, pais2);
        limitrofe.atacar();
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
