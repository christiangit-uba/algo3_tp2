public class Limitrofe implements Validador{
    Pais paisAtacante;
    Pais paisDefensor;
    Diplomacia diplomacia;

    Limitrofe(Pais unPais, Pais otroPais){
        paisAtacante = unPais;
        paisDefensor = otroPais;
        diplomacia = new Diplomacia(unPais,otroPais);
    }

    @Override
    public int atacar() throws Exception{
        if(!paisAtacante.esLimitrofe(paisDefensor)){
            throw new Exception();
        }
        else{
            return diplomacia.atacar();
        }


    }
}
