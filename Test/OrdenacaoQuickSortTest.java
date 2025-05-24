import org.junit.Test;

import static org.junit.Assert.*;

public class OrdenacaoQuickSortTest {
    @Test
    public void ordenarVetorPequeno() {
        Integer[] vetor = {50, 14, 80, 66, 72, 12};

        OrdenacaoQuickSort<Integer> bolha = new OrdenacaoQuickSort<>();
        bolha.setInfo(vetor);

        long inicio = System.nanoTime();
        bolha.ordenar();
        long fim = System.nanoTime();
        double duracao = (fim - inicio) / 1_000_000_000.0;

        String output = bolha.toString();
        System.out.println("Tempo de execução ordenação quick (caso padrão): " + String.format("%.8f segundos", duracao));
        String expected = "12, 14, 50, 66, 72, 80";
        assertEquals(expected, output);
    }

    @Test
    public void ordenarVetorAleatorio() {
        OrdenacaoQuickSort<Integer> bolha = new OrdenacaoQuickSort<>();
        bolha.setInfo(VetorTestes.getVetorTeste());
        // começa a medir o tempo
        long inicio = System.currentTimeMillis();
        bolha.ordenar();
        // finaliza a medição do tempo
        long fim = System.currentTimeMillis();
        double duracao = (fim - inicio) / 1000.0;
        System.out.println("Tempo de execução ordenação quick(5000 elementos): " + duracao + " segundos");
    }
}