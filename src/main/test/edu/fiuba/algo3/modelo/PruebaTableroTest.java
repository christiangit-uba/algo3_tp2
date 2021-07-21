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

    private String nombreArg = "Argentina";
    private String nombreAus = "Australia";
    private String nombreMon = "Mongolia";
    private String nombreMex = "Mexico";
    private String nombreEsp = "España";
    private String nombreChi = "China";
    private String nombreJava = "Java";
    private String nombreUru = "Uruguay";
    private String nombreBra = "Brazil";
    private String nombreChile = "Chile";
    private String nombrePer = "Peru";

    private Pais argentina = new Pais("Argentina");
    private Pais australia = new Pais(nombreAus);
    private Pais mongolia = new Pais(nombreMon);
    private Pais mexico = new Pais(nombreMex);
    private Pais espania = new Pais(nombreEsp);
    private Pais china = new Pais(nombreChi);
    private Pais java = new Pais(nombreJava);

    private Pais uruguay = new Pais(nombreUru);
    private Pais brasil = new Pais(nombreBra);
    private Pais chile = new Pais(nombreChile);
    private Pais peru = new Pais(nombrePer);

    private Pais aux;
    private Pais pais1;
    private Pais pais2;
    private Pais pais3;
    private Pais pais4;
    private Pais pais5;

    private Color colorBlanco = new Color("ffffff");
    private Tarjetero mazo = new Tarjetero();
    private ValidarCanje validador = new ValidarCanje(mazo);

    public PruebaTableroTest() throws FileNotFoundException {
    }

    @Test
    public void SeRepartenLosPaisesEntreDosJugadoresEntoncesJugador1Tiene25Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
        Jugador jugadorDos = new Jugador(colorJugadorDos, validador);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 25);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador1Tiene17Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Color colorJugadorTres = new Color("azul");

        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
        Jugador jugadorDos = new Jugador(colorJugadorDos, validador);
        Jugador jugadorTres = new Jugador(colorJugadorTres, validador);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorUno), 17);
    }

    @Test
    public void SeRepartenLosPaisesEntreTresJugadoresEntoncesJugador3Tiene16Paises() throws FileNotFoundException {
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorJugadorDos = new Color("rojo");
        Color colorJugadorTres = new Color("azul");

        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
        Jugador jugadorDos = new Jugador(colorJugadorDos, validador);
        Jugador jugadorTres = new Jugador(colorJugadorTres, validador);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
        jugadores.add(jugadorTres);
        tablero.asignarPaises(jugadores);
        assertEquals(tablero.cantidadDePaises(colorJugadorTres), 16);
    }

    @Test
    public void JugadorUnoNoOcupaNingunContinenteEntoncesDevuelveCero() throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        tablero.asignarPaises(jugadores);

        (tablero.obtenerPais("Australia")).agregarColor(colorACambiar);

        assertEquals(tablero.cantidadEjercitosPorContinente(colorACambiar),0);

    }

    @Test
    public void ColorRojoOcupaOccidenteContinenteEntoncesDevuelveDos() throws FileNotFoundException{
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
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
        Tablero tablero = new Tablero(new Tarjetero());
        Color colorJugadorUno = new Color("verde");
        Color colorACambiar = new Color("rojo");
        Jugador jugadorUno = new Jugador(colorJugadorUno, validador);
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

        aux.agregarColor(colorBlanco);
        assert(aux.mismoColor(colorBlanco));

        pais1 = mapa.obtenerPais(nombreAus);
        assert(aux.mismoNombre(nombreAus));
        assert(pais1.mismoColor(colorBlanco));
    }
}
