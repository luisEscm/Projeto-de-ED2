package ED2_java;

import java.util.Random;

public class Main{
    public static <T> void main(String [] args){
        testeMergesort(1000);
    }

    private static Integer[] vectorGerator(int n){
        Integer[] vet = new Integer[n];
        Random random = new Random();

        for(int i = 0; i < n; i++){
            vet[i] = random.nextInt(301);
        }
        return vet;
    }

    public static void testeQuicksortL(int n){
        Integer[] ints = vectorGerator(n);
        Integer[] ints2 = ints.clone();
        Integer[] ints3 = ints.clone();
        Quicksorter.quicksort(ints.clone(), 0, ints.length-1, 5);
        int l1 = 15, l2 = 10, l3 = 5;
        System.out.println("Teste vetor");
        System.out.println("\n--------------------\nVetor de tamanho " + ints3.length + ", L = " + l3);

        Quicksorter.quicksortTemporizadoNS(ints3, 0, ints3.length - 1, l3);

        System.out.println("\n--------------------\n");
        System.out.println("\n--------------------\nVetor de tamanho " + ints2.length + ", L = " + l2);

        Quicksorter.quicksortTemporizadoNS(ints2, 0, ints2.length - 1, l2);

        System.out.println("\n--------------------\n");
        System.out.println("\n--------------------\nVetor de tamanho " + ints.length + ", L = " + l1);

        Quicksorter.quicksortTemporizadoNS(ints, 0, ints.length - 1, l1);

        System.out.println("\n--------------------\n");
    }

    public static void testeMergesort(int n){
        Integer[] ints = vectorGerator(n);
        Integer[] ints2 = ints.clone();
        //Mergesorter.newMergesort(ints.clone());
        //System.out.println("Vetor de entrada: " + java.util.Arrays.toString(ints) + "\n newMergesort");
        System.out.println("-----------------------------------------");
        System.out.println("Vetor de tamanho " + ints.length + ", mergesort modificado\n");
        Mergesorter.newMergesortTemporizadoNS(ints);
        System.out.println("-----------------------------------------");
        
        //System.out.println("Vetor de saida: " + java.util.Arrays.toString(ints) + "\n mergesort");
        System.out.println("-----------------------------------------");
        System.out.println("Vetor de tamanho " + ints2.length + ", mergesort\n");
        Mergesorter.mergesortTemporizadoNS(ints2);
        System.out.println("-----------------------------------------");
        //System.out.println("Vetor de saida: " + java.util.Arrays.toString(ints2));
    }

}
