# Documentação da API de Gestão de Eletrodomésticos
---
## Propósito
Permitir o cadastro e gerenciamento de informações sobre os aparelhos eletrônicos dos usuários cadastrados em nosso sistema

## Objetivos
Receber as informações dos eletrônicos com os campos de nome, modelo, potência e outros dados relevantes com os seguintes requisitos:
1. Receber as solicitações em formato HTTP POST.
2. As informações devem ser validadas para garantir que elas estão no formato correto e que são válidas.    
3. Caso haja algum erro, a API deve retornar uma mensagem de erro indicando o problema encontrado.
4. Uma vez validadas as informações, a API deve informar que está tudo ok e dar um retorno positivo ao usuário.
                  
## Endpoints
Swagger acessível através do endereço: [http://localhost:8080/swagger-ui/index.html#/eletrodomestico-controller]

### Para exemplos práticos de entrada e de validações consultar arquivo Postman:
[Enpoints e Validações no Postman](/postman/EletrodomesticoAPI.postman_collection.json)


![](2023-06-16-15-01-19.png)

<h3 style="background:rgba(73,204,144,.1)" dispay=block;>        <span style="background:#49cc90; color: #FFF; display:inline-block; padding: 6px 15px; border-radius:3px">POST</span>
<span style="color: #000">/eletrodomestico</span>
<sub style="color: #000; font-size: 15px; display: inline-block; margin-left: 10px" >inserir</sub>
</h3>

### Descrição
Recebe uma representação de eletrodoméstico no formato json com os seguintes campos
 - idUsuario - Long
 - modelo - String
 - nome - String
 - potencia - Double

###Exemplos de entrada e saída

**Entrada Esperada**
```json
{
  "idUsuario": 0,
  "modelo": "string",
  "nome": "string",
  "potencia": 0
}
```
**Saída - Código 200 OK**
```json
{
  "id": 0,
  "idUsuario": 0,
  "modelo": "string",
  "nome": "string",
  "potencia": 0
}
```


<h3 style="background:rgba(97,175,254,.1)" dispay=block;>        <span style="background:#61affe; color: #FFF; display:inline-block; padding: 6px 15px; border-radius:3px">GET</span>
<span style="color: #000">/eletrodomestico/{id}</span>
<sub style="color: #000; font-size: 15px; display: inline-block; margin-left: 10px" >listar</sub>
</h3>
### Descrição
Recebe um id como Path Parameter e retorna o respectivo eletrodomestico corresponente a esse id
###Exemplos de entrada e saída

**Entrada Esperada**
```
/eletrodomestico/1
```
**Saída - Código 200 OK**
```json
{
  "id": 0,
  "idUsuario": 2,
  "modelo": "string",
  "nome": "string",
  "potencia": 0
}
```

<h3 style="background:rgba(97,175,254,.1)" dispay=block;>        <span style="background:#61affe; color: #FFF; display:inline-block; padding: 6px 15px; border-radius:3px">GET</span>
<span style="color: #000">/eletrodomestico/usuario/{id}</span>
<sub style="color: #000; font-size: 15px; display: inline-block; margin-left: 10px" >listar Eletrodomesticos de Usuario</sub>
</h3>
### Descrição
Recebe um id como Path Parameter e retorna uma lista com os eletrodomésticos associados ao usuário que corresponda a esse id
###Exemplos de entrada e saída

**Entrada Esperada**
```
/eletrodomestico/usuario/1
```
**Saída - Código 200 OK**
```json
[
    {
        "idUsuario": 2,
        "id": 809437828,
        "nome": "Microondas 1",
        "modelo": "Brastemp",
        "potencia": 75.0
    },
    {
        "idUsuario": 2,
        "id": 575896321,
        "nome": "Microondas 2",
        "modelo": "Brastemp",
        "potencia": 75.0
    }
]
```

<h3 style="background:rgba(252,161,48,.1)" dispay=block;>        <span style="background:#fca120; color: #FFF; display:inline-block; padding: 6px 15px; border-radius:3px">PUT</span>
<span style="color: #000">/eletrodomestico/{id}</span>
<sub style="color: #000; font-size: 15px; display: inline-block; margin-left: 10px" >atualizar</sub>
</h3>
### Descrição
Recebe um eletrodoméstico no formato json com os seguintes campos e um id como Path Parameter que indica qual eletrodoméstico será atualizado
 - idUsuario - Long
 - modelo - String
 - nome - String
 - potencia - Double

###Exemplos de entrada e saída

**Entrada Esperada**
```json
/eletrodomestico/0
{
  "idUsuario": 2,
  "modelo": "string alterado",
  "nome": "string alterado",
  "potencia": 4.0
}
```
**Saída - Código 200 OK**
```json
{
  "id": 0,
  "idUsuario": 2,
  "modelo": "string alterado",
  "nome": "string alterado",
  "potencia": 4.0
}
```
<h3 style="background:rgba(249,62,62,.1)" dispay=block;>        <span style="background:#f93e3e; color: #FFF; display:inline-block; padding: 6px 15px; border-radius:3px">DELETE</span>
<span style="color: #000">/eletrodomestico/{id}</span>
<sub style="color: #000; font-size: 15px; display: inline-block; margin-left: 10px" >deletar</sub>
</h3>
### Descrição
Recebe um Id via Path Parameter e deleta o recurso correspondente ao ID
```
/eletrodomestico/1
```
**Saída - Código 204 No Content**