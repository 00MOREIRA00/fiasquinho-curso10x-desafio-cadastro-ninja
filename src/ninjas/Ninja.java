package ninjas;

public class Ninja {

    private String nome;
    private int idade;
    private String missao;
    private String nivelDificuldade;
    private String statusMissao;

    public Ninja(String nome, int idade, String missao, String nivelDificuldade, String statusMissao) {
        this.nome = nome;
        this.idade = idade;
        this.missao = missao;
        this.nivelDificuldade = nivelDificuldade;
        this.statusMissao = statusMissao;
    }

    public String getTipoCla() {
        return "Comum";
    }

    public String getHabilidadeEspecial() {
        return "Nenhuma";
    }

    public void setHabilidadeEspecial(String habilidade) {
        // Ninja comum não possui habilidade especial
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Missão: " + missao);
        System.out.println("Nível de Dificuldade: " + nivelDificuldade);
        System.out.println("Status da Missão: " + statusMissao);
        System.out.println("Clã: " + getTipoCla());
        System.out.println("Habilidade Especial: " + getHabilidadeEspecial());
    }

    public String getNome() {
        return nome;
    }
}