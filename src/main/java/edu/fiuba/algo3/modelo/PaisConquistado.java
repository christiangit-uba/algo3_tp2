package edu.fiuba.algo3.modelo;

public class PaisConquistado extends Validador {
    Pais pais;
    Validador siguiente;
    Color color;

    PaisConquistado(Pais unPais, Color color , Validador siguiente){
        pais = unPais;
        this.siguiente = siguiente;
        this.color = color;
    }

    @Override
    public void validar() throws Exception {
        if(!pais.mismoColor(color)){
            throw new Exception();
        }
        if (siguiente != null){
            siguiente.validar();
        }
    }
}
