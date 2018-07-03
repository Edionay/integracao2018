# Definição de Escopo?

### 1 - Qual o problema de integração que será resolvido? <br>
Será resolvido um problema de integração entre sistemas de caizas de supermercados e um sistema central de estoque. Os caixas enviarão mensagens contendo dados sobre vendas realizadas, e o sistema central irá capturar essas mensagens e processá-las de acordo.<br>

### 2 - Informações sobre os dados a serem trocados entre as aplicações <br>
As informações a serem trocadas serão dados referentes as vendas realizadas, contendo produto vendido, quantidade e valor unitário.<br>

### 3 - JSON, XML, binário? <br>
Serão enviados arquivos json serializados.

### 4 - Há um esquema? <br>

O esquema do json enviado segue o padrão abaixo:

{  
  “produto”: String,  
  “valor”: double,  
  “quantidade”: int,    
 }  
<br>  

### 5 - Qual a frequência da interação entre as aplicações? <br>
Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central, por sua vez, captura mensagens em intervalos de tempo podendo variar de algumas horas até dariamente. <br>

### 6 - Em que circunstâncias a interação deve ocorrer? <br>
Por parte do caixa, a interação ocorre sempre que uma venda for concluída. O sistema central deve interagir quando for necessário atualizar o estoque e/ou fechar o balanço.<br>
