# ➕ Adicionando um Novo Clã

## 📌 Visão Geral

Este documento descreve o passo a passo para adicionar um novo clã ao sistema de gerenciamento de main.java.ninjas.

O sistema foi estruturado com herança e polimorfismo, permitindo adicionar novos clãs com poucas alterações.

---

## 🧠 Conceito

Cada clã é representado por uma classe que:

- Herda de `Ninja`
- Possui atributo `habilidadeEspecial`
- Sobrescreve métodos para comportamento específico

---

## 🧱 Passo 1: Criar a classe do novo clã

Exemplo: `Senju`

```java
package ninjas;

import ninjas.Ninja;

public class Senju extends Ninja {

    private String habilidadeEspecial;

    public Senju(String nome, int idade, String missao, String nivelDificuldade, String statusMissao, String habilidadeEspecial) {
        super(nome, idade, missao, nivelDificuldade, statusMissao);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public String getTipoCla() {
        return "Senju";
    }

    @Override
    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    @Override
    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }
}
```

---

## 🧩 Passo 2: Registrar o clã no menu

No `Main.java`, adicione o novo clã na lista `CLA_NOMES`:

```java
static final String[] CLA_NOMES = {
    "Ninja Comum",
    "Uchirra",
    "Hyuga",
    "Senju"
};
```

---

## ⚙️ Passo 3: Atualizar criação do ninja

No método `criarNinjaEspecial()`, adicione a nova opção:

```java
switch (tipoCla) {
    case 1:
        return new Uchirra(...);
    case 2:
        return new Hyuga(...);
    case 3:
        return new Senju(...);
    default:
        return new Ninja(...);
}
```

---

## 🔥 Resultado

Após esses passos:

- ✅ O novo clã pode ser criado
- ✅ Funciona automaticamente com polimorfismo
- ✅ Pode ser listado e atualizado sem alterações adicionais

---

## ⚠️ Limitação Atual

Ainda é necessário alterar o `Main.java` para registrar novos clãs manualmente.

---

## 🚀 Evolução Futura

Para eliminar essa limitação, pode-se implementar:

### 🔹 Factory Pattern

Centralizar a criação de objetos:

```java
Ninja ninja = NinjaFactory.criar(tipo, dados);
```

### 🔹 Uso de Enum

Substituir índices por valores mais seguros:

```java
enum Cla {
    COMUM,
    UCHIRRA,
    HYUGA,
    SENJU
}
```

---

## 🏁 Conclusão

O sistema permite adicionar novos clãs de forma simples, utilizando herança e polimorfismo.

Com pequenas melhorias estruturais, é possível tornar o processo totalmente automático e escalável.

### 📚 Conceitos Demonstrados

- ✔️ Extensão de sistema
- ✔️ Polimorfismo na prática
- ✔️ Documentação de evolução
