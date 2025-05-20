@SuppressWarnings("rawtypes")
public class OrdenacaoBolha<T extends Comparable> extends OrdenacaoAbstract {
    public void ordenar() {
        for (int i = 0; i < getInfo().length; i++) {
            for (int j = 0; j < getInfo().length - i - 1; j++) {
                if (((T) getInfo()[j]).compareTo((T) getInfo()[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
