public class Uchirra extends Ninja{
    String habilidadeEspecial;

    Uchirra(String nome, int idade, String missao, String nivelDificuldade, String statusMissao) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
    }

    public void mostrarInformacoes(){
        super.mostrarInformacoes();
        mostrarHabilidadeEspecial();
    }

    public void mostrarHabilidadeEspecial(){
        System.out.println("Habilidade Especial: " + habilidadeEspecial);
    }
}
