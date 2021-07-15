package edu.fiuba.algo3.modelo;

public class Limitrofe implements Validador{
    Pais paisAtacante;
    Pais paisDefensor;
    Validador siguiente;

    Limitrofe(Pais unPais, Pais otroPais, Validador siguiente){
        paisAtacante = unPais;
        paisDefensor = otroPais;
        this.siguiente = siguiente;
    }

    @Override
    public void validar() throws Exception{
        if(!paisAtacante.esLimitrofe(paisDefensor)){
            throw new Exception();
        }
        if (siguiente != null){
            siguiente.validar();
        }
    }
}
