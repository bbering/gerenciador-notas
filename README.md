# Gerenciador de Notas

Este projeto é uma simples API de gerenciamento de notas pessoais, permitindo criar, listar, atualizar e excluir notas. A API será posta em produção utilizando o Docker para containerização da aplicação, possibilitando o deploy da imagem no Render.

## Tecnologias Utilizadas

- **Spring Boot 3.4.4**
- **Java 17**
- **JPA (Java Persistence API)** com **banco de dados H2** para persistência de dados em memória
- **Lombok** para simplificação do código
- **Docker** para containerização da aplicação
- **Render** para o deploy da aplicação

## Dependências

As dependências utilizadas foram:

- **Spring Boot Starter Web**: Para criação da API.
- **Spring Boot Starter Data JPA**: Para manipulação de dados com JPA.
- **H2 Database**: Banco de dados em memória para persistência simples.
- **Spring Boot DevTools**: Para facilitar o desenvolvimento com reinicializações automáticas.
- **Lombok**: Para redução de boilerplate no código.

## Endpoints da API

| Método | Endpoint                     | Descrição                               | Corpo da requisição                       | Resposta                                                                 |
|--------|------------------------------|-----------------------------------------|--------------------------------------------|--------------------------------------------------------------------------|
| GET    | `/api/notes`                  | Verifica se a API está funcionando.     | ```{}```                                  | **Status HTTP**: `200 OK` <br> **Resposta**: <br> ```"A API está em funcionamento"``` |
| GET    | `/api/notes/list`             | Retorna a lista de todas as notas.      | ```{}```                                  | **Status HTTP**: `200 OK` <br> **Resposta**: <br> ```[ { "id": 1, "description": "Lavar a calçada", "isCompleted": true } ]``` |
| GET    | `/api/notes/list/{id}`        | Retorna uma nota específica pelo `id`.  | ```{}```                                  | **Status HTTP**: `200 OK` <br> **Resposta**: <br> ```{ "id": 1, "description": "Lavar a calçada", "isCompleted": true }``` <br> Caso não encontrado, retorna **Status HTTP**: `500 Internal Server Error` |
| POST   | `/api/notes/create`           | Cria uma nova nota.                     | ```{ "description": "Lavar a calçada", "isCompleted": true }``` | **Status HTTP**: `201 Created` <br> **Resposta**: <br> ```{ "id": 1, "description": "Lavar a calçada", "isCompleted": true }``` |
| DELETE | `/api/notes/delete/{id}`      | Deleta uma nota específica pelo `id`.   | ```{}```                                  | **Status HTTP**: `200 OK` <br> Caso não encontrado, retorna **Status HTTP**: `500 Internal Server Error` |
| PUT    | `/api/notes/update/{id}`      | Atualiza os dados de uma nota existente. | ```{ "description": "Lavar a calçada - alteração", "isCompleted": true }``` | **Status HTTP**: `200 OK` <br> **Resposta**: <br> ```{ "id": 2, "description": "Lavar a calçada - alteração", "isCompleted": true }``` |

## Como Rodar o Projeto

### Pré-requisitos

- **Java 17** ou superior
- **Maven** para build do projeto
- **Docker** para containerizar a aplicação (o projeto inclui um arquivo Dockerfile na raiz, permitindo containerizar a aplicação e construir uma imagem Docker para executar o aplicativo de forma isolada)

### Rodando localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/gerenciador-notas.git
   cd gerenciador-notas

2. Compilando e rodando o projeto com Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
A aplicação fica disponível em: `http://localhost:8080`

## Acessando a API online

Caso prefira acessar a API online, envie requisições para o URL: `https://gerenciador-notas-v1-0.onrender.com/api/notes`

**Importante:** Devido ao fato do servidor gratuito ter limitações técnicas, as requisições podem levar um tempo para serem respondidas.
