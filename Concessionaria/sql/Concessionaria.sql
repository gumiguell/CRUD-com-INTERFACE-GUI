create schema Concessionaria

create table Concessionaria.Marca
(
	idMarca int not null primary key,
	nomeMarca varchar(50) not null,
	fundacao int not null,
	proprietario varchar(26) not null,
)

create table Concessionaria.Carro
(
	idMarca int not null,
	idCarro int not null primary key,
	modelo varchar(20) not null,
	foreign key (idMarca) references Concessionaria.Marca(idMarca)
)

select * from Concessionaria.Marca
select * from Concessionaria.Carro