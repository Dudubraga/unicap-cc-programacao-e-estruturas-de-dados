package AlgoritmosDeOrdenacao.HeapSort;

public class HeapSort {
    public static void main(String[] args) {
        int[] v = {18, 13, 22, 9, 10, 25, 12};
        for(int i : v){
            System.out.print(i + " ");
        } System.out.println();

        heapsort(v, v.length);
        
        for(int i : v){
            System.out.print(i + " ");
        } System.out.println();
    }
    
    static void heapsort(/*<tipo>*/int v[], int n){
        int i, r, n1;
        /*<tipo>*/int auxkey;
        i = n/2 -1;
        for(r = i; r >= 0; r--){
            heap(v, n, r);
        }
        for(n1 = n-2; n1 >= 0; n1--){
            auxkey = v[0];
            v[0] = v[n1+1];
            v[n1+1] = auxkey;
            heap(v, n1, 0);
        }
    }

    static void heap(/*<tipo>*/int v[], int n, int r){
        int i, h, troca;
        /*<tipo>*/int auxkey;
        i = r; troca = 1;
        while(troca == 1){
            troca = 0;
            if(keyval(v, n, 2*i+1) > keyval(v, n, 2*i+2)){
                h = 2*i+1;
            }else{
                h = 2*i+2;
            }
            if(v[i] < keyval(v, n, h)){
                auxkey = v[i]; 
                v[i] = v[h];
                v[h] = auxkey;
                i = h;
                troca = 1;
            }
        }
    }

    static /*<tipo>*/int keyval(/*<tipo>*/int v[], int n, int i){
        if(i > n){
            return Integer.MIN_VALUE; // menor valor de chave possivel representado (MIN_VALUE)
        }else{
            return v[i];
        }
    }
}