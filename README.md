# CRUD API

Uma API RESTful para operações de CRUD (Create, Read, Update, Delete) de clientes, desenvolvida com Spring Boot.

## Tecnologias Utilizadas

*   Java 17
*   Spring Boot 3.x
*   Spring Data JPA
*   Maven
*   H2 Database (para ambiente de desenvolvimento)

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot, com a seguinte organização de pacotes:

*   `com.clients.crud_api.controllers`: Contém os controladores REST que expõem os endpoints da API.
*   `com.clients.crud_api.dto`: Contém os Data Transfer Objects (DTOs) para transferência de dados entre as camadas.
*   `com.clients.crud_api.entities`: Contém as entidades JPA que representam as tabelas do banco de dados.
*   `com.clients.crud_api.repositories`: Contém os repositórios Spring Data JPA para acesso aos dados.
*   `com.clients.crud_api.services`: Contém a lógica de negócio da aplicação.

## Endpoints da API

A API expõe os seguintes endpoints para manipulação de clientes:

| Método HTTP | Endpoint | Descrição |
| --- | --- | --- |
| GET | `/clients` | Retorna uma lista paginada de todos os clientes. |
| GET | `/clients/{id}` | Retorna um cliente específico pelo seu ID. |
| POST | `/clients` | Cria um novo cliente. |
| PUT | `/clients/{id}` | Atualiza um cliente existente. |
| DELETE | `/clients/{id}` | Exclui um cliente existente. |

## Estrutura de Dados

A entidade `Client` possui os seguintes campos:

| Campo | Tipo | Descrição |
| --- | --- | --- |
| `id` | `Long` | Identificador único do cliente. |
| `name` | `String` | Nome do cliente. |
| `cpf` | `String` | CPF do cliente. |
| `income` | `Double` | Renda do cliente. |
| `birthDate` | `LocalDate` | Data de nascimento do cliente. |
| `children` | `Integer` | Número de filhos do cliente. |

O `ClientDTO` é utilizado para a troca de dados com a API e inclui validações para garantir a integridade dos dados:

| Campo | Validação | Mensagem de Erro |
| --- | --- | --- |
| `name` | `@NotBlank`, `@Size(min = 3, max = 80)` | "Campo requerido", "Nome precisa ter de 3 a 80 caracteres" |
| `cpf` | `@Size(min = 11, max = 11)`, `@Pattern(regexp = "\\d+")` | "O Cpf deve ter exatamente 11 digitos", "O cpf deve conter apenas números" |
| `income` | `@PositiveOrZero` | "O rendimento não pode ser negativo" |
| `birthDate` | `@PastOrPresent` | "A data de nascimento não pode ser futura" |
| `children` | `@PositiveOrZero` | "O numero de filhos não pode ser negativo" |

## Como Executar o Projeto

1.  Clone o repositório:

    ```bash
    git clone https://github.com/Vitormwxm/crud-api.git
    ```

2.  Navegue até o diretório do projeto:

    ```bash
    cd crud-api
    ```

3.  Execute a aplicação com o Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.
