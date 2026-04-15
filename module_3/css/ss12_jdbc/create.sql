CREATE DATABASE jdbc;
USE jdbc;
CREATE TABLE users (
id int(3) NOT NULL AUTO_INCREMENT,
name varchar(120) NOT NULL,
email varchar(220) NOT NULL,
country varchar(120),
PRIMARY KEY(id)
);
INSERT INTO users(name, email, country) values('Hai', 'hai@gmail.com', 'Viet Nam');
INSERT INTO users(name, email, country) values('Dang', 'dang@gmail.com', 'Viet Nam');

