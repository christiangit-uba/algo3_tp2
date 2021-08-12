package Clases;

public class EjercitosAtaque extends Condicion{
    private final Ejercito ejercito;
    private final int cantidadEjecitosAUsar;

    public EjercitosAtaque(Ejercito ejercito, int cantidadEjercitosAUsar) {
        this.ejercito = ejercito;
        this.cantidadEjecitosAUsar = cantidadEjercitosAUsar;
    }

    public void ejecutar() throws Exception{
        if (!this.ejercito.atacar(this.cantidadEjecitosAUsar)) {
            throw new Exception();
        }
    }
}
