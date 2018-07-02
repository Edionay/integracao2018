# Integracao2018
Repositório criado com intuito de armazenar arquivos do grupo de Integração de Aplicações da turma 2018/1 do Prof. Fábio Lucena.

# Integrantes
Edionay Aguiar <br>
Erick Vieira <br>
João Lucas Pacheco <br>

# Exemplo utilizando o [Docker](https://www.docker.com/)

Utilizamos o container Management do RabbitMQ para testar o canal em um contexto "real" com o seguinte comando:

`docker run -d --hostname rabbit --name rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management`
