package Clases;

public class Enemigo extends Condicion{
    Pais paisAtacante;
    Pais paisDefensor;

    Enemigo(Pais atacante, Pais defensor, Condicion siguiente) {
        paisAtacante = atacante;
        paisDefensor = defensor;
        siguienteCondicion = siguiente;
    }

    @Override
    public void ejecutar() throws Exception {
        if(paisAtacante.mismoColor(paisDefensor))
            throw new Exception();
        else
            siguienteCondicion.ejecutar();
    }
}
