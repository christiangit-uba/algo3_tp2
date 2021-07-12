package Clases;

public class UnEjercito implements Ejercito {
    static final int CANTIDADDEEJERCITOS = 1;
    @Override
    public boolean atacar(int cantidadEjercitosAUsar){
        return false;
    }

    public boolean mover(int cantidadEjercitosAMover){
        return false;
    }

    @Override
    public Ejercito agregarEjercito() {
        return (new DosEjercitos());
    }

    @Override
    public int cantidadDeEjercitos() {
        return CANTIDADDEEJERCITOS;
    }

    @Override
    public Ejercito sacarEjercito(){
        return(new CeroEjercitos());
    }

    @Override
    public int cantidadDeDadosAtacante(){
        return 0;
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
