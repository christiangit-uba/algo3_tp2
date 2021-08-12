package Clases;

public class CeroEjercitos implements Ejercito{
    static final int CANTIDADDEEJERCITOS = 0;
    @Override
    public boolean atacar(int cantidadEjercitosAUsar){
        return false;
    }

    public boolean mover(int cantidadEjercitosAMover){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {
        return(new UnEjercito());
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return null;
    }

    @Override
    public int cantidadDeDadosAtacante(){
        return 0;
    }

    @Override
    public int cantidadDeDadosDefensor() {
        return 0;
    }

    @Override
    public boolean ocupable() {
        return true;
    }
}
