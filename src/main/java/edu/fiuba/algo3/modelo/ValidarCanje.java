package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidarCanje {
    private  Map<Simbolo, Integer> simbolosAuxiliar = new HashMap<>();

    public boolean validar(ArrayList<Tarjeta> tarjetas , Tarjetero mazo ) {

        for (Tarjeta tarjeta : tarjetas)
            tarjeta.comprobarExistencia(simbolosAuxiliar);

       return borradoDeTarjetas(tarjetas,mazo);
    }

    private boolean borradoDeTarjetas(ArrayList<Tarjeta> tarjetas, Tarjetero mazo) {

        if (simbolosAuxiliar.size() == 3) {
            borrarTresTarjetasDistintas(tarjetas,mazo);
            return true;
        }
        return borrarTresTarjetasIguales(tarjetas,mazo,consultarTresIguales());
    }


    private boolean borrarTresTarjetasIguales(ArrayList<Tarjeta> tarjetas, Tarjetero mazo,Simbolo simbolo) {
        int iterador = 0;
        int cantidadBorrada = 0;
        Tarjeta tarjeta;


        if(simbolo != null){
              while(cantidadBorrada < 3){
                  tarjeta = tarjetas.get(iterador);
                  if(mismoSimbolo(tarjeta,simbolo,mazo,tarjetas))
                      cantidadBorrada++;
                  else
                      iterador++;
              }
             return true;
        }
          return false;
    }

    private boolean mismoSimbolo(Tarjeta tarjeta, Simbolo simbolo, Tarjetero mazo, ArrayList<Tarjeta> tarjetas) {

        if(tarjeta.mismoSimbolo(simbolo)) {
            mazo.vuelveAlTarjetero(tarjeta);
            tarjetas.remove(tarjeta);
           return true;
        }
          return false;
    }

    private Simbolo consultarTresIguales() {
        for(Simbolo simbolo : simbolosAuxiliar.keySet()) {
            if (simbolosAuxiliar.get(simbolo) == 3)
                return simbolo;
        }
        return null;
    }

    private void borrarTresTarjetasDistintas(ArrayList<Tarjeta> tarjetas, Tarjetero mazo) {

        for(Simbolo simbolo : simbolosAuxiliar.keySet()){
            for (Tarjeta tarjeta : tarjetas) {
                if (mismoSimbolo(tarjeta,simbolo,mazo,tarjetas))
                    break;
            }
        }
    }

}


