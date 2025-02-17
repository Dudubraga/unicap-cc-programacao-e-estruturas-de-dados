package ArvoreBinBusca;

public class ABBNode<T extends Comparable<T>> {
    private ABBNode<T> esq;
    private T info;
    private ABBNode<T> dir;

    ABBNode(T value) {
        this.info = value;
    }

    ABBNode<T> getEsq() {
        return esq;
    }
    void setEsq(ABBNode<T> esq) {
        this.esq = esq;
    }
    T getInfo() {
        return info;
    }
    void setInfo(T info) {
        this.info = info;
    }
    ABBNode<T> getDir() {
        return dir;
    }
    void setDir(ABBNode<T> dir) {
        this.dir = dir;
    }
}
