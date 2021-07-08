import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dados {
    private ArrayList<Integer> dados;

    public Dados(int cantidadDeDados) {
        ArrayList<Integer> dadosNuevos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidadDeDados; i++){
            dadosNuevos.add(random.nextInt(6) + 1);
        }

        dadosNuevos.sort(Collections.reverseOrder());
        dados = dadosNuevos;
   }

    public static ArrayList comparar(Dados dadoAtaque, Dados dadoDefensa, Pais paisAtacante, Pais paisDefensor) throws Exception {
        ArrayList<Integer> resultado = new ArrayList<>();
        resultado.set(0, 0);
        resultado.set(1, 0);
        int i = 0;
        while (i < (dadoAtaque.dados().size()) && i < (dadoDefensa.dados().size())){
            if ((dadoAtaque.dados().get(i)) <= (dadoDefensa.dados().get(i))) {
                paisAtacante.perdioEjercito();
            }
            else {
                paisDefensor.perdioEjercito();
            }
            i++;
        }
        return resultado;
    }

    public ArrayList<Integer> dados() {
        return dados;
    }

    public void setDados(ArrayList<Integer> dados) {
        this.dados = dados;
    }
}
