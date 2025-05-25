public class OrdenacaoQuickSort<T extends Comparable> extends OrdenacaoAbstract {

    public static int subproblemas = 0;
    public static double somaDosFatores = 0;
    public static int chamadasValidas = 0;
    public static int custoParticionamento = 0;

    public void ordenar() {
        subproblemas = 0;// Quantidade de chamadas recursivas o algoritmo faz em cada etapa
        somaDosFatores = 0;
        chamadasValidas = 0;
        quickSort(0, getInfo().length - 1);

        if (chamadasValidas > 0) {
            double mediaFatorDivisao = somaDosFatores / chamadasValidas;
            System.out.println("Média dos fatores de divisão (aproximado): " + mediaFatorDivisao);
        }
    }

    /*
     * a = cada chamada do método da chamada recursiva, mede o tamanho da entrada e
     * dos subproblemas.
     * b = n / subtamanho (nesse caso foi usado a média)
     * F(n) = custo de particionamento: ocorre somente quando posicaoMaior <
     * posicaoMenor, e isso acontece algumas vezes (mas não em todas as iterações)
     * 
     * ------- Custo T(n) para quickSort(0, n) --------------------
     * T(n) = 6449 * T(n/2,96) + 74194
     * ------------------------------------------------------------
     * 
     * Como a função T(n) para quickSort contém múltiplas chamadas
     * recursivas com tamanho reduzido por um fator de aproximadamente b = 2,96,
     * a função corresponde à forma geral de recorrência do Teorema Mestre:
     *
     * T(n) = a . T(n/b) + f(n), onde:
     * a = 6449
     * b = 2,96
     * f(n) = 74194
     *
     * Medindo o custo total da recursão:
     * log_b a = log_2,96 (6449)
     *
     * log_2,96 (6449) ≈ log_10(6449) / log_10(2,96)
     * ≈ 3,809 / 0,471
     * ≈ 8,085
     *
     * Como f(n) = 74194 pertence a Θ(1), e:
     * f(n) = O(n^c) com c = 0
     * c < log_b a (0 < 8,085)
     *
     * Isto caracteriza o **Caso 1 do Teorema Mestre**, que diz:
     * Se f(n) = O(n^c), com c < log_b a, então:
     * T(n) ∈ Θ(n^log_b a)
     *
     * Conclusão:
     * T(n) ∈ Θ(n^8,083)
     * ------------------------------------------------------------
     */

    private void quickSort(int inicio, int fim) {
        subproblemas++;// Calcular a quantidade de chamadas recursivas que o algoritmo faz

        if (inicio < fim) {
            int n = fim - inicio + 1;

            int pivo = particionar(inicio, fim);

            int tamEsquerda = pivo - 1 - inicio + 1;
            int tamDireita = fim - (pivo + 1) + 1;

            if (tamEsquerda > 0) {
                somaDosFatores += (double) n / tamEsquerda; // Para cada divisão do problema (chamada recursiva),
                                                            // calcula-se o fator n / subproblema para o cálculo da
                                                            // mediaFatorDivisao
                chamadasValidas++; // Calcular a quantidade de camadas válidas par a divisão do mediaFatorDivisao
            }

            if (tamDireita > 0) {
                somaDosFatores += (double) n / tamDireita; // Para cada divisão do problema (chamada recursiva),
                                                           // calcula-se o fator n / subproblema para o cálculo da
                                                           // mediaFatorDivisao
                chamadasValidas++;// Calcular a quantidade de camadas válidas par a divisão do mediaFatorDivisao
            }

            quickSort(inicio, pivo - 1);
            quickSort(pivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int posicaoMaior = inicio;
        int posicaoMenor = fim + 1;
        T pivo = (T) getInfo()[inicio];

        while (true) {
            do {
                posicaoMaior++;
                custoParticionamento++;// Incrementado a cada operação de comparação dentro de particionar
            } while (posicaoMaior <= fim && getInfo()[posicaoMaior].compareTo(pivo) < 0);

            do {
                posicaoMenor--;
                custoParticionamento++;// Incrementado a cada operação de comparação dentro de particionar
            } while (posicaoMenor >= inicio && getInfo()[posicaoMenor].compareTo(pivo) > 0);

            if (posicaoMaior >= posicaoMenor) {
                break;
            }

            trocar(posicaoMaior, posicaoMenor);
        }
        trocar(posicaoMenor, inicio);
        return posicaoMenor;
    }
}
