package Clases;

public class Limitrofe extends Condicion{
    Pais paisAtacante;
    Pais paisDefensor;

    Limitrofe(Pais unPais, Pais otroPais, Condicion siguiente){
        paisAtacante = unPais;
        paisDefensor = otroPais;
        siguienteCondicion = siguiente;
    }

    @Override
    public void ejecutar() throws Exception{
        if(!paisAtacante.esLimitrofe(paisDefensor)){
            throw new Exception();
        }
        else
            siguienteCondicion.ejecutar();
    }
}
