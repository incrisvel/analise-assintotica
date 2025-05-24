@SuppressWarnings("rawtypes")
public class OrdenacaoMergeSort<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    /*
     * --- Custo S(n) para mergeSort(0, n) ---
     * * S(n) = 2 + 2 . S(n/2) + M(n)
     * S(n) = 2 + 2 . S(n/2) + 9n + 8
     * S(n) = 9n + 10 + 2.S(n/2)
     * S(n) = 2.S(n/2) + 9n + 10 
     * ---------------------------------------
     */

    /*
     * Como a função S(n) para mergeSort contém duas chamadas recursivas
     * com metade do vetor (n/2), a função corresponde a uma recorrência
     * e se enquadra perfeitamente no formato do Teorema Mestre, em que
     * T(n) = aT(n/b) + f(n). Tomando a fórmula como referência, temos:
     *
     *  S(n) = T(n) = 2T(n/2) + 9n + 10, de modo que:
     *      a = 2
     *      b = 2
     *      f(n) = 9n + 10
     * 
     *  Medindo o custo total da recursão:
     *  log_b (a - ε) = log_2 (2 - ε)
     * 
     *  f(n) <= O(n^(log_b (a - ε)))
     *  9n + 10 <= c . n^(log_2 (2 - ε))
     * 
     *  -> Para ser verdadeiro, n precisa ter expoente 1, e, para tanto:
     *    𝜀 = 0; log_2 (2 - 1) = 1
     * 
     *  9n + 10 <= c . n^1 (VERDADEIRO)
     * 
     *  Ou seja, o crescimento do custo da recursão é proporcional ao 
     *  crescimento de n, o que configura o caso 2, onde 𝜀 = 0.
     * 
     *  Assim, temos que:
     *      1. f(n) pertence a teta(n^(log_b a));
     *      2. T(n) pertence a teta(n^(log_b a) log n);
     *      2. Como n^log_b a = 1, então T(n) pertence a teta(n log n).
     */

    private void mergeSort(int inicio, int fim) { 
        if (inicio < fim) { // 1
            int meio = (inicio + fim) / 2; // 1
            mergeSort(inicio, meio); // S(n/2)
            mergeSort(meio + 1, fim); // S(n/2)
            merge(inicio, fim, meio); // M(n)
        }
    }
    
    /*
     * ------- Custo M(n) para merge(0, n, n/2) ------------------
     * M(n) = Operações básicas + 2 for's + For grande + 2 while's
     * M(n) = 8 + 2 . (n/2) +  n . 4 + 2 . (n/2) . 3
     * M(n) = 8 + n + 4n + 3n
     * M(n) = 7n + 8
     * -----------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        Comparable[] info = getInfo(); // 1

        int tamanhoEsquerda = meio - inicio + 1; // 1
        T[] metadeEsquerda = (T[]) new Comparable[tamanhoEsquerda]; // 1
        for (int i = 0; i < metadeEsquerda.length; i++) { //  (n/2) . 1
            metadeEsquerda[i] = (T) info[inicio + i]; // 1
        }

        int tamanhoDireita = fim - meio; // 1
        T[] metadeDireita = (T[]) new Comparable[tamanhoDireita]; // 1
        for (int i = 0; i < metadeDireita.length; i++) { // (n/2) . 1
            metadeDireita[i] = (T) info[meio + i + 1]; // 1
        }

        int primeiroEsquerda = 0; // 1
        int primeiroDireita = 0; // 1
        int i; // 1
        for (i = inicio; i < fim; i++) {  // n . 4
            if (primeiroEsquerda < tamanhoEsquerda && primeiroDireita < tamanhoDireita) { // 1
                if (metadeEsquerda[primeiroEsquerda].compareTo(metadeDireita[primeiroDireita]) < 0)  { // 1     Verificação + Corpo = 3
                    info[i] = metadeEsquerda[primeiroEsquerda]; // 1
                    primeiroEsquerda ++; // 1
                } else { 
                    info[i] = metadeDireita[primeiroDireita]; // 1
                    primeiroDireita ++; // 1
                }
            } else {
                break; // 1
            }
        }

        while(primeiroEsquerda < tamanhoEsquerda) { // (n/2) . 3 
            info[i] = metadeEsquerda[primeiroEsquerda]; // 1
            primeiroEsquerda ++; // 1
            i ++; // 1
        }
        
        while(primeiroDireita < tamanhoDireita) { // (n/2) . 3 
            info[i] = metadeDireita[primeiroDireita]; // 1
            primeiroDireita ++; // 1
            i ++; // 1
        }
    }
}
