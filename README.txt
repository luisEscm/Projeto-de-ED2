Código fonte java do Projeto 1 de Estrutura da dados 2.
Feito por Luis Eduardo S C martins, e Lucas Pereira Ribeiro

ED 2 - 2024.1 T01

questões a serem respondidas/feitas:

Problema 1: Implemente uma versão do mergesort. Adicione um corte para vetores pequenos, teste se o vetor já
está em ordem e evite a cópia trocando argumentos no código recursivo.
  ● Use o InsertSort para subvetores pequenos. No caso da ordenação, sabemos que a ordenação
por inserção é simples e, portanto, provavelmente mais rápida do que a ordenação com o
MergeSort para sub-vetores pequenos. Mudar para a ordenação com o InsertSort para
sub-vetores pequenos (comprimento 15 ou menos, por exemplo) melhorará o tempo de
execução de uma implementação típica de mergesort em 10 a 15%.
  ● Teste se o vetor já está ordenador. É possível reduzir o tempo de execução para ser linear para
vetores que já estão ordenados, adicionando um teste para ignorar a chamada para merge()
se vetor[meio] for menor ou igual a vetor[meio+1]. Com essa alteração, ainda fazemos todas
as chamadas recursivas, mas o tempo de execução para qualquer sub-vetor ordenado é linear

Problema 2: Implemente uma versão modificada do algoritmo SelectSort. O passo de seleção do menor ou maior
item deve ser modificado para selecionar o maior e menor na mesma iteração (verifique algoritmo
minmax3 na nota de aula 2, apresentado em aula). Seguindo essa ideia, o algoritmo já organizará o
menor e o maior elemento a cada iteração.

Problema 3: Quicksort + BubbleSort: você deverá implementar a variação “mediana de três”, em que o pivô é
escolhido usando a mediana entre a chave mais à esquerda, a chave mais à direita, e a chave central.
O Quicksort deve ser executado recursivamente (como padrão) e, quando você obtiver uma partição
de tamanho menor ou igual a L, essa partição deverá ser imediatamente ordenada usando o
algoritmo do Bubble Sort. Determine empiricamente o valor de L para o qual o quicksort é executado
mais rapidamente em seu ambiente de computação para ordenar vetores aleatórios de N, para N =
102,103, 104, 105 e 106

Problema 4: Implemente um programa em java que implemente uma nova versão do HeapSort, denominada
DoubleHeapSort. Nessa versão, você deverá construir dois Heaps, um mínimo e outro máximo, para
coordenar a inserção dos elementos alternados preenchendo um vetor auxiliar ordenado, alternando
a inserção no lado esquerdo e direito. Verifique, também, a possibilidade de utilizar Threads e avalie
a diferença de desempenho

Link do github: https://github.com/luisEscm/Projeto-de-ED2/tree/main
