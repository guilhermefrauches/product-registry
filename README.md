# 📦 Product Registry Management System

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

> **Sistema de gerenciamento de produtos desenvolvido em Java Puro, com foco em Arquitetura MVC, Clean Code e Boas Práticas.**

---

## 🎯 Objetivo do Projeto
Este projeto marca o encerramento do meu ciclo de estudos em Java Puro (Java SE). O foco aqui não foi utilizar frameworks prontos, mas sim entender como as coisas funcionam: arquitetura em camadas, manipulação de coleções em memória e lógica de programação.

---

## ♻️ Refatoração e Melhorias Implementadas

* **Arquitetura:** Extraí toda a lógica de controle da `Main` para uma classe dedicada `MenuController`, respeitando o Princípio da Responsabilidade Única (SRP).
* **Performance:** Substituí estruturas legadas (`Vector`) por modernas (`ArrayList`), alinhando o projeto aos padrões de mercado.
* **Separação de Camadas:** Removi dependências de interface gráfica (`Swing`) de dentro dos Repositórios. Agora, o Repositório apenas manipula dados.
* **UX/Usabilidade:**
    * Correção de loops que travavam o botão "Cancelar".
    * Implementação de validações que impedem o usuário de cadastrar produtos sem categorias existentes.

---

## 🚀 Funcionalidades
* [x] **Gestão de Categorias:** Cadastro e listagem.
* [x] **Gestão de Produtos:** Cadastro vinculado a categorias, edição e busca.
* [x] **Persistência em Memória:** Simulação de banco de dados com listas estáticas.
* [x] **Interface Gráfica:** Interação via janelas nativas do SO.

---

## 🔮 Próximos Passos (Roadmap)
Agora que a base (Java Core) está sólida e limpa, os próximos passos são evoluir a stack:
- [ ] Migração para **Spring Boot 3**.
- [ ] Implementação de Banco de Dados **PostgreSQL** ou **MySQL**.

---

## 🛠️ Tecnologias
* **Java 17** (Streams API, Lambda Expressions)
* **Git** (Versionamento com Semantic Commits)

---

## ⚙️ Como Executar
1. Clone o repositório:
   `git clone https://github.com/guilhermefrauches/product-registry.git`
2. Abra o projeto na sua IDE de preferência.
3. Execute a classe `Main.java`.

---
**Desenvolvido por [Guilherme Frauches](https://www.linkedin.com/in/guilhermefrauches/)**
