import ninjas.Hyuga;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Hyuga")
public class HyugaTest {

    @Test
    @DisplayName("Deve retornar clã Hyuga corretamente")
    void deveRetornarClaHyuga() {
        Hyuga hyuga = new Hyuga(
                "Hinata",
                16,
                "Proteger o Naruto",
                "Médio",
                "Em andamento",
                "Byakugan"
        );

        assertEquals("Hyuga", hyuga.getTipoCla());
    }

    @Test
    @DisplayName("Deve retornar a habilidade especial Byakugan")
    void deveRetornarHabilidadeByakugan() {
        Hyuga hyuga = new Hyuga(
                "Hinata",
                16,
                "Proteger o Naruto",
                "Médio",
                "Em andamento",
                "Byakugan"
        );

        assertEquals("Byakugan", hyuga.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Deve atualizar habilidade especial do Hyuga")
    void deveAtualizarHabilidadeHyuga() {
        Hyuga hyuga = new Hyuga(
                "Hinata",
                16,
                "Proteger o Naruto",
                "Médio",
                "Em andamento",
                "Byakugan"
        );

        hyuga.setHabilidadeEspecial("Jutsus de Palma");
        assertEquals("Jutsus de Palma", hyuga.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Hyuga herda dados do Ninja corretamente")
    void hyugaHerdaDadosNinja() {
        Hyuga hyuga = new Hyuga(
                "Neji",
                17,
                "Treinar",
                "Difícil",
                "Ativa",
                "Byakugan"
        );

        assertEquals("Neji", hyuga.getNome());
        assertEquals("Hyuga", hyuga.getTipoCla());
    }

    @Test
    @DisplayName("Hyuga com nome e idade diferentes")
    void hyugaComDadosDiferentes() {
        Hyuga hyuga = new Hyuga(
                "Hanabi",
                12,
                "Treinar",
                "Fácil",
                "Em andamento",
                "Byakugan Aprimorado"
        );

        assertEquals("Hanabi", hyuga.getNome());
        assertEquals(12, hyuga.getIdade());
        assertEquals("Byakugan Aprimorado", hyuga.getHabilidadeEspecial());
    }

    @Test
    @DisplayName("Hyuga deve ter habilidade especial definida")
    void hyugaTemHabilidadeEspecial() {
        Hyuga hyuga = new Hyuga(
                "Hinata",
                16,
                "Proteger o Naruto",
                "Médio",
                "Em andamento",
                "Byakugan"
        );

        assertNotNull(hyuga.getHabilidadeEspecial());
        assertNotEquals("Nenhuma", hyuga.getHabilidadeEspecial());
    }
}

