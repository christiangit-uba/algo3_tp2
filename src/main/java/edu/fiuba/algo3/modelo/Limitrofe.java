package edu.fiuba.algo3.modelo;

public class Limitrofe implements Validador{
    String paisAtacante;
    String paisDefensor;
    Grafo grafo;
    Validador siguiente;

    Limitrofe(String unPais, String otroPais, Grafo grafo){
        paisAtacante = unPais;
        paisDefensor = otroPais;
        this.grafo = grafo;
    }

    public void siguiente(Validador siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar() throws Exception{
        if(!this.grafo.limitrofes(paisAtacante,paisDefensor)){
            throw new Exception();
        }
        else{
            return this.siguiente.validar();
        }
    }
}
