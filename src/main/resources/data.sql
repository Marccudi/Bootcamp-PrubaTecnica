drop table if exists mensajes;
drop table if exists salas;
drop table if exists usuarios;
drop table if exists juegos;

create table juegos(
	nombre varchar(100),
    primary key (nombre)
);
create table usuarios(
	id int auto_increment,
    username varchar(100),
    pass varchar(255),
    steam_user varchar(255),
    primary key (id)
);

create table salas(
	id int auto_increment,
	nombre varchar(100),
    juego varchar(100),
    primary key (id),
    foreign key (juego) references juegos(nombre)
);

create table mensajes(
	id int auto_increment,
    mensaje varchar(255),
    fecha datetime,
    usuario int,
    sala int,
    primary key (id),
    foreign key(usuario) references usuarios(id),
    foreign key(sala) references salas(id)
);
insert into juegos values("God of war");
insert into juegos values("Sonic");
insert into juegos values("mario");

insert into usuarios(username, pass, steam_user) values("root","root", null);
insert into usuarios(username, pass, steam_user) values("Marccudi","1234", "marccudi");

insert into salas(nombre, juego) values("Gorgonitas","God of war");
insert into salas(nombre, juego) values("Bootcamp","Sonic");

insert into mensajes(mensaje, fecha, usuario, sala)values("Estais conectados?", CURRENT_TIMESTAMP, 1, 1);
