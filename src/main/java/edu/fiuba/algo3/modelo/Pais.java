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

    //Limitrofes
    public void agregarLimitrofe(Pais paisLimitrofes){
        paisLimitrofes.mismoNombre(nombre);
        this.limitrofes.agregarLimitrofe(paisLimitrofes);
    }

    public boolean esLimitrofe(Pais otroPais){
        return limitrofes.esAdyacente(otroPais);
    }


    //Ejercitos
    public void agregarEjercito(){
        ejercito.agregarEjercito();
    }

    public void perdioEjercito(){
        ejercito = ejercito.sacarEjercito();
    }

    public int cantidadEjercitos(){
        return ejercito.getCantidadDeEjercitos();
    }

    //movimiento de ejercito
    public boolean puedeMoverse(int cantidadEjercitos) {
        return ejercito.puedeMoverse(cantidadEjercitos);
    }

    public void moverEjercitoA(Pais paisDestino, int ejercitosAMover){
        if (esLimitrofe(paisDestino) && (ejercitosAMover < this.ejercito.getCantidadDeEjercitos()))  //Agregado
            MoverPais.moverPais(ejercitosAMover,ejercito,paisDestino);
    }

    //ataque entre ejercitos
    public boolean puedeAtacar(int cantidadEjecitosAUsar) {
        return ejercito.puedeAtacar(cantidadEjecitosAUsar);
    }

    public void atacaA(Pais defensor,int ejercitosAtaque){
        defensor.teAtaca(this,ejercitosAtaque);
    }


    //Nombres
    public boolean mismoNombre(String pais) {
        return nombre.equals(pais);
    }

    public boolean mismoNombre(Pais otroPais){ return this.mismoNombre(otroPais.nombre);}   //Agregado


    //Colores
    public boolean mismoColor(Pais otroPais) {
        return (ejercito.mismoColor(otroPais));
    }

    public boolean mismoColor(Color color){
        return (ejercito.mismoColor(color));
    }

    public void agregarColor(Color color) {
        if (0 == ejercito.getCantidadDeEjercitos()) //Agregado
            ejercito.agregarColor(color);
    }


    //Acciones defensivas
    public void teAtaca(Pais atacante,int ejercitosAtaque){
        Ataque.atacar(atacante,this,ejercitosAtaque,ejercito.getCantidadDeEjercitos());
    }

    public boolean ocupable(){
        return (ejercito.ejercitoVacio());
    }

    public boolean ocuparPais(Pais unPais, Color color){
        if(unPais.ocupable()){
            ejercito.sacarEjercito();
            unPais.agregarColor(color);
            unPais.agregarEjercito();
            return true;
        }
        return false;
    }
}
