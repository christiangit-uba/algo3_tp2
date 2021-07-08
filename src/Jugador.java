import java.util.ArrayList;

public class Jugador {
    private String color;
    private ArrayList<Pais> paises = new ArrayList<Pais>();
    private int cantidadDePaises = 0;

    public Jugador(String colorNuevo) {
        this.color = colorNuevo;
    }

    public void asignarPais(Pais pais) {
        cantidadDePaises += 1;
        paises.add(pais);
    }

    public String nombre() {
        return this.color;
    }

    public int cantidadDePaises() {
        return cantidadDePaises;
    }
}