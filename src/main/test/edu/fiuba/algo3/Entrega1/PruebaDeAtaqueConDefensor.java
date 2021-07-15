package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.Color;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaDeAtaqueConDefensor {
    @Test
    public void unPaisAtacaAunPaisLimitrofeEnemigo() throws Exception {
        Color rojo = new Color("rojo");
        Color azul = new Color("azul");
        Jugador jugador1 = new Jugador(rojo);
        Jugador jugador2 = new Jugador(azul);

        Pais Argentina = new Pais("Argentina");
        Pais Brazil = new Pais("Brazil");

        Argentina.agregarLimitrofe(Brazil);
        Brazil.agregarLimitrofe(Argentina);

        jugador1.asignarPais(Argentina);
        jugador2.asignarPais(Brazil);

        Argentina.agregarEjercito();

        jugador1.realizarAtaque(Argentina,Brazil,1);

        assertEquals(1,Brazil.cantidadEjercitos());
        assertEquals(1,Argentina.cantidadEjercitos());
    }
}
