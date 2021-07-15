package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class PruebaTablero {
    @Test
    public void SeRepartenLosPaisesEntreDosJugadoresEntoncesJugador1Tiene25Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorDos);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 25);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador1Tiene17Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Color colorJugadorTres = new Color("azul");

        Jugador jugadorUno = new Jugador(colorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorDos);
        Jugador jugadorTres = new Jugador(colorJugadorTres);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 17);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador3Tiene16Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Color colorJugadorTres = new Color("azul");

        Jugador jugadorUno = new Jugador(colorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorDos);
        Jugador jugadorTres = new Jugador(colorJugadorTres);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorTres), 16);
    }

    @Test
    public void JugadorUnoNoOcupaNingunContinenteEntoncesDevuelveCero() throws FileNotFoundException{
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorACambiar);

        assertEquals(tablero.cantidadEjercitosPorContinente(colorACambiar),0);

    }

    @Test
    public void ColorRojoOcupaOccidenteContinenteEntoncesDevuelveDos() throws FileNotFoundException{
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Sumatra")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Borneo")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Java")).agregarColor(colorACambiar);

        assertEquals(tablero.cantidadEjercitosPorContinente(colorACambiar),2);

    }
    @Test
    public void ColorRojoOcupaOccidenteYAfricaEntoncesDevuelveCinco() throws FileNotFoundException{
        Tablero tablero = new Tablero();
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Sumatra")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Borneo")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Java")).agregarColor(colorACambiar);

        (tablero.obtenerPais("Sahara")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Egipto")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Etiopia")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Madagascar")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Sudafrica")).agregarColor(colorACambiar);
        (tablero.obtenerPais("Zaire")).agregarColor(colorACambiar);


        assertEquals(tablero.cantidadEjercitosPorContinente(colorACambiar),5);

    }
    @Test
    public void SiUnJugadorConquista4PaisesSINContinentesEntoncesPuedeColocarSolo3Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadPaisesAColocar(4,0),3);
    }
    @Test
    public void SiUnJugadorConquista6PaisesSINContinentesEntoncesPuedeColocarSolo3Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadPaisesAColocar(6,0),3);
    }
    @Test
    public void SiUnJugadorConquista8PaisesSINContinentesEntoncesPuedeColocarSolo4Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadPaisesAColocar(8,0),4);
    }
    @Test
    public void SiUnJugadorConquista8PaisesYAsiaEntoncesPuedeColocar11Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadPaisesAColocar(8,7),11);
    }



}
