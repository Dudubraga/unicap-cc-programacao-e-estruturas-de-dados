package AlgoritmosDeOrdenacao.QuickSort;
import AlgoritmosDeOrdenacao.ClassesExtra.Aluno;

public class Main {
    public static void main(String[] args) {
        sortInteiros(); // Questão 4
        sortStrings(); // Questão 5
        sortNotasAlunos(); // Questão 6
    }
    
    public static void sortInteiros(){
        QuickSort qSort = new QuickSort('D'); // C - crescente | D - decrescente 

        Integer[] v = {59, 17, 42, 23, 75, 9, 34};
        qSort.quicksort(v, 0, v.length-1);

        System.out.println("Vetor de Inteiros (ordem decrescente):");
        for(Integer i : v){
            System.out.println(i);
        } System.out.println();
    }

    public static void sortStrings(){
        QuickSort qSort = new QuickSort('C'); // C - crescente | D - decrescente

        String[] v = {"eduardo", "julia", "isabela", "henrique", "isadora", "malu"};
        qSort.quicksort(v, 0, v.length-1);

        System.out.println("Vetor de Strings (ordem crescente):");
        for(String s : v){
            System.out.println(s);
        } System.out.println();
    }

    public static void sortNotasAlunos(){
        QuickSort qSort = new QuickSort('D'); // C - crescente | D - decrescente

        double[] v = {5.9, 1.7, 4.2, 2.3, 7.5, 9.0, 3.4};
        Aluno[] alunos = new Aluno[v.length];
        for(int i = 0; i < v.length; i++){
            Aluno a = new Aluno(null, null, v[i], 0);
            alunos[i] = a;
        }
        qSort.quicksort(alunos, 0, v.length-1);
    
        System.out.println("Vetor de Alunos (ordem decresente de notas):");
        for(Aluno a : alunos){
            System.out.println(a.getNota());
        } System.out.println();
    }
}
