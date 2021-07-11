public class CuatroOMasEjercitos implements Ejercito{
    static final int CANTIDADDADOS = 3;
    public int cantidadDeEjercitos;

    public CuatroOMasEjercitos(int cantidad){
        cantidadDeEjercitos = cantidad;
    }

    @Override
    public boolean atacar(int cantidadEjecitosAUsar){
        return (CANTIDADDADOS - cantidadEjecitosAUsar >= 0 && cantidadEjecitosAUsar > 0);
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
    public int cantidadDeDados(){
        return CANTIDADDADOS;
    }

}
