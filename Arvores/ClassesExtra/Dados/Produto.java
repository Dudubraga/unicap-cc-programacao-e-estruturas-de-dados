package Arvores.ClassesExtra.Dados;

public class Produto implements Comparable <Produto>{
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int emEstoque;
    @Override
    public String toString(){
        return "Código: " + this.codigo + "\nDescrição: " + this.descricao + "\nFornecedor: "
        + this.fornecedor + "\nPreço: R$" + this.preco + "\nEm Estoque: " + emEstoque + "\n";
    }
    @Override
    public int compareTo(Produto p) {
        return this.codigo.compareTo(p.codigo);
    }   
    public Produto(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return emEstoque;
    }
    public void setEstoque(int estoque) {
        this.emEstoque = estoque;
    }
}