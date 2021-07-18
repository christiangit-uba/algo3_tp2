package edu.fiuba.algo3.modelo;

public class CadenaDeResponsabilidad {
    public static void confirmarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar, Color color) throws Exception{
        CantidadDeEjercitos cantidadDeEjercitos = new CantidadDeEjercitos(atacante,cantidadEjercitosAUsar, null);
        Enemigo esEnemigo = new Enemigo(atacante,defensor);
        Limitrofe esLimitrofe = new Limitrofe(atacante,defensor);
        PaisConquistado paisConquistado = new PaisConquistado(atacante,color, esLimitrofe);

        cantidadDeEjercitos.siguiente(null);
        esEnemigo.siguiente(cantidadDeEjercitos);
        esLimitrofe.siguiente(esEnemigo);
        paisConquistado.siguiente(esLimitrofe);

        paisConquistado.validar();
    }


    public static void confirmarMovimiento(Pais origen, Pais destino, int cantidadEjercitos, Color color) throws Exception {
        EjercitoMovible ejercitoMovible = new EjercitoMovible(origen,cantidadEjercitos,null);
        Aliado esAliado = new Aliado(origen,destino);
        Limitrofe esLimitrofe = new Limitrofe(origen,destino);
        PaisConquistado paisOrigenConquistado = new PaisConquistado(origen,color, esLimitrofe);

        ejercitoMovible.siguiente(null);
        esAliado.siguiente(ejercitoMovible);
        esLimitrofe.siguiente(esAliado);
        paisOrigenConquistado.siguiente(esLimitrofe);

        paisOrigenConquistado.validar();
    }

}
