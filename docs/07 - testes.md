# Testes - Sistema de Gerenciamento de Ninjas

## Por que usar o JUnit?

Toda vez que você altera um código, existe o risco de quebrar algo que funcionava antes. Fazer isso manualmente — rodar o programa, digitar dados, verificar a saída — é lento, chato e não garante que você testou tudo.

O **JUnit** resolve esse problema: você escreve uma vez as verificações que precisam ser feitas, e ele as executa automaticamente sempre que quiser. Em segundos você sabe se tudo continua funcionando.

### O que o JUnit oferece

- `@Test` — marca um método como um teste a ser executado
- `@DisplayName` — dá um nome legível ao teste, facilita entender o que falhou
- `assertEquals(esperado, recebido)` — verifica se dois valores são iguais
- `assertNotNull(valor)` — verifica se o valor não é nulo
- `assertNotEquals(a, b)` — verifica se dois valores são diferentes
- `assertTrue(condição)` — verifica se uma condição é verdadeira

### Como funciona na prática

```
Você escreve uma classe de teste
  → Marca métodos com @Test
  → O JUnit encontra esses métodos
  → Executa um por um
  → Mostra o resultado:
      ✅ passou
      ❌ falhou
```

---

## Testes criados

### NinjaTest — 12 testes

Testa a classe base `Ninja`, verificando atributos, getters, setters e o comportamento padrão de um ninja comum.

| Teste | O que verifica |
|---|---|
| `deveRetornarClaNenhumParaNinjaComum` | Ninja comum retorna clã `"Nenhum"` |
| `deveRetornarHabilidadeNenhumaParaNinjaComum` | Ninja comum retorna habilidade `"Nenhuma"` |
| `deveRetornarNomeCorreto` | `getNome()` retorna o valor passado no construtor |
| `deveAtualizarNome` | `setNome()` atualiza o nome corretamente |
| `deveAtualizarIdade` | `setIdade()` atualiza a idade corretamente |
| `deveAtualizarMissao` | `setMissao()` atualiza a missão corretamente |
| `deveAtualizarDificuldade` | `setNivelDificuldade()` atualiza o nível corretamente |
| `deveAtualizarStatus` | `setStatusMissao()` atualiza o status corretamente |
| `ninjaComIdadeMinima` | Ninja pode ser criado com idade 1 |
| `ninjaComIdadeMaxima` | Ninja pode ser criado com idade 120 |
| `naoPermiteHabilidadeEmNinjaComum` | `setHabilidadeEspecial()` não tem efeito em ninja comum — continua retornando `"Nenhuma"` |
| `ninjaNomeVazio` | Ninja pode ser criado com nome vazio — valida que `getNome()` retorna string vazia |

---

### HyugaTest — 6 testes

Testa a classe `Hyuga`, garantindo que herda corretamente de `Ninja` e que possui seu próprio comportamento de habilidade especial.

| Teste | O que verifica |
|---|---|
| `deveRetornarClaHyuga` | `getTipoCla()` retorna `"Hyuga"` |
| `deveRetornarHabilidadeByakugan` | `getHabilidadeEspecial()` retorna o valor passado no construtor |
| `deveAtualizarHabilidadeHyuga` | `setHabilidadeEspecial()` atualiza a habilidade corretamente |
| `hyugaHerdaDadosNinja` | Nome e clã são retornados corretamente via herança |
| `hyugaComDadosDiferentes` | Diferentes ninjas Hyuga têm seus dados independentes |
| `hyugaTemHabilidadeEspecial` | Habilidade não é nula e não é `"Nenhuma"` |

---

### UchirraTest — 7 testes

Testa a classe `Uchirra`, garantindo que herda corretamente de `Ninja` e que permite evoluir a habilidade especial.

