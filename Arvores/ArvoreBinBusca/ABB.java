package ArvoreBinBusca;
import ClassesExtra.TADQueue.Queue;
import ClassesExtra.TADStack.Stack;

public class ABB<T extends Comparable<T>> {
    private ABBNode<T> raiz;
    
    public boolean isEmpty() {
        return this.raiz == null;
    }
    
    public void inserir(T obj){
        if(this.isEmpty()){
            this.raiz = new ABBNode<>(obj);
            // System.out.println("Inserção Efetuada");
        }else{
            this.inserirNode1(obj);
        }
    }
    private void inserirNode1(T obj) {
        ABBNode<T> novo;
        novo = new ABBNode<>(obj);
        if (this.isEmpty()) {
            this.raiz = novo;
            // System.out.println("Inserção Efetuada");
        } else {
            ABBNode<T> aux = this.raiz;
            while (true) {
                int result = obj.compareTo(aux.getInfo());
                /*if (result == 0) {
                    System.out.println("Item Repetido");
                    return;
                } else*/if (result < 0) {
                    if (aux.getEsq() != null) {
                        aux = aux.getEsq();
                    } else {
                        aux.setEsq(novo);
                        // System.out.println("Inserção Efetuada");
                        return;
                    }
                } else {
                    if (aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux.setDir(novo);
                        // System.out.println("Inserção Efetuada");
                        return;
                    }
                }
            }
        }
    }
    @SuppressWarnings("unused")
    private void inserirNode2(T obj) {
        ABBNode<T> novo, pai, filho;
        novo = new ABBNode<>(obj);
        int compare;
        if (this.isEmpty()) {
            this.raiz = novo;
            // System.out.println("Inserção efetuada");
        } else {
            filho = this.raiz;
            while (true) {
                pai = filho;
                compare = obj.compareTo(filho.getInfo());
                /*if (compare == 0) {
                    System.out.println("Item Repetido");
                    return;
                } else */if (compare < 0) {
                    if (filho.getEsq() != null) {
                        filho = filho.getEsq();
                    } else {
                        pai.setEsq(novo);
                        // System.out.println("Inserção efetuada");
                        return;
                    }
                } else {
                    if (filho.getDir() != null) {
                        filho = filho.getDir();
                    } else {
                        pai.setDir(novo);
                        // System.out.println("Inserção efetuada.");
                        return;
                    }
                }
            }
        }
    }
    
    public T buscar(T obj) {
        ABBNode<T>aux = this.buscarNode(obj);
        if (aux == null) {
            return null;
        } 
        return aux.getInfo();
    }
    private ABBNode<T> buscarNode(T obj){
        ABBNode<T> aux;
        if (this.isEmpty()) {
            aux = null;
        } else {
            aux = this.raiz;
            while (true) {
                int result = obj.compareTo(aux.getInfo());
                if (result == 0) {
                    break;
                } else if (result < 0) {
                    if (aux.getEsq() != null) {
                        aux = aux.getEsq();
                    } else {
                        aux = null; break;
                    }
                } else {
                    if (aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux = null; break;
                    }
                }
            }
        }
        return aux;
    }
    
    public void remover(T obj){
        if(this.isEmpty()){
            System.out.println("Nada para remover");
        }else{
            this.raiz = this.removerNodeRecursivo(this.raiz, obj);
        }
    }
    private ABBNode<T> removerNodeRecursivo(ABBNode<T> node, T obj){
        if(node != null){
            int result = obj.compareTo(node.getInfo());
            if(result == 0){
                if(node.getEsq() == null && node.getDir() == null){
                    node = null;
                }else if(node.getEsq() == null){
                    node = node.getDir();
                }else if(node.getDir() == null){
                    node = node.getEsq();
                }else{
                    ABBNode<T> pai, filho;
                    pai = node;
                    filho = pai.getEsq();
                    if(filho.getDir() != null){
                        while(filho.getDir() != null){
                            pai = filho;
                            filho = filho.getDir();
                        }
                        pai.setDir(filho.getEsq());
                    }else{
                        pai.setEsq(filho.getEsq());
                    }
                    node.setInfo(filho.getInfo());
                }
            }else if(result < 0){
                node.setEsq(removerNode(node.getEsq(), obj));
            }else{
                node.setDir(removerNode(node.getDir(), obj));
            }
        }
        return node;
    }
    
