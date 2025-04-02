package DFS;

import java.util.LinkedList;

public class Implementacao {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;

    private LinkedList< LinkedList<Integer> > grafo;

    public Implementacao(LinkedList< LinkedList<Integer> > grafo){
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

