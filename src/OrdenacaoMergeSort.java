@SuppressWarnings("rawtypes")
public class OrdenacaoMergeSort<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    /*
     * ------- Custo total S(n) para o método mergeSort(0, n) -------
     * S(n) = 2 + 2 . S(n/2) + 9n + 8
     * S(n) = 9n + 10 + 2.S(n/2)
     * S(n) =  2.S(n/2) + 9n + 10 
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
     * ------- Custo total M(n) para o método merge(0, n, n/2) -------
     * M(n) = Operações básicas + 2 for's + For grande + 2 while's
     * M(n) = 8 + 2 . (n/2) +  n . 4 + 2 . (n/2) . 3
     * M(n) =  8 + n + 4n + 3n
     * M(n) = 7n + 8
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
