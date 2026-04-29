import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Ninja> ninjas = new ArrayList<>();

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
            System.out.println();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou a opção 1: Exibir informações de todos os ninjas");
                    if (ninjas.isEmpty()){
                        System.out.println("Nenhum ninja cadastrado !!");
                    }

                    for (int i = 0; i < ninjas.size(); i++) {
                        System.out.println("\n--- Ninja " + (i + 1) + " ---");
                        ninjas.get(i).mostrarInformacoes();
                    }

                    break;

                case 2:
                    System.out.println("Você selecionou a opção 2: Adicionar um novo ninja");
                    System.out.println("--------------------------------------------");

                    String nomeNinja = "";
                    while (nomeNinja.trim().isEmpty()) {
                        System.out.println("Digite o nome do ninja (não pode ser vazio):");
                        nomeNinja = sc.nextLine();
                        if (!nomeNinja.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("❌ Erro: O nome do ninja não pode ser vazio. Por favor, tente novamente.");
                    }

                    int idadeNinja = 0;
                    boolean isValidaIdade = false;

                    while (!isValidaIdade) {
                        System.out.println("Digite a idade do ninja:");
                        try {
                            idadeNinja = sc.nextInt();
                            if (idadeNinja > 0 && idadeNinja <= 150) {
                                isValidaIdade = true;
                                sc.nextLine();
                            } else {
                                System.out.println("❌ Erro: A idade deve estar entre 1 e 150 anos!");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Erro: Digite um número válido para a idade!");
                            sc.nextLine();
                        }
                    }

                    String missaoNinja;
                    while(true){
                        System.out.println("Digite a missão do ninja:");
                        missaoNinja = sc.nextLine();

                        if (!missaoNinja.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("❌ Erro: A missão do ninja não pode ser vazia. Por favor, tente novamente.");
                    }

                    String nivelDificuldadeNinja = "";
                    while (nivelDificuldadeNinja.trim().isEmpty()) {
                        System.out.println("Digite o nível de dificuldade da missão:");
                        nivelDificuldadeNinja = sc.nextLine();

                        if (!nivelDificuldadeNinja.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("❌ Erro: O nível de dificuldade não pode ser vazio! Tente novamente.");
                    }

                    String statusMissaoNinja = "";
                    while (statusMissaoNinja.trim().isEmpty()) {
                        System.out.println("Digite o status da missão do ninja:");
                        statusMissaoNinja = sc.nextLine();
                        if (!statusMissaoNinja.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("❌ Erro: O status da missão não pode ser vazio! Tente novamente.");
                    }

                    Ninja ninja = new Ninja(nomeNinja, idadeNinja, missaoNinja, nivelDificuldadeNinja, statusMissaoNinja);

                    ninjas.add(ninja);
                    System.out.println("Ninja adicionado com sucesso!");
                    break;

                case 3:
                    System.out.println("Você selecionou a opção 3: Remover um ninja");
                    System.out.println("--------------------------------------------");

                    if (ninjas.isEmpty()) {
                        System.out.println("Nenhum ninja cadastrado para remover!");
                        break;
                    }

                    for (int i = 0; i < ninjas.size(); i++){
                        System.out.println((i + 1) + ". " + ninjas.get(i).nome);
                    }

                    System.out.println("Digite o número do ninja que deseja remover:");
                    sc.nextLine();
                    int numeroNinja = sc.nextInt();

                    if (numeroNinja < 1 || numeroNinja > ninjas.size()) {
                        System.out.println("Número inválido!");
                        break;
                    }

                    ninjas.remove(numeroNinja - 1);
                    System.out.println("Ninja removido com sucesso!");
                    break;

                case 4:
                    System.out.println("Você selecionou a opção 4: Atualizar ninja");
                    System.out.println("--------------------------------------------");

                    if (ninjas.isEmpty()) {
                        System.out.println("Nenhum ninja cadastrado para atualizar!");
                        break;
                    }

                    for (int i = 0; i < ninjas.size(); i++) {
                        System.out.println((i + 1) + " - " + ninjas.get(i).nome);
                    }

                    System.out.println("Digite o número do ninja que deseja atualizar:");
                    int opcaoNinja = sc.nextInt();
                    sc.nextLine();

                    int indice = opcaoNinja - 1;

                    if (indice < 0 || indice >= ninjas.size()) {
                        System.out.println("Número inválido!");
                        break;
                    }

                    System.out.println("Digite o novo nome:");
                    String nome = sc.nextLine();

                    System.out.println("Digite a nova idade:");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a nova missão:");
                    String missao = sc.nextLine();

                    System.out.println("Digite o novo nível de dificuldade:");
                    String nivelDificuldade = sc.nextLine();

                    System.out.println("Digite o novo status da missão:");
                    String statusMissao = sc.nextLine();

                    Ninja ninjaNovo = new Ninja(
                            nome,
                            idade,
                            missao,
                            nivelDificuldade,
                            statusMissao
                    );

                    ninjas.set(indice, ninjaNovo);

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
