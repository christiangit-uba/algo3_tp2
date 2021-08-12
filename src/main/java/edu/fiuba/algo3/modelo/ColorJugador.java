package edu.fiuba.algo3.modelo;

public class ColorJugador {
    private final String codigo;
    private final String nombre;

    public ColorJugador(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String nombre(){
        return nombre;
    }


    public Boolean mismoColor(ColorJugador otroColorJugador){
        return otroColorJugador.mismoColor(nombre);
    }

    public Boolean mismoColor(String otroColor){
        return (nombre.equals(otroColor));
    }

    public String codigo() {
        return codigo;
    }
}