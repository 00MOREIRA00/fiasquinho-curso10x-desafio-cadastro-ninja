# Criação de Testes

A criação de test em Java é realizado usando o `JUnit`. E a ideia é simples, simplesmente as classes que criamos são testadas por classes de test.

O JUnit é o framework mais u tilizado para a criação de test em Java. Ele é uma biblioteca que fornece uma série de anotações e métodos para facilitar a criação de test unitários.

Para esse projeto vamos focar somente em test unitarios. Esses test unitarios são pequenos programas que testam uma parte específica do código, como um método ou uma classe. Eles são usados para garantir que o código esteja funcionando corretamente e para detectar erros o mais cedo possível.

## JUnit

O JUnit é um framework de teste para Java que permite criar e executar test unitários. Ele fornece uma série de anotações e métodos para facilitar a criação de test, como `@Test`, `@Before`, `@After`, entre outros.

Ele é utilizado para: 

    - Escrever test
    - Executar test
    - Verificar os resultados dos test

Ele é básicamente utilizado para criar um ambiente automatico de verificação do código, onde podemos garantir que o código esteja funcionando corretamente e detectar erros o mais cedo possível. Ele é uma ferramenta essencial para garantir a qualidade do código e para facilitar a manutenção do projeto.

### Como ele funciona ?

Pensa assim:

    - Você escreve uma classe de teste
    - Marca métodos com @Test
    - O JUnit:
        * encontra esses métodos
        * executa um por um
        * verifica se deu erro
        * Mostra resultado:
            ✅ passou
            ❌ falhou










