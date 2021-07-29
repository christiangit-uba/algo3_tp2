package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PruebaTableroTest {

    private Tablero mapa;
    { try {
        mapa = new Tablero(new Tarjetero());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }

    private final String nombreArg = "Argentina";
    private final String nombreAus = "Australia";
    private final String nombreMon = "Mongolia";
    private final String nombreMex = "Mexico";
    private final String nombreEsp = "España";
    private final String nombreChi = "China";
    private final String nombreJava = "Java";
    private final String nombreUru = "Uruguay";
    private final String nombreBra = "Brazil";
    private final String nombreChile = "Chile";
    private final String nombrePer = "Peru";


    private Pais aux;
    private Pais pais1;
    private Pais pais2;
    private Pais pais3;
    private Pais pais4;


    private final ColorJugador colorJugadorBlanco = new ColorJugador("blanco","ffffff");

    @Test
    public void SeRepartenLosPaisesEntreDosJugadoresEntoncesJugador1Tiene25Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo","rojo");
        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorJugadorDos);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorUno), 25);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador1Tiene17Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo","rojo");
        ColorJugador colorJugadorJugadorTres = new ColorJugador("azul","azul");

        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorJugadorDos);
        Jugador jugadorTres = new Jugador(colorJugadorJugadorTres);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorUno), 17);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador3Tiene16Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorJugadorDos = new ColorJugador("rojo","verde");
        ColorJugador colorJugadorJugadorTres = new ColorJugador("azul","azul");

        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        Jugador jugadorDos = new Jugador(colorJugadorJugadorDos);
        Jugador jugadorTres = new Jugador(colorJugadorJugadorTres);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorJugadorTres), 16);
    }

    @Test
    public void JugadorUnoNoOcupaNingunContinenteEntoncesDevuelveCero() throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorACambiar = new ColorJugador("rojo","rojo");
        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorJugadorACambiar);

        assertEquals(tablero.cantidadEjercitosPorContinente(colorJugadorACambiar),0);

    }

    @Test
    public void ColorRojoOcupaOccidenteContinenteEntoncesDevuelveDos() throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorACambiar = new ColorJugador("rojo","rojo");
        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Sumatra")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Borneo")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Java")).agregarColor(colorJugadorACambiar);

        assertEquals(tablero.cantidadEjercitosPorContinente(colorJugadorACambiar),2);

    }
    @Test
    public void ColorRojoOcupaOccidenteYAfricaEntoncesDevuelveCinco() throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        ColorJugador colorJugadorJugadorUno = new ColorJugador("verde","verde");
        ColorJugador colorJugadorACambiar = new ColorJugador("rojo","rojo");
        Jugador jugadorUno = new Jugador(colorJugadorJugadorUno);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Sumatra")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Borneo")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Java")).agregarColor(colorJugadorACambiar);

        (tablero.obtenerPais("Sahara")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Egipto")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Etiopia")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Madagascar")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Sudafrica")).agregarColor(colorJugadorACambiar);
        (tablero.obtenerPais("Zaire")).agregarColor(colorJugadorACambiar);


        assertEquals(tablero.cantidadEjercitosPorContinente(colorJugadorACambiar),5);

    }

    @Test
    public void SiUnJugadorConquista4PaisesSINContinentesEntoncesPuedeColocarSolo3Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        assertEquals(tablero.cantidadPaisesAColocar(4,0),3);
    }
    @Test
    public void SiUnJugadorConquista6PaisesSINContinentesEntoncesPuedeColocarSolo3Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        assertEquals(tablero.cantidadPaisesAColocar(6,0),3);
    }
    @Test
    public void SiUnJugadorConquista8PaisesSINContinentesEntoncesPuedeColocarSolo4Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        assertEquals(tablero.cantidadPaisesAColocar(8,0),4);
    }
    @Test
    public void SiUnJugadorConquista8PaisesYAsiaEntoncesPuedeColocar11Ejercitos()throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        assertEquals(tablero.cantidadPaisesAColocar(8,7),11);
    }

    //Inicializacion de Tablero
    @Test
    public void unPaisEstaCargadoEnElTablero(){
        aux = mapa.obtenerPais(nombreArg);
        assert(aux.mismoNombre(nombreArg));
    }

    @Test
    public void variosPaisesEstanCargadosEnElTablero(){
        aux = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(nombreAus));

        aux = mapa.obtenerPais(nombreMon);
        assert(aux.mismoNombre(nombreMon));

        aux = mapa.obtenerPais(nombreMex);
        assert(aux.mismoNombre(nombreMex));

        aux = mapa.obtenerPais(nombreEsp);
        assert(aux.mismoNombre(nombreEsp));

        aux = mapa.obtenerPais(nombreChi);
        assert(aux.mismoNombre(nombreChi));

        aux = mapa.obtenerPais(nombreJava);
        assert(aux.mismoNombre(nombreJava));
    }

    @Test
    public void unPaisEntregadoPorElTableroSeComportaComoUnPais(){
        aux = mapa.obtenerPais(nombreArg);
        assert(aux.mismoNombre(nombreArg));

        pais1 = mapa.obtenerPais(nombreUru);
        pais2 = mapa.obtenerPais(nombreBra);
        pais3 = mapa.obtenerPais(nombreChile);
        pais4 = mapa.obtenerPais(nombrePer);

        assertEquals(0, aux.cantidadEjercitos());

        assert(aux.esLimitrofe(pais1));
        assert(aux.esLimitrofe(pais2));
        assert(aux.esLimitrofe(pais3));
        assert(aux.esLimitrofe(pais4));
    }

    @Test
    public void losPaisesLimitrofesDeUnPaisSonLimitrofesEntreSi(){
        aux = mapa.obtenerPais(nombreArg);
        pais1 = mapa.obtenerPais(nombreUru);
        pais2 = mapa.obtenerPais(nombreBra);
        pais3 = mapa.obtenerPais(nombreChile);
        pais4 = mapa.obtenerPais(nombrePer);

        assert(aux.esLimitrofe(pais1));
        assert(aux.esLimitrofe(pais2));
        assert(aux.esLimitrofe(pais3));
        assert(aux.esLimitrofe(pais4));

        assert(pais1.esLimitrofe(aux));
        assert(pais2.esLimitrofe(aux));
        assert(pais3.esLimitrofe(aux));
        assert(pais4.esLimitrofe(aux));

        assert(pais3.esLimitrofe(pais4));
        assert(pais1.esLimitrofe(pais2));
    }

    @Test
    public void unPaisInicializadoDelTableroPuedeCambiarDecolor(){
        aux = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(nombreAus));

        aux.agregarColor(colorJugadorBlanco);
        assert(aux.mismoColor(colorJugadorBlanco));

        pais1 = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(nombreAus));
        assert(pais1.mismoColor(colorJugadorBlanco));
    }
}


