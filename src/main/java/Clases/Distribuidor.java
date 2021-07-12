package Clases;

import java.util.ArrayList;
import java.util.Random;

public class Distribuidor {
    static final int SINPAISES = 0;

    public static void distribuirPaises(ArrayList<Jugador> jugadores, ArrayList<Pais> paises){
        Random random = new Random();
        while(paises.size()>SINPAISES){
            for(Jugador y:jugadores)
                Distribuidor.asignarPais(random,y,paises);
        }
    }
    public static void asignarPais(Random random, Jugador unJugador, ArrayList<Pais> paises){
        if (paises.size()> SINPAISES) {
            int numeroRandom = random.nextInt(paises.size());
            unJugador.asignarPais(paises.get(numeroRandom));
            paises.remove(numeroRandom);
        }
    }
}
