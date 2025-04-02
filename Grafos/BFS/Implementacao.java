package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Implementacao {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] cor;
    public int[] distancia;
    public Integer[] ante;
    public Queue<Integer> fila;

    public boolean[][] grafo;
    
    public Implementacao(boolean[][] grafo){
        this.grafo = grafo;
        int n = grafo.length;
        this.cor = new int[n];
        this.distancia = new int[n];
        this.ante = new Integer[n];
        this.fila = new LinkedList<>();
    }

    public void BFS(int s){
        for(int u = 0; u < grafo.length; u++){
            cor[u] = BRANCO;
            distancia[u] = -1;
            ante[u] = null;
        }
        cor[s] = CINZA;
        distancia[s] = 0;
        fila.add(s);

        while(!fila.isEmpty()){
            int u = fila.remove();
            for(int v  = 0; v < grafo.length; v++){
                if(cor[v] == BRANCO && grafo[u][v] == true){
                    cor[v] = CINZA;
                    distancia[v] = distancia[u]+1;
                    ante[v] = u;
                    fila.add(v);
                }
            }
            cor[u] = PRETO;
        }
    }
} 