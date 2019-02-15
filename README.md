# Poatransporte

O objetivo da aplicação é integras as linhas de ônibus de Porto Alegre e seus itinerários, além de salvar clientes e suas linhas de ônibus.

- [Api de lista de ônibus de Porto Alegre](http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o)
- [Api de itinerário de uma determinada unidade de transporte](http://www.poatransporte.com.br/php/facades/process.php?a=il&p=5566)

#### Deserialização 
Para fazer a deserialização da lista de objetos foi utilizado [Gson](https://github.com/google/gson/blob/master/README.md). Para a deserialização das linhas, a escolha foi pela biblioteca [Jackson](https://github.com/FasterXML/jackson/blob/master/README.md). A mudança aconteceu porque a deserialização dos das linhas foi feita primeiro, e, por ser mais simples, gson foi a primeira opçao e funcionou bem. A api de itinerários é mais complexa e utilizar as annotations do Jackson deixou o trabalho mais fácil de ser realizado.

#### Banco de dados 

O banco de dados escolhido foi o [PostgreSQL](https://www.postgresql.org/), por ser uma opção gratuita, completa e simples de instalar e utilizar. 

#### Spring Framework

Foi utilizado [Spring](https://spring.io/) e suas ferramentas para facilitar o desenvolvimento, a  comunicação com banco de dados e o desenvolvimento e para rodar os testes.

#### Testes
Os testes unitários foram feitos utilizando [JUnit4](https://junit.org/junit4/) e [Mockito](https://site.mockito.org/) para fazer o mock dos dados.

#### Requisições

Na pasta __postman__, no diretório raiz, estão as coleções do Postman com exemplos de requisições. 
A requisição de integração é a que faz a busca das informações da API e insere no banco. Existem três requisições das linhas: todas as linhas, busca passando id e busca passando nome. Há também o CRUD completo de cliente. Tem exemplos dessas requisições na coleção do postman.


## Rodando a aplicação

Após subir o servidor, para a aplicação rodar corretamente, é necessário primeiro entrar na url */api/linha/integracao*. É a partir dela que é feita a inserção dos dados da API com o banco de dados. O processo é demorado, mas precisa ser feito apenas uma vez. A partir daí, é possível fazer a busca de todas as linhas ou de uma única linha (por id ou por nome) direto do banco de dados.
Também é possível cadastrar, excluir, modificar e buscar um cliente, e a lista de todos os clientes cadastrados.

A aplicação está configurada para apagar o banco de dados toda vez que o servidor for derrubado. Para não precisar fazer a requisição de integração mais de uma vez, é preciso modificar o arquivo [application.properties](https://github.com/ClaudiaStrm/poatransporte/blob/master/src/main/resources/application.properties). Na linha 5, o valor *create* deve ser modificado para *update*.
