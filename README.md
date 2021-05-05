# Social Bank Api
## API Restfull para gerenciamento de contas e pagamentos.

### DOCUMENTAÇÂO API:
##### Account:
- **POST:** `{host}/accounts` - Neste endpoint é possivel realizar a criação de uma conta. Segue abaixo um exemplo de payload de reqisição. 
```
{
    "idenfifier":"1010",
    "name":"John's Account",
    "description": "Checking account",
    "status": "ACTIVE"
}
```
- **GET:** `{host}/accounts/{idenfifier}` - Neste endpoint é possivel realizar a consulta de uma conta pelo idenfifier. Segue abaixo um exemplo de resposta.
```
{
    "idenfifier": "1010",
    "name": "John's Account",
    "description": "Checking account",
    "balance": 57.760000000000005,
    "status": "ACTIVE",
}
```
- **GET:** `{host}/accounts/extracts/{idenfifier}?sort=name&direction=ASC&size=50` - Neste endpoint é possivel realizar a consulta de transações de uma conta pelo idenfifier.
Lembrando que caso não seja enviado os parametros (sort, direction e size) o paramentro será padrão, tendo um limite de exibir no maximo 100 páginas.
Segue abaixo um exemplo de resposta.
```
{
    "idenfifier": "1010",
    "name": "John's Account",
    "description": "Checking account",
    "balance": 57.760000000000005,
    "status": "ACTIVE",
    "movementItemList": [
        {
            "idenfifier": "16794222-ef43-450c-95a2-4d0f13c2be2f",
            "barCode": null,
            "expirationDate": "2021-05-04T21:14:07",
            "amount": 15.0,
            "type": "DEPOSIT"
        }
    ]
}
```

- **GET:** `{host}/accounts/{idenfifier}/balances` - Neste endpoint é possivel realizar consulta do saldo da conta pelo idenfifier. Segue abaixo um exemplo de resposta.
```
{
    "balance": 0.0
}
```

- **PUT:** `{host}/accounts/{idenfifier}` - Neste endpoint é possivel realizar alteração da conta pelo idenfifier. Segue abaixo um exemplo payload de requisição.
```
{
    "name": "Elias Borges", 
    "description": "Developer"
}
```
- **DELETE:** `{host}/accounts/{idenfifier}/canceled` - Neste endpoint é possivel realizar o cancelamento da conta pelo idenfifier.
- 
##### Movement:
- **PUT:** `{host}/movements/deposits/accounts/{idenfifier}` - Neste endpoint é possivel realizar um deposito em uma conta ativa pelo idenfifier. Segue abaixo um exemplo payload de requisição.
```
{
    "value": 15
}
```

- **PUT:** `{host}/movements/transfers/accounts/{idenfifier}` - Neste endpoint é possivel realizar uma transferencia de uma conta ativa para outra. Segue abaixo um exemplo payload de requisição.
```
{
    "value": 10,
    "idenfifierAccountDestiny": 2020
}
```

- **PUT:** `{host}/movements/payments/accounts/{idenfifier}` - Neste endpoint é possivel realizar um pagamento atráves de uma conta ativa pelo idenfifier. Segue abaixo um exemplo payload de requisição.
```
{
    "barCode":"123900000500000000060000000007856760000015075",
    "expiration_date": "2022-04-12T23:59:59",
    "value":6.12
}
```
#### UML DO PROJETO
![UML](https://user-images.githubusercontent.com/31020103/117090151-f1651800-ad2d-11eb-96bd-e99193c94998.png)


#### PRINCIPAIS BIBLIOTECAS UTILIZADAS PARA EXECUÇÃO DO PROJETO:

* [MySQL Connector/J](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
* [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
* [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [Swagger](https://swagger.io/)
* [Hibernate Validator](https://hibernate.org/validator/)
* [Docker](https://www.docker.com/)

### MELHORIAS
- Realização de testes unitários; 
- Revisar e refatorar projeto.

#### AUTOR

- [Elias Borges](https://www.linkedin.com/in/eliasborges)
