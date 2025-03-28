create table Funcionarios(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	funcao varchar (100) not null,
	idade int (100) not null,
	
	 primary key(id)
);