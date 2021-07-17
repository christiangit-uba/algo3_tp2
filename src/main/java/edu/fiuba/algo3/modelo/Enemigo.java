package edu.fiuba.algo3.modelo;

public class Enemigo extends Validador{
    Pais paisAtacante;
    Pais paisDefensor;


    Enemigo(Pais atacante, Pais defensor) {
        paisAtacante = atacante;
        paisDefensor = defensor;
    }

    @Override
    public void validar() throws Exception {
        if(paisAtacante.mismoColor(paisDefensor)) {
            throw new Exception();
        }
        if (siguiente != null){
            siguiente.validar();
        }
    }
}