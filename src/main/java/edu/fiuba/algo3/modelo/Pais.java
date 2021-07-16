package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombre;
    private Ejercito ejercito;
    private Limitrofes limitrofes;

    public Pais(String nombreNuevo) {
        this.nombre = nombreNuevo;
        ejercito = new UnoOMenosEjercito(0);
        limitrofes = new Limitrofes();
    }
    public void agregarLimitrofe(Pais paisLimitrofes){
        paisLimitrofes.mismoNombre(nombre);
        this.limitrofes.agregarLimitrofe(paisLimitrofes);
    }

    public boolean esLimitrofe(Pais otroPais){
        return limitrofes.esAdyacente(otroPais);
    }

    public void agregarEjercito(){
        ejercito = ejercito.agregarEjercito();
    }

    public void atacaA(Pais defensor,int ejercitosAtaque){
        defensor.teAtaca(this,ejercitosAtaque);
    }

    public void teAtaca(Pais atacante,int ejercitosAtaque){
        Dado dadoAtacante = new Dado(ejercitosAtaque);
        Dado dadoDefensor = new Dado(ejercito.getCantidadDeEjercitos());
        dadoAtacante.comparar(dadoDefensor,atacante,this);
    }

    public boolean mismoColor(Pais otroPais) {
        return (ejercito.mismoColor(otroPais));
    }

    public boolean mismoColor(Color color){
        return (ejercito.mismoColor(color));
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }

    public int cantidadEjercitos(){
        return ejercito.getCantidadDeEjercitos();
    }

    public boolean mismoNombre(String pais) {
        return nombre.equals(pais);
    }

    public void agregarColor(Color color) {
        ejercito.agregarColor(color);
    }

    public void moverEjercitoA(Pais paisDestino, int ejercitosAMover){
        for(int i = 0 ; i < ejercitosAMover ; i++){
            ejercito.sacarEjercito();
            paisDestino.agregarEjercito();
        }
    }

    public boolean puedeAtacar(int cantidadEjecitosAUsar) {
        return ejercito.puedeAtacar(cantidadEjecitosAUsar);
    }

    public void ocuparPais(Pais unPais, Color color){
        if(unPais.ocupable()){
            ejercito.sacarEjercito();
            unPais.agregarColor(color);
            unPais.agregarEjercito();
        }
    }

    public boolean ocupable(){
        return (ejercito.ejercitoVacio());
    }

    public boolean puedeMoverse(int cantidadEjercitos) {
        return ejercito.puedeMoverse(cantidadEjercitos);
    }
}
