package edu.fiuba.algo3.modelo;

public class Diplomacia implements Validador{
    Pais paisAtacante;
    Pais paisDefensor;
    CantidadDeEjercitos ejercito;

    Diplomacia(Pais paisAtacante, Pais paisDefensor){
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
        ejercito = new CantidadDeEjercitos(paisAtacante.ejercito(), 2);
    }

    @Override
    public int atacar() throws Exception{
        if(paisAtacante.mismoColor(paisDefensor)){
            throw new Exception();
        }
        else{
            return ejercito.atacar();
        }

    }
}