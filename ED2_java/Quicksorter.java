package ED2_java;

public class Quicksorter {
    private static int passos;

    /*
     * Função que cronometra o tempo de execução do quicksort modificado em nanosegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados. 
     */
    public static <T extends Comparable<? super T>> void quicksortTemporizadoNS(T[] v, int inicio, int fim, int l){
        long timeInicio = System.nanoTime();
        passos = 0;
        quicksort(v, inicio, fim, l);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim-timeInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * Função que cronometra o tempo de execução do quicksort modificado em milisegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados. 
     */
    public static <T extends Comparable<? super T>> void quicksortTemporizadoMS(T[] v, int inicio, int fim, int l){
        long timeInicio = System.currentTimeMillis();
        passos = 0;
        quicksort(v, inicio, fim, l);
        long timeFim = System.currentTimeMillis();
        System.out.println("Tempo de Inicio: " + timeInicio + "ms\nTempo de Fim: " + timeFim + "ms\nTempo Total: " + (timeFim-timeInicio) + "ms");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
    * método do quicksort usando Generics, modificado para usar o bubblesort
    * nos subvetores que tenham um tamanho menor igual a L
    */
    public static <T extends Comparable<? super T>> void quicksort(T[] v, int inicio, int fim, int l){
        if(inicio < fim){
            int posicaoPivo = particiona(v, inicio, fim);

            if(posicaoPivo-inicio > l){
                quicksort(v, inicio, posicaoPivo-1, l);
            }else{
                bubblesortQuick(v, inicio, posicaoPivo-1);
            }
            if(fim-posicaoPivo > l){
                quicksort(v, posicaoPivo+1, fim, l);
            }else{
                bubblesortQuick(v, posicaoPivo+1, fim);
            }
        }
    }

    /*
     * Função que particiona um vetor escolhendo um pivô e colocando todos os elementos menores
     * ou iguais ao pivô na esquerda dele e os elementos maiores que ele a direita dele, nessa 
     * função de partição o pivô é tido como o elemento na posição de fim-1, por causa da função
     * de mediaDeTres.
     */
    private static <T extends Comparable<? super T>> int particiona(T[] v, int inicio, int fim){
        T pivo, troca;
        mediaDeTres(v, inicio, fim);
        pivo = v[fim-1];
        int i = inicio, j = fim-1;

        while(i <= j){
            if(v[i].compareTo(pivo) < 0){
                i++;
                passos++;
            }else if(v[j].compareTo(pivo) >= 0){
                j--;
                passos++;
                passos++;
            }else{
                troca = v[i];
                v[i] = v[j];
                v[j] = troca;
                i++;
                j--;
                passos++;
                passos++;
                passos++;
            }
        }
        v[fim-1] = v[i];
        v[i] = pivo;
        passos++;
        return i;
    }

    /*
     * Função que tira a media de três de um vetor, ordenando os três valores
     * colocando o maior na posição fim, o menor no inicio e a mediana na posição
     * fim-1.
     */
    private static <T extends Comparable<? super T>> void mediaDeTres(T[] vetor, int inicio, int fim){
        int meio = (inicio + fim)/2;
        T troca;
        if(meio != inicio){
            if(vetor[meio].compareTo(vetor[inicio]) < 0){
                troca = vetor[meio];
                vetor[meio] = vetor[inicio];
                vetor[inicio] = troca;
                passos++;
            }
            passos++;

            if(vetor[meio].compareTo(vetor[fim]) > 0){
                troca = vetor[fim];
                vetor[fim] = vetor[meio];
                vetor[meio] = troca;
                passos++;
            }
            passos++;

            troca = vetor[meio];
            vetor[meio] = vetor[fim-1];
            vetor[fim-1] = troca;
            passos++;
        }else if(vetor[inicio].compareTo(vetor[fim]) > 0){
            troca = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = troca;
            passos++;
            passos++;
        }
    }

    /*
     * função bubblesort feita para executar em um subvetor que começa em inicio e termina em fim.
     */
    public static <T extends Comparable<? super T>> void bubblesortQuick(T[] vetor, int inicio, int fim){
        int n = fim-inicio+1; 
        T temp;
        for(int i=0; i < n; i++){
            for(int j=inicio+1; j <= (fim-i); j++){
                if(vetor[j-1].compareTo(vetor[j]) > 0){
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;
                    passos++;
                }
                passos++;
            }
        }
    }
}
