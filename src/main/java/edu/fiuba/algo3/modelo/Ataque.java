/*package edu.fiuba.algo3.modelo;

public class Ataque {
    public void atacar(String paisAtacante, String paisDefensor, Grafo grafo, int cantidadDeEjercitosAUsar) throws Exception {

        Limitrofe limitrofe = new Limitrofe(paisAtacante, paisDefensor, grafo);
        DiplomaciaEnemiga diplomacia = new DiplomaciaEnemiga(paisAtacante,paisDefensor, grafo, cantidadDeEjercitosAUsar);
        CantidadDeEjercitos ejercito = new CantidadDeEjercitos(paisAtacante, cantidadDeEjercitosAUsar);
        limitrofe.siguiente(diplomacia);
        diplomacia.siguiente(grafo.ejercitoDePais(paisAtacante));
        limitrofe.validar();
    }
}*/
