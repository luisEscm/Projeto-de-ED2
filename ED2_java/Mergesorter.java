package ED2_java;

public class Mergesorter {
    private static int passos;
    
    /*
     * Função que temporiza o tempo da função normal do mergesort em nanosegundos,
     * tambem mostra a quantidade de passos executados
     */
    public static<T extends Comparable<? super T>> void mergesortTemporizadoNS(T[] vetor){
        long tempInicio, tempFim;
        passos = 0;
        tempInicio = System.nanoTime();
        mergesort(vetor);
        tempFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + tempInicio + "ns\nTempo de Fim: " + tempFim + "ns\nTempo Total: " + (tempFim-tempInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * Função normal de mergesort
     */
    public static <T extends Comparable<? super T>> T[] mergesort(T[] vetor){
        return  mergeMain(vetor, 0, vetor.length-1);
    }

    /*
     * Função recursiva do mergesort
     */
    private static <T extends Comparable<? super T>> T[] mergeMain(T[] vetor,int inicio,int fim){
        int meio;
        if(inicio < fim){
            meio = (inicio+fim)/2;
            mergeMain(vetor, inicio, meio);
            mergeMain(vetor, meio+1, fim);

            merge(vetor, inicio, meio+1, fim);
        }
        return vetor;
    }

    /*
     * Função merge que ordena os elementos de dois subvetores no vetor principal
     */
    private static <T extends Comparable<? super T>> void merge(T[] vetor,int esqPos,int dirPos, int dirFim){
        int esqFim = dirPos-1;
        T[] temp = vetor.clone();
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(vetor[esqPos].compareTo(vetor[dirPos]) <= 0){
                temp[tempPos++] = vetor[esqPos++];
            }else{
                temp[tempPos++] = vetor[dirPos++];
            }
            passos++;
            passos++;
        }

        while(esqPos <= esqFim){
            temp[tempPos++] = vetor[esqPos++];
            passos++;
        }

        while(dirPos <= dirFim){
            temp[tempPos++] = vetor[dirPos++];
            passos++;
        }

        for(int i = 0; i<numElem; i++, dirFim--){
            vetor[dirFim] = temp[dirFim];
            passos++;
        }
    }

    /*
     * Função que temporiza o tempo de execução do mergesort modificado em nanosegundos,
     * tambem é mostrado a quantidade de passos executados.
     */
    public static<T extends Comparable<? super T>> void newMergesortTemporizadoNS(T[] vetor){
        long tempInicio, tempFim;
        passos = 0;
        tempInicio = System.nanoTime();
        newMergesort(vetor);
        tempFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + tempInicio + "ns\nTempo de Fim: " + tempFim + "ns\nTempo Total: " + (tempFim-tempInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * método mergesort com alterações, como:
     * Usar o insertsort para subvetores menores que que 15;
     * Fazendo um teste para ver se o vetor já está ordenado assim
     * ignorando a chamada para o merge;
     * E reduzindo o uso de memoria auxiliar.
     */
    public static <T extends Comparable<? super T>> T[] newMergesort(T[] vetor){
        Boolean ordenado = isSorted(vetor, 0, vetor.length-1);
        if(ordenado == false){
            return newMergeMain(vetor, 0, vetor.length - 1);
        }else{
            return vetor;
        }
    }

    /*
     * Função de recursão do mergesort modificado, onde é feito uma verificação se 
     * o subvetor é maior que 15, se sim segue fazendo a recursão, se não ele chama a função
     * insertsort para ordenar aquele subvetor, tambem é feito a verificação se o ultimo
     * elemento do subvetor esquerdo é menor que o primeiro elemento do subvetor direito
     * se sim então já estão ordenados.
     */
    private static <T extends Comparable<? super T>> T[] newMergeMain(T[] vetor, int inicio, int fim){
        int meio;
        if(inicio < fim){
            meio = (inicio + fim)/2;
            
            if((meio-inicio)+1 > 15){
                newMergeMain(vetor, inicio, meio);
            }else{
                insertsortMerge(vetor, inicio, meio);
            }
            
            if((fim-meio) > 15){
                newMergeMain(vetor, meio+1, fim);
            }else{
                insertsortMerge(vetor, meio+1, fim);
            }

            if(vetor[meio].compareTo(vetor[meio+1]) > 0){
                newMerge(vetor, inicio, meio+1, fim);
            }
        }
        return vetor;
    }

    /*
     * função padrão de merge do mergesort
     */
    private static <T extends Comparable<? super T>> void newMerge(T[] vetor, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos-1;
        T[] temp = vetor.clone();
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(vetor[esqPos].compareTo(vetor[dirPos]) <= 0){
                temp[tempPos++] = vetor[esqPos++];
            }else{
                temp[tempPos++] = vetor[dirPos++];
            }
            passos++;
            passos++;
        }
        while(esqPos <= esqFim){
            temp[tempPos++] = vetor[esqPos++];
            passos++;
        }
        while(dirPos <= dirFim){
            temp[tempPos++] = vetor[dirPos++];
            passos++;
        }
        for(int i = 0; i<numElem; i++, dirFim--){
            vetor[dirFim] = temp[dirFim];
            passos++;
        }

    }

    /*
     * função insertsort para um subvetor que começa em inicio e termina em fim.
     */
    public static <T extends Comparable<? super T>> void insertsortMerge(T[] vetor, int inicio, int fim){
        int i, j;
        T chave;
        for(j = inicio+1; j <= fim; j++){
            chave = vetor[j];
            i = j-1;
            while(i >= inicio && vetor[i].compareTo(chave) > 0){
                vetor[i+1] = vetor[i];
                i--;
                passos++;
                passos++;
            }
            vetor[i+1] = chave;
            passos++;
        }
    }

    /*
     * Função verifica se um vetor está ordenado
     */
    public static <T extends Comparable<? super T>> Boolean isSorted(T[] vetor, int inicio, int fim){
        Boolean ordenado = true;
        int i = inicio;
        while(i < fim && ordenado == true){
            if(vetor[i].compareTo(vetor[i+1]) > 0){
                ordenado = false;
            }
            passos++;
            i++;
        }
        return ordenado;
    }
}
