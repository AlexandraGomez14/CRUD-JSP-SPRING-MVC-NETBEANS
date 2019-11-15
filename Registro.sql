create database registro;
use registro;

create table persona(
	id int auto_increment primary key not null,
    nombre varchar(50) not null,
    correo varchar(50) not null,
    nacionalidad varchar(50) not null
);


select * from persona;

insert into persona(nombre,correo,nacionalidad) values('test','test@gmail.com','Salvadorena')