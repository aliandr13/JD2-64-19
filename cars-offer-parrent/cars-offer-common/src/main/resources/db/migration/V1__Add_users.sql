CREATE TABLE user
 (
     id          int          NOT NULL PRIMARY KEY,
     login   CHAR(10) NOT NULL,
     password CHAR(18) NOT NULL,
     role   int NOT NULL,
     e_mail       CHAR(255)
 );
 INSERT INTO user(id,login,password,role,e_mail)
 values (1,'Den','13579',1,'First@mail.ru'),
 (2,'Rem','2468',2,'Second@mail.ru'),
 (3,'Andr','13412',2,'Third@mail.ru'),
 (1,'scPA','27910',2,'Fouth@mail.ru');

 CREATE TABLE access (
 id int not null primary key,
 role char (255) not null;
 );
 Insert into access(id,role) values (1,'admin'),
 (2,'user');

CREATE TABLE car(id int not null primary key, model_id int, foreign key (model_id) references model(id), price  int not null ,date DATA ,engine int ,VIN char(30) );
INSERT INTO car(id,model_id,price,engine,VIN) values
(1,1,200,2015.03.10,1,'WP1AB29P662A68044')
(1,2,150,2012.04.21,2,'WP1AB29P662N87044');

CREATE TABLE engine (id int not null primary key, value decimal,model_id int, foreign key (model_id) references model (id));
INSERT INTO engine(id,value,model_id) values
(1,2.0,3),
(2,4.8,1);

CREATE TABLE mark(id int not null primary key ,name varchar(20) not null);
insert into mark(id,name) values (1,'Porsche'),
insert into mark(id,name) values (2,'Audi');

CREATE TABLE model(id int no  primary key , name char(255),mark_id int, foreign key (mark_id) references mark(id));
Insert into model (id,name,mark_id)
values (1,'Panamera',1),
(2,'A7',2);