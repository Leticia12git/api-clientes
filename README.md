# API - CLIENTES

## Sobre o projeto
Este é um API RestFull de Clientes onde voce consegue:
- cadastrar,
- listar ,
- buscar um cliente por id,
- atualizar,
- excluir um cliente por id


### Tecnologias Utilizadas

- Java (JDK 17)
- Spring Boot 3.1.1
- Spring Security
- JPA
- Hibernate
- Lombok
- Swagger
- Model Mapper
- Mysql (MySQL 5.7)
- Flyway

##### Instale

* IntelliJ IDEA
* Java JDK 17
* Maven
* Git

### Configuração

Clone este repositorio para sua maquina local:
git clone https://github.com/seu-usuario/api-clientes.git

Importe o projeto em sua IDE Java de preferência (IntelliJ).

Configure as credenciais do banco de dados no arquivo application.properties localizado em src/main/resources. Substitua os valores entre < e > pelas suas próprias credenciais:


spring.datasource.url=jdbc:mysql://<host>:<porta>/<nome-banco-dados>?useSSL=false&serverTimezone=UTC
spring.datasource.username=<usuario>
spring.datasource.password=<senha>

Execute o comando Maven para baixar as dependencias do projeto

mvn clean install


A API estará disponível em http://localhost:8080

Endpoints
A API de clientes possui os seguintes endpoints principais:

GET /clientes: Retorna todos os clientes cadastrados.
GET /clientes/{id}: Retorna os detalhes de um cliente específico com base no ID.
POST /clientes: Cria um novo cliente com base nos dados fornecidos no corpo da requisição.
PUT /clientes/{id}: Atualiza os dados de um cliente específico com base no ID.
DELETE /clientes/{id}: Remove um cliente específico com base no ID.
Certifique-se de enviar as requisições usando o formato JSON adequado.



Exemplo de Requisição
Para criar um novo cliente, envie uma requisição POST para http://localhost:8080/clientes com o seguinte corpo em formato JSON:

json
{
"nome": "João da Silva",
"telefone": "(99) 99999-9999",
"email": "joao.silva@example.com"
}


##### Swagger

1. Localhost
    - Acesse o swagger por meio do link:
        - http://localhost:8080/swagger-ui/index.html
