/* 
* Converta o grafo representado por uma matriz de adjacência, int[][], 
* em uma lista de adjacência LinkedList<LinkedList<Integer>> e vice-versa.
*/
package Represetancao;

import java.util.LinkedList;

public class Representacao {
    public LinkedList<LinkedList<Integer>> listaAdj;
    public int[][] matrizAdj;

    public LinkedList<LinkedList<Integer>>  matriz2lista(int[][] grafoMatrizAdj){
        int size = grafoMatrizAdj.length;
        LinkedList<LinkedList<Integer>> grafoListaAdj = new LinkedList<>();
        for(int i = 0; i < size; i++){
            LinkedList<Integer> arestas = new LinkedList<>();
            for(int j = 0; j < size; j++){
                if(grafoMatrizAdj[i][j] != 0){
                    arestas.add(j);
                }
            }
            grafoListaAdj.add(arestas);
        }
        return grafoListaAdj;
    }

    public int[][] lista2matriz(LinkedList<LinkedList<Integer>> grafoListaAdj){
        int size = grafoListaAdj.size();
        int[][] grafoMatrizAdj = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int aresta : grafoListaAdj.get(i)){
                grafoMatrizAdj[i][aresta] = 1;
            }
        }
        return grafoMatrizAdj;
    }
}
