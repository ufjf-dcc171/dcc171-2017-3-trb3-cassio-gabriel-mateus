create table projeto (
    id_projeto integer primary key GENERATED ALWAYS AS IDENTITY,
    nome varchar (30) not null,
    descricao varchar (100),
    dataInicio date,
    dataFinal date
);

create table tarefa (
    id_tarefa integer primary key GENERATED ALWAYS AS IDENTITY,
    nome varchar (30) not null,
    descricao varchar (100),
    duracao integer,
    progresso integer,
    dataInicio date,
    dataFinal date,
    fkid_projeto integer,
    constraint fk_projetoId foreign key (fkid_projeto) references projeto (id_projeto)
);
create table prerequisito (


)

create table tarefa_pessoa (


)

create table pessoa (

    PESCOD int NOT NULL AUTO_INCREMENT,
    PESNOME VARCHAR(255),
    PESMAIL VARCHAR(255),
    PRIMARY KEY (ID)

)   