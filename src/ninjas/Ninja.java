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

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Missão: " + missao);
        System.out.println("Nível de Dificuldade: " + nivelDificuldade);
        System.out.println("Status da Missão: " + statusMissao);
    }

    public String getNome() { return nome; }

    public int getIdade() { return idade; }

    public String getMissao() { return missao; }

    public String getNivelDificuldade() { return nivelDificuldade; }

    public String getStatusMissao() { return statusMissao; }
}