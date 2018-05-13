package caminhominimo;
import java.lang.*;
import java.text.DecimalFormat;

class CaminhoMinimo {
    /*  A função abaixo encontra o vértice com o menor valor de dist�ncia dos vértices
        n�o inclu�dos na �rvore de busca */
    static final int V = 7;
    static final String cidades[] = {"ipatinga", "Timoteo", "Coronel Fabriciano", "Naque", "Periquito", "Governador Valadares", "Santana do Paraiso"};
    /* altere de acordo com o n�mero de v�rtices do grafo */
    double distanciaMin(double dist[], Boolean visitados[]) {
        /* Inicialize o menor valor */
        double min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (visitados[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    /* A fun��o imprimeSolucao imprime a rota m�nima e o custo m�nimo, exemplo de sa�da:
        Caminho m�nimo = 0-2-3-5
        Custo m�nimo = 20		
     */
    static void imprimeSolucao(double dist[], int caminho[], int fim, int origem) {
        // Fa�a o que se pede acima
        int aux=0;
        int custo = fim;
        int rota [] = new int [V];
        rota[0] = fim;
        DecimalFormat df = new DecimalFormat("0.##");
        for (int i = 1; i < V; i++) {
            if(fim != 0){
                rota[i] = caminho[fim];
                fim = caminho[fim];
                aux++;
            }
            else
                i = V;
        }
        System.out.print("Caminho mínimo: ");
        for (int i = 0; aux >= i; aux--) {
            System.out.print(cidades[rota[aux]]);
            if(aux != i){
                System.out.print(" - ");
            }
        }
        String dx = df.format(dist[custo]);
        System.out.println("\nCusto mínimo: " + dx);
    }

    /* A fun��o abaixo implementa o algoritmo de dijkstra para um grafo representado
	   por uma matriz de adjac�ncia */
    void dijkstra(double grafo[][], int origem, int fim, int caminho[]) {
        origem-=1;
        fim-=1;
        /* Vetor de dist�ncia m�nima*/
        double dist[] = new double[V];
        /*Vetor de v�rtices visitados*/
        Boolean visitados[] = new Boolean[V];

        /* Inicializando todas as dist�ncia para infinito e marcando todos os v�rtices como n�o visitados */
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        /* Dist�ncia da origem � sempre 0 */
        dist[origem] = 0;

        /* Encontra o menor caminho para todos os v�rtices */
        for (int count = 0; count < V - 1; count++) {
            
            /* Pega a dist�ncia m�nima do v�rtice para o conjunto de v�rtives n�o visitados. u � sempre igual a origem(origem) na primeira itera��o.*/
            int u = (int) distanciaMin(dist, visitados);
            /* Marca o v�rtice como visitado */
            visitados[u] = true;

            /* Atualiza a dist�ncia dos v�rtices adjacentes do v�rtice visitado*/
            /* Atualiza a dist[v] somente se o v�rtice n�o foi visitado e se existir uma aresta de u para v e se o peso total do caminho de origem(origem) para v onde u � o menor valor dos valores de dist[v] */ 
            for (int v = 0; v < V; v++){
                if (!visitados[v] && grafo[u][v] != 99999 && dist[u] != Integer.MAX_VALUE && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                    caminho[v] = u;
                }
            }
        }
        // Imprime o caminho m�nimo e o custo total m�nimo
        imprimeSolucao(dist, caminho, fim, origem);
    }
}