package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.ColorJugador;
import edu.fiuba.algo3.modelo.Distribucion;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaDistribucionPaisesTest {

    @Test
    public void ColocacionDeEjercitos() throws Exception {
        ColorJugador rojo = new ColorJugador("rojo","001");
        ColorJugador verde = new ColorJugador("verde","002");

        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",verde);

        Pais Argentina = new Pais("Argentina");
        Pais Etiopia = new Pais("Etiopia");
        Pais Turquia = new Pais("Turquia");
        Pais Java = new Pais("Java");

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(Argentina);
        paises.add(Etiopia);
        paises.add(Turquia);
        paises.add(Java);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Distribucion distribucion = new Distribucion(jugadores,paises);

        distribucion.asignarEjercito(0,jugador1);
        distribucion.asignarEjercito(0,jugador2);
        distribucion.asignarEjercito(0,jugador1);
        distribucion.asignarEjercito(0,jugador2);

        jugador1.setTope(10);
        jugador2.setTope(10);

        jugador1.colocarEjercitos(5,Argentina);
        jugador2.colocarEjercitos(5,Etiopia);
        jugador1.colocarEjercitos(3,Turquia);
        jugador2.colocarEjercitos(3,Java);


        int acumulador = 0;
        for (Pais pais : paises){
            if (pais.mismoColor(rojo))
                acumulador += pais.cantidadEjercitos();
        }
        assertEquals(acumulador,10);

        acumulador = 0;
        for (Pais pais : paises){
            if (pais.mismoColor(verde))
                acumulador += pais.cantidadEjercitos();
        }
        assertEquals(acumulador,10);
    }
}
