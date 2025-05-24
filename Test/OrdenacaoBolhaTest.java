import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class OrdenacaoBolhaTest {
    @Test
    public void ordenarVetorPequeno() {
        Integer[] vetor = {50, 14, 80, 66, 72, 12};

        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetor);

        long inicio = System.nanoTime();
        bolha.ordenar();
        long fim = System.nanoTime();
        double duracao = (fim - inicio) / 1_000_000_000.0;

        String output = bolha.toString();
        // Formatando para remover a notação científica do resultado
        System.out.println("Tempo de execução ordenação bolha (caso padrão): " + String.format("%.8f segundos", duracao));
        String expected = "12, 14, 50, 66, 72, 80";
        assertEquals(expected, output);
    }

    @Test
    public void ordenarVetorAleatorio() {
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(VetorTestes.getVetorTeste());
        // começa a medir o tempo
        long inicio = System.currentTimeMillis();
        bolha.ordenar();
        // finaliza a medição do tempo
        long fim = System.currentTimeMillis();
        double duracao = (fim - inicio) / 1000.0;
        System.out.println("Tempo de execução ordenação bolha (5000 elementos): " + duracao + " segundos");
    }

    @Test
    public void ordenarVetorOrdenado() {
        Integer[] vetor = VetorTestes.getVetorTeste();
        Arrays.sort(vetor);

        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetor);
        long inicio = System.currentTimeMillis();
        bolha.ordenar();
        long fim = System.currentTimeMillis();
        double duracao = (fim - inicio) / 1000.0;
        System.out.println("Tempo de execução ordenação bolha melhor caso(5000 elementos): " + duracao + " segundos");
    }

    @Test
    public void ordenarVetorDecrescente() {
        Integer[] vetor = VetorTestes.getVetorTeste();
        Arrays.sort(vetor, Collections.reverseOrder());

        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetor);
        long inicio = System.currentTimeMillis();
        bolha.ordenar();
        long fim = System.currentTimeMillis();
        double duracao = (fim - inicio) / 1000.0;
        System.out.println("Tempo de execução ordenação bolha pior caso (5000 elementos): " + duracao + " segundos");
    }

    @Test
    public void ordenarVetorOrdenadoOtimizado() {
        Integer[] vetor = VetorTestes.getVetorTeste();
        Arrays.sort(vetor);
        OrdenacaoBolhaOtimizada<Integer> bolha = new OrdenacaoBolhaOtimizada<>();
        bolha.setInfo(vetor);
        long inicio = System.nanoTime();
        bolha.ordenar();
        long fim = System.nanoTime();
        double duracao = (fim - inicio) / 1_000_000_000.0;
        System.out.println("Tempo de execução ordenação bolha otimizado melhor caso (5000 elementos): " + String.format("%.8f segundos", duracao));
    }

    @Test
    public void ordenarVetorDecrescenteOtimizado() {
        Integer[] vetor = VetorTestes.getVetorTeste();
        Arrays.sort(vetor, Collections.reverseOrder());
        OrdenacaoBolhaOtimizada<Integer> bolha = new OrdenacaoBolhaOtimizada<>();
        bolha.setInfo(vetor);
        long inicio = System.nanoTime();
        bolha.ordenar();
        long fim = System.nanoTime();
        double duracao = (fim - inicio) / 1_000_000_000.0;
        System.out.println(String.format("%.8f", duracao));
        System.out.println("Tempo de execução ordenação bolha otimizado pior caso (5000 elementos): " + String.format("%.8f segundos", duracao));
    }
}