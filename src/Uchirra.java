public class Uchirra extends Ninja{
    String habilidadeEspecial;

    public void mostrarInformacoes(){
        super.mostrarInformacoes();
        mostrarHabilidadeEspecial();
    }

    public void mostrarHabilidadeEspecial(){
        System.out.println("Habilidade Especial: " + habilidadeEspecial);
    }
}
