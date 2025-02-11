package Arvores.ArvoreRedBlack;

public class ARBNode<T extends Comparable<T>> {
    private T info;
    private int cor; // 0 - Preto / 1 - Vermelho
    private ARBNode<T> esq;
    private ARBNode<T> dir;
    private ARBNode<T> pai;
    private boolean status; // 0 - inativo / 1 - ativo

    ARBNode (T info){ // novo nó sempre vermelho e ativo
        this.info = info;
        this.cor = 1;
        this.status = true;
    }

    T getInfo() {
        return info;
    }
    void setInfo(T info) {
        this.info = info;
    }
    int getCor() {
        return cor;
    }
    void setCor(int cor) {
        this.cor = cor;
    }
    ARBNode<T> getPai() {
        return pai;
    }
    void setPai(ARBNode<T> pai) {
        this.pai = pai;
    }
    ARBNode<T> getEsq() {
        return esq;
    }
    void setEsq(ARBNode<T> esq) {
        this.esq = esq;
    }
    ARBNode<T> getDir() {
        return dir;
    }
    void setDir(ARBNode<T> dir) {
        this.dir = dir;
    }
    boolean getStatus() {
        return status;
    }
    void setStatus(boolean status) {
        this.status = status;
    }
}