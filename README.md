# 🎬 Movies API - Quarkus

Projeto desenvolvido para leitura e análise de intervalos de premiação de produtores na categoria **Pior Filme** do **Golden Raspberry Awards**.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Quarkus 3.21.4
- Hibernate ORM
- Banco de dados em memória H2
- RestAssured (Testes de integração)
- JUnit5

---
##  Pré-requisitos

- Java 17 instalado
- Maven 3.8+ instalado

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone 
cd movies
``` 

### 2. Rodar a aplicação em modo desenvolvimento

```bash
mvn compile quarkus:dev
```

### 3. Testar a aplicação

```bash
curl http://localhost:8080/movies
```

---
## ⚙️ Como rodar os testes de integração

### 1. Pré-requisitos

- Java 17 instalado
- Maven 3.8+ instalado

### 2. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd movies
``` 

### 3. Rodar os testes de integração

```bash
mvn clean verify
```

---
