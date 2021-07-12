package Clases;

public class EjercitosMovibles extends Condicion{
    private final Ejercito ejercito;
    private final int cantidadAMover;

    public EjercitosMovibles(Ejercito ejercito, int cantidadEjercitosAMover) {
        this.ejercito = ejercito;
        this.cantidadAMover = cantidadEjercitosAMover;
    }

    public void ejecutar() throws Exception{
        if (!this.ejercito.mover(this.cantidadAMover)) {
            throw new Exception();
        }
    }
}
