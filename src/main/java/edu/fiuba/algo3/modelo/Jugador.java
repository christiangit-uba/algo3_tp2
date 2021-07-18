package edu.fiuba.algo3.modelo;

public class Jugador {
    private final Color color;
    public Jugador(Color color){
        this.color = color;
    }

    public void asignarPais(Pais unPais){
        unPais.agregarColor(color);
        unPais.agregarEjercito();
    }

    public int cantidadEjercitosAColocar(Tablero tablero){
        return tablero.cantidadEjercitosAColocar(color);
    }


    public void colocarEjercitos(int ejercitosAColocar,int ejercitosTope, Pais unPais) throws Exception {

        if(ejercitosAColocar > ejercitosTope) {
            throw new Exception();
        }else {
            for (int i = 0; i < ejercitosAColocar; i++) {
                unPais.agregarEjercito();
            }
        }
    }

    public void realizarAtaque(Pais atacante, Pais defensor, int cantidadEjercitosAUsar) throws Exception{
        CadenaDeResponsabilidad.confirmarAtaque(atacante, defensor, cantidadEjercitosAUsar, color);

        atacante.atacaA(defensor,cantidadEjercitosAUsar);
        atacante.ocuparPais(defensor,color);
    }

    public void realizarMovimiento(Pais origen,Pais destino, int cantidadEjercitos) throws Exception {
        CadenaDeResponsabilidad.confirmarMovimiento(origen,destino,cantidadEjercitos,color);

        origen.moverEjercitoA(destino,cantidadEjercitos);
    }
}