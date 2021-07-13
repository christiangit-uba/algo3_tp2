package edu.fiuba.algo3.modelo;

public class Enemigo implements Validador{
    Pais paisAtacante;
    Pais paisDefensor;
    Validador siguiente;

    Enemigo(Pais atacante, Pais defensor, Validador siguiente) {
        paisAtacante = atacante;
        paisDefensor = defensor;
        this.siguiente = siguiente;
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