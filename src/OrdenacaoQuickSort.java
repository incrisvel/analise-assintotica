@SuppressWarnings("rawtypes")
public class OrdenacaoQuickSort<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(inicio, fim);
            System.out.println(pivo);
            quickSort(inicio, pivo - 1);
            quickSort(pivo + 1, fim);
        }
    }

    @SuppressWarnings("unchecked")
    private int particionar(int inicio, int fim) {
        int posicaoMaior = inicio;
        int posicaoMenor = fim + 1;
        T pivo = (T) getInfo()[inicio];

        while (true) {
            do {
                posicaoMaior++;
            } while (posicaoMaior <= fim &&getInfo()[posicaoMaior].compareTo(pivo) < 0);
        
            do {
                posicaoMenor--;
            } while (posicaoMenor >= inicio && getInfo()[posicaoMenor].compareTo(pivo) > 0); // Desloca-se (é decrementada) ignorando os elementos maiores
        

            if (posicaoMaior >= posicaoMenor) {
                break;
            }

            trocar(posicaoMaior, posicaoMenor);
        }
        trocar(posicaoMenor, inicio);
        return posicaoMenor;
    }
}
