# Definição de Escopo?

### 1 - Qual o problema de integração que será resolvido? <br>
A aplicação Thinderbooks permite que usuários cadastrados possam postar livros que possuem disponíveis para troca ou venda. O problema de integração existente no aplicativo remete à ineficiência em conectar seus usuários interessados em livros, com os usuários que possuem estes disponibilizados.<br>

Nesse sentido, o problema será resolvido com a promoção da troca facilitada de livros entre usuários, a partir da premissa que um usuário interessado poderá seguir e acompanhar - de maneira automática em sua própria página -, todos os livros que determinado usuário, visado por quem tem interesse, cadastrar.<br> 

### 2 - Informações sobre os dados a serem trocados entre as aplicações <br>
As informações sobre os dados a serem trocados serão referentes aos livros que estiverem cadastrados por aquela conta que o usuário em questão demonstrar interesse em seguir. Segue template abaixo das informações que quem estiver seguindo determinada conta irá receber em sua própria página.<br>

![Protótipo informações](https://github.com/paulaResende/integracao2018/blob/master/Imagens/prototipo1.png)

### 3 - JSON, XML, binário? <br>
Utilização de JSON.

### 4 - Há um esquema? <br>
![Esquema escopo](https://github.com/paulaResende/integracao2018/blob/master/Imagens/EsquemaEscopo.png)

### 5 - Qual a frequência da interação entre as aplicações? <br>
A frequência da interação acontecerá sempre que usuário 1 cadastra um livro, e visto que todos os demais usuários que seguem este, receberão em seus próprios feeds a indicação de que um livro novo foi cadastrado pelo usuário 1. 

### 6 - Em que circunstâncias a interação deve ocorrer? <br>
A interação de aviso de novo livro cadastrado só deve ocorrer para aqueles usuários que seguem aquele que cadastrou o livro. 
