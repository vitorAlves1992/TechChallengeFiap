# Relatório Técnico da Fase 1
---
## Tecnologias, Frameworks e Bibliotecas Utilizadas 
- Java
- Spring
- Lombok 
- JMapper
---
## Desafios Encontrados / Soluções Apresentadas
### Desafio: Classe de domínio responsável por encapsular dados das requisições 
Como descrito nas aulas, temos dois grandes problemas advindos desse Desafio: 
1. Ferir o Single Responsability, prejudicando a arquitetura de nosso código e deixando mais difícil de dar manutenção e evoluir o código
2. Comprometer a segurança, uma vez que expor diretamente as entities nos deixa vulnerável ao [Mass Assignment](https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html)

### Solução: Criar DTOs / Forms
Implementando DTOs para a recepção de dados do cliente e troca de dados entre a camada Controller e Service nos permite encapsular nossas entidades e fornecer uma representação própria dos dados que estamos expondo, esse encapsulamento nos protege do  [Mass Assignment](https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html).
Outro benefício é permitir que tenhamos diversas representações de dados para uma mesmo recurso, de forma a permitir que o retorno do endpoint contenha apenas os dados necessários àquela requisição.



---
### Desafio: Necessidade de transformar os DTOs nas respectivas classes de domínio manualmente  
O desafio aqui reside na quantidade de trabalho e código necessário para realizar tarefas como: 
1. Transformar uma entidade para múltiplas representações DTO
2.  transformar uma entidade com muitos campos em um DTO (especialmente quando envolvem outras entidades aninhadas).  
3.  Fazer as operações inversas as anteriores (Entity-DTO)
### Solução: Introduzir um mapper (atualmente o Jmapper)
Há diversas bibliotecas que se propõe a realizar a tarefa de tranformar DTOs em entidades (e vice-versa). Optamos pelo JMapper para mantermos o alinhamento com o que foi passado no curso, mas cientes das limitações dela, principalmente em relação à versão do Java 

---
### Desafio: Necessidade de validar os dados de entrada, aplicando o failfast 
Descrever aqui porque isso é um problema 
### Solução: Utilizar o Bean Validation
Descrever aqui como isso resolve o problema

---
### Desafio: Necessidade de retirar as regras de negócio do controller e desacolplar sua especificação de sua implementação 
Descrever aqui porque isso é um problema 
### Solução: Utilizar o service em nossa arquitetura e abstraí-lo no esquema interface / implementação 
Descrever aqui como isso resolve o problema

---
### Desafio: Tratar as exceçoes que são geradas através das quebras nas validações anteriormente definidas de forma que geramos exceções com maior semântica para os clientes de nossas APIs
Descrever aqui porque isso é um problema 
### Solução: Criar classes responsáveis por capturar as exceções e transformá-las em mensagens com maior significado
Descrever aqui como isso resolve o problema
