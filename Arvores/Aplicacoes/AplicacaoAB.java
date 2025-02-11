package Arvores.Aplicacoes;
import Arvores.ArvoreB.AB;
import java.util.Scanner;

public class AplicacaoAB {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira a ordem da árvore: ");
        AB arvore = new AB(scan.nextInt());
        int op;
        do {
            System.out.println("-------------- Selecione uma Opção --------------");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Exibir a maior chave armazenada");
            System.out.println("3 - Exibir a menor chave armazenada");
            System.out.println("4 - Exibir altura");
            System.out.println("5 - Procurar um valor");
            System.out.println("6 - Exibir por Nível");
            System.out.println("7 - Exibir em Ordem");
            System.out.println("8 - Remover um valor");
            System.out.println("0 - Encerrar Programa");
            System.out.println("-------------------------------------------------");
            op = scan.nextInt();
            switch (op) {
                case 1 -> { // Inserir
                    System.out.print("Número para inserir: ");
                    arvore.inserir(scan.nextInt());
                }
                case 2 -> { // Maior
                    arvore.exibirMaior();
                }
                case 3 -> { // Menor
                    arvore.exibirMenor();
                }
                case 4 -> { // Altura
                    arvore.exibirAltura();
                }
                case 5 -> { // Procurar
                    System.out.println("Número para procurar: ");
                    arvore.procurar(scan.nextInt());
                }
                case 6 -> { // Por Nível
                    arvore.exibirPorNivel();
                }
                case 7 -> { // Em Ordem
                    arvore.exibirEmOrdem();
                }
                case 8 -> { // Remover
                    System.out.println("Número para remover: ");
                    arvore.remover(scan.nextInt());
                }
                case 0 -> { System.out.println("Encerrando..."); }
                default -> { System.out.println("Opção inválida."); }
            }
        } while (op != 0);
        scan.close();
    }
}
