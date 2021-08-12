package Clases;

abstract class Condicion implements Validador{

    Condicion siguienteCondicion;

    @Override
    public void ejecutar() throws Exception {

    }

    public void asignarSiguiente(Condicion unaCondicion){
        siguienteCondicion = unaCondicion;
    }
}