import java.util.Random;

public class ArvoreBenchMark {
    public static void main(String[] args) {

        long semente = System.currentTimeMillis();
        Random random = new Random(semente);

        int[] tamanhos = {100, 500, 1000, 10000, 20000};

        for (int tamanho : tamanhos) {
            System.out.println("Tamanho da Árvore: " + tamanho);


            int[] numerosAleatorios = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                numerosAleatorios[i] = random.nextInt(1000000);
            }


            ArvoreBinariaAVL arvoreAVL = new ArvoreBinariaAVL();
            long startTime = System.nanoTime();

            for (int numero : numerosAleatorios) {
                arvoreAVL.inserir(numero);
            }

            long endTime = System.nanoTime();
            System.out.println("Tempo de Inserção AVL: " + (endTime - startTime) + " ns");


            ArvoreBinaria arvoreNaoBalanceada = new ArvoreBinaria();
            startTime = System.nanoTime();

            for (int numero : numerosAleatorios) {
                arvoreNaoBalanceada.inserir(numero);
            }

            endTime = System.nanoTime();
            System.out.println("Tempo de Inserção Árvore Não Balanceada: " + (endTime - startTime) + " ns");


            int chaveBusca = numerosAleatorios[random.nextInt(tamanho)];

            startTime = System.nanoTime();
            arvoreAVL.buscar(chaveBusca);
            endTime = System.nanoTime();
            System.out.println("Tempo de Busca AVL: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            arvoreNaoBalanceada.buscar(chaveBusca);
            endTime = System.nanoTime();
            System.out.println("Tempo de Busca Árvore Não Balanceada: " + (endTime - startTime) + " ns");


            int chaveRemocao = numerosAleatorios[random.nextInt(tamanho)];

            startTime = System.nanoTime();
            arvoreAVL.remover(chaveRemocao);
            endTime = System.nanoTime();
            System.out.println("Tempo de Remoção AVL: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            arvoreNaoBalanceada.remover(chaveRemocao);
            endTime = System.nanoTime();
            System.out.println("Tempo de Remoção Árvore Não Balanceada: " + (endTime - startTime) + " ns");

            System.out.println();
        }
    }
}