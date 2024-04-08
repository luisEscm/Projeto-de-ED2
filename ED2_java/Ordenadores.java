package ED2_java;


public class Ordenadores <T extends Comparable<? super T>>{
    /*
     * método do quicksort usando Generics
     */
    public void quicksortGeneric(T[] v, int inicio, int fim){
        if(inicio < fim){
            int posicaoPivo = particionaGeneric(v, inicio, fim);

            quicksortGeneric(v, inicio, posicaoPivo-1);
            quicksortGeneric(v, posicaoPivo+1, fim);
        }
    }

    private int particionaGeneric(T[] v, int inicio, int fim){
        T pivo = v[fim];
        int i = inicio, j = fim-1;

        while(i <= j){
            if(v[i].compareTo(pivo) <= 0){
                i++;
            }else if(v[j].compareTo(pivo) > 0){
                j--;
            }else{
                T troca = v[i];
                v[i] = v[j];
                v[j] = troca;
                i++;
                j--;
            }
        }
        v[fim] = v[i];
        v[i] = pivo;
        return i;
    }

    /*
     * método do mergesort usando Generics
     */
    public T[] mergesort(T[] vetor){
        T[] temp = vetor.clone();

        return mergeMain(vetor, temp, 0, vetor.length - 1);
    }

    private T[] mergeMain(T[] vetor, T[] temp, int inicio, int fim){
        int meio;
        if(inicio < fim){
            meio = (inicio + fim)/2;
            mergeMain(vetor, temp, inicio, meio);
            mergeMain(vetor, temp, meio+1, fim);
            merge(vetor, temp, inicio, meio+1, fim);
        }
        return vetor;
    }

    private void merge(T[] vetor, T[] temp, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos-1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(vetor[esqPos].compareTo(vetor[dirPos]) <= 0){
                temp[tempPos++] = vetor[esqPos++];
            }else{
                temp[tempPos++] = vetor[dirPos++];
            }
        }
        while(esqPos <= esqFim){
            temp[tempPos++] = vetor[esqPos++];
        }
        while(dirPos <= dirFim){
            temp[tempPos++] = vetor[dirPos++];
        }
        for(int i = 0; i<numElem; i++, dirFim--){
            vetor[dirFim] = temp[dirFim];
        }

    }

    /*
     * método mergesort com alterações, como:
     * Usar o insertsort para subvetores menores que que 15;
     * Fazendo um teste para ver se o vetor já está ordenado assim
     * ignorando a chamada para o merge;
     * E reduzindo o uso de memoria auxiliar.
     */
    public T[] newMergesort(T[] vetor){

        return newMergeMain(vetor, 0, vetor.length - 1);
    }

    private T[] newMergeMain(T[] vetor, int inicio, int fim){
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

    private void newMerge(T[] vetor, int esqPos, int dirPos, int dirFim){
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
        }
        while(esqPos <= esqFim){
            temp[tempPos++] = vetor[esqPos++];
        }
        while(dirPos <= dirFim){
            temp[tempPos++] = vetor[dirPos++];
        }
        for(int i = 0; i<numElem; i++, dirFim--){
            vetor[dirFim] = temp[dirFim];
        }

    }

    public void insertsortMerge(T[] vetor, int inicio, int fim){
        int i, j;
        T chave;
        for(j = inicio+1; j <= fim; j++){
            chave = vetor[j];
            i = j-1;
            while(i >= inicio && vetor[i].compareTo(chave) > 0){
                vetor[i+1] = vetor[i];
                i--;
            }
            vetor[i+1] = chave;
        }
    }

    public void bubblesort(T[] vetor){
        int n = vetor.length;  
        T temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(vetor[j-1].compareTo(vetor[j]) > 0){
                    //swap elements
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }

    /*
    * método do quicksort usando Generics, modificado para usar o bubblesort
    * nos subvetores que tenham um tamanho menor igual a L
    */
    public void newQuicksortIniciador(T[] v, int inicio, int fim, int l){
        long timeInicio = System.nanoTime();
        newQuicksort(v, inicio, fim, l);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim-timeInicio) + "ns");
    }

    public void newQuicksort(T[] v, int inicio, int fim, int l){
        if(inicio < fim){
            int posicaoPivo = newParticiona(v, inicio, fim);

            if(posicaoPivo-inicio > l){
                newQuicksort(v, inicio, posicaoPivo-1, l);
            }else{
                bubblesortQuick(v, inicio, posicaoPivo-1);
            }
            if(fim-posicaoPivo > l){
                newQuicksort(v, posicaoPivo+1, fim, l);
            }else{
                bubblesortQuick(v, posicaoPivo+1, fim);
            }
        }
    }

    private int newParticiona(T[] v, int inicio, int fim){
        T pivo, troca;
        mediaDeTres(v, inicio, fim);
        pivo = v[fim-1];
        int i = inicio, j = fim-1;

        while(i <= j){
            if(v[i].compareTo(pivo) < 0){
                i++;
            }else if(v[j].compareTo(pivo) >= 0){
                j--;
            }else{
                troca = v[i];
                v[i] = v[j];
                v[j] = troca;
                i++;
                j--;
            }
        }
        v[fim-1] = v[i];
        v[i] = pivo;
        return i;
    }

    private void mediaDeTres(T[] vetor, int inicio, int fim){
        int meio = (inicio + fim)/2;
        T troca;
        if(meio != inicio){
            if(vetor[meio].compareTo(vetor[inicio]) < 0){
                troca = vetor[meio];
                vetor[meio] = vetor[inicio];
                vetor[inicio] = troca;
            }
            if(vetor[meio].compareTo(vetor[fim]) > 0){
                troca = vetor[fim];
                vetor[fim] = vetor[meio];
                vetor[meio] = troca;
            }
            troca = vetor[meio];
            vetor[meio] = vetor[fim-1];
            vetor[fim-1] = troca;
        }else if(vetor[inicio].compareTo(vetor[fim]) > 0){
            troca = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = troca;
        }
    }

    public void bubblesortQuick(T[] vetor, int inicio, int fim){
        int n = fim-inicio+1; 
        T temp;
        for(int i=0; i < n; i++){
            for(int j=inicio+1; j <= (fim-i); j++){
                if(vetor[j-1].compareTo(vetor[j]) > 0){
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }

}
