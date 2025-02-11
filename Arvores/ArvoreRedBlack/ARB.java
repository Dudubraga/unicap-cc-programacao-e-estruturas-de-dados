package Arvores.ArvoreRedBlack;
import Arvores.ClassesExtra.TADQueue.Queue;
import Arvores.ClassesExtra.TADStack.Stack;

@SuppressWarnings("unused")
public class ARB<T extends Comparable<T>> {
    private ARBNode<T> raiz;
    private ARBNode<T> nil; // nó nulo e preto que seve como folha para toda a árvore

    public boolean isEmpty(){
        return this.raiz == null;
    }

    public void inserir(T val){
        if(this.isEmpty()){ // inicialização da raiz
            this.raiz = new ARBNode<>(val);
            this.raiz.setCor(0); // raiz sempre preta
            this.nil = new ARBNode<>(null); // inicialização do nil
            this.nil.setCor(0);
            this.raiz.setEsq(nil);
            this.raiz.setDir(nil);
        } else {
            inserirNode(val);
        }
        System.out.println(val + " inserido\n");
    }
    private void inserirNode(T val){
        ARBNode<T> aux = this.raiz;
        ARBNode<T> K = new ARBNode<>(val);
        ARBNode<T> P, G, S; // P -> Pai de K; G -> Avô de K; S -> Tio de K;
        while (true) {
            int result = val.compareTo(aux.getInfo());
            if (result == 0) { // reativa um nó previamente removido, não aceita repetido
                aux.setStatus(true);
                return;
            } else if (result < 0) { // val é menor que o valor de aux atual
                if (aux.getEsq() != nil) { // se aux já tem um nó a sua esquerda
                    aux = aux.getEsq(); // aux vai para esquerda
                } else { // achou o lugar certo para o novo val
                    aux.setEsq(K);
                    break;
                }
            } else { // val é maior que o valor de aux atual
                if (aux.getDir() != nil) { // se aux já tem um nó a sua direita
                    aux = aux.getDir(); // aux vai para direita
                } else { // achou o lugar certo para o novo val
                    aux.setDir(K); 
                    break;
                }
            }
        }
        K.setPai(aux); 
        K.setEsq(nil);
        K.setDir(nil);
        P = K.getPai(); // verificar K, P, G, S para possíveis ajustes
        if(P.getPai() != null){ // perguntar se G existe para não acessar uma variável nula
            G = P.getPai();
            if(G.getEsq() == P){ // se P é o filho da esquerda, S é da direita
                S = G.getDir();
            } else { // se P é o filho da direita, S é da esquerda
                S = G.getEsq();
            }
            if(P.getCor() == 1){ // se P for vermelho -> reajuste (Propriedade Vermelha)
                if(S == nil || S.getCor() == 0){ // se S for null ou preto -> rotação 
                    rotacionar(K, P, G, S);
                } else if(S.getCor() == 1) { // se S for vermelho -> recoloração
                    recolorir(K, P, G, S);
                }
            }
        }
    }
    private void recolorir(ARBNode<T>K, ARBNode<T>P, ARBNode<T>G, ARBNode<T>S){
        P.setCor(0); S.setCor(0);
        if(G != this.raiz){ // se G for a raíz não troca sua cor (Propriedade Preta)
            G.setCor(1);
        }
        K = G; // novo K
        P = K.getPai(); // novo P
        if(P != null && P.getPai() != null){ // para não acessar uma variáveis nulas
            G = P.getPai(); // novo G
            if(G.getEsq() == P){ // novo S
                S = G.getDir();
            } else {
                S = G.getEsq();
            }
            if(K.getCor() == 1 && P.getCor() == 1){ // novo K e novo P são vermelhos
                if(S == nil || S.getCor() == 0){ // se S for null ou preto -> rotação
                    rotacionar(K, P, G, S); // -> rotação (Propriedade Vermelha)
                } else if(S.getCor() == 1) { // se S for vermelho 
                    recolorir(K, P, G, S); // -> recoloração novamente (foi propagada)
                }
            }
        }
    }
    private void rotacionar(ARBNode<T>K, ARBNode<T>P, ARBNode<T>G, ARBNode<T>S){
        ARBNode<T> aux; // está acima da sub-árvore que será rotacionada
        if(G.getPai() != null){ // se G tiver um pai, ele receberá a sub-árvore rotacionada
            aux = G.getPai();
        } else { // se G for a própria raíz, deveremos mexer na raíz
            aux = null;
        }
        if(P == G.getEsq()){ // Rotação Direita
            if(K == P.getEsq()){ // Rotação Simples a Direita
                if(aux == null){ // P vira a nova raíz em uma RSD se G for a raíz anterior
                    this.raiz = P;
                } else { // o nó que apontava para G anteriormente agora aponta para P
                    if(G == aux.getEsq()){
                        aux.setEsq(P);
                    } else {
                        aux.setDir(P);
                    }
                }
                G.setEsq(P.getDir()); // reajuste de filhos, pais e cores dos nós envolvidos
                if (P.getDir() != nil) {
                    P.getDir().setPai(G);
                }
                P.setDir(G);
                P.setPai(aux);
                G.setPai(P); 
                P.setCor(0);
                G.setCor(1);
            } else {  // Rotação Dupla Direita
                if(aux == null){ // K vira a nova raíz em uma RDD se G for a raíz anterior
                    this.raiz = K;
                } else { // o nó que apontava para G anteriormente agora aponta para K
                    if(G == aux.getEsq()){
                        aux.setEsq(K);
                    } else {
                        aux.setDir(K);
                    }
                }
                P.setDir(K.getEsq()); // reajuste de filhos, pais e cores dos nós envolvidos
                if (K.getEsq() != nil) {
                    K.getEsq().setPai(P); 
                }
                G.setEsq(K.getDir()); 
                if (K.getDir() != nil) {
                    K.getDir().setPai(G); 
                }
                K.setEsq(P);
                K.setDir(G); 
                K.setPai(aux);
                P.setPai(K);
                G.setPai(K);
                K.setCor(0);
                G.setCor(1);
            }
        } else { // Rotação Esquerda 
            if(K == P.getDir()){ // Rotação Simples Esquerda
                if(aux == null){ // P vira a nova raíz em uma RSE se G for a raíz anterior
                    this.raiz = P;   
                } else { // o nó que apontava para G anteriormente agora aponta para P
                    if(G == aux.getDir()){
                        aux.setDir(P);
                    } else {
                        aux.setEsq(P);
                    }
                }
                G.setDir(P.getEsq()); // reajuste de filhos, pais e cores dos nós envolvidos
                if (P.getEsq() != nil) {
                    P.getEsq().setPai(G);
                }
                P.setEsq(G);
                P.setPai(aux);
                G.setPai(P);
                P.setCor(0);
                G.setCor(1);
            } else { // Rotação Dupla Esquerda
                if(aux == null){ // K vira a nova raíz em uma RDE se G for a raíz anterior
                    this.raiz = K;
                } else { // o nó que apontava para G anteriormente agora aponta para K
                    if(G == aux.getEsq()){
                        aux.setEsq(K);
                    } else {
                        aux.setDir(K);
                    }
                }
                P.setEsq(K.getDir()); // reajuste de filhos, pais e cores dos nós envolvidos
                if (K.getDir() != nil) {
                    K.getDir().setPai(P); 
                }
                G.setDir(K.getEsq()); 
                if (K.getEsq() != nil) {
                    K.getEsq().setPai(G); 
                }
                K.setDir(P); 
                K.setEsq(G);
                K.setPai(aux); 
                G.setPai(K); 
                P.setPai(K); 
                K.setCor(0);
                G.setCor(1);
            }
        }
    }
    
