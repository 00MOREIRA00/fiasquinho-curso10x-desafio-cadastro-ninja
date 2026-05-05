package ninjas;

public class Hyuga extends Ninja {
    private String habilidadeEspecial;

    public Hyuga(String nome, int idade, String missao, String nivelDificuldade, String statusMissao, String habilidadeEspecial) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Habilidade Especial: " + habilidadeEspecial);
    }
}