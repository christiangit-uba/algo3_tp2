public class UnEjercito implements Ejercito {
    static final int CANTIDADDEEJERCITOS = 1;
    @Override
    public boolean atacar(int cantidadEjecitosAUsar){
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
    public int cantidadDeDados(){
        return 0;
    }
}
