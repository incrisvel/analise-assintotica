@SuppressWarnings("rawtypes")
public class OrdenacaoMergeSort<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        Comparable[] info = getInfo();

        int tamanhoEsquerda = meio - inicio + 1;
        T[] metadeEsquerda = (T[]) new Comparable[tamanhoEsquerda];
        for (int i = 0; i < metadeEsquerda.length; i++) {
            metadeEsquerda[i] = (T) info[inicio + i];
        }

        int tamanhoDireita = fim - meio;
        T[] metadeDireita = (T[]) new Comparable[tamanhoDireita];
        for (int i = 0; i < metadeDireita.length; i++) {
            metadeDireita[i] = (T) info[meio + i + 1];
        }

        int primeiroEsquerda = 0;
        int primeiroDireita = 0;
        int i;
        for (i = inicio; i < fim; i++) {
            if (primeiroEsquerda < tamanhoEsquerda &&
                primeiroDireita < tamanhoDireita) { 

                if (metadeEsquerda[primeiroEsquerda].compareTo(metadeDireita[primeiroDireita]) < 0)  {
                    info[i] = metadeEsquerda[primeiroEsquerda];
                    primeiroEsquerda ++;
                } else {
                    info[i] = metadeDireita[primeiroDireita];
                    primeiroDireita ++;
                }
            } else {
                break;
            }
        }

        while(primeiroEsquerda < tamanhoEsquerda) {
            info[i] = metadeEsquerda[primeiroEsquerda];
            primeiroEsquerda ++;
            i ++;
        }
        
        while(primeiroDireita < tamanhoDireita) {
            info[i] = metadeDireita[primeiroDireita];
            primeiroDireita ++;
            i ++;
        }
    }
}
