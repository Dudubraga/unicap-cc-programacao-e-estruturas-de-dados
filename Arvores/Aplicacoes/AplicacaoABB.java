package Arvores.Aplicacoes;
import Arvores.ClassesExtra.Cadastros.CadastroProduto;
import Arvores.ClassesExtra.Dados.Produto;
import java.util.Scanner;

public class AplicacaoABB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CadastroProduto C = new CadastroProduto();
        int op;
        String s;
        do {
            System.out.println("-------------- Selecione uma Opção --------------");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Exibir informações de todos os produtos");
            System.out.println("3 - Alterar preço de um produto");
            System.out.println("4 - Alterar quantia em estoque de um produto");
            System.out.println("5 - Exibir informações de um produto");
            System.out.println("6 - Remover um Produto");
            System.out.println("0 - Encerrar Programa");
            System.out.println("-------------------------------------------------");
            op = scan.nextInt();
            switch (op) {
                case 1: // Cadastrar
                    System.out.println("Insira o Código do produto que deseja inserir: ");
                    s = scan.next();
                    Produto p = new Produto(s);
                    C.cadastrar(p);
                    break;
                case 2: // exibir infos
                    C.exibirTodos();
                    break;
                case 3: // alterar preco
                    System.out.println("Insira o código do produto que deseja alterar o preço: ");
                    s = scan.next();
                    System.out.println("Insira o novo preço desse produto: ");
                    double preco = scan.nextDouble();
                    C.alterarPreco(s, preco);
                    break;
                case 4: // alterar qnt estoque
                    System.out.println("Insira o código do produto que deseja alterar a quantia em estoque: ");
                    s = scan.next();
                    System.out.println("Insira a nova quantia do estoque: ");
                    int estoque = scan.nextInt();
                    C.alterarEstoque(s, estoque);
                    break;
                case 5: // exibir info produto
                    System.out.println("Insira o código do produto que deseja obter as informações: ");
                    s = scan.next();
                    C.exibir(s);
                    break;
                case 6: // remover produto
                    System.out.println("Insira o código do produto que deseja remover: ");
                    s = scan.next();
                    C.removerProduto(s);
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
