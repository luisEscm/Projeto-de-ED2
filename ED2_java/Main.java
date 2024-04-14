/*
 * Código fonte java do Projeto 1 de Estrutura da dados 2.
 * Feito por Luis Eduardo S C martins, e Lucas Pereira Ribeiro
 *
 * ED 2 - 2024.1 T01
 */

import java.util.Random;

public class Main{
    public static <T> void main(String [] args){
        //testeMergesort(1000);
        //testeSelectsort(1000);
        //testeQuicksortL(10);
        testeHeapsort(100000000);
        //testeDoubleHeapsort(10);
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

    public static void testeSelectsort(int n) {
        Integer[] ints = vectorGerator(n);
        Integer[] ints2 = ints.clone();
        //Integer[] ints3 = vectorGerator(n);

        System.out.print("\nTeste Selectsort:");
        //System.out.print("Vetor de entrada: " + Arrays.toString(ints));
        System.out.println("\n--------------------\nVetor de tamanho " + ints.length);

        Selectsorter.selectsortTemporizadoNS(ints);
        //System.out.print("Vetor Ordenado: " + Arrays.toString(ints));
        System.out.print("--------------------\n");

        System.out.print("\nTeste Selectsort Modificado:\n");
        //System.out.print("Vetor de entrada: " + Arrays.toString(ints2));
        System.out.println("--------------------\nVetor de tamanho " + ints2.length);

        Selectsorter.modifiedSelectsortTemporizadoNS(ints2);
        //.out.print("Vetor Ordenado: " + Arrays.toString(ints2));

        System.out.println("--------------------\n");
    }

    public static void testeHeapsort(int n) {
        Integer[] ints = vectorGerator(n);
        Integer[] ints2 = ints.clone();

        System.out.print("\nTeste HeapSort:");
        //System.out.print("Vetor original: " + Arrays.toString(ints));
        System.out.print("\n--------------------\nVetor de tamanho " + ints.length);
        System.out.println("\nHeapsort com temporizador (em nanossegundos):");
        Heapsorter.heapsortTemporizadoNS(ints);
        //System.out.println("Vetor ordenado: " + Arrays.toString(ints));
        System.out.println("--------------------");

        System.out.print("\nTeste DoubleHeapSort:");
        //System.out.print("\nVetor original: " + Arrays.toString(ints2));
        System.out.println("\n--------------------\nVetor de tamanho " + ints2.length);
        System.out.println("\nDoubleHeapSort com temporizador (em nanossegundos):");
        DoubleHeapSorter.doubleHeapsortTemporizadoNS(ints2);
        //System.out.println("Vetor ordenado: " + Arrays.toString(ints2));
        System.out.println("--------------------\n");
    }
}
