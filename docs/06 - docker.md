# 🐳 Docker - Imagem do Projeto

## 📌 Visão Geral

Este documento descreve as opções disponíveis para containerizar o projeto e explica o motivo da escolha da abordagem **Multi-stage build**.

---

## 🧠 Como Java funciona no Docker

Java possui dois passos distintos antes de executar:

1. **Build** — o Maven compila os arquivos `.java` e gera um `.jar`
2. **Run** — a JVM executa o `.jar` gerado

Esses dois passos podem ser feitos de formas diferentes dentro do Docker, o que origina as opções abaixo.

---

## 📦 Opção 1: Tudo junto (imagem única)

Uma única imagem contendo JDK + Maven. Ela compila e executa o projeto.

```dockerfile
FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn package -DskipTests
CMD ["java", "-jar", "target/desafio-cadastro-ninja-1.0-SNAPSHOT.jar"]
```

**Prós:**
- Simples de entender e escrever
- Bom para aprender

**Contras:**
- Imagem final muito pesada (~600MB+)
- Inclui Maven e todo o código-fonte na imagem de produção
- Não é recomendado para uso real

---

## 📦 Opção 2: Build local + execução no Docker

O `.jar` é gerado na máquina local com `mvn package`, e o Dockerfile apenas copia e executa esse arquivo.

```dockerfile
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

**Prós:**
- Dockerfile simples
- Imagem final leve

**Contras:**
- Depende do Maven instalado localmente
- O build não é reproduzível: ambiente local pode diferir de outros ambientes
- Não é portátil — outro desenvolvedor precisa compilar antes de usar o Docker

---

## 📦 Opção 3: Multi-stage build ✅ Escolhida

Usa duas imagens em sequência dentro do mesmo Dockerfile:

- **Estágio 1** (`maven`) — compila o projeto e gera o `.jar`
- **Estágio 2** (`jre`) — recebe apenas o `.jar` e executa

```dockerfile
# Estágio 1: build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Estágio 2: runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

**Prós:**
- Imagem final leve — não carrega Maven nem código-fonte
- Build totalmente contido no Docker — não depende do ambiente local
- Portátil: qualquer pessoa com Docker consegue buildar e rodar
- Padrão usado em produção no mercado

**Contras:**
- Dockerfile um pouco mais extenso
- Conceito de dois estágios pode ser menos intuitivo para iniciantes

---

## 🏆 Por que Multi-stage?

| Critério | Tudo junto | Build local | Multi-stage |
|---|---|---|---|
| Imagem final leve | ❌ | ✅ | ✅ |
| Não depende do ambiente local | ✅ | ❌ | ✅ |
| Portátil para outros devs | ✅ | ❌ | ✅ |
| Padrão de mercado | ❌ | ❌ | ✅ |

A opção **Multi-stage** combina o melhor dos dois mundos: o build é feito dentro do Docker (sem depender do ambiente local), e a imagem final entregue é leve, contendo apenas o necessário para executar a aplicação.

---

## 🔍 Entendendo o Dockerfile linha a linha

```dockerfile
# Estágio 1: build
FROM maven:3.9-eclipse-temurin-17 AS build
```

`FROM` define qual imagem base será usada. Aqui usamos a imagem oficial do Maven com Java 17 já incluído. O `AS build` dá um nome a este estágio para referenciarmos depois.

---

```dockerfile
WORKDIR /app
```

Define o diretório de trabalho dentro do container. Todos os comandos seguintes serão executados a partir de `/app`. Se a pasta não existir, o Docker a cria automaticamente.

---

```dockerfile
COPY pom.xml .
COPY src ./src
```

Copia os arquivos do projeto para dentro do container. O `pom.xml` é copiado primeiro, separado do código-fonte — isso é uma boa prática: o Docker tem um sistema de cache por camadas, e se o `pom.xml` não mudar, ele reutiliza o cache das dependências baixadas anteriormente, tornando os builds seguintes mais rápidos.

---

```dockerfile
RUN mvn package -DskipTests
```

Executa o Maven para compilar o projeto e gerar o `.jar`. A flag `-DskipTests` pula a execução dos testes neste momento (o build seria mais lento com eles). O arquivo gerado fica em `target/desafio-cadastro-ninja-1.0-SNAPSHOT.jar`.

---

```dockerfile
# Estágio 2: runtime
FROM eclipse-temurin:17-jre
```

Inicia um novo estágio com uma imagem diferente, bem mais leve. `jre` (Java Runtime Environment) é o suficiente para *executar* um `.jar` — ao contrário do `jdk`, que inclui ferramentas de desenvolvimento. Isso reduz o tamanho final da imagem.

---

```dockerfile
WORKDIR /app
```

Define novamente o diretório de trabalho, agora na segunda imagem.

---

```dockerfile
COPY --from=build /app/target/desafio-cadastro-ninja-1.0-SNAPSHOT.jar app.jar
```

Aqui está a mágica do multi-stage: `--from=build` diz ao Docker para copiar um arquivo do estágio anterior (chamado `build`) para esta imagem. Trazemos apenas o `.jar` gerado — nada do Maven, nada do código-fonte. O arquivo é renomeado para `app.jar` por simplicidade.

---

```dockerfile
CMD ["java", "-jar", "app.jar"]
```

Define o comando padrão executado quando o container inicia. `java -jar app.jar` roda o `.jar` usando a JVM. O formato de lista `["java", "-jar", "app.jar"]` é o recomendado (forma `exec`), pois o processo Java se torna o processo principal do container.

---

## ⚠️ Observação: projeto interativo

Este projeto utiliza `Scanner` para leitura de input do terminal. Para executar o container corretamente, é necessário usar as flags `-it` no `docker run`:

```bash
docker run -it desafio-cadastro-ninja
```

Sem essas flags, o container encerrará imediatamente ao tentar ler a entrada do usuário.