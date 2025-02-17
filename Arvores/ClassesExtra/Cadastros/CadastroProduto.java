package ClassesExtra.Cadastros;
import ArvoreBinBusca.ABB;
import ClassesExtra.Dados.Produto;

public class CadastroProduto {
    private ABB<Produto> dados;

    public CadastroProduto(){
        this.dados = new ABB<Produto>();
    }
    public void cadastrar(Produto p){
        dados.inserir(p);
    }
    public void exibir(String cod){
        Produto p = buscarProduto(cod);
        if(p == null){
            System.out.println("Produto não encontrado");
        }else{
            System.out.println(p);
        }
    }
    private Produto buscarProduto(String cod){
        Produto p = new Produto(cod);
        Produto aux = dados.buscar(p);
        return aux;
    }
    public void removerProduto(String cod){
        Produto p = new Produto(cod);
        dados.remover(p);
    }
    public void exibirTodos(){
        System.out.println();
        dados.emOrdemRecursiva();
    }
    public void alterarPreco(String cod, double qnt){
        Produto p = buscarProduto(cod);
        if(p == null){
            System.out.println("Código de produto inválido");
        }else{
            p.setPreco(qnt);
            System.out.println("Alteração realizada");
        }
    }
    public void alterarEstoque(String cod, int qnt){
        Produto p = buscarProduto(cod);
        if(p == null){
            System.out.println("Código de produto inválido");
        }else{
            p.setEstoque(qnt);
            System.out.println("Alteração realizada");
        }
    }
}
