# CRUD de Chamados de TI

API REST desenvolvida com Java e Spring Boot para gerenciamento de chamados de suporte.

## Sobre o projeto

Este projeto foi criado com o objetivo de praticar operações de CRUD em uma aplicação backend, utilizando uma estrutura organizada em camadas e integração com banco de dados relacional.

A aplicação permite cadastrar, listar, buscar, atualizar e remover chamados de suporte técnico.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Lombok

## Funcionalidades

- Criar chamado
- Listar todos os chamados
- Buscar chamado por ID
- Atualizar chamado
- Excluir chamado
- Buscar chamados por status
- Buscar chamados por prioridade

## Estrutura do projeto

```text
src/main/java/com/samuel/chamados
├── controller
├── entity
├── enums
├── repository
├── service
└── CrudChamadosTiApplication.java
