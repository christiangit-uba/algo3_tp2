package edu.fiuba.algo3.modelo;

public class Limitrofe implements Validador{
    String paisAtacante;
    String paisDefensor;
    Tablero tablero;
    Validador siguiente;

    Limitrofe(String unPais, String otroPais, Tablero tablero){
        paisAtacante = unPais;
        paisDefensor = otroPais;
        this.tablero = tablero;
    }

    public void siguiente(Validador siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar() throws Exception{
        if(!this.tablero.limitrofes(paisAtacante,paisDefensor)){
            throw new Exception();
        }
        else{
            return this.siguiente.validar();
        }
    }
}
