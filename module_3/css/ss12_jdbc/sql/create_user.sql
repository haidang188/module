CREATE DATABASE user_management;
USE user_management;

CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL UNIQUE,
country VARCHAR(200) NOT NULL
);
INSERT INTO users(name, email, country) VALUE('Nguyen', 'nguyen@gmail.com', 'Viet Nam');
INSERT INTO users(name, email, country) VALUE('Ha', 'ha@gmail.com', 'Viet Nam');
INSERT INTO users(name, email, country) VALUE('Hai', 'hai@gmail.com', 'Viet Nam');
INSERT INTO users(name, email, country) VALUE('Dang', 'dang@gmail.com', 'Viet Nam');
INSERT INTO users(name, email, country) VALUE('Alex', 'alex@gmail.com', 'Italia');
INSERT INTO users(name, email, country) VALUE('Bill', 'bill@gmail.com', 'Phap');

