CREATE DATABASE product_management;
USE product_management;

CREATE TABLE category(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL UNIQUE,

create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE products( 
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
quantity INT NOT NULL CHECK (quantity >= 0),
category_id INT NOT NULL,
status TINYINT DEFAULT 1,

create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

INDEX idx_product_name (name),
INDEX idx_category_id (category_id),

FOREIGN KEY (category_id) REFERENCES category(id) 
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO category (name) VALUES
('iPhone'),
('Samsung'),
('Xiaomi'),
('Oppo'),
('Vivo');

INSERT INTO products (name, price, quantity, category_id) VALUES

('iPhone 15 128GB', 18990000, 10, 1),
('iPhone 15 Pro Max 256GB', 29990000, 5, 1),
('iPhone 14 128GB', 15990000, 8, 1),

('Samsung Galaxy S24', 20990000, 7, 2),
('Samsung Galaxy A54', 8990000, 12, 2),

('Xiaomi 13T', 12990000, 15, 3),
('Xiaomi Redmi Note 13', 5990000, 20, 3),

('Oppo Reno10', 10990000, 9, 4),
('Oppo A78', 6990000, 14, 4),

('Vivo V27', 9990000, 11, 5),
('Vivo Y36', 6490000, 18, 5);


