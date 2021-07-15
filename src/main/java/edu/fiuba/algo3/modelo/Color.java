package edu.fiuba.algo3.modelo;

public class Color{
    private final String codigo;

    Color(String codigo){
        this.codigo = codigo;
    }

    public String color(){
        return codigo;
    }

    public Boolean mismoColor(Color otroColor){
        return otroColor.mismoColor(codigo);
    }

    public Boolean mismoColor(String otroColor){
        return (codigo).equals(otroColor);
    }
}

