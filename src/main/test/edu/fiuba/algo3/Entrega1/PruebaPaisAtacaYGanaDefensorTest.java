package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaPaisAtacaYGanaDefensorTest {
    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigoYGana(){
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        Argentina.agregarColor(rojo);
        Brazil.agregarColor(azul);

        Argentina.agregarEjercito();
        Argentina.agregarEjercito();
        Brazil.agregarEjercito();



        ArrayList<Integer> valoresDadoAtacante = new ArrayList<>();
        ArrayList<Integer> valoresDadoDefensor = new ArrayList<>();

        valoresDadoAtacante.add(6);
        valoresDadoDefensor.add(2);

        Dado dadoAtacante = new Dado(1,valoresDadoAtacante);
        Dado dadoDefensor = new Dado(1,valoresDadoDefensor);


        dadoAtacante.comparar(dadoDefensor,Argentina,Brazil);

        Argentina.ocuparPais(Brazil,rojo);

        assertTrue(Argentina.mismoColor(rojo));
        assertTrue(Brazil.mismoColor(rojo));
    }
}
