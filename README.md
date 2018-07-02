# Integracao2018
Repositório criado com intuito de armazenar arquivos do grupo de Integração de Aplicações da turma 2018/1 do Prof. Fábio Lucena.

## Definição do projeto de integração
- Escopo definido com clareza.
  - Qual o problema de integração que será resolvido?  
  *Será resolvido um problema de integração entre sistemas de caizas de supermercados e um sistema central de estoque. Os caixas enviarão mensagens contendo dados sobre vendas realizadas, e o sistema central irá capturar essas mensagens e processá-las de acordo.*
- Informações sobre os dados a serem trocados entre as aplicações
  - JSON, XML, binário?
  *Serão enviados bytes como mensagens.*
  - Há um esquema?
  - Qual a frequência da interação entre as aplicações?
  *Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central, por sua vez, captura mensagens em intervalos de tempo podendo variar de algumas horas até dariamente.*
  - Em que circunstâncias a interação deve ocorrer?
  *Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central deve interagir quando for necessário atualizar o estoque e/ou fechar o balanço.*
- Distribuição de papéis entre os membros da equipe  

| Integrante     | Papel                      |
| -------------  |:--------------------------:|
| Edionay Aguiar | Codificação e Documentação |
| João Lucas     | Codificação e Documentação |
| Erick Vinícius | Documentação               |

- Processo a ser seguido pela equipe
- Mecanismo de comunicação utilizado pelos membros da equipe.  
  - [WhatsAppMessenger](https://www.whatsapp.com/)

- Ferramentas
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

# Descrição da atividade

## Definição e desenvolvimento de um projeto de integração de aplicações no qual troca de mensagens é utilizada. 

O grupo estabelecido logo na primeira aula deverá iniciar o esforço de identificação e caracterização (documentação) precisa do projeto de integração. O docente da disciplina, portanto, não irá apresentar o trabalho prático sobre o qual o grupo será avaliado. Ao longo do mês de março o docente irá auxiliar o grupo nessa definição. A expectativa é o que o projeto seja “interessante” ao grupo.  

As aplicações, pelo menos duas necessárias para que ocorra a integração, não necessariamente existem, nem tampouco precisam ser desenvolvidas. Observe que o escopo do trabalho restringe-se à integração e não inclui as aplicações que serão “integradas”. 

A integração deve necessariamente fazer uso de troca de mensagens, ou seja, mensagens serão entregues entre as aplicações por meio de um “canal” ou “fila”. Trata-se de um estilo de integração assíncrono e com entrega confiável das mensagens. Observe que troca de mensagens não é um “remédio para todos os males” e a definição do trabalho prático deve ser coerente com este estilo. Caso as aplicações não existam, deve ser criado um contexto compatível para um projeto de integração via troca de mensagens. Em tempo, o projeto pode demandar o uso de outros estilos de integração além de troca de mensagens (o que não é um inconveniente).  

O desenvolvimento não está restrito à plataforma Java. O projeto definido pode optar por .Net Core, por exemplo, assim como NodeJS, entre outras opções. A identificação da plataforma, linguagem de programação e ferramentas empregadas faz parte da definição do projeto de integração e, naturalmente, devem ser adequadas ao contexto em questão. 

