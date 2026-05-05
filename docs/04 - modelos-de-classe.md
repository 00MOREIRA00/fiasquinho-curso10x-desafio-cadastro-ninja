# 🧩 Modelo de Classes - Sistema de Gerenciamento de Ninjas

## 📌 Visão Geral

Este documento descreve as principais classes do sistema, seus atributos, métodos e responsabilidades.

O sistema utiliza herança e polimorfismo para representar diferentes tipos de ninjas.

---

## 🥷 Classe `Ninja`

### Responsabilidade

Representa um ninja comum e serve como classe base para os demais clãs.

### Atributos

- `nome`
- `idade`
- `missao`
- `nivelDificuldade`
- `statusMissao`

### Métodos

- `mostrarInformacoes()`
- `getTipoCla()`
- `getHabilidadeEspecial()`
- `setHabilidadeEspecial()`
- `getNome()`
- `setNome()`
- `setIdade()`
- `setMissao()`
- `setNivelDificuldade()`
- `setStatusMissao()`

### Comportamento padrão

Um `Ninja` comum não possui clã específico nem habilidade especial.

---

## 🔴 Classe `Uchirra`

### Responsabilidade

Representa um ninja do clã Uchirra.

### Herança

```java
public class Uchirra extends Ninja
```

### Atributos

- `habilidadeEspecial`

### Métodos sobrescritos

- `getTipoCla()`
- `getHabilidadeEspecial()`
- `setHabilidadeEspecial()`

### Comportamento

Retorna o clã Uchirra e permite cadastrar ou atualizar uma habilidade especial.

---

## 👁️ Classe `Hyuga`

### Responsabilidade

Representa um ninja do clã Hyuga.

### Herança

```java
public class Hyuga extends Ninja
```

### Atributos

- `habilidadeEspecial`

### Métodos sobrescritos

- `getTipoCla()`
- `getHabilidadeEspecial()`
- `setHabilidadeEspecial()`

### Comportamento

Retorna o clã Hyuga e permite cadastrar ou atualizar uma habilidade especial.

🧠 Relação entre as Classes
Ninja
├── Uchirra
└── Hyuga
⚡ Polimorfismo no Modelo

Todas as classes podem ser tratadas como Ninja.

Exemplo:

ArrayList<Ninja> ninjas = new ArrayList<>();

Isso permite armazenar diferentes tipos de ninjas na mesma lista:

ninjas.add(new Ninja(...));
ninjas.add(new Uchirra(...));
ninjas.add(new Hyuga(...));

Mesmo sendo tratados como Ninja, cada objeto executa seu próprio comportamento quando métodos sobrescritos são chamados.

🏁 Conclusão

O modelo de classes foi criado para aplicar conceitos de POO, principalmente:

Herança
Encapsulamento
Polimorfismo
Reutilização de código