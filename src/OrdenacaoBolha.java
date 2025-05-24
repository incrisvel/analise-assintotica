@SuppressWarnings("rawtypes")
public class OrdenacaoBolha<T extends Comparable> extends OrdenacaoAbstract {
    @SuppressWarnings("unchecked")

    /*
     * -- Função de custo B(n) para ordenar() --
     * B(n) = n . 4(n-1)
     * B(n) = n . (4n - 4)
     * B(n) = 4n^2 - 4n
     * ------------------------------------------
     */

     /*
      * Desconsiderando as constantes multiplicativas, como o crescimento da
      * função quadrática é maior do que da função linear (n < n^2), temos que
      * a complexidade assintótica de ordenar() é O(n^2).
      */

    /*
     * Prova real de que B(n) pertence ao limite superior O(n^2)
     * B(n) <= O(n^2)
     * 4n^2 - 4n <= c . n^2   -> Divide-se por n^2
     * 4 - 4/n <= c           -> Se c = 4
     * 
     *  Para n = 1, teríamos:
     *  4 - 4/1 <= 4
     *  0 <= 4        -> Verdadeiro, portanto, a = 1
     */

    /*
     * Como o algoritmo ordenar() sempre executa os dois loops independentemente
     * do valor de n (não tem uma condição de interrupção), o melhor e pior caso
     * têm a mesma complexidade, ou seja, temos teta(n^2).
     */

    public void ordenar() {
        for (int i = 0; i < getInfo().length; i++) { // n . 4(n-1)
            for (int j = 0; j < getInfo().length - i - 1; j++) { // (n-1) . 4
                if (((T) getInfo()[j]).compareTo((T) getInfo()[j + 1]) > 0) { // 1
                    trocar(j, j + 1); // 3
                }
            }
        }
    }
}
