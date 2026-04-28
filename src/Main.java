import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> ninjas = new ArrayList<>();

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
                    if (ninjas.isEmpty()){
                        System.out.println("Nenhum ninja cadastrado !!");
                    }

                    for (int i = 0; i < ninjas.size(); i++) {
                        System.out.println("Ninja " + (i + 1) + ": " + ninjas.get(i));
                    }

                    break;

                case 2:
                    System.out.println("Você selecionou a opção 2: Adicionar um novo ninja");
                    System.out.println("Digite o nome do ninja:");
                    sc.nextLine();
                    String nomeNinja = sc.nextLine();
                    ninjas.add(nomeNinja);
                    break;

                case 3:
                    System.out.println("Você selecionou a opção 3: Remover um ninja");
                    System.out.println("--------------------------------------------");
                    System.out.println("Digite o número do ninja que deseja remover:");
                    sc.nextLine();
                    int numeroNinja = sc.nextInt();
                    ninjas.remove(numeroNinja - 1);
                    System.out.println("Ninja removido com sucesso!");
                    break;

                case 4:
                    System.out.println("Você selecionou a opção 4: Atualizar habilidades especiais de um");
                    System.out.println("--------------------------------------------");
                    System.out.println("Digite o número do ninja que deseja atualizar as habilidades especiais:");
                    sc.nextLine();
                    int numeroNinjaAtualizar = sc.nextInt();
                    System.out.println("Digite o novo nome do ninja:");
                    sc.nextLine();
                    String novasHabilidades = sc.nextLine();
                    ninjas.set(numeroNinjaAtualizar - 1, novasHabilidades);
                    System.out.println("Ninja atualizado com sucesso!");
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


// [OK] - Menu Interativo
// [OK] - Exibir informações de todos os ninjas
// [OK] - Adicionar novos ninjas
// [OK] - Remover Ninjas
// [OK] - Atualizar habilidades Especiais
