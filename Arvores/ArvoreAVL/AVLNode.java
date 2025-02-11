package Arvores.ArvoreAVL;

@SuppressWarnings("unused")
public class AVLNode<T extends Comparable<T>> {
    private T info;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int fatBal;

    AVLNode (T info){
        this.info = info;
    }

    AVLNode<T> getLeft() {
        return left;
    }
    void setLeft(AVLNode<T> left) {
        this.left = left;
    }
    AVLNode<T> getRight() {
        return right;
    }
    void setRight(AVLNode<T> right) {
        this.right = right;
    }
    T getInfo() {
        return info;
    }
    void setInfo(T info) {
        this.info = info;
    }
    int getFatBal() {
        return fatBal;
    }
    void setFatBal(int fatBal) {
        this.fatBal = fatBal;
    }
}
