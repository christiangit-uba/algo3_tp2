package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidarCanje {

    private Map<Simbolo, ArrayList<Tarjeta> > simbolosAuxiliar = new HashMap<>();
    private CanjesDeTresTarjetas canjes_3 = new CanjesDeTresTarjetas();
    private ArrayList<Simbolo> simbolosJugador = new ArrayList<>();
    private Tarjetero mazo;

    public ValidarCanje(Tarjetero unMazo){
        this.mazo = unMazo;
    }

    //recibe las tarjetas activadas del jugador.
    public int validar(ArrayList<Tarjeta> tarjetas, ProximoCanje canjesJugador) {
        int ejercitos = 0;

        //cargo los distintos simbolos de las tarjetas del jugador en una lista.
        for (Tarjeta tarjeta : tarjetas)
            if ( !simbolosJugador.contains(tarjeta.simbolo()) )
                simbolosJugador.add(tarjeta.simbolo());

        for (Simbolo simbolo : simbolosJugador){
            ArrayList<Tarjeta> tarjetasMismoSimbolo = new ArrayList<>();

            for (Tarjeta tarjetaJugador : tarjetas)
                if (tarjetaJugador.mismoSimbolo(simbolo))
                    tarjetasMismoSimbolo.add(tarjetaJugador);

            simbolosAuxiliar.put(simbolo, tarjetasMismoSimbolo); //agrego las tarjetas por simbolo.
        }

        ejercitos += canjearTarjetasIguales(tarjetas, canjesJugador);
        ejercitos += canjearTarjetasDistintas(tarjetas, canjesJugador);

        return ejercitos;
    }

    private int canjearTarjetasIguales(ArrayList<Tarjeta> tarjetasDelJugador, ProximoCanje canjesJugador){

        int ejercitos = 0;

        for(Simbolo simbolo : simbolosAuxiliar.keySet()){
            ArrayList<Tarjeta> tarjetasConMismoSimbolo = new ArrayList<>();
            ArrayList<Tarjeta> tarjetasACanjear = new ArrayList<>();
            ArrayList<Simbolo> simboloCanjeado = new ArrayList<>();

            tarjetasConMismoSimbolo.addAll(simbolosAuxiliar.get(simbolo));
            simboloCanjeado.add(simbolo);

            while(tarjetasConMismoSimbolo.size() >= 3){

                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(0));
                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(1));
                tarjetasACanjear.add(tarjetasConMismoSimbolo.get(2));

                ejercitos += canjes_3.cantidadACanjear(canjesJugador);

                borrarTarjetasDiccionario(simboloCanjeado, tarjetasACanjear);
                tarjetasConMismoSimbolo.removeAll(tarjetasACanjear);

                //borro las tarjetas elegidas.
                borrarTresTarjetas(tarjetasDelJugador, tarjetasACanjear);
            }
        }
        return ejercitos;
    }

    private int canjearTarjetasDistintas(ArrayList<Tarjeta> tarjetasDelJugador, ProximoCanje canjesJugador) {
        ArrayList<Tarjeta> tarjetasConDistintoSimbolo;
        ArrayList<Tarjeta> tarjetasACanjear = new ArrayList<>();
        ArrayList<Simbolo> simbolosCanjeados = new ArrayList<>();

        int tarjetasRestantes = contarTarjetasRestantes();
        int ejercitos = 0;

        while(tarjetasRestantes >= 3 && (tarjetasACanjear.size() == 0)){

            for(Simbolo simbolo : simbolosAuxiliar.keySet()){
                simbolosCanjeados.add(simbolo);
                tarjetasConDistintoSimbolo = (simbolosAuxiliar.get(simbolo));

                if(tarjetasConDistintoSimbolo.size() > 0)
                    tarjetasACanjear.add(tarjetasConDistintoSimbolo.get(0)); //saco la primera

                if(tarjetasACanjear.size() == 3){
                    ejercitos += canjes_3.cantidadACanjear(canjesJugador); //canjeo los distintos.

                    //borro las tarjetas del diccionario...
                    borrarTarjetasDiccionario(simbolosCanjeados, tarjetasACanjear);

                    //borro las tarjetas elegidas
                    borrarTresTarjetas(tarjetasDelJugador, tarjetasACanjear);
                }
            }
            tarjetasRestantes = contarTarjetasRestantes();
        }
        return ejercitos;
    }

    private void borrarTarjetasDiccionario(ArrayList<Simbolo> simbolos, ArrayList<Tarjeta> tarjetasABorrar){
        ArrayList<Tarjeta> aux;

        for(Simbolo simbolo : simbolos) {
            aux = simbolosAuxiliar.get(simbolo);
            aux.removeAll(tarjetasABorrar);
        }
    }

    private void borrarTresTarjetas(ArrayList<Tarjeta> tarjetasJugador, ArrayList<Tarjeta> tarjetasABorrar){
        ArrayList<Tarjeta> copia = new ArrayList<>();
        copia.addAll(tarjetasABorrar);

        for (Tarjeta tarjeta : copia){
            mazo.vuelveAlTarjetero(tarjeta);   //se inicializa y se devuelve al mazo.
            tarjetasABorrar.remove(tarjeta);
            tarjetasJugador.remove(tarjeta);   //se le saca la tarjeta al jugador.
        }
    }

    private int contarTarjetasRestantes(){
        ArrayList<Tarjeta> tarjetas;
        int restantes = 0;

        for(Simbolo simbolo : simbolosAuxiliar.keySet()) {
            tarjetas = simbolosAuxiliar.get(simbolo);
            restantes += tarjetas.size();
        }
        return restantes;
    }
}


