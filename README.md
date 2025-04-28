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

Ou

- Docker instalado

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/RichardPFernandes/outsera-movies.git
cd movies
```

### 2. Rodando a aplicação

### Rodando com Docker

#### 2.1 Build da Imagem Docker

```bash
docker build -t movies-api .
```

#### 2.2 Rodando a aplicação

```bash
docker run -p 8080:8080 movies-api
```

---

### Rodando Sem Docker

#### 2.1 Rodando a aplicação

```bash
mvn compile quarkus:dev
```

#### 2.2 Testar a aplicação

```bash
curl http://localhost:8080/movies
```

---
## ⚙️ Como rodar os testes de integração

### 1. Clonar o repositório

```bash
git clone https://github.com/RichardPFernandes/outsera-movies.git
cd movies
``` 

### 2. Rodar os testes de integração

```bash
mvn clean verify
```

---
