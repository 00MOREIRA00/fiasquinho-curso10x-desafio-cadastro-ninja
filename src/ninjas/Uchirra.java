package ninjas;

public class Uchirra extends Ninja {
    private String habilidadeEspecial;

    public Uchirra(String nome, int idade, String missao, String nivelDificuldade, String statusMissao, String habilidadeEspecial) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Habilidade Especial: " + habilidadeEspecial);
    }
}