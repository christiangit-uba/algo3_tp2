package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final ColorJugador colorJugador;
    private final String nombre;
    private Canje canjes;
    private ArrayList<Tarjeta> tarjetas;
    private int tope;

    public Jugador(String nombre, ColorJugador colorJugador) {
        this.nombre = nombre;
        tarjetas = new ArrayList<>();
        this.colorJugador = colorJugador;
        canjes = new Canje();
    }

    public void asignarPais(Pais unPais) {
        unPais.agregarColor(colorJugador);
        unPais.agregarEjercito();
    }

    public boolean activarTarjetaPais(Tarjeta unaTarjeta){

        return unaTarjeta.activarTarjeta(colorJugador);

    }

    public int cantidadEjercitosAColocar(Tablero tablero) {
        return tablero.cantidadEjercitosAColocar(colorJugador);
    }


    public boolean colocarEjercitos(int ejercitosAColocar, Pais unPais){

        if(ejercitosAColocar > tope || !unPais.mismoColor(colorJugador)) {
            return false;
        }else {
            for (int i = 0; i < ejercitosAColocar; i++) {
                unPais.agregarEjercito();
            }
            tope = tope - ejercitosAColocar;
            return true;
        }
    }

    public boolean realizarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar,ArrayList<Integer> valorDadoAtacante, ArrayList<Integer> valorDadoDefensor) throws Exception {
        CadenaDeResponsabilidad.confirmarAtaque(atacante, defensor, cantidadEjercitosAUsar, colorJugador);

        atacante.atacaA(defensor, cantidadEjercitosAUsar, valorDadoAtacante, valorDadoDefensor);
        atacante.ocuparPais(defensor, colorJugador);
        return true;
    }

    public boolean realizarMovimiento(Pais origen, Pais destino, int cantidadEjercitos) throws Exception {

        CadenaDeResponsabilidad.confirmarMovimiento(origen, destino, cantidadEjercitos, colorJugador);
        origen.moverEjercitoA(destino, cantidadEjercitos);
        return true;
    }


    public void agregarTarjeta(Tarjeta unaTarjeta) {

        tarjetas.add(unaTarjeta);
    }

    public void canjear(){
           tope = tope + canjes.cantidadACanjear();
    }


    public boolean validarCanjes(ArrayList<Tarjeta> tarjetasJugador,Tarjetero mazo) {

        if(comprobarValides(tarjetasJugador)){
            for(Tarjeta tarjetaJugador: tarjetasJugador) {
                mazo.vuelveAlTarjetero(tarjetaJugador);
                tarjetas.remove(tarjetaJugador);
            }
            canjes.sumarCanje();
            return true;
        }
        else
            return false;
    }

    public boolean comprobarValides(ArrayList<Tarjeta> tarjetasSelecionadas){

        Tarjeta tarjetaUno = tarjetasSelecionadas.get(0);
        Tarjeta tarjetaDos = tarjetasSelecionadas.get(1);
        Tarjeta tarjetaTres = tarjetasSelecionadas.get(2);

        return(distintosSimbolos(tarjetaUno,tarjetaDos,tarjetaTres) || mismoSimbolo(tarjetaUno,tarjetaDos,tarjetaTres) );
    }

    private boolean mismoSimbolo(Tarjeta tarjetaUno, Tarjeta tarjetaDos, Tarjeta tarjetaTres) {
        return(tarjetaUno.mismoSimbolo(tarjetaDos) && tarjetaUno.mismoSimbolo(tarjetaTres));
    }

    private boolean distintosSimbolos(Tarjeta tarjetaUno,Tarjeta tarjetaDos,Tarjeta tarjetaTres){
       return((!tarjetaUno.mismoSimbolo(tarjetaDos)) && (!tarjetaUno.mismoSimbolo(tarjetaTres)) && (!tarjetaDos.mismoSimbolo(tarjetaTres)));
    }

    public int cantidadTarjetas(){
        return tarjetas.size();
    }

    public String color() {
        return colorJugador.nombre();
    }

    public String colorCodigo() {
        return colorJugador.codigo();
    }

    public int getTope() {
        return tope;
    }

    public void reiniciarTope(Tablero tablero) {
        tope = cantidadEjercitosAColocar(tablero);
    }

    public String nombre() {
        return nombre;
    }
}
