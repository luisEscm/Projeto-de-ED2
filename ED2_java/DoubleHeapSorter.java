/*
 * Código fonte java do Projeto 1 de Estrutura da dados 2.
 * Feito por Luis Eduardo S C martins, e Lucas Pereira Ribeiro
 *
 * ED 2 - 2024.1 T01
 */

public class DoubleHeapSorter {
    private static int passos;

    /*
     * Função que cronometra o tempo de execução do DoubleHeapSort em nanosegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void doubleHeapsortTemporizadoNS(T[] v) {
        long timeInicio = System.nanoTime();
        passos = 0;
        doubleHeapsort(v);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim - timeInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * Função do heapsort mas utilizando um min-heap e um max-heap ao mesmo tempo
     */
    public static <T extends Comparable<? super T>> void doubleHeapsort(T[] v){
        T[] maxheap = v.clone();
        T[] minheap = v.clone();
        T temp;
        int n = v.length;
        int inicio, fim;
        inicio = 0;
        fim = n-1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(maxheap, n, i);
            minHeapify(minheap, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            temp = maxheap[0];
            maxheap[0] = maxheap[i];
            maxheap[i] = temp;
            v[fim--] = temp;

            temp = minheap[0];
            minheap[0] = minheap[i];
            minheap[i] = temp;
            v[inicio++] = temp;
            if(inicio >= fim){
                break;
            }

            maxHeapify(maxheap, i, 0);
            minHeapify(minheap, i, 0);
        }
    }

    /*
     * Função heapify para max-heap
     */
    private static <T extends Comparable<? super T>> void maxHeapify(T[] v, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && v[left].compareTo(v[largest]) > 0) {
            largest = left;
        }

        if (right < n && v[right].compareTo(v[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T swap = v[i];
            v[i] = v[largest];
            v[largest] = swap;
            passos++;

            maxHeapify(v, n, largest);
        }
    }

    /*
     * Função heapify para min-heap
     */
    private static <T extends Comparable<? super T>> void minHeapify(T[] v, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && v[left].compareTo(v[smallest]) < 0) {
            smallest = left;
        }

        if (right < n && v[right].compareTo(v[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != i) {
            T swap = v[i];
            v[i] = v[smallest];
            v[smallest] = swap;
            passos++;

            minHeapify(v, n, smallest);
        }
    }
}
