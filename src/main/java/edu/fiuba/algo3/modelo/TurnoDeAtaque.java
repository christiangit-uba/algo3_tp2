package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TurnoDeAtaque extends Turno {
    Tarjetero tarjetero;
    protected boolean conquistoUnPaisAlmenos = false;


    public TurnoDeAtaque(Tarjetero tarjetero) {
        this.tarjetero = tarjetero;
    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas, ArrayList<Integer> valoresDadosAtacante, ArrayList<Integer> valoresDadoDefensor) throws Exception {
        if(jugador.realizarAtaque(paisAtacante,paisDefensor,cantidadTropas,valoresDadosAtacante,valoresDadoDefensor)){
            conquistoUnPaisAlmenos = true;
        }
    }

    @Override
    public void terminarTurno() {
        if(conquistoUnPaisAlmenos){
            tarjetero.asignarTarjeta(jugador);
        }
        sigueTurno = false;
    }

    @Override
    public void recibirOrden() {

    }
}
