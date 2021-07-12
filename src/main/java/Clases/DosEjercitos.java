package Clases;

public class DosEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 1;
    static final int CANTIDADDEEJERCITOS = 2;

    @Override
    public boolean atacar(int cantidadEjercitosAUsar){
        return (cantidadEjercitosAUsar == CANTIDADDADOS);
    }

    public boolean mover(int cantidadEjercitosAMover){
        return (cantidadEjercitosAMover == CANTIDADDEEJERCITOS - 1);
    }

    @Override
    public Ejercito agregarEjercito() { return (new TresEjercitos()); }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new UnEjercito());
    }

    @Override
    public int cantidadDeDadosAtacante(){
        return CANTIDADDADOS;
    }

    @Override
    public int cantidadDeDadosDefensor() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public boolean ocupable() {
        return false;
    }
}