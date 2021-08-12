package edu.fiuba.algo3.modelo;

public class PaisConquistado extends Validador {
    Pais pais;
    Validador siguiente;
    ColorJugador colorJugador;

    PaisConquistado(Pais unPais, ColorJugador colorJugador, Validador siguiente){
        pais = unPais;
        this.siguiente = siguiente;
        this.colorJugador = colorJugador;
    }

    @Override
    public void validar() throws Exception {
        validar(!pais.mismoColor(colorJugador),"Error el pais de origen no pertenece al jugador en turno");
    }
}
