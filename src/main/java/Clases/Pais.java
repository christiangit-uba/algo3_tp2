package Clases;

import java.util.ArrayList;

public class Pais {
    private final String nombre;
    private final ArrayList<String> limitrofes;
    private Ejercito ejercito;
    private String color;

    public Pais(String nombreNuevo, String colorNuevo, ArrayList<String> limitrofesNuevos) {
        this.nombre = nombreNuevo;
        this.limitrofes = limitrofesNuevos;
        this.color = colorNuevo;
        this.ejercito = new CeroEjercitos();
        }

    public int cantidadDeEjercitos() {
        return ejercito.cantidadDeEjercitos();
    }

    public boolean mismoColor(Pais otroPais) {
        return (this.color().equals(otroPais.color()));
    }

    public String color() {
        return this.color;
    }

    private void setColor(String unColor){this.color = unColor;}

    public Ejercito ejercito() {
        return ejercito;
    }

    public boolean esLimitrofe(Pais otroPais) {
        return ((this.limitrofes).contains(otroPais.nombre()));
    }

    private String nombre() {
        return this.nombre;
    }

    public void atacaA(Pais paisDefensor, int cantidadEjercitosAUsar) throws Exception {
        EjercitosAtaque ejercitosAtaque = new EjercitosAtaque(ejercito,cantidadEjercitosAUsar);
        Enemigo esEnemigo = new Enemigo(this,paisDefensor, ejercitosAtaque);
        Limitrofe esLimitrofe = new Limitrofe(this, paisDefensor,esEnemigo);

        esLimitrofe.ejecutar();

        int dadosAtacante = this.cantidadDeDadosAtaque();
        int dadosDefensor = paisDefensor.cantidadDeDadosDefensa();

        ArrayList<Integer> dadosNuevos = new ArrayList<>();
        Dados dados = new Dados(dadosNuevos,dadosNuevos,dadosAtacante,dadosDefensor);

        dados.lanzarDados();
        dados.combatir(this, paisDefensor);
    }

    public void ocupar(Pais unPais){
        if(unPais.ocupable()){
            unPais.setColor(this.color);
            unPais.agregarEjercito();
            this.sacarEjercito();
        }
    }

    private boolean ocupable(){
        return (this.ejercito.ocupable());
    }

    public void moverEjercitoA(Pais paisDestino, int ejercitosAMover) throws Exception{
        EjercitosMovibles ejercitosMovibles = new EjercitosMovibles(ejercito,ejercitosAMover);
        Aliado esAliado = new Aliado(this,paisDestino,ejercitosMovibles);
        Limitrofe esLimitrofe = new Limitrofe(this,paisDestino, esAliado);
        esLimitrofe.ejecutar();
        for(int i = 0; i < ejercitosAMover; i++){
            paisDestino.agregarEjercito();
            this.sacarEjercito();
        }
    }

    private int cantidadDeDadosAtaque(){
        return ejercito.cantidadDeDadosAtacante();
    }

    private int cantidadDeDadosDefensa(){
        return ejercito.cantidadDeDadosDefensor();
    }

    public void sacarEjercito(){
        ejercito = ejercito.sacarEjercito();
    }

    public void agregarEjercito(){
        ejercito = ejercito.agregarEjercito();
    }
}
