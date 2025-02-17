package ArvoreB;
import ClassesExtra.TADQueue.Queue;

@SuppressWarnings("ManualArrayToCollectionCopy")
public class AB {
    private ABNode raiz;
    private final int ordem;

    public AB (int ordem){
        this.ordem = ordem;
    }

    private boolean isEmpty(){
        return this.raiz == null;
    }
    // OK /* A : Inserir */
    public void inserir(int val){
        if(isEmpty()){ // arvore vazia
            ABNode aux = new ABNode(ordem);
            aux.setInfoPos(0, val);
            aux.setN(aux.getN()+1);
            raiz = aux;
        } else {
            if(procurarVal(raiz, val).getPosRetorno() > -1){
                System.out.println("Valor repetido.");
                System.out.println();
                return;
            }
            ABNode aux = raiz;
            if (aux.getN() >= ordem-1) { // Se a raiz estiver cheia, precisa dividir
                if(aux.getFilhos()[0] != null && aux.getN() <= ordem){
                    inserirVal(aux, val);
                } else {
                    ABNode novaRaiz = new ABNode(ordem);
                    raiz = novaRaiz;
                    novaRaiz.setFilhoPos(0, aux);
                    novaRaiz.setN(1);
                    int i = aux.getN()-1;
                    while (i >= 0 && val < aux.getInfos()[i]) {
                        aux.setInfoPos(i + 1, aux.getInfos()[i]);
                        i--;
                    }
                    aux.setInfoPos(i + 1, val);
                    aux.setN(aux.getN() + 1);
                    cisao(novaRaiz, 0, aux);
                }
            } else {
                inserirVal(aux, val);
            }
        }
    }
    private void inserirVal(ABNode node, int val) {
        int i = node.getN() - 1;
        if (node.getFilhos()[0] == null) { // Se for um nó folha
            while (i >= 0 && val < node.getInfos()[i]) {
                node.setInfoPos(i + 1, node.getInfos()[i]);
                i--;
            }
            node.setInfoPos(i + 1, val);
            node.setN(node.getN() + 1);
        } else { // Nó interno
            i--;
            while (i >= 0 && val < node.getInfos()[i]) {
                i--;
            }
            i++;
            if (node.getFilhos()[i].getN() >= ordem - 1) {
                cisao(node, i, node.getFilhos()[i]);
                if (val > node.getInfos()[i]) {
                    i++;
                }
            }
            inserirVal(node.getFilhos()[i], val);
            // if(node.getN() > ordem){
            //     ABNode novoPai = new ABNode(ordem);
            //     if(raiz == node){
            //         raiz = novoPai;
            //     }
            //     novoPai.setFilhoPos(0, node);
            //     novoPai.setN(1);
            //     cisaoEspecial(novoPai, 0, node);
            // }
        }
    }
    // private void cisaoEspecial(ABNode pai, int indexNode, ABNode node){
    //     ABNode novo = new ABNode(ordem);
    //     int meio = ordem / 2;
    //     if (ordem % 2 == 0) {
    //         meio--;
    //     }
    //     // Transfere metade das chaves para o novo nó
    //     for (int i = meio + 1, j = 0; i < node.getN()-1; i++, j++) {
    //         novo.setInfoPos(j, node.getInfos()[i]);
    //         novo.setN(novo.getN() + 1);
    //         node.setInfoPos(i, 0);  // "Apagar" valor ?
    //     }
    //     // Se o nó não for folha, transfere os filhos também
    //     if (node.getFilhos()[0] != null) {
    //         for (int i = meio + 1, j = 0; i < node.getN(); i++, j++) {
    //             novo.setFilhoPos(j, node.getFilhos()[i]);
    //             node.setFilhoPos(i, null);
    //         }
    //     }
    //     node.setN(meio); 
       
