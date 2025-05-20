public class Main {
    public static void main(String[] args) {
        new Main();
    }

    @SuppressWarnings("unchecked")
    public Main() {
        Integer[] vetorTeste = {50, 14, 80, 66, 72, 12};

        // Caso 1: Bolha
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetorTeste);
        bolha.ordenar();
        System.out.println("Bolha\n" + bolha.toString());

        // Caso 2: Bolha Otimizado 
        OrdenacaoBolhaOtimizada<Integer> bolhaOtimizada = new OrdenacaoBolhaOtimizada<>();
        bolhaOtimizada.setInfo(vetorTeste);
        bolhaOtimizada.ordenar();
        System.out.println("\nBolha Otimizado\n" + bolhaOtimizada.toString());

        // Caso 3: QuickSort
        OrdenacaoQuickSort<Integer> quick = new OrdenacaoQuickSort<>();
        quick.setInfo(vetorTeste);
        quick.ordenar();
        System.out.println("\nQuickSort\n" + quick.toString());

        // Caso 4: MergeSort
        OrdenacaoMergeSort<Integer> merge = new OrdenacaoMergeSort<>();
        merge.setInfo(vetorTeste);
        merge.ordenar();
        System.out.println("\nMergeSort\n" + merge.toString());
    }
}
