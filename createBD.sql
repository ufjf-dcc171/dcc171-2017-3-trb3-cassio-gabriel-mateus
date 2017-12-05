CREATE TABLE Projeto (
procod INTEGER(10) PRIMARY KEY
pronome VARCHAR(100),
prodescricao VARCHAR(255),
prodatainicio DATE,
prodatafim Date

);



CREATE TABLE Task (
taskcod integer(20) PRIMARY KEY
procod INTEGER(10),
taskduracao INTEGER(10),
taskprogresso INTEGER(10),
taskdatainicio date,
taskdatafim date

);

CREATE TABLE pre_requisito (
prerequisitocod integer(10) PRIMARY KEY,
taskcod integer(10),
duracao VARCHAR(100)
);

CREATE TABLE PESSOA (
PESCOD integer(10),
PESNOME VARCHAR(255),
PESMAIL VARCHAR(255)
);


CREATE TABLE TASK_PESSOA (
pescod integer(10),
taskcod integer(10),
PRIMARY KEY(id_pessoa,id_tarefa)
);




/*ADICIONAR AS CHAVES ESTRANGEIRAS*/
