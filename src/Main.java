import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // ══════════════════════════════════════════════════════════════════
    // Para adicionar um novo clã:
    // 1. Crie a subclasse (ex: class Senju extends Ninja)
    // 2. Adicione uma entrada em CLA_NOMES abaixo
    // 3. Trate o novo case no método criarNinjaEspecial()
    // ══════════════════════════════════════════════════════════════════

    static final String[] CLA_NOMES = {
            "Ninja Comum",  // índice 0 — sem habilidade especial
            "Uchiha",       // índice 1
            "Hyuga"         // índice 2
            // Adicione novos clãs aqui ↑
    };

    public static void main(String[] args) {
        ArrayList<Ninja> ninjas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Ninjas!");

        int execucao = 1;
        while (execucao == 1) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Exibir informações de todos os ninjas");
            System.out.println("2. Adicionar um novo ninja");
            System.out.println("3. Remover um ninja");
            System.out.println("4. Atualizar habilidade especial de um ninja de clã");
            System.out.println("5. Sair");
            System.out.println();

            int opcao = lerInteiro(sc);
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou a opção 1: Exibir informações de todos os ninjas");
                    if (ninjas.isEmpty()) {
                        System.out.println("Nenhum ninja cadastrado!");
                        break;
                    }
                    for (int i = 0; i < ninjas.size(); i++) {
                        System.out.println("\n--- Ninja " + (i + 1) + " ---");
                        ninjas.get(i).mostrarInformacoes();
                    }
                    break;

                case 2:
                    System.out.println("Você selecionou a opção 2: Adicionar um novo ninja");
                    System.out.println("--------------------------------------------");

                    System.out.println("Selecione o clã do ninja:");
                    for (int i = 0; i < CLA_NOMES.length; i++) {
                        System.out.println(i + ". " + CLA_NOMES[i]);
                    }

                    int tipoCla = lerInteiro(sc);
                    sc.nextLine();

                    if (tipoCla < 0 || tipoCla >= CLA_NOMES.length) {
                        System.out.println("❌ Opção inválida! Ninja não adicionado.");
                        break;
                    }

                    String nomeNinja          = lerStringNaoVazia(sc, "Digite o nome do ninja:");
                    int    idadeNinja         = lerIdade(sc);
                    String missaoNinja        = lerStringNaoVazia(sc, "Digite a missão do ninja:");
                    String nivelDificuldade   = lerStringNaoVazia(sc, "Digite o nível de dificuldade da missão:");
                    String statusMissao       = lerStringNaoVazia(sc, "Digite o status da missão:");

                    Ninja ninja;
                    if (tipoCla == 0) {
                        ninja = new Ninja(nomeNinja, idadeNinja, missaoNinja, nivelDificuldade, statusMissao);
                    } else {
                        ninja = criarNinjaEspecial(sc, tipoCla, nomeNinja, idadeNinja, missaoNinja, nivelDificuldade, statusMissao);
                    }

                    ninjas.add(ninja);
                    System.out.println("✅ Ninja adicionado com sucesso!");
                    break;

                case 3:
                    System.out.println("Você selecionou a opção 3: Remover um ninja");
                    System.out.println("--------------------------------------------");

                    if (ninjas.isEmpty()) {
                        System.out.println("Nenhum ninja cadastrado para remover!");
                        break;
                    }

                    listarNinjas(ninjas);
                    System.out.println("Digite o número do ninja que deseja remover:");
                    int numeroRemover = lerInteiro(sc);
                    sc.nextLine();

                    if (numeroRemover < 1 || numeroRemover > ninjas.size()) {
                        System.out.println("❌ Número inválido!");
                        break;
                    }

                    ninjas.remove(numeroRemover - 1);
                    System.out.println("✅ Ninja removido com sucesso!");
                    break;

                case 4:
                    System.out.println("Você selecionou a opção 4: Atualizar habilidade especial de um ninja de clã");
                    System.out.println("--------------------------------------------");

                    if (ninjas.isEmpty()) {
                        System.out.println("Nenhum ninja cadastrado!");
                        break;
                    }

                    // Filtra apenas ninjas com habilidade especial
                    ArrayList<Integer> indicesEspeciais = new ArrayList<>();
                    for (int i = 0; i < ninjas.size(); i++) {
                        if (ninjas.get(i) instanceof Uchiha || ninjas.get(i) instanceof Hyuga) {
                            // Adicione novos clãs aqui ↑
                            indicesEspeciais.add(i);
                        }
                    }

                    if (indicesEspeciais.isEmpty()) {
                        System.out.println("Nenhum ninja de clã especial cadastrado!");
                        break;
                    }

                    System.out.println("Ninjas com habilidade especial:");
                    for (int i = 0; i < indicesEspeciais.size(); i++) {
                        Ninja n = ninjas.get(indicesEspeciais.get(i));
                        System.out.println((i + 1) + ". " + n.nome + " [" + nomeCla(n) + "]");
                    }

                    System.out.println("Digite o número do ninja que deseja atualizar:");
                    int opcaoEspecial = lerInteiro(sc);
                    sc.nextLine();

                    if (opcaoEspecial < 1 || opcaoEspecial > indicesEspeciais.size()) {
                        System.out.println("❌ Número inválido!");
                        break;
                    }

                    int indiceReal = indicesEspeciais.get(opcaoEspecial - 1);
                    Ninja alvo = ninjas.get(indiceReal);

                    System.out.println("Habilidade atual: " + getHabilidade(alvo));
                    String novaHabilidade = lerStringNaoVazia(sc, "Digite a nova habilidade especial:");
                    setHabilidade(alvo, novaHabilidade);

                    System.out.println("✅ Habilidade especial atualizada com sucesso!");
                    break;

                case 5:
                    System.out.println("Você selecionou a opção 5: Sair");
                    execucao = 0;
                    break;

                default:
                    System.out.println("❌ Opção inválida. Por favor, selecione uma opção válida.");
            }
        }

        sc.close();
    }

    // ──────────────────────────────────────────────
    // Fábrica de ninjas especiais — adicione novos clãs aqui
    // ──────────────────────────────────────────────
    private static Ninja criarNinjaEspecial(Scanner sc, int tipoCla,
                                            String nome, int idade, String missao, String nivel, String status) {

        String habilidade = lerStringNaoVazia(sc,
                "Digite a habilidade especial do clã " + CLA_NOMES[tipoCla] + " (Kekkei Genkai):");

        switch (tipoCla) {
            case 1: return new Uchiha(nome, idade, missao, nivel, status, habilidade);
            case 2: return new Hyuga(nome, idade, missao, nivel, status, habilidade);
            // case 3: return new Senju(nome, idade, missao, nivel, status, habilidade);
            default:
                System.out.println("⚠️ Clã não implementado, criando ninja comum.");
                return new Ninja(nome, idade, missao, nivel, status);
        }
    }

    // ──────────────────────────────────────────────
    // Helpers para acessar habilidadeEspecial sem casting repetido
    // ──────────────────────────────────────────────
    private static String getHabilidade(Ninja n) {
        if (n instanceof Uchiha) return ((Uchiha) n).habilidadeEspecial;
        if (n instanceof Hyuga)  return ((Hyuga)  n).habilidadeEspecial;
        // Adicione novos clãs aqui ↑
        return "";
    }

    private static void setHabilidade(Ninja n, String habilidade) {
        if (n instanceof Uchiha) ((Uchiha) n).habilidadeEspecial = habilidade;
        if (n instanceof Hyuga)  ((Hyuga)  n).habilidadeEspecial = habilidade;
        // Adicione novos clãs aqui ↑
    }

    private static String nomeCla(Ninja n) {
        if (n instanceof Uchiha) return "Uchiha";
        if (n instanceof Hyuga)  return "Hyuga";
        // Adicione novos clãs aqui ↑
        return "Comum";
    }

    // ──────────────────────────────────────────────
    // Utilitários de I/O
    // ──────────────────────────────────────────────
    private static void listarNinjas(ArrayList<Ninja> ninjas) {
        for (int i = 0; i < ninjas.size(); i++) {
            System.out.println((i + 1) + ". " + ninjas.get(i).nome + " [" + nomeCla(ninjas.get(i)) + "]");
        }
    }

    private static String lerStringNaoVazia(Scanner sc, String mensagem) {
        String valor = "";
        while (valor.trim().isEmpty()) {
            System.out.println(mensagem);
            valor = sc.nextLine();
            if (valor.trim().isEmpty()) {
                System.out.println("❌ Erro: Este campo não pode ser vazio. Tente novamente.");
            }
        }
        return valor;
    }

    private static int lerInteiro(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Erro: Digite um número válido!");
                sc.nextLine();
            }
        }
    }

    private static int lerIdade(Scanner sc) {
        while (true) {
            System.out.println("Digite a idade do ninja:");
            int idade = lerInteiro(sc);
            if (idade > 0 && idade <= 150) {
                sc.nextLine();
                return idade;
            }
            System.out.println("❌ Erro: A idade deve estar entre 1 e 150 anos!");
        }
    }
}
