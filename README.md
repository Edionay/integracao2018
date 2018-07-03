[![Build Status](https://travis-ci.org/Edionay/integracao2018.svg?branch=master)](https://travis-ci.org/Edionay/integracao2018)
![Sonar](https://sonarcloud.io/api/project_badges/measure?project=edionay.com%3Acom.edionay.rabbitmq-exemplo&metric=alert_status)
# Integracao2018
Repositório criado com intuito de armazenar arquivos do grupo de Integração de Aplicações da turma 2018/1 do Prof. Fábio Lucena.

## **Definição do projeto de integração**
- **Escopo definido com clareza.**
  - **Qual o problema de integração que será resolvido?**  
  Será resolvido um problema de integração entre sistemas de caixas de supermercados e um sistema central de estoque. Os vários caixas enviarão mensagens contendo dados sobre vendas realizadas, e o sistema central irá capturar essas mensagens e processá-las de acordo com sua necessidade (contabilização de estoque, computação de contas etc.).
- **Informações sobre os dados a serem trocados entre as aplicações**  
  - **JSON, XML, binário?**  
  Serão enviados arquivos json serializados.
  - **Há um esquema?**  
  O esquema do json enviado segue o padrão abaixo:  
{  
  “produto”: String,  
  “valor”: double,  
  “quantidade”: int,    
 }  
  - **Qual a frequência da interação entre as aplicações?**  
  Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central, por sua vez, captura mensagens em intervalos de tempo podendo variar de algumas horas até dariamente.
  - **Em que circunstâncias a interação deve ocorrer?**  
  Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central verifica a fila de tempos em tempos em busca de mensagens. Ele faz, então, o processamento da mensagem e continua o ciclo de procura por mensagens na fila.
- **Distribuição de papéis entre os membros da equipe**  

| Integrante     | Papel                      |
| -------------  |:--------------------------:|
| Edionay Aguiar | Codificação e Documentação |
| João Lucas     | Codificação e Documentação |
| Erick Vinícius | Documentação               |
| Paula Resende  | Planejamento               |

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

Com o container rodando, ao executar a classe `Publicador` do pacote `frente_de_caixa`, acontece a simulação do envio de uma venda (publicação de uma mensagem no canal).  

Neste momento é possível acompanhar a "alimentação" da fila no RabbitMQ através do endereço `http://localhost:8080` utilizando as credendiais de usuário *user* e senha *user*

Após este processo, executando a classe `Consumidor` do pacote `sistema_principal`, é possível acompanhar na interface do RabbitMQ que a última mensagem da fila doi consumida.
