import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Main - Validadores de Entrada")
public class MainTest {

    // ===== TESTES lerStringNaoVazia =====
    @Test
    @DisplayName("Deve ler string não vazia com sucesso")
    void deveLerStringNaoVaziaComSucesso() {
        String entrada = "Naruto\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        String resultado = Main.lerStringNaoVazia(sc, "Nome:");
        
        assertEquals("Naruto", resultado);
    }

    @Test
    @DisplayName("Deve trimmar espaços em branco da string")
    void deveTrimmmarEspacosBrancos() {
        String entrada = "  Sasuke  \n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        String resultado = Main.lerStringNaoVazia(sc, "Nome:");
        
        assertEquals("Sasuke", resultado);
    }

    @Test
    @DisplayName("Deve rejeitar string vazia na primeira tentativa e aceitar na segunda")
    void deveRejeiatrVazioEAceitarValido() {
        String entrada = "\nNaruto\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        String resultado = Main.lerStringNaoVazia(sc, "Nome:");
        
        assertEquals("Naruto", resultado);
    }

    @Test
    @DisplayName("Deve aceitar string com números")
    void deveAceitarStringComNumeros() {
        String entrada = "Missão 123\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        String resultado = Main.lerStringNaoVazia(sc, "Missão:");
        
        assertEquals("Missão 123", resultado);
    }

    @Test
    @DisplayName("Deve aceitar string com caracteres especiais")
    void deveAceitarCaracteresEspeciais() {
        String entrada = "Missão-Fácil!\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        String resultado = Main.lerStringNaoVazia(sc, "Missão:");
        
        assertEquals("Missão-Fácil!", resultado);
    }

    // ===== TESTES lerInteiro =====
    @Test
    @DisplayName("Deve ler inteiro válido com sucesso")
    void deveLerInteiroValido() {
        String entrada = "25\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerInteiro(sc, "Idade:");
        
        assertEquals(25, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar texto e aceitar inteiro válido")
    void deveRejeiatrTextoEAceitarInteiro() {
        String entrada = "abc\n15\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerInteiro(sc, "Idade:");
        
        assertEquals(15, resultado);
    }

    @Test
    @DisplayName("Deve aceitar número negativo")
    void deveAceitarNumeroNegativo() {
        String entrada = "-10\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerInteiro(sc, "Número:");
        
        assertEquals(-10, resultado);
    }

    @Test
    @DisplayName("Deve aceitar zero")
    void deveAceitarZero() {
        String entrada = "0\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerInteiro(sc, "Número:");
        
        assertEquals(0, resultado);
    }

    // ===== TESTES lerIdade =====
    @Test
    @DisplayName("Deve ler idade válida entre 1 e 120")
    void deveLerIdadeValida() {
        String entrada = "25\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(25, resultado);
    }

    @Test
    @DisplayName("Deve aceitar idade 1 (mínima)")
    void deveAceitarIdadeMinima() {
        String entrada = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Deve aceitar idade 120 (máxima)")
    void deveAceitarIdadeMaxima() {
        String entrada = "120\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(120, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar idade 0 e aceitar idade válida")
    void deveRejeiatrZeroEAceitarValido() {
        String entrada = "0\n25\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(25, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar idade 121 e aceitar idade válida")
    void deveRejeiatrMaiorQue120EAceitarValido() {
        String entrada = "121\n30\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(30, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar idade negativa e aceitar idade válida")
    void deveRejeiatrNegativoEAceitarValido() {
        String entrada = "-5\n20\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerIdade(sc);
        
        assertEquals(20, resultado);
    }

    // ===== TESTES lerOpcaoMenu =====
    @Test
    @DisplayName("Deve aceitar opção válida do menu")
    void deveAceitarOpcaoValida() {
        String entrada = "2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Deve aceitar opção mínima (1)")
    void deveAceitarOpcaoMinima() {
        String entrada = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Deve aceitar opção máxima")
    void deveAceitarOpcaoMaxima() {
        String entrada = "4\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(4, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar opção menor que 1")
    void deveRejeiatrOpcaoMenorQue1() {
        String entrada = "0\n2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar opção maior que máximo")
    void deveRejeiatrOpcaoMaiorQueMaximo() {
        String entrada = "5\n3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(3, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar texto e aceitar opção válida")
    void deveRejeiatrTextoEAceitarOpcao() {
        String entrada = "abc\n1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoMenu(sc, 4);
        
        assertEquals(1, resultado);
    }

    // ===== TESTES lerOpcaoIntervalo =====
    @Test
    @DisplayName("Deve aceitar opção dentro do intervalo")
    void deveAceitarOpcaoDentroDoIntervalo() {
        String entrada = "2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Deve aceitar valor mínimo do intervalo")
    void deveAceitarValorMinimo() {
        String entrada = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Deve aceitar valor máximo do intervalo")
    void deveAceitarValorMaximo() {
        String entrada = "5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar valor menor que mínimo")
    void deveRejeiatrMenorQueMinimo() {
        String entrada = "0\n3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(3, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar valor maior que máximo")
    void deveRejeiatrMaiorQueMaximo() {
        String entrada = "6\n2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Deve rejeitar texto e aceitar valor válido")
    void deveRejeiatrTextoEAceitarValor() {
        String entrada = "xyz\n4\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 1, 5);
        
        assertEquals(4, resultado);
    }

    @Test
    @DisplayName("Deve trabalhar com intervalo diferente (2-10)")
    void deveTrabalharComIntervaloCustomizado() {
        String entrada = "5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        
        int resultado = Main.lerOpcaoIntervalo(sc, 2, 10);
        
        assertEquals(5, resultado);
    }
}

