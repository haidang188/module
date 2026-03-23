CREATE DATABASE demo_products;
USE demo_products;

CREATE TABLE Products (
ID INT AUTO_INCREMENT PRIMARY KEY,
productCode VARCHAR(50) NOT NULL,
productName VARCHAR(100),
productPrice DECIMAL(10,2),
productAmount INT, 
productDescription TEXT,
productStatus VARCHAR(50)
);


INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES
('P001', 'iPhone 13', 20000, 10, 'Apple phone', 'Available'),
('P002', 'Samsung S21', 18000, 15, 'Samsung phone', 'Available'),
('P003', 'Xiaomi Mi 11', 15000, 20, 'Xiaomi phone', 'Out of stock'),
('P004', 'Oppo Reno', 12000, 12, 'Oppo phone', 'Available');

CREATE UNIQUE INDEX idx_product_code 
ON Products(productCode);


CREATE INDEX idx_name_price 
ON Products(productName, productPrice);

CREATE VIEW view_products AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;

CREATE OR REPLACE VIEW view_products AS
SELECT productCode, productName, productPrice
FROM Products;


DROP VIEW view_products;

DELIMITER //

CREATE PROCEDURE getAllProducts()
BEGIN
    SELECT * FROM Products;
END //

DELIMITER ;

CALL getAllProducts();

DELIMITER //

CREATE PROCEDURE addProduct(
    IN p_code VARCHAR(50),
    IN p_name VARCHAR(100),
    IN p_price DECIMAL(10,2),
    IN p_amount INT,
    IN p_desc TEXT,
    IN p_status VARCHAR(50)
)
BEGIN
    INSERT INTO Products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES(p_code, p_name, p_price, p_amount, p_desc, p_status);
END //

DELIMITER ;


CALL addProduct('P005', 'iPhone 14', 25000, 8, 'New Apple phone', 'Available');


DELIMITER //

CREATE PROCEDURE updateProduct(
    IN p_id INT,
    IN p_name VARCHAR(100),
    IN p_price DECIMAL(10,2),
    IN p_amount INT,
    IN p_desc TEXT,
    IN p_status VARCHAR(50)
)
BEGIN
    UPDATE Products
    SET 
        productName = p_name,
        productPrice = p_price,
        productAmount = p_amount,
        productDescription = p_desc,
        productStatus = p_status
    WHERE Id = p_id;
END //

DELIMITER ;


CALL updateProduct(1, 'iPhone 13 Pro', 22000, 5, 'Updated version', 'Available');


DELIMITER //

CREATE PROCEDURE deleteProduct(
    IN p_id INT
)
BEGIN
    DELETE FROM Products WHERE Id = p_id;
END //

DELIMITER ;


