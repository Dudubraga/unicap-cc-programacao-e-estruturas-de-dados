package Arvores.Aplicacoes;
import Arvores.ArvoreRedBlack.ARB;
import java.util.Scanner;

public class AplicacaoARB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ARB<Integer>arvore = new ARB<>();
        int op;
        do {
            System.out.println("-------------- Selecione uma Opção --------------");
            System.out.println("1 - Inserir novo nó");
            System.out.println("2 - Remover um nó");
            System.out.println("3 - Exibir em Ordem");
            System.out.println("4 - Exibir por Nível");
            System.out.println("0 - Encerrar Programa");
            System.out.println("-------------------------------------------------");
            op = scan.nextInt();
            switch (op) {
                case 1: // inserir
                    System.out.print("Número a ser inserido: ");
                    arvore.inserir(scan.nextInt());
                    break;
                case 2: // remover
                    System.out.print("Número a ser removido: ");
                    arvore.remover(scan.nextInt());
                    break;
                case 3: // em ordem
                    System.out.println("Passeio Em Ordem: ");
                    arvore.emOrdem();
                    break;
                case 4: // por nivel
                    System.out.println("Passeio Por Nível: ");
                    arvore.porNivel();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (op != 0);
        scan.close();
    }
}
