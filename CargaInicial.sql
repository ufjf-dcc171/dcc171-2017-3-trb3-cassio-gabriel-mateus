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
    status varchar (30),
    duracao integer,
    progresso integer,
    dataInicio date,
    dataFinal date,
    fkid_projeto integer,
    foreign key (fkid_projeto) references projeto (id_projeto)
);
create table pessoa (

    PESID integer primary key generated always as identity,
    PESNOME VARCHAR(255),
    PESMAIL VARCHAR(255)
);

create table prerequisito (
    pre_cod integer primary key generated always as identity,
    fkid_tarefa integer,
    fkid_tarefaPreRequisito integer,
    foreign key (fkid_tarefa) references tarefa (id_tarefa),
    foreign key (fkid_tarefaPreRequisito) references tarefa (id_tarefa) 
);

create table tarefa_pessoa (
    pre_cod integer primary key generated always as identity,
    fkid_tarefa integer,
    fkid_pessoa integer,
    foreign key (fkid_tarefa) references tarefa (id_tarefa),
    foreign key (fkid_pessoa) references pessoa (pesid) 
);

drop table tarefa_pessoa;
drop table prerequisito;
drop table pessoa;
drop table tarefa;
drop table projeto;


select * from prerequisito;

select * from tarefa

