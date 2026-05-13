# Sistema de Gerenciamento de Ninjas

## 📋 Descrição

Este projeto é um sistema de gerenciamento de ninjas desenvolvido em Java, utilizando conceitos fundamentais de Programação Orientada a Objetos (POO) como herança e polimorfismo. O sistema permite cadastrar, listar e atualizar ninjas de diferentes clãs (Uchirra e Hyuga), cada um com habilidades especiais, através de um menu interativo no terminal.

O projeto demonstra boas práticas de organização de código em pacotes, reutilização de código via herança e extensibilidade para adição de novos clãs.

## ✨ Funcionalidades

- **Cadastro de Ninjas**: Adicione ninjas com nome, idade, missão e nível de dificuldade.
- **Listagem de Ninjas**: Visualize todos os ninjas cadastrados com suas informações.
- **Atualização de Habilidades**: Modifique as habilidades especiais dos ninjas.
- **Suporte a Clãs**: Implementação de clãs específicos (Uchirra e Hyuga) com comportamentos polimórficos.
- **Menu Interativo**: Interface simples via terminal para interação.

## 🏗️ Arquitetura

Para mais detalhes sobre a arquitetura, consulte [docs/01 - arquitetura.md](docs/01%20-%20arquitetura.md).

## 📋 Pré-requisitos

- **Java JDK**: Versão 8 ou superior (recomendado JDK 11+).
- **Maven**: Para gerenciamento de dependências e build (versão 3.6+).
- **Git**: Para clonar o repositório (opcional).

## 🚀 Instalação e Execução

### 1. Clonando o Repositório

```bash
git clone https://github.com/seu-usuario/fiasquinho-curso10x-desafio-cadastro-ninja.git
cd fiasquinho-curso10x-desafio-cadastro-ninja
```

### 2. Compilando o Projeto

```bash
mvn clean compile
```

### 3. Executando o Programa

```bash
mvn exec:java -Dexec.mainClass="Main"
```

Isso iniciará o menu interativo no terminal, onde você pode cadastrar e gerenciar ninjas.

## 🧪 Executando os Testes

O projeto inclui testes unitários usando JUnit 5. Para executá-los:

```bash
mvn test
```

Os testes cobrem as classes principais: `Ninja`, `Uchirra`, `Hyuga` e `Main`.

## 🐳 Executando com Docker (Opcional)

O projeto inclui um Dockerfile para execução em container. Certifique-se de ter o Docker instalado.

### Construindo a Imagem

```bash
docker build -t cadastro-ninja .
```

### Executando o Container

```bash
docker run -it cadastro-ninja
```

## 📁 Estrutura do Projeto

```
fiasquinho-curso10x-desafio-cadastro-ninja/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Main.java
│   │       └── ninjas/
│   │           ├── Ninja.java
│   │           ├── Uchirra.java
│   │           └── Hyuga.java
│   └── test/
│       └── java/
│           ├── MainTest.java
│           ├── NinjaTest.java
│           ├── UchirraTest.java
│           └── HyugaTest.java
├── docs/
│   ├── 01 - arquitetura.md
│   ├── 02 - caso-de-uso.md
│   ├── 03 - melhorias.md
│   ├── 04 - modelos-de-classe.md
│   ├── 05 - adicionando-cla.md
│   ├── 06 - docker.md
│   └── 07 - testes.md
├── Dockerfile
├── pom.xml
└── README.md
```

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## 📚 Documentação Adicional

- [Arquitetura do Sistema](docs/01%20-%20arquitetura.md)
- [Casos de Uso](docs/02%20-%20caso-de-uso.md)
- [Possíveis Melhorias](docs/03%20-%20melhorias.md)
- [Modelos de Classe](docs/04%20-%20modelos-de-classe.md)
- [Adicionando Novos Clãs](docs/05%20-%20adicionando-cla.md)
- [Docker](docs/06%20-%20docker.md)
- [Testes](docs/07%20-%20testes.md)
