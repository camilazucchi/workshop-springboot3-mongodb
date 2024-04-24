# Projeto: API Restful com Spring Boot e MongoDB (Web Services + NoSQL)
Este projeto foi desenvolvido através do curso de Programação Orientada a Objetos com Java. Trata-se de um CRUD feito com Spring Boot e MongoDB.
## Objetivo geral
- Implementar operações de CRUD
- Implementar associações entre objetos (objetos aninhados e referências)
- Realizar consultas com Spring Data e MongoRepository
## Tecnologias utilizadas
- Spring Boot
- Java
- MongoDB
- MongoDB Compass
- Postman (para testes de API)
## Instalação e Configuração
1. Clone este repositório:
```
git clone https://github.com/camilazucchi/workshop-springboot3-mongodb/tree/main
```
2. Navegue até o diretório do projeto:
```
cd workshop-springboot3-mongodb
```
3. Caso necessário, configure as informações do banco de dados MongoDB no arquivo <b>application.properties</b>.
4. É necessário ter o MongoDB e o MongoDB Compass instalado em sua máquina.
5. Antes de executar o projeto é importante abrir o MongoDB Compass e realizar a conexão antes.
## Utilização e funcionalidades
O projeto possui as seguintes funcionalidades:
- <b>Listar todos os Usuários</b>
<br>Feita através da requisição:
```
http://localhost:8080/users
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743aa",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ab",
        "name": "Alex Green",
        "email": "alex@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ac",
        "name": "Bob Grey",
        "email": "bob@gmail.com"
    }
]
```
- <b>Buscar Usuário por ID<br></b>
Feita através da requisição:
```
http://localhost:8080/users/{id}
```
Retorna:
```
{
    "id": "662947be1f59156c16c743aa",
    "name": "Maria Brown",
    "email": "maria@gmail.com"
}
```
- <b>Adicionar um Usuário</b><br>
Feita através da requisição:
```
http://localhost:8080/users
```
```
{
    "name": "José",
    "email": "jose@gmail.com"
}
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743aa",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ab",
        "name": "Alex Green",
        "email": "alex@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ac",
        "name": "Bob Grey",
        "email": "bob@gmail.com"
    },
    {
        "id": "662948b31f59156c16c743af",
        "name": "José",
        "email": "jose@gmail.com"
    }
]
```
- <b>Excluir um Usuário</b><br>
Feita através da requisição:
```
http://localhost:8080/users/{id}
```
Caso não encontre o ID do usuário:
```
{
    "timestamp": 1713981706774,
    "status": "NOT_FOUND",
    "error": "Not found",
    "message": "User ID not found",
    "path": "/users/66199602e0d05d6c83b237ea"
}
```
- <b>Atualizar informações de um Usuário</b><br>
Feita através da requisição:
```
http://localhost:8080/users/{id}
```
```
{
    "name": "José Blue"
}
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743aa",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ab",
        "name": "Alex Green",
        "email": "alex@gmail.com"
    },
    {
        "id": "662947be1f59156c16c743ac",
        "name": "Bob Grey",
        "email": "bob@gmail.com"
    },
    {
        "id": "662948b31f59156c16c743af",
        "name": "José Blue",
        "email": "jose@gmail.com"
    }
]
```
- <b>Listar todos os Posts de um Usuário<br></b>
Feita através da requisição:
```
http://localhost:8080/users/{id}/posts
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743ad",
        "date": "2024-03-21T00:00:00.000+00:00",
        "title": "Partiu viagem",
        "body": "Vou viajar para São Paulo! Abraços!",
        "author": {
            "id": "662947be1f59156c16c743aa",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem!",
                "date": "2024-03-21T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ab",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite!",
                "date": "2024-03-22T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ac",
                    "name": "Bob Grey"
                }
            }
        ]
    },
    {
        "id": "662947be1f59156c16c743ae",
        "date": "2024-03-23T00:00:00.000+00:00",
        "title": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "662947be1f59156c16c743ab",
            "name": "Alex Green"
        },
        "comments": [
            {
                "text": "Tenha um ótimo dia!",
                "date": "2024-03-23T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ab",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```
- <b>Buscar Post por título<br></b>
Feita através da requisição:
```
http://localhost:8080/posts/titlesearch?text=o%20
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743ae",
        "date": "2024-03-23T00:00:00.000+00:00",
        "title": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "662947be1f59156c16c743ab",
            "name": "Alex Green"
        },
        "comments": [
            {
                "text": "Tenha um ótimo dia!",
                "date": "2024-03-23T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ab",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```
- <b>Buscar Posts com uma data mínima e uma data máxima<br></b>
Feita através da requisição:
```
http://localhost:8080/posts/fullsearch?text=aproveite&minDate=2024-03-18&maxDate=2024-03-21
```
Retorna:
```
[
    {
        "id": "662947be1f59156c16c743ad",
        "date": "2024-03-21T00:00:00.000+00:00",
        "title": "Partiu viagem",
        "body": "Vou viajar para São Paulo! Abraços!",
        "author": {
            "id": "662947be1f59156c16c743aa",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem!",
                "date": "2024-03-21T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ab",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite!",
                "date": "2024-03-22T00:00:00.000+00:00",
                "author": {
                    "id": "662947be1f59156c16c743ac",
                    "name": "Bob Grey"
                }
            }
        ]
    }
]
```
