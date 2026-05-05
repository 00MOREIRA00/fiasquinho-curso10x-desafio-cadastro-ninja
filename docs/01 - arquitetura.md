# 🧠 Arquitetura do Sistema de Gerenciamento de Ninjas

## 📌 Visão Geral

Este projeto é um sistema de gerenciamento de ninjas desenvolvido em Java, com foco em:

- Programação orientada a objetos (POO)
- Uso de herança
- Aplicação de polimorfismo
- Organização por pacotes

O sistema permite cadastrar, listar e atualizar ninjas, incluindo diferentes clãs com habilidades específicas.

---

## 📁 Estrutura do Projeto

````
src/
├── ninjas/
│ ├── Ninja.java
│ ├── Uchirra.java
│ └── Hyuga.java
└── Main.java
````

---


---

## 🧱 Organização por Pacotes

### `package ninjas`

Contém todas as classes de domínio do sistema:

- `Ninja` → classe base
- `Uchirra` → herda de Ninja
- `Hyuga` → herda de Ninja

---

## 🧩 Modelo de Classes

### 🔹 Ninja (Classe Base)

Responsável por representar um ninja genérico.

**Atributos:**
- nome
- idade
- missão
- nível de dificuldade
- status da missão

**Métodos principais:**
- `mostrarInformacoes()`
- `getTipoCla()`
- `getHabilidadeEspecial()`
- `setHabilidadeEspecial()`

---

### 🔹 Uchirra

- Herda de `Ninja`
- Possui habilidade especial
- Sobrescreve métodos para comportamento específico

---

### 🔹 Hyuga

- Herda de `Ninja`
- Possui habilidade especial
- Sobrescreve métodos para comportamento específico

---

## 🔥 Herança

O sistema utiliza herança para reaproveitamento de código:

````
Ninja
├── Uchirra
└── Hyuga
````
---

## ⚡ Polimorfismo

O polimorfismo permite que diferentes tipos de ninja respondam de forma diferente aos mesmos métodos.

**Exemplo:**

ninja.getTipoCla()

ninja.getHabilidadeEspecial()


Cada classe implementa seu próprio comportamento, eliminando a necessidade de:

- `instanceof`
- múltiplos `if`

---

## 🎯 Papel do Main

A classe `Main` é responsável por:

- Controle do fluxo do sistema
- Exibição de menus
- Entrada de dados do usuário
- Gerenciamento da lista de ninjas

---

## 📦 Armazenamento de Dados

Atualmente, os dados são armazenados em memória utilizando:

ArrayList<Ninja>


Não há persistência de dados (banco ou arquivo).

---

## 🚀 Extensibilidade

O sistema foi projetado para facilitar a adição de novos clãs.

**Para adicionar um novo clã:**

1. Criar uma nova classe que herda de `Ninja`
2. Sobrescrever os métodos necessários
3. Integrar no menu do sistema

---

## ⚠️ Limitações atuais

- Uso de `if` no `Main` para criação de classes
- Não possui persistência de dados
- Interface apenas via terminal

---

## 💡 Possíveis melhorias

- Implementar Factory Pattern
- Adicionar persistência (arquivo ou banco de dados)
- Criar interface gráfica
- Melhorar validações
- Usar enum para clãs

---

## 🏁 Conclusão

O projeto demonstra conceitos fundamentais de POO em Java, com foco em organização, reutilização de código e facilidade de extensão.

