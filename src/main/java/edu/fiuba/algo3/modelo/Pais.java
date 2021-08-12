package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private Ejercito ejercito;
    private Limitrofes limitrofes;

    public Pais(String nombreNuevo) {
        this.nombre = nombreNuevo;
        ejercito = new UnoOMenosEjercito(0);
        limitrofes = new Limitrofes();
    }
    public void agregarLimitrofe(Pais paisLimitrofes){
        paisLimitrofes.mismoNombre(nombre);
        this.limitrofes.agregarLimitrofe(paisLimitrofes);
    }

    public boolean esLimitrofe(Pais otroPais){
        return limitrofes.esAdyacente(otroPais);
    }

    public void agregarEjercito(){
        ejercito = ejercito.agregarEjercito();
    }

    public void atacaA(Pais defensor, int ejercitosAtaque, ArrayList<Integer> valoresDadoAtacante, ArrayList<Integer> dadoDefensor){
        Dado dadoAtacante = new Dado(ejercitosAtaque,valoresDadoAtacante);
        defensor.teAtaca(this,dadoAtacante,dadoDefensor);
    }

    public void teAtaca(Pais atacante,Dado dadoAtacante, ArrayList<Integer> valoresDadoDefensor){
        Dado dadoDefensor = new Dado(ejercito.getCantidadDeEjercitos(),valoresDadoDefensor);
        dadoAtacante.comparar(dadoDefensor,atacante,this);
    }

    public boolean mismoColor(Pais otroPais) {
        return (ejercito.mismoColor(otroPais));
    }

    public boolean mismoColor(ColorJugador colorJugador){
        return (ejercito.mismoColor(colorJugador));
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }

    public int cantidadEjercitos(){
        return ejercito.getCantidadDeEjercitos();
    }

    public boolean mismoNombre(String pais) {
        return nombre.equals(pais);
    }

    public void agregarColor(ColorJugador colorJugador) {
        ejercito.agregarColor(colorJugador);
    }

    public boolean mismoPais(Pais unPais){
        return unPais.mismoNombre(nombre);
    }

    public void moverEjercitoA(Pais paisDestino, int ejercitosAMover){
        for(int i = 0 ; i < ejercitosAMover ; i++){
            ejercito.sacarEjercito();
            paisDestino.agregarEjercito();
        }
    }

    public boolean puedeAtacar(int cantidadEjecitosAUsar) {
        return ejercito.puedeAtacar(cantidadEjecitosAUsar);
    }

    public void ocuparPais(Pais unPais, ColorJugador colorJugador){
        if(unPais.esOcupable()){
            ejercito.sacarEjercito();
            unPais.agregarColor(colorJugador);
            unPais.agregarEjercito();
        }
    }

    public boolean esOcupable(){
        return (ejercito.ejercitoVacio());
    }

    public boolean puedeMoverse(int cantidadEjercitos) {
        return ejercito.puedeMoverse(cantidadEjercitos);
    }

    public int colocarEjercitos(int ejercitosAColocar, ColorJugador colorJugador) {

        if(ejercito.mismoColor(colorJugador)){
            for(int i = 0; i < ejercitosAColocar; i++)
                ejercito = ejercito.agregarEjercito();
            return ejercitosAColocar;
        }
        return 0;
    }

    public boolean activarTarjeta(ColorJugador unColorJugador) {
        return ejercito.activarTarjeta(unColorJugador);
    }

    public String getColor() {
        return ejercito.getColor();
    }
}
