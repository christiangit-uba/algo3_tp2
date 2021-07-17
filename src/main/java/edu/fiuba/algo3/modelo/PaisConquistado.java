package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PaisConquistado extends Validador{
    Pais pais;
    Color color;

    PaisConquistado(Pais unPais, Color color ){
        pais = unPais;
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
