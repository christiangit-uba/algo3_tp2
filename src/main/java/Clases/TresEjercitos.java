package Clases;

public class TresEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 2;
    static final int CANTIDADDEEJERCITOS = 3;

    @Override
    public boolean atacar(int cantidadEjercitosAUsar){
        return (CANTIDADDADOS - cantidadEjercitosAUsar >= 0 && cantidadEjercitosAUsar > 0);
    }

    public boolean mover(int cantidadEjercitosAMover){
        return (cantidadEjercitosAMover < CANTIDADDEEJERCITOS && cantidadEjercitosAMover > 0);
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new CuatroOMasEjercitos(4));
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new DosEjercitos());
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
