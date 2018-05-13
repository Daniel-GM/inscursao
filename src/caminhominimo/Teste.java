package caminhominimo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.##");
        /*Preencha a matriz com as distancias do vertice atual para cada vertice
	   vizinho. Cada linha da matriz representa o vertice atual e cada coluna 
	   representa os vertices e a distancia dele para o vertice que a linha da matriz
	   representa. Os vertices das colunas com -999 representam que n�o s�o vizinhos do vertice que a linha da matriz representa */
        Scanner ler = new Scanner(System.in);
        int a = Integer.MAX_VALUE;
        int caminho[] = {0, 0, 0, 0, 0, 0, 0,};
        int origem=1, fim;
        
        double grafo[][] = new double[][]{
            //    1   2   3   4   5   6   7  */
            /*1*/{99999,   30,   20,   50,   80,  200,   60,},
            /*2*/{   30,99999,   15,   60,  100,  280,   90,},
            /*3*/{   20,   15,99999,   55,   85,  250,   75,},
            /*4*/{   50,   60,   55,99999,   30,  150,   30,},
            /*5*/{   80,  100,   85,   30,99999,  100,   50,},
            /*6*/{  200,  280,  250,  150,  100,99999,  120,},
            /*7*/{   60,   90,   75,   30,   50,  120,99999,},};

        System.out.print("Insira o seu destino: ");
        fim = ler.nextInt();

        CaminhoMinimo t = new CaminhoMinimo();
        CalcularCusto novoCusto = new CalcularCusto();

        novoCusto.mudaGrafo(grafo, fim);

//        for (int i=0; i<7; i++) {
//            for (int j=0; j<7; j++) {
//                if(grafo[i][j] == 99999){
//                    System.out.print("0 ");
//                }
//                else {
//                    String dx = df.format(grafo[i][j]);
//                    System.out.print(dx + " ");
//                }
//            }
//            System.out.println();
//        }

        System.out.println();
        t.dijkstra(grafo, 1, fim, caminho);
    }
}