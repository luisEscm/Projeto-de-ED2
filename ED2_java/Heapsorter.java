/*
 * Código fonte java do Projeto 1 de Estrutura da dados 2.
 * Feito por Luis Eduardo S C martins, e Lucas Pereira Ribeiro
 *
 * ED 2 - 2024.1 T01
 */

public class Heapsorter {
    private static int passos;

    /*
     * Função que cronometra o tempo de execução do heapsort em nanosegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void heapsortTemporizadoNS(T[] v) {
        long timeInicio = System.nanoTime();
        passos = 0;
        heapsort(v);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim - timeInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    public static <T extends Comparable<? super T>> void heapsort(T[] v) {
        int n = v.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(v, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = v[0];
            v[0] = v[i];
            v[i] = temp;

            heapify(v, i, 0);
        }
    }

    private static <T extends Comparable<? super T>> void heapify(T[] v, int n, int i) {
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

            heapify(v, n, largest);
        }
    }
}
