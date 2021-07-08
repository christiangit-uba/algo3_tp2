import java.util.ArrayList;

public class Pais {
    private String nombre;
    private ArrayList<String> limitrofes;
    private Ejercito ejercito;
    private String color;

    public Pais(String nombreNuevo, String colorNuevo, ArrayList<String> limitrofesNuevos) {
        this.nombre = nombreNuevo;
        this.limitrofes = limitrofesNuevos;
        this.color = colorNuevo;
        }

    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public boolean mismoColor(Pais otroPais) {
        return (this.color() == otroPais.color());
    }

    private String color() {
        return this.color;
    }

    public Ejercito ejercito() {
        return ejercito;
    }

    public boolean esLimitrofe(Pais otroPais) {
        return ((this.limitrofes).contains(otroPais.nombre()));
    }

    private String nombre() {
        return this.nombre;
    }

    public void atacaA(Pais pais2) throws Exception {
        Limitrofe limitrofe = new Limitrofe(this, pais2);
        limitrofe.atacar();
        while ((this.cantidadDeEjercitos() != 0) && (pais2.cantidadDeEjercitos() != 0)) {
            Dados dados1 = new Dados(this.cantidadDeDados());
            Dados dados2 = new Dados(pais2.cantidadDeDados());

            ArrayList comparacion = Dados.comparar(dados1,dados2,this,pais2);
        }
    }

    private int cantidadDeDados(){
        return ejercito.cantidadDeDados();
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }
}
