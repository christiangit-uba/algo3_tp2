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

         for(Tarjeta tarjeta : tarjetas){
             if(tarjeta.mismaTarjeta(unaTarjeta)){
                return tarjeta.activarTarjeta(color);
             }
         }
         return false;
    }

    public int cantidadEjercitosAColocar(Tablero tablero) {
        return tablero.cantidadEjercitosAColocar(color);
    }


    public boolean colocarEjercitos(int ejercitosAColocar,int ejercitosTope, Pais unPais){

        if(ejercitosAColocar > ejercitosTope) {
            return false;
        }else {
            for (int i = 0; i < ejercitosAColocar; i++) {
                unPais.agregarEjercito();
            }
            return true;
        }
    }

    public void realizarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar) throws Exception {
        CadenaDeResponsabilidad.confirmarAtaque(atacante, defensor, cantidadEjercitosAUsar, color);

        atacante.atacaA(defensor, cantidadEjercitosAUsar);
        atacante.ocuparPais(defensor, color);
    }

    public void realizarMovimiento(Pais origen, Pais destino, int cantidadEjercitos) throws Exception {

        CadenaDeResponsabilidad.confirmarMovimiento(origen, destino, cantidadEjercitos, color);
        origen.moverEjercitoA(destino, cantidadEjercitos);
    }


    public void agregarTarjeta(Tarjeta unaTarjeta) {

        tarjetas.add(unaTarjeta);
    }

    public int canjear(ArrayList<Tarjeta> tarjetasJugador,Tarjetero mazo){

        if(validarCanjes( tarjetasJugador,mazo))
           return canjes.cantidadACanjear();
        return 0;
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


}
