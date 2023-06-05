#Relatório Técnico da Fase 1
---
## Tecnologias Utilizadas 

---
##Desafios Encontrados / Soluções Apresentadas
### Desafio: Classe de domínio responsável por encapsular dados das requisições 
Descrever aqui porque isso é um problema 
### Solução: Criar DTOs / Forms
Descrever aqui como isso resolve o problema


---
### Desafio: Necessidade de transformar os DTOs nas respectivas classes de domínio manualmente  
Descrever aqui porque isso é um problema 
### Solução: Introduzir um mapper (atualmente o Jmapper)
Descrever aqui como isso resolve o problema

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