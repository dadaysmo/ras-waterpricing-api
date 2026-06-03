# Desafio Técnico - API de Tabela Tarifária de Água

API RESTful desenvolvida em Java com Spring Boot para gerenciar e calcular tarifas de água com base em categorias de consumidores e faixas de consumo progressivas. O sistema é totalmente parametrizável via banco de dados.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x** (Web, Data JPA, Validation)
- **PostgreSQL**
- **Maven**

## Pré-requisitos
Para rodar este projeto, você precisará ter instalado em sua máquina:

- [JDK 17](https://adoptium.net/)
- [PostgreSQL](https://www.postgresql.org/)
- [Git](https://git-scm.com/)

## 🚀 Configuração e Execução

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/dadaysmo/ras-waterpricing-api.git](https://github.com/dadaysmo/ras-waterpricing-api.git)
   cd ras-waterpricing-api

2. **Configuração do BD:**
   ```SQL
   CREATE DATABASE ras_waterpricing_api;
   CREATE USER springuser WITH PASSWORD 'senha123';
   GRANT ALL PRIVILEGES ON DATABASE ras_waterpricing_api TO springuser;

3. **Execute a aplicação:**
   Na raiz do projeto, rode o comando Maven:
   ```bash
   ./mvnw spring-boot:run

A API estará rodando em http://localhost:8080.

## Endpoints da API
Gerenciamento de Tabelas Tarifárias

1. Criar Tabela Tarifária (Cadastro em Lote)

- POST /api/tabelas-tarifarias
- Body (JSON):
   ´´J́SON
   {
      "nome": "Tabela Padrão 2026",
      "dataVigencia": "2026-06-03",
      "categorias": [
         {
            "categoria": "INDUSTRIAL",
            "faixas": [
               { "inicio": 0, "fim": 10, "valorUnitario": 1.00 },
               { "inicio": 11, "fim": 20, "valorUnitario": 2.00 },
               { "inicio": 21, "fim": 99999, "valorUnitario": 5.00 }
            ]
         }
      ]
   }

2. Listar Tabelas Tarifárias

GET /api/tabelas-tarifarias

3. Excluir Tabela Tarifária

DELETE /api/tabelas-tarifarias/{id}