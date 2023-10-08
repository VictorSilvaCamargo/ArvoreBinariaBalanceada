import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        int escolha;

        do {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Inserir um número");
            System.out.println("2. Buscar um número");
            System.out.println("3. Remover um número");
            System.out.println("4. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite um número para inserir na árvore: ");
                    int numero = scanner.nextInt();
                    arvore.inserir(numero);
                    break;
                case 2:
                    System.out.print("Digite o número que deseja buscar: ");
                    int numero2 = scanner.nextInt();
                    if (arvore.buscar(numero2)) {
                        System.out.println("Número encontrado na árvore.");
                    } else {
                        System.out.println("Número não encontrado na árvore.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número que deseja remover: ");
                    int numero3 = scanner.nextInt();
                    arvore.remover(numero3);
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 4);

        scanner.close();
    }
}
