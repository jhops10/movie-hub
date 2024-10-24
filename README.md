# Movie Hub API

## Descrição

**Movie Hub API** é uma API RESTful que permite a gestão de um catálogo de filmes. Os usuários podem adicionar, atualizar, buscar e excluir filmes, além de filtrar filmes por gênero e data de lançamento.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **SWAGGER**

## Funcionalidades

- **Adicionar Filme**
- **Adicionar Lista de Filmes**
- **Buscar Todos os Filmes**
- **Buscar Filme por ID**
- **Atualizar Filme**
- **Excluir Filme**
- **Filtrar Filmes por Gênero**
- **Filtrar Filmes por Ano de Lançamento**

## Estrutura da API

### Endpoints

![](https://i.ibb.co/k6KWGDG/moviehub.jpg)


## Exemplo de Uso

### Adicionar um Filme

```json
POST /v1/movies
Content-Type: application/json

{
    "title": "The Matrix",
    "shortDescription": "A computer hacker learns about the true nature of reality.",
    "releaseYear": 1999,
    "gender": "Science Fiction",
    "director": "The Wachowskis"
}
