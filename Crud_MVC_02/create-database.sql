create database dbCrud;

use dbCrud;

create table tb_employees(

email varchar(255) primary key,

name varchar(255),

address varchar(255)

);

create table tb_login(

usuario varchar(255)

primary key,senha varchar(255)

);
create table tb_role (

id integer auto_increment,

nome varchar(255) not null,

primary key(id)

);

insert into tb_role(nome) values ('ADMIN');

insert into tb_role(nome) values ('USER');

create table tb_role_user (

usuario varchar(255) not null,

role_id integer not null,

primary key(usuario,role_id),

foreign key(usuario) references tb_login(usuario),

foreign key(role_id) references tb_role(id)

);

--insert into tb_role_user(usuario,role_id) values ('gabriel',1);
--insert into tb_role_user(usuario,role_id) values ('jojo',2);
