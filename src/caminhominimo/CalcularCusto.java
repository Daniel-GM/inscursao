package caminhominimo;

public class CalcularCusto {
    static final int cidade[] = {10, 5, 10, 3, 3, 10, 5,};
    static final int V=7;
    public void mudaGrafo(double grafo[][],int fim){
        fim-=1;
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if(grafo[i][j] != 99999)
                    grafo[i][j] = grafo[i][j] + (cidade[j] * 5) + ((grafo[i][j] / 12) * 3.5);
            }
        }
    }

}