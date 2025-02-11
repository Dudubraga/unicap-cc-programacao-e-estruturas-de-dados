package AlgoritmosDeOrdenacao.ClassesExtra;

public class Aluno implements Comparable <Aluno> {
    private String matr;
    private String nome;
    private double nota;
    private int faltas;

    public Aluno(String matr, String nome, double nota, int faltas) {
        this.matr = matr;
        this.nome = nome;
        this.nota = nota;
        this.faltas = faltas;
    }
    
    public String getMatr() {
        return matr;
    }
    public void setMatr(String matr) {
        this.matr = matr;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public int getFaltas() {
        return faltas;
    }
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override // QuickSort
    public int compareTo(Aluno a) {
        if(this.nota < a.getNota()){ return -1; }
        else if(this.nota > a.getNota()){ return 1; }
        else{ return 0; }
    }
    // @Override // HeapSort
    // public int compareTo(Aluno a) {
    //     if(this.faltas < a.getFaltas()){ return -1; }
    //     else if(this.faltas > a.getFaltas()){ return 1; }
    //     else{ return 0; }
    // }
}
