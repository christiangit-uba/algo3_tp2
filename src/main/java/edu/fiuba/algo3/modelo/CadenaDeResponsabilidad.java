package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CadenaDeResponsabilidad {
    public static void confirmarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar, Color color) throws Exception{
        CantidadDeEjercitos cantidadDeEjercitos = new CantidadDeEjercitos(atacante,cantidadEjercitosAUsar,null);
        Enemigo esEnemigo = new Enemigo(atacante,defensor,cantidadDeEjercitos);
        Limitrofe esLimitrofe = new Limitrofe(atacante,defensor,esEnemigo);
        PaisConquistado paisConquistado = new PaisConquistado(atacante,color,esLimitrofe);

        paisConquistado.validar();
    }


    public static void confirmarMovimiento(Pais origen, Pais destino, int cantidadEjercitos, Color color) throws Exception {
        EjercitoMovible ejercitoMovible = new EjercitoMovible(origen,cantidadEjercitos,null);
        Aliado esAliado = new Aliado(origen,destino,ejercitoMovible);
        Limitrofe esLimitrofe = new Limitrofe(origen,destino,esAliado);
        PaisConquistado paisOrigenConquistado = new PaisConquistado(origen,color,esLimitrofe);

        paisOrigenConquistado.validar();
    }
}
