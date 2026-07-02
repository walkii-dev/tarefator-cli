# Tarefator-cli

O Tarefator-CLI é uma aplicação de linha de comando a qual permite ao usuário 
gerenciar tarefas. O intuito é simular e simplificar a organização das tarefas
do dia-a-dia.
O projeto é feito em java puro, sem o uso de bibliotecas externas, unindo 
conceitos do java clássico e rústico (como loops simples e condições) ao java 
moderno, como classes wrappers(Integers) e bibliotecas nativas (Scanner, Files,
StringBuilder).

## Tecnologias usadas:
___
- Java 21 (Eclipse Temurin 21.11)
- Docker (em desenvolvimento)

## Executando a aplicação
___

Nesta página mesmo , clique no botão de "code" em verde, depois na opção "HTTPS" e, ao
lado do texto, clique no ícone que está a direita. Ele copiará o código da aplicação.

Na sua IDE preferida (ou de preferência o Intellij IDEA), abra um terminal na pasta 
desejada e digite "git clone ". Após isso, cole o código que foi copiado e aperte 'Enter.'

![img.png](img.png)
*Resultado esperado após a clonagem do repositório.*

Após o projeto ter sido completamente colado, navegue até a pasta principal do projeto,
simplesmente executando o comando `cd tarefator-cli/src/main/java/org/educational`.

Na pasta principal, faça a compilação do código pelo comando `javac Main.java`
e inicie a aplicação com `java Main.java`.

## Como utilizar
___

## Desafios do projeto
___
A utilização de *somente* bibliotecas nativas da linguagem possibilitou que houvesse muito
manejamento de String, então de qualquer forma foi bom entender a concatenação de Strings
e a recuperação de valores delas para o projeto.

Algo que foi trabalhoso foi lidar com arquivos externos da aplicação, partindo do ponto que
o desafio original pediu que guardássemos as tarefas em um arquivo json, mantendo sua 
formatação.

O uso da estrutura de dados Lista foi essencial para fazer com que a aplicação ficasse mais
organizada, e lidando direta e dinamicamente com as solicitações do usuário.

***Licença do Projeto: MIT License*** 

