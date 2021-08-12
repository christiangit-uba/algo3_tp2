package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoConquistarTreintaPaises extends Objetivo {


    public ObjetivoConquistarTreintaPaises(){
        objetivo = "Conquistar 30 paises";
    }

    @Override
    public boolean validarObjetivo(Tablero tablero, ColorJugador colorJugador) {
        int paisesJugador = tablero.cantidadDePaises(colorJugador);
        return (paisesJugador >= 30);
    }
}
