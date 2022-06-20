create database db_produtos;

create table produto(
	id int not null,
	nome varchar(255) not null,
	preco double not null,
	estoque int not null
);

insert into produto(id, nome,preco, estoque) 
values (1, 'cadeira', 200.89, 12);

insert into produto(id, nome, preco, estoque) 
values (2, 'mesa', 450.79, 6);


insert into produto(id, nome,preco, estoque) 
values (3, 'estante', 350.90, 4);

SELECT * FROM produto;