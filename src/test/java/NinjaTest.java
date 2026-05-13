import ninjas.Ninja;
import ninjas.Hyuga;
import ninjas.Uchirra;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Ninja")
public class NinjaTest {

    @Test
    @DisplayName("Deve retornar clã Nenhum para Ninja Comum")
    void deveRetornarClaNenhumParaNinjaComum() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        assertEquals("Nenhum", ninja.getTipoCla());
    }

    @Test
    @DisplayName("Ninja Comum deve retornar habilidade 'Nenhuma'")
    void deveRetornarHabilidadeNenhumaParaNinjaComum() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        assertEquals("Nenhuma", ninja.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Deve retornar o nome correto")
    void deveRetornarNomeCorreto() {
        Ninja ninja = new Ninja(
                "Sasuke",
                16,
                "Treinar",
                "Médio",
                "Pausada"
        );

        assertEquals("Sasuke", ninja.getNome());
    }

    @Test
    @DisplayName("Deve atualizar o nome do Ninja")
    void deveAtualizarNome() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        ninja.setNome("Hinata");
        assertEquals("Hinata", ninja.getNome());
    }

    @Test
    @DisplayName("Deve atualizar a idade")
    void deveAtualizarIdade() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        ninja.setIdade(25);
        assertEquals(25, ninja.getIdade());
    }

    @Test
    @DisplayName("Deve atualizar missão")
    void deveAtualizarMissao() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão Antiga",
                "Fácil",
                "Concluída"
        );

        ninja.setMissao("Nova Missão");
        assertEquals("Nova Missão", ninja.getMissao());
    }

    @Test
    @DisplayName("Deve atualizar nível de dificuldade")
    void deveAtualizarDificuldade() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        ninja.setNivelDificuldade("Difícil");
        assertEquals("Difícil", ninja.getNivelDificuldade());
    }

    @Test
    @DisplayName("Deve atualizar status da missão")
    void deveAtualizarStatus() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        ninja.setStatusMissao("Concluída");
        assertEquals("Concluída", ninja.getStatusMissao());
    }

    @Test
    @DisplayName("Ninja com idade mínima (1 ano)")
    void ninjaComIdadeMinima() {
        Ninja ninja = new Ninja(
                "Pequenino",
                1,
                "Aprender",
                "Muito Fácil",
                "Iniciante"
        );

        assertNotNull(ninja);
        assertEquals(1, ninja.getIdade());
    }

    @Test
    @DisplayName("Ninja com idade máxima (120 anos)")
    void ninjaComIdadeMaxima() {
        Ninja ninja = new Ninja(
                "Vovô",
                120,
                "Ensinar",
                "Muito Difícil",
                "Aposentado"
        );

        assertNotNull(ninja);
        assertEquals(120, ninja.getIdade());
    }

    @Test
    @DisplayName("Não deve permitir setHabilidadeEspecial em Ninja Comum")
    void naoPermiteHabilidadeEmNinjaComum() {
        Ninja ninja = new Ninja(
                "Naruto",
                16,
                "Missão",
                "Fácil",
                "Em andamento"
        );

        ninja.setHabilidadeEspecial("Qualquer coisa");
        assertEquals("Nenhuma", ninja.getHabilidadeEspecial());
    }


    @Test
    @DisplayName("Ninja com nome vazio deve ser criado")
    void ninjaNomeVazio() {
        Ninja ninja = new Ninja("", 16, "Missão", "Fácil", "Em andamento");
        assertTrue(ninja.getNome().isEmpty());
    }
}