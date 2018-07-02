# Integracao2018
Repositório criado com intuito de armazenar arquivos do grupo de Integração de Aplicações da turma 2018/1 do Prof. Fábio Lucena.

## **Definição do projeto de integração**
- **Escopo definido com clareza.**
  - **Qual o problema de integração que será resolvido?**  
  Será resolvido um problema de integração entre sistemas de caizas de supermercados e um sistema central de estoque. Os caixas enviarão mensagens contendo dados sobre vendas realizadas, e o sistema central irá capturar essas mensagens e processá-las de acordo.
- **Informações sobre os dados a serem trocados entre as aplicações**  
  - JSON, XML, binário?
  Serão enviados bytes como mensagens.
  - **Há um esquema?**
  - **Qual a frequência da interação entre as aplicações?**
  Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central, por sua vez, captura mensagens em intervalos de tempo podendo variar de algumas horas até dariamente.
  - **Em que circunstâncias a interação deve ocorrer?**
  Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central deve interagir quando for necessário atualizar o estoque e/ou fechar o balanço.
- **Distribuição de papéis entre os membros da equipe**  

| Integrante     | Papel                      |
| -------------  |:--------------------------:|
| Edionay Aguiar | Codificação e Documentação |
| João Lucas     | Codificação e Documentação |
| Erick Vinícius | Documentação               |

- **Processo a ser seguido pela equipe**
![Processo a ser seguido pela equipe](https://raw.githubusercontent.com/Edionay/integracao2018/master/docs/Imagens/processoBPMN.jpeg)
- **Mecanismo de comunicação utilizado pelos membros da equipe.**  
  - [WhatsAppMessenger](https://www.whatsapp.com/)

- **Ferramentas**
  - Trello
    - [Quadro do projeto](https://trello.com/b/9B14JR7A)
  - GitHub (Repositório e versionamento)
    - [Repositório do projeto](https://github.com/Edionay/integracao2018/)
  - [Draw.io](https://www.draw.io/) (Diagramas)
  - [SmartGit](https://www.syntevo.com/smartgit/) (Interface Git)
  - [RabbitMQ](https://www.rabbitmq.com/) (Sistema que implementa o protocolo AMQP)
  - [Intellij IDEA](https://www.jetbrains.com/idea/) (IDE)

# Exemplo utilizando o [Docker](https://www.docker.com/)

Utilizamos o container Management do RabbitMQ para testar o canal em um contexto "real" com o seguinte comando:

`docker run -d --hostname rabbit --name rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management`