| Teste | O que verifica |
|---|---|
| `deveRetornarClaUchirra` | `getTipoCla()` retorna `"Uchirra"` |
| `deveRetornarHabilidadeSharingan` | `getHabilidadeEspecial()` retorna o valor passado no construtor |
| `deveAtualizarHabilidadeUchirra` | `setHabilidadeEspecial()` atualiza a habilidade corretamente |
| `uchirraHerdaDadosNinja` | Nome e clã são retornados corretamente via herança |
| `uchirraComDadosDiferentes` | Diferentes ninjas Uchirra têm seus dados independentes |
| `uchirraTemHabilidadeEspecial` | Habilidade não é nula e não é `"Nenhuma"` |
| `uchirraEvoluirHabilidade` | A habilidade pode ser trocada e o valor antigo é diferente do novo |

---

### MainTest — 22 testes

Testa os métodos utilitários de leitura e validação de entrada da classe `Main`. Como esses métodos leem do terminal, os testes simulam a entrada do usuário via `ByteArrayInputStream`.

#### `lerStringNaoVazia` — 5 testes

| Teste | O que verifica |
|---|---|
| `deveLerStringNaoVaziaComSucesso` | Lê e retorna uma string normalmente |
| `deveTrimmmarEspacosBrancos` | Remove espaços no início e no fim da string |
| `deveRejeiatrVazioEAceitarValido` | Rejeita entrada vazia e espera uma nova entrada válida |
| `deveAceitarStringComNumeros` | Aceita strings com números misturados |
| `deveAceitarCaracteresEspeciais` | Aceita caracteres especiais como `ã`, `!`, `-` |

#### `lerInteiro` — 4 testes

| Teste | O que verifica |
|---|---|
| `deveLerInteiroValido` | Lê e retorna um número inteiro corretamente |
| `deveRejeiatrTextoEAceitarInteiro` | Rejeita texto e aguarda um número válido |
| `deveAceitarNumeroNegativo` | Aceita números negativos |
| `deveAceitarZero` | Aceita zero como entrada |

#### `lerIdade` — 6 testes

| Teste | O que verifica |
|---|---|
| `deveLerIdadeValida` | Lê uma idade válida dentro do intervalo |
| `deveAceitarIdadeMinima` | Aceita o valor mínimo: 1 |
| `deveAceitarIdadeMaxima` | Aceita o valor máximo: 120 |
| `deveRejeiatrZeroEAceitarValido` | Rejeita 0 e aguarda valor válido |
| `deveRejeiatrMaiorQue120EAceitarValido` | Rejeita 121+ e aguarda valor válido |
| `deveRejeiatrNegativoEAceitarValido` | Rejeita negativos e aguarda valor válido |

#### `lerOpcaoMenu` — 6 testes

| Teste | O que verifica |
|---|---|
| `deveAceitarOpcaoValida` | Aceita opção dentro do intervalo do menu |
| `deveAceitarOpcaoMinima` | Aceita opção 1 (mínima) |
| `deveAceitarOpcaoMaxima` | Aceita a opção máxima configurada |
| `deveRejeiatrOpcaoMenorQue1` | Rejeita 0 e aguarda opção válida |
| `deveRejeiatrOpcaoMaiorQueMaximo` | Rejeita valor acima do máximo e aguarda opção válida |
| `deveRejeiatrTextoEAceitarOpcao` | Rejeita texto e aguarda um número válido |

#### `lerOpcaoIntervalo` — 7 testes

| Teste | O que verifica |
|---|---|
| `deveAceitarOpcaoDentroDoIntervalo` | Aceita valor dentro do intervalo definido |
| `deveAceitarValorMinimo` | Aceita o valor mínimo do intervalo |
| `deveAceitarValorMaximo` | Aceita o valor máximo do intervalo |
| `deveRejeiatrMenorQueMinimo` | Rejeita valor abaixo do mínimo e aguarda válido |
| `deveRejeiatrMaiorQueMaximo` | Rejeita valor acima do máximo e aguarda válido |
| `deveRejeiatrTextoEAceitarValor` | Rejeita texto e aguarda número válido |
| `deveTrabalharComIntervaloCustomizado` | Funciona com intervalos diferentes de `1-4` |

---

## Resumo

| Classe testada | Testes |
|---|---|
| `Ninja` | 12 |
| `Hyuga` | 6 |
| `Uchirra` | 7 |
| `Main` | 22 |
| **Total** | **47** |