    public ABBNode<T> removerNode(ABBNode<T> node, T obj){
        return node;
    }

    public void menor() {
        ABBNode<T> aux = this.raiz;
        while (aux.getEsq() != null) {
            aux = aux.getEsq();
        }
        System.out.println("Menor item encontrado: \n" + aux.getInfo());
    }
    public void maior() {
        ABBNode<T> aux = this.raiz;
        while (aux.getDir() != null) {
            aux = aux.getDir();
        }
        System.out.println("Maior item encontrado: \n" + aux.getInfo());
    }
    
    public void emOrdem() {
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Stack<ABBNode<T>>stack = new Stack<>();
            ABBNode<T> aux = raiz;
            while(!stack.isEmpty() || aux != null){
                while(aux != null){
                    stack.push(aux);
                    aux = aux.getEsq();
                }
                aux = stack.pop();
                System.out.println(aux.getInfo());
                aux = aux.getDir();
            }
        }
    }
    public void emOrdemRecursiva() {
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            this.percorrerEmOrdemRecursiva(raiz);
            System.out.println();
        }
    }
    private void percorrerEmOrdemRecursiva(ABBNode<T> node) {
        if (node != null) {
            percorrerEmOrdemRecursiva(node.getEsq());
            System.out.println(node.getInfo());
            percorrerEmOrdemRecursiva(node.getDir());
        }
    }
    
    public void preOrdem(){
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Stack<ABBNode<T>> stack = new Stack<>();
            ABBNode<T> aux = raiz;
            stack.push(aux);
            while (!stack.isEmpty()) {
                aux = stack.pop();
                System.out.println(aux.getInfo()); 
                if (aux.getDir() != null) {
                    stack.push(aux.getDir());
                }
                if (aux.getEsq() != null) {
                    stack.push(aux.getEsq());
                }
            }
            System.out.println();
        }
    }
    public void preOrdemRecursiva(){
        if(this.isEmpty()){
            System.out.println("Não há itens para exibir");
        }else{
            percorrerPreOrdemRecursiva(raiz);
            System.out.println();
        }
    }
    private void percorrerPreOrdemRecursiva(ABBNode<T> node){
        if(node != null){
            System.out.println(node.getInfo());
            percorrerPreOrdemRecursiva(node.getEsq());
            percorrerPreOrdemRecursiva(node.getDir());
        }
    }
    
    public void posOrdem() {
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Stack<ABBNode<T>> stack1 = new Stack<>();
            Stack<ABBNode<T>> stack2 = new Stack<>();
            ABBNode<T> aux;
            stack1.push(raiz);
            while (!stack1.isEmpty()) {
                aux = stack1.pop();
                stack2.push(aux);
                if (aux.getEsq() != null) {
                    stack1.push(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    stack1.push(aux.getDir());
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().getInfo());
            }
            System.out.println();
        }
    }
    public void posOrdemRecursiva() {   
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            this.percorrerPosOrdemRecursiva(raiz);
            System.out.println();
        }
    }
    private void percorrerPosOrdemRecursiva(ABBNode<T> node) {
        if (node != null) {
            percorrerPosOrdemRecursiva(node.getEsq());
            percorrerPosOrdemRecursiva(node.getDir());
            System.out.println(node.getInfo());
        }
    }
    
    public void porNivel() {
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Queue<ABBNode<T>> fila;
            ABBNode<T> aux;
            fila = new Queue<>();
            if(!this.isEmpty()){
                fila.enQueue(raiz);
                while(!fila.isEmpty()){
                    aux = fila.deQueue();
                    if(aux.getEsq() != null){
                        fila.enQueue(aux.getEsq());
                    }
                    if(aux.getDir() != null){
                        fila.enQueue(aux.getDir());
                    }
                    System.out.println(aux.getInfo());
                }
            }
            System.out.println();
        }
    }

    private int contar(ABBNode<T> node, int tipoContagem){
        if (node == null){
            return 0;
        }
        int contEsq = 0, contDir = 0;
        if(tipoContagem == 1){
            contEsq = contar(node.getEsq(), tipoContagem);
            contDir = contar(node.getDir(), tipoContagem);
            return 1 + contEsq + contDir;
        }
        if(tipoContagem == 2){
            contEsq = contar(node.getEsq(), tipoContagem);
            contDir = contar(node.getDir(), tipoContagem);
            if(node.getEsq() == null && node.getDir() == null){
                return 1 + contEsq + contDir; 
            }
        }
        if(tipoContagem == 3){
            contEsq = contar(node.getEsq(), tipoContagem);
            contDir = contar(node.getDir(), tipoContagem);
            if(node.getEsq() != null || node.getDir() != null){
                return 1 + contEsq + contDir; 
            }
        }
        return contEsq + contDir;
    }
    
    public void contarNos() {
        int nos = 0;
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Stack<ABBNode<T>>stack = new Stack<>();
            ABBNode<T> aux = raiz;
            while(!stack.isEmpty() || aux != null){
                while(aux != null){
                    stack.push(aux);
                    aux = aux.getEsq();
                }
                aux = stack.pop();
                nos++;
                aux = aux.getDir();
            }
        }
        System.out.println("A árvore possui " + nos + " nós");
    }
    public void contarNosRecursiva() {
        if(this.isEmpty()){
            System.out.println("Não há itens para exibir");
        }else{
            System.out.println("A árvore possui " + contar(raiz, 1) + " nós");
        }
    }
    
    public void contarFolhas() {
        int nos = 0;
        Queue<ABBNode<T>> fila;
        ABBNode<T> aux;
        fila = new Queue<>();
        if(!this.isEmpty()){
            fila.enQueue(raiz);
            while(!fila.isEmpty()){
                aux = fila.deQueue();
                if(aux.getEsq() != null){
                    fila.enQueue(aux.getEsq());
                }
                if(aux.getDir() != null){
                    fila.enQueue(aux.getDir());
                }
                if(aux.getEsq() == null && aux.getDir() == null){
                    nos++;
                }
            }
        }
        System.out.println("A árvore possui " + nos + " nós folhas");
    }
    public void contarFolhasRecursiva() {
        if(this.isEmpty()){
            System.out.println("Não há itens para exibir");
        }else{
            System.out.println("A árvore possui " + contar(raiz, 2) + " nós folhas");
        }
    }
    
    public void contarNaoTerminais() {
        int nos = 0;
        Queue<ABBNode<T>> fila;
        ABBNode<T> aux;
        fila = new Queue<>();
        if(!this.isEmpty()){
            fila.enQueue(raiz);
            while(!fila.isEmpty()){
                aux = fila.deQueue();
                if(aux.getEsq() != null){
                    fila.enQueue(aux.getEsq());
                }
                if(aux.getDir() != null){
                    fila.enQueue(aux.getDir());
                }
                if(aux.getEsq() != null || aux.getDir() != null){
                    nos++;
                }
            }
        }
        System.out.println("A árvore possui " + nos + " nós não terminais");
    }
    public void contarNaoTerminaisRecursiva() {
        if(this.isEmpty()){
            System.out.println("Não há itens para exibir");
        }else{
            System.out.println("A árvore possui " + contar(raiz, 3) + " nós não terminais");
        }
    }

    public void alturaArvore(){
        if(this.isEmpty()){
            System.out.println("Altura: 0");
        }else{
            int altura = alturaNodeRecursiva(raiz);
            System.out.println("Altura: " + altura);
        }
    }
    private int alturaNodeRecursiva(ABBNode<T> node){
        if(node == null){
            return -1;
        }
        int alturaEsq = alturaNodeRecursiva(node.getEsq());
        int alturaDir = alturaNodeRecursiva(node.getDir());
        if(alturaEsq >= alturaDir){
            return 1 + alturaEsq;
        }
        return 1 + alturaDir;
    }

    public void frequenciaNode(T obj){
        ABBNode<T> aux = this.raiz;
        int freq = 0;
        while(aux != null){
            int result = obj.compareTo(aux.getInfo());
            if(result == 0){
                freq++;
                aux = aux.getDir();
            } else if(result > 0){
                aux = aux.getDir();
            }else{
                aux = aux.getEsq();
            }
        }
        System.out.println("Frequência: " + freq);
    }
}
