public class CantidadDeEjercitos implements Validador{
    private final Ejercito ejercito;
    private int cantidadEjecitosAUsar;

    public CantidadDeEjercitos(Ejercito ejercito, int cantidadEjecitosAUsar) {
        this.ejercito = ejercito;
        this.cantidadEjecitosAUsar = cantidadEjecitosAUsar;
    }

    public int atacar() throws Exception{
        if (!this.ejercito.atacar(this.cantidadEjecitosAUsar)) {
            throw new Exception();
        }
        return 0;
    }
}
