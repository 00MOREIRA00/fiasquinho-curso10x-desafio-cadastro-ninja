
package ninjas;

public class Hyuga extends Ninja {

    private String habilidadeEspecial;

    public Hyuga(String nome, int idade, String missao, String nivelDificuldade, String statusMissao, String habilidadeEspecial) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public String getTipoCla() {
        return "Hyuga";
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

