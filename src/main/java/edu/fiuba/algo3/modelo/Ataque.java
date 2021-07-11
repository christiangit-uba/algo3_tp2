package edu.fiuba.algo3.modelo;

public class Ataque {
    public void atacar(String paisAtacante, String paisDefensor, Tablero tablero, int cantidadDeEjercitosAUsar) throws Exception {
        Limitrofe limitrofe = new Limitrofe(paisAtacante, paisDefensor, tablero);
        DiplomaciaEnemiga diplomacia = new DiplomaciaEnemiga(paisAtacante,paisDefensor, tablero, cantidadDeEjercitosAUsar);
        limitrofe.siguiente(diplomacia);
        diplomacia.siguiente(tablero.ejercitoDePais(paisAtacante));
        limitrofe.validar();
    }
}
