# Stentio — Backend

Backend do projeto Stentio, desenvolvido em Java 25 com Spring Boot, seguindo uma arquitetura de microsserviços. Este serviço utiliza PostgreSQL, MongoDB e RabbitMQ.

## Stack

- Linguagem: Java 25
- Framework: Spring Boot 4.1.1
- Build tool: Gradle
- Bancos de dados: PostgreSQL (relacional) e MongoDB (não relacional)
- Mensageria: RabbitMQ
- Containerização: Docker / Docker Compose

## Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- JDK 25 (sudo apt install openjdk-25-jdk no Debian/Ubuntu)
- Docker e Docker Compose
- Git

## Como rodar localmente

### 1. Clone o repositório

    git clone https://github.com/Equipe-SUL/5-ADS-API.git
    cd 5-ADS-API

### 2. Configure as variáveis de ambiente

Na raiz do repositório (não dentro de backend/), copie o arquivo de exemplo:

    cp .env.example .env

Os valores padrão já funcionam para desenvolvimento local — não é necessário editar nada para rodar o projeto pela primeira vez.

### 3. Suba os containers (Postgres, MongoDB, RabbitMQ)

Ainda na raiz do repositório:

    docker compose up -d

Confirme que os três serviços subiram corretamente:

    docker compose ps

Você deve ver postgresdb, mongodb-local e rabbitmq-local com status Up.

### 4. Rode a aplicação Spring Boot

    cd backend
    chmod +x gradlew
    ./gradlew bootRun

Na primeira execução, o Gradle vai baixar as dependências — isso pode levar alguns minutos. Aguarde até aparecer no log algo como:

    Started StentioApplication in X seconds

A aplicação ficará rodando nesse terminal (isso é esperado, não é um travamento). Para parar, use Ctrl+C.

### 5. Verifique se está tudo funcionando

Em outro terminal (sem fechar o anterior), rode:

    curl http://localhost:8080/actuator/health

Se a resposta vier com "status":"UP", o backend está rodando corretamente e conectado aos bancos de dados.

## Estrutura do projeto

    backend/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/example/stentio/
    │   │   │   ├── StentioApplication.java
    │   │   │   ├── controller/     # Endpoints REST
    │   │   │   ├── service/        # Regras de negócio
    │   │   │   ├── repository/     # Acesso a dados (JPA / MongoDB)
    │   │   │   ├── model/          # Entidades
    │   │   │   ├── dto/            # Objetos de transferência (request/response)
    │   │   │   ├── config/         # Configurações (RabbitMQ, etc.)
    │   │   │   └── exception/      # Tratamento de exceções
    │   │   └── resources/
    │   │       └── application.yaml
    │   └── test/
    ├── build.gradle
    └── settings.gradle

## Portas utilizadas

| Serviço          | Porta  |
|------------------|--------|
| Aplicação (API)  | 8080   |
| PostgreSQL       | 5432   |
| MongoDB          | 27017  |
| RabbitMQ (AMQP)  | 5672   |
| RabbitMQ (painel)| 15672  |

O painel de gerenciamento do RabbitMQ fica disponível em http://localhost:15672 (usuário/senha definidos no .env).

## Observações

- O health-check do MongoDB (/actuator/health) está desativado (management.health.mongodb.enabled: false) devido a um bug conhecido do Spring Boot 4.x nessa verificação específica. A conexão real com o MongoDB funciona normalmente para leitura e escrita — apenas o indicador de saúde automático está desligado.
- Para parar os containers Docker: docker compose down (na raiz do repositório).
- Para parar os containers e apagar os dados (reset completo dos bancos): docker compose down -v.
