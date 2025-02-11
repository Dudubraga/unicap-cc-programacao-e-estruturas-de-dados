package AlgoritmosDeOrdenacao.QuickSort;

public class QuickSort {
    @SuppressWarnings("FieldMayBeFinal")
    private char ordem; // C - crescente | D - decrescente

    public QuickSort(char c){
        this.ordem = c;
    }

    public <T extends Comparable<T>> void quicksort (T[] v, int i, int f){
        int k;
        if (f > i){
            k = particao (v, i, f); // S2
            quicksort(v, i, k-1); // seguimento S1
            quicksort(v, k+1, f); // seguimento S3
        }
    }
    
    private <T extends Comparable<T>> int particao(T[] v, int i, int f){
        T pivot = v[i];
        char lado = 'E';
        while(i < f){
            if(lado == 'E'){ // < crescente | > decresente
                if((this.ordem == 'C' && v[f].compareTo(pivot) < 0) 
                || (this.ordem == 'D' && v[f].compareTo(pivot) > 0)){
                    v[i] = v[f];
                    lado = 'D'; i++;
                } else {
                    f--;
                }
            } else { // < crescente | > decresente
                if((this.ordem == 'C' && v[i].compareTo(pivot) < 0) 
                || (this.ordem == 'D' && v[i].compareTo(pivot) > 0)){
                    i++;
                } else {
                    v[f] = v[i];
                    lado = 'E'; f--;
                }
            }
        }
        v[i] = pivot;
        return i;
    }
}