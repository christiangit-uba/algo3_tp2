package edu.fiuba.algo3.modelo;

public class Ataque {

    public static void atacar(Pais atacante, Pais defensor , int ejercitosAtaque , int ejercitosDefensor){
        Dados dadoAtacante = new Dados(ejercitosAtaque);
        Dados dadoDefensor = new Dados(ejercitosDefensor);
        dadoAtacante.comparar(dadoDefensor,atacante,defensor);
    }
}
