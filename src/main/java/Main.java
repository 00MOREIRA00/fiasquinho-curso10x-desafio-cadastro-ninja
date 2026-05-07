import java.util.ArrayList;
import java.util.Scanner;
import ninjas.Ninja;
import ninjas.Uchirra;
import ninjas.Hyuga;


public class Main {

    static final String[] CLA_NOMES = {
            "Ninja Comum",
            "Uchirra",
            "Hyuga"
    };

    public static void main(String[] args) {

        ArrayList<Ninja> ninjas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean executando = true;

        mostrarCabecalho();

        while (executando) {
            mostrarMenu();

            int opcao = lerOpcaoMenu(sc, 4);

            switch (opcao) {
                case 1:
                    listarNinjas(ninjas);
                    break;

                case 2:
                    adicionarNinja(sc, ninjas);
                    break;

                case 3:
                    atualizarNinja(sc, ninjas);
                    break;

                case 4:
                    System.out.println("\n╔════════════════════════════════════╗");
                    System.out.println("║      Sistema finalizado. Até!      ║");
                    System.out.println("╚════════════════════════════════════╝");
                    executando = false;
                    break;
            }
        }

        sc.close();
    }

    private static void mostrarCabecalho() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GERENCIAMENTO NINJA   ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void mostrarMenu() {
        System.out.println("\n╔════════════ MENU ════════════╗");
        System.out.println("║ 1 - Listar ninjas            ║");
        System.out.println("║ 2 - Adicionar ninja          ║");
        System.out.println("║ 3 - Atualizar ninja          ║");
        System.out.println("║ 4 - Sair                     ║");
        System.out.println("╚══════════════════════════════╝");
    }

    private static void listarNinjas(ArrayList<Ninja> ninjas) {
        if (ninjas.isEmpty()) {
            System.out.println("\n[AVISO] Nenhum ninja cadastrado!");
            return;
        }

        System.out.println("\n╔════════ LISTA DE NINJAS ════════╗");

        for (int i = 0; i < ninjas.size(); i++) {
            System.out.println("\n--- Ninja " + (i + 1) + " ---");
            ninjas.get(i).mostrarInformacoes();
        }

        System.out.println("╚═════════════════════════════════╝");
    }

    private static void adicionarNinja(Scanner sc, ArrayList<Ninja> ninjas) {
        System.out.println("\n╔══════ ADICIONAR NINJA ══════╗");

        for (int i = 0; i < CLA_NOMES.length; i++) {
            System.out.println("║ " + i + " - " + CLA_NOMES[i]);
        }

        System.out.println("╚══════════════════════════════╝");

        int tipo = lerOpcaoIntervalo(sc, 0, 2);

        String nome = lerStringNaoVazia(sc, "Nome:");
        int idade = lerIdade(sc);
        String missao = lerStringNaoVazia(sc, "Missão:");
        String dificuldade = lerStringNaoVazia(sc, "Dificuldade:");
        String status = lerStringNaoVazia(sc, "Status:");

        Ninja novo;

        if (tipo == 0) {
            novo = new Ninja(nome, idade, missao, dificuldade, status);
        } else {
            String habilidade = lerStringNaoVazia(sc, "Habilidade especial:");

            if (tipo == 1) {
                novo = new Uchirra(nome, idade, missao, dificuldade, status, habilidade);
            } else {
                novo = new Hyuga(nome, idade, missao, dificuldade, status, habilidade);
            }
        }

        ninjas.add(novo);
        System.out.println("\n[SUCESSO] Ninja adicionado!");
    }

    private static void atualizarNinja(Scanner sc, ArrayList<Ninja> ninjas) {
        if (ninjas.isEmpty()) {
            System.out.println("\n[AVISO] Nenhum ninja cadastrado!");
            return;
        }

        System.out.println("\n╔══════ ATUALIZAR NINJA ══════╗");

        for (int i = 0; i < ninjas.size(); i++) {
            Ninja n = ninjas.get(i);
            System.out.println((i + 1) + " - " + n.getNome() + " (" + n.getTipoCla() + ")");
        }

        int escolha = lerOpcaoIntervalo(sc, 1, ninjas.size());
        Ninja ninja = ninjas.get(escolha - 1);

        System.out.println("\nAtualizando cadastro de: " + ninja.getNome());

        String novoNome = lerStringNaoVazia(sc, "Novo nome:");
        int novaIdade = lerIdade(sc);
        String novaMissao = lerStringNaoVazia(sc, "Nova missão:");
        String novaDificuldade = lerStringNaoVazia(sc, "Nova dificuldade:");
        String novoStatus = lerStringNaoVazia(sc, "Novo status:");

        ninja.setNome(novoNome);
        ninja.setIdade(novaIdade);
        ninja.setMissao(novaMissao);
        ninja.setNivelDificuldade(novaDificuldade);
        ninja.setStatusMissao(novoStatus);

        if (!ninja.getTipoCla().equals("Comum")) {
            String novaHabilidade = lerStringNaoVazia(sc, "Nova habilidade especial:");
            ninja.setHabilidadeEspecial(novaHabilidade);
        }

        System.out.println("\n[SUCESSO] Cadastro atualizado!");
    }

    private static String lerStringNaoVazia(Scanner sc, String msg) {
        String valor;

        do {
            System.out.print(msg + " ");
            valor = sc.nextLine().trim();

            if (valor.isEmpty()) {
                System.out.println("[ERRO] Campo não pode ser vazio!");
            }

        } while (valor.isEmpty());

        return valor;
    }

    private static int lerInteiro(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg + " ");
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("[ERRO] Digite um número válido!");
            }
        }
    }

    private static int lerIdade(Scanner sc) {
        while (true) {
            int idade = lerInteiro(sc, "Idade:");

            if (idade > 0 && idade <= 120) {
                return idade;
            }

            System.out.println("[ERRO] Idade inválida!");
        }
    }

    private static int lerOpcaoMenu(Scanner sc, int max) {
        while (true) {
            int op = lerInteiro(sc, "Escolha:");

            if (op >= 1 && op <= max) {
                return op;
            }

            System.out.println("[ERRO] Opção inválida!");
        }
    }

    private static int lerOpcaoIntervalo(Scanner sc, int min, int max) {
        while (true) {
            int op = lerInteiro(sc, "Escolha:");

            if (op >= min && op <= max) {
                return op;
            }

            System.out.println("[ERRO] Opção inválida!");
        }
    }
}
