# FIAP-FLIX  | API de Streaming de Vídeo

## Estrutura do Projeto

O projeto segue uma estrutura modular com base nos princípios da Clean Architecture, proporcionando uma separação clara de responsabilidades. 

A estrutura principal do projeto é organizada da seguinte forma:

1. **adapter:** Contendo as classes responsáveis pela comunicação externa, como controladores REST, interfaces de banco de dados, e outros detalhes específicos de implementação;

2. **application:** Aqui são definidos os casos de uso da aplicação, que representam a lógica de negócios. Sendo esta camada a responsável por coordenar as interações entre os componentes;

3. **domain:** Contém as entidades do domínio e as regras de negócio. Esta camada é independente de qualquer tecnologia ou framework específico, garantindo reutilização em diferentes contextos.

## Tecnologias Utilizadas

Aqui estão algumas das principais tecnologias e bibliotecas utilizadas:

1. **Java 17:**
  - Atualmente a versão LTS mais estável e com uma gama muito maior de suporte da própria comunidade e da Oracle.

2. **Spring Boot:**
  - Framework que simplifica o desenvolvimento de aplicativos Java. No contexto deste projeto, o módulo Webflux é utilizado para construir APIs reativas.

3. **Spring Data MongoDB e MongoDB Driver:**
  - Integração com o MongoDB para facilitar as operações de banco de dados através do driver oficial para Java.

4. **Lombok:**
  - Biblioteca que simplifica a criação de classes Java, reduzindo a necessidade de escrever código boilerplate.

5. **JUnit e TestNG:**
  - Frameworks de teste para escrever e executar testes unitários e de integração.

6. **Reactor:**
  - Biblioteca reativa utilizada pelo Webflux para suportar programação reativa.

## Como Executar

1. Certifique-se de ter o Java 17 e o MongoDB instalados em seu sistema;
2. Clone este repositório;
3. Importe o projeto em sua IDE preferida;
4. Configure as informações do banco de dados no arquivo `application.properties`;
5. Execute a aplicação.

## Benefícios de Usar o Webflux

### Programação Reativa

O Webflux utiliza um modelo de programação reativa, permitindo lidar eficientemente com um grande número de requisições. 

Essa abordagem escalável não requer a alocação de um thread para cada conexão, resultando em uma utilização mais eficiente dos recursos do sistema, especialmente em situações de alto tráfego.

### Assincronicidade e Não Bloqueio

As operações no Webflux são assíncronas e não bloqueantes. Isso significa que a thread não fica bloqueada enquanto espera a resposta de uma operação de I/O.

A liberação da thread para lidar com outras tarefas durante a espera aumenta a capacidade de resposta da aplicação.

### Suporte a Programação Funcional

O Webflux suporta programação funcional, permitindo escrever código de maneira mais concisa e expressiva. 

Essa característica facilita o desenvolvimento e a manutenção da aplicação.

## Benefícios de Usar a Clean Architecture

![img.png](assets/img.png)

### Separação de Responsabilidades

A Clean Architecture separa as responsabilidades da aplicação em diferentes camadas, tornando o código mais modular e fácil de entender. Isso facilita a manutenção e evolução da aplicação ao longo do tempo.

### Independência de Tecnologia

As camadas da Clean Architecture são independentes de qualquer tecnologia ou framework específico. 

Isso possibilita a reutilização em diferentes contextos sem modificar a lógica interna, tornando a aplicação mais flexível e fácil de adaptar a novos requisitos e tecnologias.

### Testabilidade

A separação de responsabilidades e a clara definição das interfaces entre as camadas facilitam a escrita de testes automatizados para cada componente da aplicação. 

Isso contribui para garantir a qualidade e robustez da aplicação, permitindo detectar e corrigir problemas de forma rápida e eficiente.
