package ED2_java;

import java.util.Random;

public class Main{
    public static <T> void main(String [] args){
        //for(int i = 0; i < 10; i++){
            Integer[] ints = vectorGerator();
            Integer[] ints2 = ints.clone();
            System.out.println("Teste vetor");
            System.out.println("Vetor de entrada: " + java.util.Arrays.toString(ints) + "\n");
            for(int j = 15; j <= 25; j++){
                System.out.println("\n--------------------\nVetor de tamanho " + ints.length + ", L = " + j);
                Ordenadores<Integer> intSorter = new Ordenadores<>();

                intSorter.newQuicksortIniciador(ints, 0, ints.length - 1, j);

                //System.out.println("\nVetor de saida: " + java.util.Arrays.toString(ints));
                System.out.println("\n--------------------\n");
                ints = ints2.clone();
            }
        //}
    }

    private static Integer[] geradorVetor(){
        Random random = new Random();
        int n = random.nextInt(13) + 8;

        Integer[] vet = new Integer[n];
        for(int i = 0; i < n; i++){
            vet[i] = random.nextInt(121);
        }
        return vet;
    }

    private static Integer[] vectorGerator(){
        Integer[] vet = new Integer[1000];
        Random random = new Random();

        for(int i = 0; i < 1000; i++){
            vet[i] = random.nextInt(601);
        }
        return vet;
    }

}