    public void remover(T val){
        if(this.isEmpty()){
            System.out.println("Não há itens para remover\n");
        } else {
            removerNode(val);
        }
    }
    private void removerNode(T val){
        ARBNode<T> aux = buscarNode(val); // busca pelo nó a ser removido
        if(aux != nil){
            aux.setStatus(false); // Remoção Preguiçosa -> o nó inativo sem mudar a árvore
            System.out.println(aux.getInfo() + " removido\n");
        } else {
            System.out.println("Valor não se encontra na árvore\n");
        }
    }
    
    private ARBNode<T> buscarNode(T val){ // busca padrão ABB até chegar na folha nil
        ARBNode<T> aux = this.raiz;
        while(aux != nil){
            int result = val.compareTo(aux.getInfo());
            if(result == 0){
                break;
            } else if (result < 0) {
                aux = aux.getEsq();
            } else {
                aux = aux.getDir();
            }
        }
        return aux;
    }

    public void emOrdem(){ // passeio em ordem padrão ABB
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            Stack<ARBNode<T>>stack = new Stack<>();
            ARBNode<T> aux = raiz;
            while(!stack.isEmpty() || aux != nil){ 
                while(aux != nil){
                    stack.push(aux);
                    aux = aux.getEsq();
                }
                aux = stack.pop();
                if(aux.getStatus()){
                    String saida; // string para auxílio do print da cor 
                    if(aux.getCor() == 0){ // "\u001B[30m" + txt + "\u001B[0m" -> txt preto
                        saida = "\u001B[30m" + "[" + aux.getInfo() + ", PRETO] " + "\u001B[0m";
                    } else { // "\u001B[31m" + txt + "\u001B[0m" -> txt vermelho
                        saida = "\u001B[31m" + "[" + aux.getInfo() + ", VERMELHO] " + "\u001B[0m";
                    }
                    System.out.println(saida);
                } /*else { // print nó removido ?
                    System.out.print("[inativo] ");
                }*/
                aux = aux.getDir();
            }
        }
        System.out.println();
    }
    public void porNivel(){ // passeio por nível padrão ABB
        if (this.isEmpty()) {
            System.out.println("Não há itens para exibir");
        } else {
            ARBNode<T> aux;
            Queue<ARBNode<T>> fila = new Queue<>();
            fila.enQueue(raiz);
            while(!fila.isEmpty()){
                aux = fila.deQueue();
                if(aux != nil){ // sempre enfileirar para que nós folha nil apareçam
                    fila.enQueue(aux.getEsq());
                    fila.enQueue(aux.getDir());
                }
                if(aux == nil){ // "\u001B[30m" + txt + "\u001B[0m" -> txt preto
                    System.out.println("\u001B[30m" + "[null] " + "\u001B[0m");
                }else if(aux.getStatus()){
                    String saida; // string para auxílio do print da cor 
                    if(aux.getCor() == 0){ // "\u001B[30m" + txt + "\u001B[0m" -> txt preto
                        saida = "\u001B[30m" + "[" + aux.getInfo() + ", PRETO] " + "\u001B[0m";
                    } else { // "\u001B[31m" + txt + "\u001B[0m" -> txt vermelho
                        saida = "\u001B[31m" + "[" + aux.getInfo() + ", VERMELHO] " + "\u001B[0m";
                    }
                    System.out.println(saida);
                } /*else { // print nó removido ?
                    System.out.print("[inativo] ");
                }*/
            }
        }
        System.out.println();
    }
}
