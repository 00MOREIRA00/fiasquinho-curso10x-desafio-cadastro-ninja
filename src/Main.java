import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Ninjas!");
        int execucao = 1;

        while(execucao == 1) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Exibir informações de todos os ninjas");
            System.out.println("2. Adicionar um novo ninja");
            System.out.println("3. Remover um ninja");
            System.out.println("4. Atualizar habilidades especiais de um ninja");
            System.out.println("5. Sair");

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou a opção 1: Exibir informações de todos os ninjas");
                    break;

                case 2:
                    System.out.println("Você selecionou a opção 2: Adicionar um novo ninja");
                    break;

                case 3:
                    System.out.println("Você selecionou a opção 3: Remover um ninja");
                    break;

                case 4:
                    System.out.println("Você selecionou a opção 4: Atualizar habilidades especiais de um");
                    break;

                case 5:
                    System.out.println("Você selecionou a opção 5: Sair");
                    execucao = 0;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }

    }
}


// Menu Interativo                                  [OK]
// Exisbir informações de todos os ninjas
// Adicionar novos ninjas
// Remover Ninjas
// Atualizar habilidades Especiais
