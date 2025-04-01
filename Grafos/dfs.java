package com.atividade;
import java.util.LinkedList;

public class Solucao {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;

    private LinkedList< LinkedList<Integer> > grafo;

    public Solucao(LinkedList< LinkedList<Integer> > grafo){
        this.grafo = grafo;
        int n = grafo.size();
        ante = new int[n];
        i = new int[n];
        f = new int[n];
        cor = new int[n];
        tempo = 0;
    }
    
    public void dfs_start(int s){
        for(int j = 0; j < grafo.size(); j++){
            ante[j] = -2;
            i[j] = -2;
            f[j] = -2;
            cor[j] = BRANCO;
        }
        dfs_visit(s);
    }
    public void dfs_visit(int u){
        cor[u] = CINZA;
        tempo++;
        i[u] = tempo;
        for(int v : grafo.get(u)){
            if(cor[v] == BRANCO){
                ante[v] = u;
                dfs_visit(v);
            }
        }
        cor[u] = PRETO;
        tempo++;
        f[u] = tempo;
    }
}

/* 
vértices = [0, 1, 2, 3, 4, 5]
cor = [1, 1, 1, 1, 1, 1]
i = [1, 2, 3, 4, 7]
f = [12, 11, 10, 9, 6, 8]
ante = [-2, 0, 1, 2, 3, 3]
tempo = 12
*/
