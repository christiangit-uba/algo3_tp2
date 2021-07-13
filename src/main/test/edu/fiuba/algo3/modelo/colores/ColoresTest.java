package edu.fiuba.algo3.modelo.colores;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ColoresTest {
    private String blanco = "ffffff";
    private String azul = "077bb";
    private String rojo = "cc3311";
    private String amarillo = "ee7733";
    private String verde = "009988";
    private String rosa = "ee3377";
    private String negro = "000000";

    private Colores color0 = new ColorBlanco();
    private Colores color1 = new ColorAzul();
    private Colores color2 = new ColorRojo();
    private Colores color3 = new ColorAmarillo();
    private Colores color4 = new ColorVerde();
    private Colores color5 = new ColorRosa();
    private Colores color6 = new ColorNegro();

    @Test
    public void losColoresSeInicializanEnBlanco() {
        color0 = color0.sinColor();
        assertEquals(color0.color(), blanco);
    }

    @Test
    public void laCantidadJugadoresPorDefaultEs0 () {
        assertEquals(0, color0.informarCantidadJugadores());
    }

    @Test
    public void noHayJugadoresSuficientesParaComenzarElJuegoPorDefault() {
        assertFalse(color0.hayJugadoresSuficientes(color0.informarCantidadJugadores()));
    }

    @Test
    public void elPrimerColorDeJugadorEsElColorAzul() {
        color1 = color0.siguienteColor();
        assertEquals(color1.color(),azul);
        assertEquals(1, color1.informarCantidadJugadores());
    }

    @Test
    public void elSegundoJugadorTieneElColorRojo() {
        color1 = color1.siguienteColor();
        assertEquals(color1.color(),rojo);
        assertEquals(2, color1.informarCantidadJugadores());

    }

    @Test
    public void elTercerJugadorTieneElColorAmarillo() {
        color3 = color2.siguienteColor();
        assertEquals(color3.color(), amarillo);
        assertEquals(3, color3.informarCantidadJugadores());
    }

    @Test
    public void elCuartoJugadorTieneElColorVerde() {
        color4 = color3.siguienteColor();
        assertEquals(color4.color(), verde);
        assertEquals(4, color4.informarCantidadJugadores());
    }

    @Test
    public void elQuintoJugadorTieneElColorRosa() {
        color5 = color4.siguienteColor();
        assertEquals(color5.color(), rosa);
        assertEquals(5, color5.informarCantidadJugadores());
    }

    @Test
    public void elUltimoJugadorTieneElColorNegro() {
        color6 = color5.siguienteColor();
        assertEquals(color6.color(), negro);
        assertEquals(6, color6.informarCantidadJugadores());
    }

    @Test
    public void noPuedenHaberMasDe6Jugadores() {
        color6 = color6.siguienteColor();
        assertEquals(color6.color(), negro);
        assertEquals(6, color6.informarCantidadJugadores());
    }

}