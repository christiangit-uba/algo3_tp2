package edu.fiuba.algo3.modelo;

public class CadenaDeResponsabilidad {
    public static void confirmarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar, ColorJugador colorJugador) throws Exception{
        CantidadDeEjercitos cantidadDeEjercitos = new CantidadDeEjercitos(atacante,cantidadEjercitosAUsar, null);
        Enemigo esEnemigo = new Enemigo(atacante,defensor);
        Limitrofe esLimitrofe = new Limitrofe(atacante,defensor);
        //PaisConquistado paisConquistado = new PaisConquistado(atacante, colorJugador, esLimitrofe);

        cantidadDeEjercitos.siguiente(null);
        esEnemigo.siguiente(cantidadDeEjercitos);
        esLimitrofe.siguiente(esEnemigo);
        //paisConquistado.siguiente(esLimitrofe);

        //paisConquistado.validar();
        esLimitrofe.validar();
    }


    public static void confirmarMovimiento(Pais origen, Pais destino, int cantidadEjercitos, ColorJugador colorJugador) throws Exception {
        EjercitoMovible ejercitoMovible = new EjercitoMovible(origen,cantidadEjercitos);
        Aliado esAliado = new Aliado(origen,destino);
        Limitrofe esLimitrofe = new Limitrofe(origen,destino);
        //PaisConquistado paisOrigenConquistado = new PaisConquistado(origen, colorJugador, esLimitrofe);

        ejercitoMovible.siguiente(null);
        esAliado.siguiente(ejercitoMovible);
        esLimitrofe.siguiente(esAliado);
        //paisOrigenConquistado.siguiente(esLimitrofe);

        //paisOrigenConquistado.validar();
        esLimitrofe.validar();
    }

}
