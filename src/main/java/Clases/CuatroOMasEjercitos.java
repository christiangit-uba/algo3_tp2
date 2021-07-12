package Clases;

public class CuatroOMasEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 3;
    public int cantidadDeEjercitos;

    public CuatroOMasEjercitos(int cantidad){
        cantidadDeEjercitos = cantidad;
    }

    @Override
    public boolean atacar(int cantidadEjercitosAUsar){
        return (CANTIDADDADOS - cantidadEjercitosAUsar >= 0 && cantidadEjercitosAUsar > 0);
    }

    public boolean mover(int cantidadEjercitosAMover){
        return (cantidadEjercitosAMover < cantidadDeEjercitos && cantidadEjercitosAMover > 0);
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new CuatroOMasEjercitos(cantidadDeEjercitos+1));
    }

    @Override
    public int cantidadDeEjercitos() {
        return cantidadDeEjercitos;
    }

    @Override
    public Ejercito sacarEjercito(){
        if (cantidadDeEjercitos > 4) {
            return (new CuatroOMasEjercitos(cantidadDeEjercitos-1));
        }
        else {
            return (new TresEjercitos());
        }
    }

    @Override
    public int cantidadDeDadosAtacante(){
        return CANTIDADDADOS;
    }

    @Override
    public int cantidadDeDadosDefensor() {
        return CANTIDADDADOS;
    }

    @Override
    public boolean ocupable() {
        return false;
    }

}
