package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombre;
    private Ejercito ejercito;
    private Limitrofes limitrofes;

    public Pais(String nombreNuevo) {
        this.nombre = nombreNuevo;
        ejercito = new MenosDeUnEjercito(0);
        limitrofes = new Limitrofes();
    }
    public void agregarLimitrofe(Pais paisLimitrofes){
        this.limitrofes.agregarLimitrofe(paisLimitrofes);
    }

    public boolean esLimitrofe(Pais otroPais){
        return limitrofes.esAdyacente(otroPais);
    }

    public void agregarEjercito(){
        ejercito.agregarEjercito();
    }

    public void atacaA(Pais defensor,int ejercitosAtaque){
        defensor.teAtaca(this,ejercitosAtaque);
    }

    public void teAtaca(Pais atacante,int ejercitosAtaque){
        Ataque.atacar(atacante,this,ejercitosAtaque,ejercito.getCantidadDeEjercitos());
    }

    public boolean mismoColor(Pais otroPais) {
        return (ejercito.mismoColor(otroPais));
    }

    public boolean mismoColor(String color){
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

    public void agregarColor(String color) {
        ejercito.agregarColor(color);
    }

    public void moverEjercitoA(Pais paisDestino, int ejercitosAMover){
        MoverPais.moverPais(ejercitosAMover,ejercito,paisDestino);
    }

    public boolean puedeAtacar(int cantidadEjecitosAUsar) {
        return ejercito.puedeAtacar(cantidadEjecitosAUsar);
    }
}
