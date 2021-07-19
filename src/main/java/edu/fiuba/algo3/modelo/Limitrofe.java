package edu.fiuba.algo3.modelo;

public class Limitrofe extends Validador{
    Pais paisAtacante;
    Pais paisDefensor;


    Limitrofe(Pais unPais, Pais otroPais){
        paisAtacante = unPais;
        paisDefensor = otroPais;
    }

    @Override
    public void validar() throws Exception{
       validar(!paisAtacante.esLimitrofe(paisDefensor));
    }
}
