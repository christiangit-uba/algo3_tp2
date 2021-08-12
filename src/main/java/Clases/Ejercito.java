package Clases;

public interface Ejercito{
    boolean atacar(int cantidadEjercitosAUsar);

    boolean mover(int cantidadEjercitosAMover);

    Ejercito agregarEjercito();

    int cantidadDeEjercitos();

    Ejercito sacarEjercito();

    int cantidadDeDadosAtacante();

    int cantidadDeDadosDefensor();

    boolean ocupable();
}
