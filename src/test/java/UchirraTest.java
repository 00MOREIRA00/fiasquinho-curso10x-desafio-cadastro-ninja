import ninjas.Uchirra;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Uchirra")
public class UchirraTest {

    @Test
    @DisplayName("Deve retornar clã Uchirra corretamente")
    void deveRetornarClaUchirra() {
        Uchirra uchirra = new Uchirra(
                "Sasuke",
                16,
                "Matar Itachi",
                "Difícil",
                "Em andamento",
                "Sharingan"
        );

        assertEquals("Uchirra", uchirra.getTipoCla());
    }

    @Test
    @DisplayName("Deve retornar a habilidade especial Sharingan")
    void deveRetornarHabilidadeSharingan() {
        Uchirra uchirra = new Uchirra(
                "Sasuke",
                16,
                "Matar Itachi",
                "Difícil",
                "Em andamento",
                "Sharingan"
        );

        assertEquals("Sharingan", uchirra.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Deve atualizar habilidade especial do Uchirra")
    void deveAtualizarHabilidadeUchirra() {
        Uchirra uchirra = new Uchirra(
                "Sasuke",
                16,
                "Matar Itachi",
                "Difícil",
                "Em andamento",
                "Sharingan"
        );

        uchirra.setHabilidadeEspecial("Mangekyou Sharingan");
        assertEquals("Mangekyou Sharingan", uchirra.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Uchirra herda dados do Ninja corretamente")
    void uchirraHerdaDadosNinja() {
        Uchirra uchirra = new Uchirra(
                "Itachi",
                21,
                "Vigilância",
                "Muito Difícil",
                "Ativa",
                "Mangekyou Sharingan"
        );

        assertEquals("Itachi", uchirra.getNome());
        assertEquals("Uchirra", uchirra.getTipoCla());
    }

    @Test
    @DisplayName("Uchirra com nome e idade diferentes")
    void uchirraComDadosDiferentes() {
        Uchirra uchirra = new Uchirra(
                "Obito",
                14,
                "Treinar",
                "Médio",
                "Em andamento",
                "Sharingan Evoluído"
        );

        assertEquals("Obito", uchirra.getNome());
        assertEquals(14, uchirra.getIdade());
        assertEquals("Sharingan Evoluído", uchirra.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Uchirra deve ter habilidade especial definida")
    void uchirraTemHabilidadeEspecial() {
        Uchirra uchirra = new Uchirra(
                "Sasuke",
                16,
                "Matar Itachi",
                "Difícil",
                "Em andamento",
                "Sharingan"
        );

        assertNotNull(uchirra.getHabilidadeEspecial());
        assertNotEquals("Nenhuma", uchirra.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Uchirra deve permitir evoluir habilidade")
    void uchirraEvoluirHabilidade() {
        Uchirra uchirra = new Uchirra(
                "Sasuke",
                20,
                "Treinar",
                "Muito Difícil",
                "Em andamento",
                "Sharingan"
        );

        String habilidadeInicial = uchirra.getHabilidadeEspecial();
        uchirra.setHabilidadeEspecial("Rinnegan");
        
        assertNotEquals(habilidadeInicial, uchirra.getHabilidadeEspecial());
        assertEquals("Rinnegan", uchirra.getHabilidadeEspecial());
    }
}

