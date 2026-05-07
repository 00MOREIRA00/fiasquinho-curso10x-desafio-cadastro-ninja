import ninjas.Ninja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaTest {

    @Test
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
}