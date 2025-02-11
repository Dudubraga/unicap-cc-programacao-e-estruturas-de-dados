import Arvores.ArvoreAVL.AVL;
import Arvores.ArvoreB.AB;
import Arvores.ArvoreBinBusca.ABB;
import Arvores.ArvoreRedBlack.ARB;
// import Arvores.ClassesExtra.Dados.*;
// import Arvores.ClassesExtra.TADQueue.Queue;
// import Arvores.ClassesExtra.TADStack.Stack;

public class Teste {
    public static void main(String[] args) {
        int[] arr = {12, 27, 54, 86, 33, 41, 67, 72, 94, 29, 23, 38, 59, 107, 61, 32};
        // int[] arr = {};
        
        System.out.print("Números Inseridos: ");
        for(int i : arr){
            System.out.print(i + " ");
        }  System.out.println("\n");
        
        AB ab = new AB(5);
        // ABB<Integer> abb = new ABB<>();
        // AVL<Integer> avl = new AVL<>();
        // ARB<Integer> arb = new ARB<>();
        for(int i : arr){
            ab.inserir(i);
            // abb.inserir(i);
            // avl.insert(i);
            // arb.inserir(i);
        }
        // testeSAB(ab, arr);
        testeAB(ab);
        // testeABB(abb);
        // testeAVL(avl);
        // testeARB(arb);
    }
    public static void testeABB(ABB<Integer> abb){
        abb.buscar(10); abb.buscar(100);
        abb.maior(); abb.menor();
        abb.emOrdem(); abb.emOrdemRecursiva();
        abb.preOrdem(); abb.preOrdemRecursiva();
        abb.posOrdem(); abb.posOrdemRecursiva();
        abb.porNivel();
        abb.contarNos(); abb.contarNosRecursiva();
        abb.contarFolhas(); abb.contarFolhasRecursiva();
        abb.contarNaoTerminais(); abb.contarNaoTerminaisRecursiva();
        abb.alturaArvore();
        abb.frequenciaNode(100);
    }
    public static void testeAVL(AVL<Integer> avl){
        System.out.println("altura: " + avl.calcularAltura());
        avl.emOrdem(); 
        avl.porNivel();
    }
    public static void testeARB(ARB<Integer> arb){
        arb.emOrdem();
        arb.porNivel();
        arb.remover(70);
        arb.emOrdem();
        arb.porNivel();
        arb.inserir(70);
        arb.emOrdem();
        arb.porNivel();
    }
    public static void testeAB(AB ab){
        ab.exibirMaior(); ab.exibirMenor(); 
        ab.exibirAltura();
        ab.exibirPorNivel(); ab.exibirEmOrdem();
        ab.procurar(1); // não está
        ab.procurar(12); // está
        // ab.remover(12);
    } 
    
}
