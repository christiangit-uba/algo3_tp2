package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.ColorJugador;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Pais;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaPaisAtacaAUnPaisLimitrofeYPierdeTest {
    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigoYGana(){
        ColorJugador rojo = new ColorJugador("rojo","rojo");
        ColorJugador azul = new ColorJugador("azul","azul");

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

        valoresDadoAtacante.add(2);
        valoresDadoDefensor.add(6);

        Dado dadoAtacante = new Dado(1,valoresDadoAtacante);
        Dado dadoDefensor = new Dado(1,valoresDadoDefensor);


        dadoAtacante.comparar(dadoDefensor,Argentina,Brazil);

        Argentina.ocuparPais(Brazil,rojo);

        assertTrue(Argentina.mismoColor(rojo));
        assertEquals(Argentina.cantidadEjercitos(),1);

        assertTrue(Brazil.mismoColor(azul));
    }
}
