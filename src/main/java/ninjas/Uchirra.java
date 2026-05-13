
package ninjas;

public class Uchirra extends Ninja {

    private String habilidadeEspecial;

    public Uchirra(String nome, int idade, String missao, String nivelDificuldade, String statusMissao, String habilidadeEspecial) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public String getTipoCla() {
        return "Uchirra";
    }

    @Override
    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    @Override
    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }
}

