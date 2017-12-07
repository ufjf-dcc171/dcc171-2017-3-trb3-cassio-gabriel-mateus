--insert into Tarefa_pessoa (fkid_pessoa, fkid_tarefa) values (1,7)

select * from projeto;
select * from tarefa;
select * from prerequisito;
select * from tarefa_pessoa;

select * from pessoa;

delete from tarefa_pessoa where fkid_tarefa = 13;
delete from prerequisito where fkid_tarefa = 13;
delete from tarefa where id_tarefa = 13;                   
delete from projeto where id_projeto = 9;                   