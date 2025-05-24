@SuppressWarnings("rawtypes")
public abstract class OrdenacaoAbstract<T extends Comparable> {
    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(int a, int b) {
        T auxiliar = getInfo()[a]; // 1
        getInfo()[a] = getInfo()[b]; // 1
        getInfo()[b] = auxiliar; // 1
    }

    public abstract void ordenar();

    public String toString() {
        String retorno = "";
        for (int i = 0; i < getInfo().length - 1; i++) {
            retorno += getInfo()[i] + ", ";
        }
        return retorno + getInfo()[getInfo().length - 1];
    }
}
