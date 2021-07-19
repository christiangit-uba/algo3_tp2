package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidarCanje {

    //---------------AGREGADO--o--MODIFICADO------------------//
    private  Map<Simbolo, ArrayList<Tarjeta> > simbolosAuxiliar = new HashMap<>(); //para discriminar por simbolos distintos.
    private CanjesDeTresTarjetas canjes_3 = new CanjesDeTresTarjetas();

    //deberia existir una instancia del mazo?
    public int validar(ArrayList<Tarjeta> tarjetas , Tarjetero mazo, int canjesJugador) {
        int ejercitos = 0;

        for (Tarjeta tarjeta : tarjetas)
            agregarTarjeta(simbolosAuxiliar, tarjeta);

        //tengo todas las tarjetas separadas por simbolos.
        ejercitos += canjearTarjetasIguales(tarjetas, canjesJugador, mazo);
        ejercitos += canjearTarjetasDistintas(tarjetas, canjesJugador, mazo);

        return ejercitos;
    }

    private void agregarTarjeta(Map<Simbolo, ArrayList<Tarjeta> > simbolosAuxiliar, Tarjeta tarjeta) {
        Simbolo simbolo= tarjeta.simbolo();

        if (simbolosAuxiliar.containsKey(simbolo))
            simbolosAuxiliar.get(simbolo).add(tarjeta); //agrego la tarjeta.

        else{
            ArrayList<Tarjeta> tarjetas = new ArrayList<>();
            tarjetas.add(tarjeta);
            simbolosAuxiliar.put(simbolo, tarjetas);
        }
    }

    private int canjearTarjetasIguales(ArrayList<Tarjeta> tarjetasDelJugador, int canjesJugador, Tarjetero mazo){

        //recorro simbolo por simbolo y voy sacando de a tres tarjetas.
        ArrayList<Tarjeta> tarjetasConMismoSimbolo;
        ArrayList<Tarjeta> tarjetasACanjear = new ArrayList<>();
        int ejercitos = 0;

        for(Simbolo clave : simbolosAuxiliar.keySet()){
            tarjetasConMismoSimbolo = simbolosAuxiliar.get(clave);

            //voy canjeando las tarjetas de a grupos de 3.
            while(tarjetasConMismoSimbolo.size() >= 3){

                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(0));
                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(1));
                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(2));

                //ya tengo la lista de las tarjetas a canjear.
                ejercitos += canjes_3.cantidadACanjear(canjesJugador); //canjeo los iguales.

                //borro las tarjetas elegidas.
                borrarTresTarjetas(tarjetasDelJugador, mazo, tarjetasConMismoSimbolo);
            }
        }
        return ejercitos;
    }

    private void borrarTresTarjetas(ArrayList<Tarjeta> tarjetasJugador, Tarjetero mazo, ArrayList<Tarjeta> tarjetasABorrar){

        for (Tarjeta tarjeta : tarjetasABorrar){
            Tarjeta tarjetaCopia = tarjeta.copiar();
            mazo.vuelveAlTarjetero(tarjetaCopia);   //se inicializa y se devuelve al mazo.

            tarjetasABorrar.remove(tarjeta);
            tarjetasJugador.remove(tarjeta);     //se le saca la tarjeta al jugador.
        }
    }

    private int canjearTarjetasDistintas(ArrayList<Tarjeta> tarjetasDelJugador, int canjesJugador, Tarjetero mazo) {
        ArrayList<Tarjeta> tarjetasConDistintoSimbolo;
        ArrayList<Tarjeta> tarjetasACanjear = new ArrayList<>();
        int tarjetasRestantes = contarTarjetasRestantes();
        int ejercitos = 0;

        while(tarjetasRestantes >= 3 && (tarjetasACanjear.size() == 0)){

            for(Simbolo clave : simbolosAuxiliar.keySet()){
                tarjetasConDistintoSimbolo = simbolosAuxiliar.get(clave);

                if(tarjetasConDistintoSimbolo.size() > 0)
                    tarjetasACanjear.add(tarjetasConDistintoSimbolo.get(0)); //saco la primera

                if(tarjetasACanjear.size() == 3){
                    ejercitos += canjes_3.cantidadACanjear(canjesJugador); //canjeo los distintos.

                    //borro las tarjetas elegidas
                    borrarTresTarjetas(tarjetasDelJugador, mazo,tarjetasConDistintoSimbolo);
                }

                tarjetasRestantes = contarTarjetasRestantes();
            }
        }
        return ejercitos;
    }

    private int contarTarjetasRestantes(){
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        int restantes = 0;

        for(Simbolo clave : simbolosAuxiliar.keySet()) {
            tarjetas = simbolosAuxiliar.get(clave);
            restantes += tarjetas.size();
        }
        return restantes;
    }

    //--------------------------------------------------------//
}


