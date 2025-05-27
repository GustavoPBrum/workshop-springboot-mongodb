# Projeto Spring Boot com MongoDB

## Descrição do Projeto

Este projeto tem como objetivo principal explorar e compreender as principais diferenças entre os paradigmas de banco de dados **orientado a documentos** (MongoDB) e **relacional**. 

Através do desenvolvimento, foram implementadas operações completas de CRUD (Create, Read, Update, Delete), além de refletir sobre decisões de design específicas para bancos orientados a documentos, focando em:

- Implementação de associações entre objetos, utilizando:
  - Objetos aninhados
  - Referências entre documentos

- Realização de consultas avançadas utilizando **Spring Data MongoDB** e a interface **MongoRepository**.

---

## Tecnologias Utilizadas

- **Java 21**


- **Spring Boot** (framework para desenvolvimento rápido e produtivo de aplicações Java)


- **MongoDB** (banco de dados NoSQL orientado a documentos)


- **MongoDB Compass** (ferramenta visual para explorar e manipular dados no MongoDB)


- **Spring Data MongoDB** (simplifica a integração do Spring com MongoDB)


- **Maven** (ferramenta de automação e gerenciamento de dependências)


- **DTOs** (Data Transfer Objects) para otimização e segurança na troca de dados

---

## Estrutura e Conceitos do Projeto

### Arquitetura em Camadas

O projeto foi estruturado seguindo o conceito lógico de camadas, garantindo organização, modularidade e fácil manutenção:

1. **Aplicação do Cliente**  
   Interface que consome os serviços REST.


2. **Controladores REST (Controllers)**  
   Responsáveis por expor endpoints que recebem requisições HTTP e repassam para a camada de serviço.


3. **Camada de Serviço (Service)**  
   Contém a lógica de negócio da aplicação e está atrelada à camada de domínio, realizando as regras específicas.


4. **Camada de Acesso a Dados (Repository)**  
   Interface de acesso ao banco MongoDB, utilizando o Spring Data MongoRepository, também atrelada à camada de domínio.

---

### Modelo de Dados (Entidades)

As entidades principais do sistema são:

- **User (Usuário)**
- **Post (Publicação)**
- **Comment (Comentário)**

#### Relacionamentos

- Um **Usuário** pode ter **vários Posts** (relação 1:N).
- Um **Post** pode ter **vários Comments** (relação 1:N).
- Cada **Post pertence a apenas um User**.
- Cada **Comment pertence a apenas um User**.

---

### Uso de **DTO** (Data Transfer Object)

Para otimizar o tráfego de dados e evitar exposição desnecessária de informações sensíveis, o projeto utiliza o padrão **DTO** para retorno das entidades, especialmente para o **User**.

O **DTO** permite:

- Retornar apenas os dados essenciais para a requisição específica.
- Reduzir o volume de dados trafegados.
- Customizar o formato da resposta para cada endpoint conforme necessidade.
- Garantir segurança e encapsulamento das informações internas do sistema.

---

### Consultas e Queries

O projeto explora diferentes formas de realizar consultas no MongoDB via Spring Data:

- Consultas simples (ex: buscar por ID, nome).
- Consultas com múltiplos critérios, incluindo:
- Intervalo de datas (data início e término).
- Busca por palavra-chave, que ignora distinção entre letras maiúsculas/minúsculas (case insensitive).
  
Essas consultas são implementadas usando o modelo de Query do Spring Data MongoDB, aproveitando do banco orientado a documentos para facilitar a busca.

---

### Sobre o Desenvolvedor

Este projeto foi desenvolvido por [Gustavo Pereira Brum](https://www.linkedin.com/in/gustavo-pereira-brum-42671b241/), estudante de Engenharia de Software, entusiasta de Java e apaixonado por desenvolvimento backend.  
