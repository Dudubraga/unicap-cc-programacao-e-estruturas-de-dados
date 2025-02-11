package Arvores.ArvoreAVL;
import Arvores.ClassesExtra.TADQueue.Queue;
import Arvores.ClassesExtra.TADStack.Stack;

public class AVL<T extends Comparable<T>> {
    private AVLNode<T> root;
    private boolean status;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(T value){
        if(this.isEmpty()){
            this.root = new AVLNode<>(value);
        }else{
            this.root = insertNode(this.root, value);
            this.status = false;
        }
    }
    private AVLNode<T> insertNode(AVLNode<T>node, T value){
        if(node == null){
            node = new AVLNode<>(value);
            this.status = true;
        } else if(node.getInfo().compareTo(value) > 0){
            node.setLeft(insertNode(node.getLeft(), value));
            if(this.status){
                switch (node.getFatBal()) {
                    case 1 -> { 
                        node.setFatBal(0);
                        this.status = false;
                    }
                    case 0 -> node.setFatBal(-1);
                    case -1 -> node = this.rotateRight(node);
                }
            }
        } else {
            node.setRight(insertNode(node.getRight(), value));
            if(this.status){
                switch (node.getFatBal()) {
                    case -1 -> { 
                        node.setFatBal(0);
                        this.status = false;
                    }
                    case 0 -> node.setFatBal(1);
                    case 1 -> node = this.rotateLeft(node);
                }
            }
        }
        return node;
    }

    private AVLNode<T> rotateRight(AVLNode<T> a){
        AVLNode<T> b, c;
        b = a.getLeft();
        if(b.getFatBal() == -1){ // rotação simples
                a.setLeft(b.getRight());
                b.setRight(a);
                a.setFatBal(0);
                a = b;
            } else { // rotação dupla
                c = b.getRight();
                b.setRight(c.getLeft());
                c.setLeft(b);
                a.setLeft(c.getRight());
            c.setRight(a);
            if(c.getFatBal() == -1){
                a.setFatBal(1);
            } else {
                a.setFatBal(0);
            }
            if(c.getFatBal() == 1){
                b.setFatBal(-1);
            } else {
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }
    private AVLNode<T> rotateLeft(AVLNode<T> a){
        AVLNode<T> b, c;
        b = a.getRight();
        if(b.getFatBal() == 1){ // rotação simples
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setFatBal(0);
            a = b;
        } else { // rotação dupla
            c = b.getLeft();
            b.setLeft(c.getRight());
            c.setRight(b);
            a.setRight(c.getLeft());
            c.setLeft(a);
            if(c.getFatBal() == 1){
                a.setFatBal(-1);
            } else {
                a.setFatBal(0);
            }
            if(c.getFatBal() == -1){
                b.setFatBal(1);
            } else {
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    public void emOrdem(){
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            System.out.print("Em Ordem -> ");
            Stack<AVLNode<T>>stack = new Stack<>();
            AVLNode<T> aux = root;
            while(!stack.isEmpty() || aux != null){
                while(aux != null){
                    stack.push(aux);
                    aux = aux.getLeft();
                }
                aux = stack.pop();
                System.out.print(aux.getInfo() + " ");
                aux = aux.getRight();
            }
            System.out.println();
        }
    }
    public void porNivel(){
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            System.out.print("Por Nível -> ");
            AVLNode<T> aux;
            Queue<AVLNode<T>> fila = new Queue<>();
            fila.enQueue(root);
            while(!fila.isEmpty()){
                aux = fila.deQueue();
                if(aux != null /*&& (aux.getLeft() != null || aux.getRight() != null)*/){
                    fila.enQueue(aux.getLeft());
                    fila.enQueue(aux.getRight());
                }
                if(aux == null){
                    System.out.print("null ");
                }else{
                    System.out.print(aux.getInfo() + " ");
                }
            }
            System.out.println();
        }
    }

    public int calcularAltura(){
        int altura = 0;
        if(this.isEmpty()){
            return altura;
        }
        AVLNode<T>aux = this.root;
        while(aux.getLeft() != null || aux.getRight() != null){
            if(aux.getFatBal() <= 0){
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
            altura++;
        }
        return altura;
    }
}