    //     pai.setInfoPos(indexNode, node.getInfos()[meio]);
    //     node.setInfoPos(meio, 0);
    //     pai.setN(pai.getN() + 1);
    //     pai.setFilhoPos(indexNode + 1, novo);
    // }
    private void cisao(ABNode pai, int indexNode, ABNode node) {
        ABNode novo = new ABNode(ordem);
        int meio = ordem / 2;
        if (ordem % 2 == 0) {
            meio--;
        }
        // Transfere metade das chaves para o novo nó
        for (int i = meio + 1, j = 0; i < node.getN(); i++, j++) {
            novo.setInfoPos(j, node.getInfos()[i]);
            novo.setN(novo.getN() + 1);
            node.setInfoPos(i, 0);  // "Apagar" valor
        }
        // Se o nó não for folha, transfere os filhos também
        if (node.getFilhos()[0] != null) {
            for (int i = meio + 1, j = 0; i <= node.getN(); i++, j++) {
                novo.setFilhoPos(j, node.getFilhos()[i]);
                node.setFilhoPos(i, null);
            }
        }
        node.setN(meio);     
        // Organiza os ponteiros do pai para acomodar o novo nó
        int j = 0; if(pai.getN() >= ordem - 1){ j = 1; }
        for (int i = pai.getN()-j; i > indexNode; i--) {
            pai.setFilhoPos(i + 1, pai.getFilhos()[i]);
            pai.setInfoPos(i, pai.getInfos()[i - 1]);
        }    
        pai.setInfoPos(indexNode, node.getInfos()[meio]);
        pai.setN(pai.getN() + 1);
        pai.setFilhoPos(indexNode + 1, novo);
        node.setInfoPos(meio, 0);
    }
    // OK /* B + C : Encontrar maior valor  */
    public void exibirMaior(){
        Retorno maior = acharMaior();
        System.out.print("O numero de maior valor é: ");
        System.out.println(maior.getNodeRetorno().getInfos()[maior.getPosRetorno()]);
        System.out.println();
    }
    private Retorno acharMaior(){
        ABNode aux = raiz;
        while(aux.getFilhos()[aux.getN()-1] != null){
            aux = aux.getFilhos()[aux.getN()-1];
        }
        Retorno r = new Retorno(aux, aux.getN()-1);
        return r;
    }
    // OK /* D + E : Encontrar menor valor */
    public void exibirMenor(){
        Retorno menor = acharMenorNo();
        System.out.print("O número de menor valor é: ");
        System.out.println(menor.getNodeRetorno().getInfos()[menor.getPosRetorno()]);
        System.out.println();
    }
    private Retorno acharMenorNo(){
        ABNode aux = raiz;
        while(aux.getFilhos()[0] != null){
            aux = aux.getFilhos()[0];
        }
        Retorno r = new Retorno(aux, 0);
        return r;
    }
    // OK /* F : Calcular altura */
    public void exibirAltura(){
        System.out.println("Altura = " + calcularAltura(raiz));
        System.out.println();
    }
    private int calcularAltura(ABNode node){
        if(node.getFilhos()[0] == null){
            return 0;
        }
        return 1 + calcularAltura(node.getFilhos()[0]);
    }
    // OK /* G + H : Encontrar valor */
    public void procurar(int val){
        if(isEmpty()){
            System.out.println("Árvore Vazia");
        } else {
            Retorno r = procurarVal(raiz, val);
            if(r.getPosRetorno() > -1){
                System.out.println("Número " + val + " encontrado na posição " 
                + r.getPosRetorno() + " do nó [ " + r.getNodeRetorno() + "]");
            } else {
                System.out.println("Número " + val + " não encontrado");
            }
            System.out.println();
        }
    }
    private Retorno procurarVal(ABNode node, int val){
        ABNode aux = node;
        Retorno r;
        int i;
        for(i = 0; i < aux.getN(); i++){
            if(aux.getInfos()[i] == val){
                r = new Retorno(aux, i);
                return r;
            }
            else if(aux.getInfos()[i] > val){
                break;
            }
        }
        if(aux.getFilhos()[i] != null){
            return procurarVal(aux.getFilhos()[i], val);
        } else {
            r = new Retorno(aux, -1);
            return r;
        }
    }
    // OK /* I + J : Passeios */
    public void exibirPorNivel(){
        if(isEmpty()){
            System.out.println("Não há itens para exibir");
        } else {
            System.out.println("Nós exibidos por nível:");
            passeioPorNivel(raiz);
            System.out.println();
        }
    }
    private void passeioPorNivel(ABNode node){
        Queue<ABNode> fila;
        ABNode aux;
        int nivel = 0;
        fila = new Queue<>();
        fila.enQueue(raiz);
        while(!fila.isEmpty()){
            System.out.print("Nível " + nivel + ": ");
            aux = fila.deQueue();
            for(int i = 0; i < aux.getN()-1; i++){
                if(aux.getFilhos()[i] != null){
                    fila.enQueue(aux.getFilhos()[i]);
                }
            }
            if(aux.getFilhos()[aux.getN()-1] != null){
                fila.enQueue(aux.getFilhos()[aux.getN()-1]);
                nivel++;
            }
            System.out.println(aux);
        }
        System.out.println();
    }
    public void exibirEmOrdem(){
        if(isEmpty()){
            System.out.println("Não há itens para exibir");
        } else {
            System.out.println("Números exibidos em ordem:");
            passeioEmOrdem(raiz);
            System.out.println(); System.out.println();
        }
    }
    private void passeioEmOrdem(ABNode node){
        if(node != null){
            int i;
            for(i = 0; i < node.getN(); i++){
                passeioEmOrdem(node.getFilhos()[i]);
                if(node.getInfos()[i] != 0){
                    System.out.print(node.getInfos()[i] + " ");
                }
            }
            passeioEmOrdem(node.getFilhos()[i]);
        }
    }
    /* K : Remover */
    public void remover(int val){
        if(isEmpty() || procurarVal(raiz, val).getPosRetorno() == -1){
            System.out.println("Não foi possível realizar a remoção");
        } else {
            removerVal(raiz, raiz, val);
        }
    }
    private void removerVal(ABNode node, ABNode pai, int val){
        int i = node.getN()-1; // 10 20 30 40 
        while(i >= 0 && val < node.getInfos()[i]){ i--; }
        if(node.getFilhos()[0] == null && node == pai){ // raiz == folha
            while(i < node.getN()){
                node.setInfoPos(i, node.getInfos()[i+1]);
                i++;
            }
            node.setN(node.getN()-1);
        } 
        else if(node.getFilhos()[0] == null){ // folha
            if(i != 0){
                removerFolha(pai, node, pai.getFilhos()[i-1], val);
            } else {
                removerFolha(pai, node, pai.getFilhos()[i+1], val);
            }
        } else { // no nao folha
            if(val == node.getInfos()[i]){ // numero p remover esta no no
                ABNode novoPai = node;
                ABNode novoFilho = node.getFilhos()[i+1];
                while(novoFilho.getFilhos()[0] != null){
                    novoPai = novoFilho;
                    novoFilho = novoFilho.getFilhos()[0];
                }
                int maior = novoFilho.getInfos()[0];
                node.setInfoPos(i, maior); // sobe o imediato maior numero
                removerFolha(novoPai, novoFilho, novoPai.getFilhos()[i], maior); // pai filho irmao valor
            } else { // numero n esta nesse no
                removerVal(node.getFilhos()[i+1], node, val);
            }
        }
    }
    @SuppressWarnings("unused")
    private void removerFolha(ABNode W, ABNode P, ABNode Q, int val){ // remover de P
        int i = P.getN()-1;
        while(i >= 0 && val < P.getInfos()[i]){ i--; }
        if(P.getN()-1 < ordem/2){
            if(P.getN() + Q.getN() < ordem-1){ // concatenação
                
            } else { // redistribuição
                
            }
        } else { // nao é necessario tratar
            while(i < P.getN()){
                P.setInfoPos(i, P.getInfos()[i+1]);
                i++;
            }
            P.setN(P.getN()-1);
        }
    }
}