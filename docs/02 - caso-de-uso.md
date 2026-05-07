# 📋 Casos de Uso - Sistema de Gerenciamento de Ninjas

## 📌 Visão Geral

Este documento descreve como o usuário interage com o sistema de gerenciamento de main.java.ninjas.

O sistema permite:

- Cadastrar main.java.ninjas
- Listar main.java.ninjas
- Atualizar informações de main.java.ninjas

---

## 👤 Ator

**Usuário do sistema** (via terminal)

---

## 🎯 Caso de Uso 1: Adicionar Ninja

### Descrição
Permite ao usuário cadastrar um novo ninja no sistema.

### Fluxo principal

1. Usuário seleciona a opção "Adicionar ninja"
2. Sistema exibe os tipos de clã disponíveis
3. Usuário escolhe o tipo de ninja
4. Sistema solicita:
    - Nome
    - Idade
    - Missão
    - Nível de dificuldade
    - Status da missão
5. Se for um clã especial:
    - Sistema solicita habilidade especial
6. Sistema cria o ninja
7. Ninja é adicionado à lista

### Resultado esperado
Ninja cadastrado com sucesso

---

## 📄 Caso de Uso 2: Listar Ninjas

### Descrição
Permite visualizar todos os main.java.ninjas cadastrados.

### Fluxo principal

1. Usuário seleciona a opção "Listar main.java.ninjas"
2. Sistema percorre a lista de main.java.ninjas
3. Sistema exibe as informações de cada ninja

### Resultado esperado
Lista de main.java.ninjas exibida no terminal

---

## ✏️ Caso de Uso 3: Atualizar Ninja

### Descrição
Permite atualizar os dados de um ninja existente.

### Fluxo principal

1. Usuário seleciona a opção "Atualizar ninja"
2. Sistema exibe a lista de main.java.ninjas
3. Usuário escolhe um ninja
4. Sistema solicita novos dados:
    - Nome
    - Idade
    - Missão
    - Nível de dificuldade
    - Status
5. Se for um clã especial:
    - Sistema solicita nova habilidade especial
6. Sistema atualiza o ninja

### Resultado esperado
Dados do ninja atualizados com sucesso

---

## ⚠️ Validações

O sistema possui validações para garantir integridade dos dados:

- Nome não pode ser vazio
- Idade deve ser entre 1 e 120
- Campos obrigatórios não podem ser vazios
- Opções de menu devem ser válidas

---

## 🚫 Fluxos Alternativos

### Entrada inválida

- Se o usuário digitar texto em vez de número:
    - Sistema exibe erro
    - Solicita novamente

### Campo vazio

- Sistema impede continuar
- Solicita novo valor

---

## 🧠 Observações

- O sistema funciona via terminal
- Os dados são armazenados em memória (`ArrayList`)
- Não há persistência após encerrar o programa

---

## 🚀 Possíveis Extensões

- Remover ninja
- Buscar ninja por nome
- Salvar dados em arquivo
- Interface gráfica