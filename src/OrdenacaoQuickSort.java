@SuppressWarnings("rawtypes")
public class OrdenacaoQuickSort<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    /*
     * --- Custo Q(n) para quickSort(0, n) ---
     * * Q(n) = P(n) + 2Q(n/2)
     *   Q(n) = 2Q(n/2) + 3n + 8
     * ---------------------------------------
     */
  
    /*
     * Como a função Q(n) para quickSort contém duas chamadas recursivas
     * com metade do vetor (n/2), a função corresponde a uma recorrência
     * e se enquadra perfeitamente no formato do Teorema Mestre, em que
     * T(n) = aT(n/b) + f(n). Tomando a fórmula como referência, temos:
     *
     * T(n) = Q(n) = 2Q(n/2) + 3n + 8, de modo que:
     *      a = 2
     *      b = 2
     *      f(n) = 3n + 8
     * 
     *  Medindo o custo total da recursão:
     *  log_b (a - ε) = log_2 (2 - ε)
     * 
     *  f(n) <= O(n^(log_b (a - ε)))
     *  3n + 8 <= c . n^(log_2 (2 - ε))
     * 
     *  -> Para ser verdadeiro, n precisa ter expoente 1, e, para tanto:
     *    𝜀 = 0; log_2 (2 - 1) = 1
     * 
     *  3n + 8 <= c . n^1 (VERDADEIRO)
     * 
     *  Ou seja, o crescimento do custo da recursão é proporcional ao 
     *  crescimento de n, o que configura o caso 2, onde 𝜀 = 0.
     * 
     *  Assim, temos que:
     *      1. f(n) pertence a teta(n^(log_b a));
     *      2. T(n) pertence a teta(n^(log_b a) log n);
     *      2. Como n^log_b a = 1, então T(n) pertence a teta(n log n).
     */

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) { // 1
            int pivo = particionar(inicio, fim); // P(n)
            quickSort(inicio, pivo - 1); // Q(n/2)
            quickSort(pivo + 1, fim); // Q(n/2)
        }
    }

    /*
     * ------- Custo P(n) para particionar(0, n) ------------------
     * * P(n) = Operações básicas + do while's + if + break 
     *  P(n) = 7 + n/2 . 2 +  n/2 . 1 + n/2 . 3 + 1
     *  P(n) = 6n/2 + 8
     *  P(n) = 3n + 8
     * ------------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    private int particionar(int inicio, int fim) {
        int posicaoMaior = inicio; // 1
        int posicaoMenor = fim + 1; // 1
        T pivo = (T) getInfo()[inicio]; // 1

        while (true) {
            do {
                posicaoMaior++; // 1
            } while (posicaoMaior <= fim && getInfo()[posicaoMaior].compareTo(pivo) < 0); // n/2 
        
            do {
                posicaoMenor--; // 1
            } while (posicaoMenor >= inicio && getInfo()[posicaoMenor].compareTo(pivo) > 0); // n/2 
        
            /* Obs.: a soma das execuções dos dois do while deve ser menor ou igual a n. 
             * As execuções são limitadas até que posicaoMaior e posicaoMenor se cruzem.
             * Usar n/2 para ambos é uma estimativa.
            */

            if (posicaoMaior >= posicaoMenor) { // n/2 . 1
                break; // 1
            }

            trocar(posicaoMaior, posicaoMenor); // n/2 . 3
        }
        trocar(posicaoMenor, inicio); // 3
        return posicaoMenor; // 1
    }
}
