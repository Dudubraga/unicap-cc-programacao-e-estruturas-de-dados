package ArvoreB;

@SuppressWarnings("FieldMayBeFinal")
class ABNode {
    private int n;
    private int[] infos;
    private ABNode[] filhos;

    ABNode (int M) {
        this.n = 0;
        this.infos = new int[M];
        this.filhos = new ABNode[M+1];
    }

    int getN() {
        return n;
    }
    void setN(int n) {
        this.n = n;
    }

    int[] getInfos() {
        return infos;
    }
    void setInfoPos(int index, int value) {
        this.infos[index] = value;
    }

    ABNode[] getFilhos() {
        return filhos;
    }
    void setFilhoPos(int index, ABNode filho) {
        this.filhos[index] = filho;
    }
    @Override
    public String toString(){
        String saida = ""; int j = 0;
        if(infos[n-1] == 0){ j = 1; }
        for(int i = 0; i < n-j; i++){
            saida += infos[i] + " ";
        }
        return saida;
    }
}
