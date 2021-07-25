package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Color color;
    private Canje canjes;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(Color color) {
        tarjetas = new ArrayList<>();
        this.color = color;
        canjes = new Canje();
    }

    public void asignarPais(Pais unPais) {
        unPais.agregarColor(color);
        unPais.agregarEjercito();
    }

    public boolean activarTarjetaPais(Tarjeta unaTarjeta){

        return unaTarjeta.activarTarjeta(color);

    }

    public int cantidadEjercitosAColocar(Tablero tablero) {
        return tablero.cantidadEjercitosAColocar(color);
    }

    public boolean colocarEjercitos(int ejercitosAColocar,int ejercitosTope, Pais unPais){

        if(ejercitosAColocar > ejercitosTope || !unPais.mismoColor(color)) {
            return false;
        }else {
            for (int i = 0; i < ejercitosAColocar; i++) {
                unPais.agregarEjercito();
            }
            return true;
        }
    }

    public boolean realizarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar,ArrayList<Integer> valorDadoAtacante, ArrayList<Integer> valorDadoDefensor) throws Exception {
        CadenaDeResponsabilidad.confirmarAtaque(atacante, defensor, cantidadEjercitosAUsar, color);

        atacante.atacaA(defensor, cantidadEjercitosAUsar, valorDadoAtacante, valorDadoDefensor);
        atacante.ocuparPais(defensor, color);
        return true;
    }

    public void realizarMovimiento(Pais origen, Pais destino, int cantidadEjercitos) throws Exception {

        CadenaDeResponsabilidad.confirmarMovimiento(origen, destino, cantidadEjercitos, color);
        origen.moverEjercitoA(destino, cantidadEjercitos);
    }

    public void agregarTarjeta(Tarjeta unaTarjeta) {

        tarjetas.add(unaTarjeta);
    }

    //Canjes
    public ArrayList<Tarjeta> mostrarTarjetas(){
        /*
        muestra las tarjetas del jugador con javafx.
        cada tarjeta elegida se acumula en un array hasta llegar a 3
        y lo devuelve.
         */

        ArrayList<Tarjeta> aux = new ArrayList<>();
        //elije las primeras 3 tarjetas
        aux.add(tarjetas.get(0));
        aux.add(tarjetas.get(1));
        aux.add(tarjetas.get(2));
        return aux; //solo para pruebas unitarias de turno colocacion.
    }

    //seguro existe en el array.
    public Tarjeta elegirTarjeta(Tarjeta tarjetaJugador){

        int indice = tarjetas.indexOf(tarjetaJugador);
        return tarjetas.get(indice);
    }

    private int canjear(){
           return canjes.cantidadACanjear();
    }

    //recibe un array con Sòlo 3 tarjetas seleccionadas, que posee el jugador.
    public int validarCanjes(ArrayList<Tarjeta> tarjetasJugador,Tarjetero mazo) {

        if(comprobarValidez(tarjetasJugador)){
            for(Tarjeta tarjetaJugador: tarjetasJugador) {
                mazo.vuelveAlTarjetero(tarjetaJugador);
                tarjetas.remove(tarjetaJugador);
            }

            return canjear();
        }
        return 0;
    }

    //siempre recibe un array sólo de 3 tarjetas.
    public boolean comprobarValidez(ArrayList<Tarjeta> tarjetasSelecionadas){

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

}
