create table movie(
id bigint not null auto_increment,
name varchar(100) not null,
duration int not null,
years int not null,
gender varchar(100),
primary key(id)
);