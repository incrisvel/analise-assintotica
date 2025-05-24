@SuppressWarnings("rawtypes")
public class OrdenacaoBolhaOtimizada<T extends Comparable> extends OrdenacaoAbstract {
    /*
     * -- Custo do pior caso para ordenar() --
     * B(n) = n . (5(n-1) + 3)
     * B(n) = n . (5n - 5 + 3)
     * B(n) = n . (5n - 2)
     * B(n) = 5n^2 - 2n -> O(n^2)
     * ------------------------------------------
     */

    /* 
     * O melhor caso seria se o vetor já estivesse ordenado. Nesse caso, dado
     * que não há valores maiores que o primeiro, o bloco de código interno do if
     * não será executado em nenhuma das iterações do for interno, apenas a comparação,
     * totalizando n-1 de custo para esse loop. Finalmente, como o valor de "trocou" não
     * é atualizado, o for externo é quebrado ao fim de sua primeira iteração.
     * 
     * Assim, temos, para o melhor caso:
     * B(n) = 2 + (n-1) 
     * B(n) = n + 1 -> Omega(n)
     */

    
    @SuppressWarnings("unchecked")
    public void ordenar() {
        for (int i = 0; i < getInfo().length; i++) { // n
            boolean trocou = false; // 1
            
            for (int j = 0; j < getInfo().length - i - 1; j++) { // (n-1) . 5
                if (((T) getInfo()[j]).compareTo((T) getInfo()[j + 1]) > 0) { // 1
                    trocar(j, j + 1); // 3
                    trocou = true; // 1
                }
            }

            if (!trocou) { // 1
                return; // 1
            }
        }
    }
}
