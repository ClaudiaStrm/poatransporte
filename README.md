# Poatransporte

O objetivo da aplicação é integras as linhas de ônibus de Porto Alegre e seus itinerários, além de salvar clientes e suas linhas de ônibus.

[Api de lista de ônibus de Porto Alegre](http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o)
[Api de itinerário de uma determinada unidade de transporte](http://www.poatransporte.com.br/php/facades/process.php?a=il&p=5566)

#### Deserialização 
Para fazer a deserialização da lista de objetos foi utilizado [Gson](https://github.com/google/gson/blob/master/README.md). Para a deserialização das linhas, a escolha foi pela biblioteca [Jackson](https://github.com/FasterXML/jackson/blob/master/README.md). A mudança aconteceu porque a deserialização dos das linhas foi feita primeiro, e, por ser mais simples, gson foi a primeira opçao e funcionou bem. A api de itinerários é mais complexa e suas annotations facilitaram bastante nesse processo.

#### Banco de dados 

O banco de dados escolhido foi o [PostgreSQL](https://www.postgresql.org/), por ser uma opção gratuita, completa e simples de instalar e utilizar. 

#### Spring Framework

Foi utilizado [Spring](https://spring.io/) e suas ferramentas para facilitar o desenvolvimento, a  comunicação com banco de dados e o desenvolvimento e para rodar os testes.

#### Testes
Os testes unitários foram feitos utilizando JUnit4 e Mockito.

## Requisições

Na pasta Postman, no diretório raiz, estão as coleções com eemplos de requisições. Para rodar, é necessário primeiro entrar na url */api/linha/integracao*. É a partir dela que é feita a inserção dos dados da API com o banco de dados. O processo é demorado, mas precisa ser feito apenas uma vez. A partir daí, é possível fazer a busca de todas as linhas, ou de uma única linha por id ou por nome direto do banco de dados.
Além das requisições das linhas, há o CRUD completo de cliente. Também há exemplos dessas requisições na coleção do postman.
