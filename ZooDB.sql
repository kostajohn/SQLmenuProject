create database if not exists zoo;

use zoo;

drop table if exists animals;

create table animals (
	id int(10) auto_increment not null,
	type_of_animal varchar(20) not null,
	name varchar(20) not null,
	food varchar(20) not null,
	primary key(id)
);