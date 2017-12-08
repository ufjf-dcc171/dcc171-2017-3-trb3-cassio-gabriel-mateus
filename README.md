<h1> Identificação dos alunos </h1> 
Cássio Henrique Resende Reis - 201576041<br/>
Gabriel Martins Santana – 201576002<br/>
Mateus Gonçalo do Nascimento – 201576003

<h2> Modelo de Dados </h2>
<p>Para realizar a persistência dos dados utilizamos o JavaDB através do JDBC. Utilizamos diversos DAOs para fazerem o acesso ao banco, de modo que as janelas da nossa aplicação não se comunicam diretamente com o banco. A conexão com o JavaDB é feita através da classe BdConnection.</p>
<p>As principais classes do nosso sistema possuem uma classe DAO associada a elas, como as classes PessoaDAO, ProjetoDAO, TaskDAO, TaskPessoaDAO e TaskPreRequisitoDAO, com operações preparadas para a escrita e leitura no banco de dados, visando isolar este acesso das janelas da aplicação.</p>
<p>Ao iniciar o sistema, a classe Main instancia a classe Controle Funcionamento, que por sua vez irá chamar a classe SampleDataFuncionamento e abrir a janela Dashboard. A classe SampleDataFuncionamento tem a função de criar e controlar todos os DAOs do sistema. As demais janelas do sistema são acessadas através da janela Dashboard.
A classe SampleDataFuncionamento também entra em contato com todos os DAOs para pegar todos os dados de pessoas, projetos e tarefas armazenados no banco de dados. </p>
<p>Como já foi dito anteriormente, cada classe está associada ao seu respectivo DAO. Vejamos agora as operações que cada DAO realiza no banco de dados: o ProjetoDAO possui as operações criar, que irá criar um novo projeto no banco, buscar, que irá buscar por um projeto específico no banco, listarTodos, que irá retornar todos os projetos salvos no banco, alterar, que modifica os dados de um projeto no banco e  excluir que apaga todos os dados de um projeto do banco; o TaskDAO realiza operações relativas as tarefas, tais como criar, buscar, listarTodos, alterar e excluir, além da operação varrerTarefa, que faz uma busca da tarefa no banco através de seu id; o PessoaDAO irá tratar dos dados das pessoas que são cadastradas no sistema e implementa as operações de criar, listarTodos, alterar e excluir; o TaskPessoaDAO relaciona as classes Pessoa e Tarefa no banco de dados, utilizando as operações associar, que associa o id da pessoa com o id da tarefa no banco, buscar, presença, que verifica se uma pessoa está associada a uma tarefa e excluir; e por fim, o TaskPreRequisitoDAO associa uma tarefa às suas tarefas pré-requisito, com as operações associar, buscar, excluir e presença.</p>

<h2>Esquema do banco de dados</h2>

O diagrama de classes do sistema pode ser acessado pelo seguite link: https://imgur.com/a/qZG2n

O esquema utilizado no desenvolvimento do banco de dados pode ser visualizado neste link: https://imgur.com/a/H05AE


<h2>Melhorias Futuras</h2>
	<p>Uma possibilidade de melhoria futura seria a utilização de XML para a realização da persistência dos dados da aplicação. Como é utilizada a interface, é possível também realizar a persistência de dados de diversas formas. Caso haja alguma necessidade de outra forma de armazenamento, a mesma poderá ser feita de diversas formas.</p>
	<p>Uma melhoria futura também seria alterar os pré-requisitos de uma tarefa e as pessoas que fazem parte de uma tarefa também. Essas mudanças garantiriam um poder maior ao sistema.</p>
	<p>Outras melhorias futuras que podem se fazer presente é a utilização de gráficos para mostrar a evolução das tarefas e do projeto. No caso da tarefa, a atualização garantiria que fosse possível visualizar subitens e as disponibilidade das pessoas, de acordo com data, parecido com o diagrama de rede. No caso do projeto, poderia ser feito um diagrama similar ao EAP, o qual nos traria uma dimensão das tarefas e a divisão em Iniciação, Planejamento, Execução, Monitoramento e Controle e Finalização. </p>
