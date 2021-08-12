/*package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PruebaRondaJugadoresColocarTest {
    @Test
    public void PruebaActivacionTarjeta() throws Exception {
        ColorJugador rojo = new ColorJugador("rojo","001");
        ColorJugador verde = new ColorJugador("verde","002");
        ColorJugador azul = new ColorJugador("azul","003");

        Jugador jugador1 = new Jugador("Jugador1",rojo);
        Jugador jugador2 = new Jugador("Jugador2",verde);
        Jugador jugadorAuxiliar = new Jugador("JugadorAuxiliar",azul);

        ArrayList<Jugador> jugadores = new ArrayList<>();

        Juego juego = new Juego(2);

        jugadores.add(jugadorAuxiliar);
        juego.agregarJugadores(jugadores);

        juego.asignarPaises();

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.remove(jugadorAuxiliar);
        juego.agregarJugadores(jugadores);

        Pais Argentina = juego.obtenerPais("Argentina");
        Pais Etiopia = juego.obtenerPais("Etiopia");
        Pais Turquia = juego.obtenerPais("Turquia");
        Pais Francia = juego.obtenerPais("Francia");


        Argentina.agregarColor(rojo);
        Etiopia.agregarColor(rojo);
        Turquia.agregarColor(verde);
        Francia.agregarColor(verde);

        juego.iniciarTurno();



        assertEquals(juego.getTope(),3);
        assertEquals(Argentina.cantidadEjercitos(),1);

        juego.colocarEjercito("Argentina",2);
        assertEquals(Argentina.cantidadEjercitos(),3);
        assertEquals(juego.getTope(),1);

        assertEquals(Etiopia.cantidadEjercitos(),1);

        juego.colocarEjercito("Etiopia",1);

        assertEquals(Etiopia.cantidadEjercitos(),2);

        juego.colocarEjercito("Argentina",1);
        assertEquals(Argentina.cantidadEjercitos(),3);

        juego.terminarTurno(true);
        juego.iniciarTurno();


        assertEquals(juego.getTope(),3);


        assertEquals(Argentina.cantidadEjercitos(),3);
        juego.colocarEjercito("Argentina",1);
        assertEquals(Argentina.cantidadEjercitos(),3);

        juego.colocarEjercito("Turquia",3);
        assertEquals(Turquia.cantidadEjercitos(),4);
        assertEquals(juego.getTope(),0);
        juego.terminarTurno(false);
    }
}*/
