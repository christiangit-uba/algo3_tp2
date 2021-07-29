package edu.fiuba.algo3.modelo;

abstract class Validador {
    protected Validador siguiente;

    public void siguiente(Validador siguiente){
        this.siguiente = siguiente;
    }

    void validar(boolean desicion,String mensajeExcepcion) throws Exception{
        if(desicion){
            throw new Exception(mensajeExcepcion);
        }
        if (siguiente != null){
            siguiente.validar();
        }
    }

    abstract void validar()throws Exception;
}



