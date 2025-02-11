package Arvores.ClassesExtra.TADStack;

class StackNode <T> {
    private T info;
    private StackNode<T> prox;
    
    StackNode(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public StackNode<T> getProx() {
        return prox;
    }
    public void setProx(StackNode<T> prox) {
        this.prox = prox;
    }
}