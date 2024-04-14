/*
 * Código fonte java do Projeto 1 de Estrutura da dados 2.
 * Feito por Luis Eduardo S C martins, e Lucas Pereira Ribeiro
 *
 * ED 2 - 2024.1 T01
 */

public class Selectsorter {
    private static int passos;

    /*
     * Função que cronometra o tempo de execução do selectsort em nanosegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void selectsortTemporizadoNS(T[] v){
        long timeInicio = System.nanoTime();
        passos = 0;
        selectsort(v);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim-timeInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * Função que cronometra o tempo de execução do selectsort em milisegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void selectsortTemporizadoMS(T[] v){
        long timeInicio = System.currentTimeMillis();
        passos = 0;
        selectsort(v);
        long timeFim = System.currentTimeMillis();
        System.out.println("Tempo de Inicio: " + timeInicio + "ms\nTempo de Fim: " + timeFim + "ms\nTempo Total: " + (timeFim-timeInicio) + "ms");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * método do selectsort usando Generics
     */
    public static <T extends Comparable<? super T>> void selectsort(T[] v){
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].compareTo(v[minIndex]) < 0) {
                    minIndex = j;
                    passos++;
                }
                passos++;
            }
            if (minIndex != i) {
                T temp = v[i];
                v[i] = v[minIndex];
                v[minIndex] = temp;
                passos++;
                passos++;
                passos++;
            }
        }
    }
    /*
     * Função que cronometra o tempo de execução do selectsort modificado em nanosegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void modifiedSelectsortTemporizadoNS(T[] v) {
        long timeInicio = System.nanoTime();
        passos = 0;
        modifiedSelectsort(v);
        long timeFim = System.nanoTime();
        System.out.println("Tempo de Inicio: " + timeInicio + "ns\nTempo de Fim: " + timeFim + "ns\nTempo Total: " + (timeFim - timeInicio) + "ns");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * Função que cronometra o tempo de execução do selectsort modificado em milisegundos
     * e faz um print na tela mostrando o tempo inicial, o final e o tempo total
     * de execução, além de também mostrar a quantidade de passos executados.
     */
    public static <T extends Comparable<? super T>> void modifiedSelectsortTemporizadoMS(T[] v) {
        long timeInicio = System.currentTimeMillis();
        passos = 0;
        modifiedSelectsort(v);
        long timeFim = System.currentTimeMillis();
        System.out.println("Tempo de Inicio: " + timeInicio + "ms\nTempo de Fim: " + timeFim + "ms\nTempo Total: " + (timeFim - timeInicio) + "ms");
        System.out.println("Quantidade de passos: " + passos);
    }

    /*
     * método do selectsort modificado usando Generics
     */
    public static <T extends Comparable<? super T>> void modifiedSelectsort(T[] v) {
        int n = v.length;
        for (int i = 0; i < n / 2; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j < n - i; j++) {
                if (v[j].compareTo(v[minIndex]) < 0) {
                    minIndex = j;
                    passos++;
                } else if (v[j].compareTo(v[maxIndex]) > 0) {
                    maxIndex = j;
                    passos++;
                }
                passos++;
            }
            if (minIndex != i) {
                T temp = v[i];
                v[i] = v[minIndex];
                v[minIndex] = temp;
                passos++;
            }
            if (maxIndex != n - i - 1) {
                T temp = v[n - i - 1];
                v[n - i - 1] = v[maxIndex];
                v[maxIndex] = temp;
                passos++;
            }
        }
    }
}
