# Integracao2018
Repositório criado com intuito de armazenar arquivos do grupo de Integração de Aplicações da turma 2018/1 do Prof. Fábio Lucena.

# Integrantes
Edionay Aguiar <br>
Erick Vieira <br>
João Lucas Pacheco <br>

# Exemplo utilizando o [Docker](https://www.docker.com/)

Utilizamos o container Management do RabbitMQ para testar o canal em um contexto "real" com o seguinte comando:

`docker run -d --hostname rabbit --name rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management`

# Descrição da atividade

## Definição e desenvolvimento de um projeto de integração de aplicações no qual troca de mensagens é utilizada. 

O grupo estabelecido logo na primeira aula deverá iniciar o esforço de identificação e caracterização (documentação) precisa do projeto de integração. O docente da disciplina, portanto, não irá apresentar o trabalho prático sobre o qual o grupo será avaliado. Ao longo do mês de março o docente irá auxiliar o grupo nessa definição. A expectativa é o que o projeto seja “interessante” ao grupo.  

As aplicações, pelo menos duas necessárias para que ocorra a integração, não necessariamente existem, nem tampouco precisam ser desenvolvidas. Observe que o escopo do trabalho restringe-se à integração e não inclui as aplicações que serão “integradas”. 

A integração deve necessariamente fazer uso de troca de mensagens, ou seja, mensagens serão entregues entre as aplicações por meio de um “canal” ou “fila”. Trata-se de um estilo de integração assíncrono e com entrega confiável das mensagens. Observe que troca de mensagens não é um “remédio para todos os males” e a definição do trabalho prático deve ser coerente com este estilo. Caso as aplicações não existam, deve ser criado um contexto compatível para um projeto de integração via troca de mensagens. Em tempo, o projeto pode demandar o uso de outros estilos de integração além de troca de mensagens (o que não é um inconveniente).  

O desenvolvimento não está restrito à plataforma Java. O projeto definido pode optar por .Net Core, por exemplo, assim como NodeJS, entre outras opções. A identificação da plataforma, linguagem de programação e ferramentas empregadas faz parte da definição do projeto de integração e, naturalmente, devem ser adequadas ao contexto em questão. 

