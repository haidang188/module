USE QuanLyBanHang;

INSERT INTO Customer
VALUES (1, 'Minh Quan', 10);
INSERT INTO Customer
VALUES (2, 'Ngoc Oanh', 20);
INSERT INTO Customer
VALUES (3, 'Hong Ha', 50);

INSERT INTO `Order`
VALUES (1, 1, '2006-03-21', null);
INSERT INTO `Order`
VALUES (2, 2, '2006-03-23', null);
INSERT INTO `Order`
VALUES (3, 1, '2006-03-16', null);

INSERT INTO Product
VALUES (1, 'May Giat', 3);
INSERT INTO Product
VALUES (2, 'Tu Lanh', 5);
INSERT INTO Product
VALUES (3, 'Dieu Hoa', 7);
INSERT INTO Product
VALUES (4, 'Quat', 1);
INSERT INTO Product
VALUES (5, 'Bep Dien', 2);

INSERT INTO OrderDetail
VALUES (1, 1, 3);
INSERT INTO OrderDetail
VALUES (1, 3, 7);
INSERT INTO OrderDetail
VALUES (1, 4, 2);
INSERT INTO OrderDetail
VALUES (2, 1, 1);
INSERT INTO OrderDetail
VALUES (3, 1, 8);
INSERT INTO OrderDetail
VALUES (2, 5, 4);
INSERT INTO OrderDetail
VALUES (2, 3, 3);

SELECT oID, oDate, oTotalPrice
FROM `Order` ;

SELECT Customer.cID, Customer.cName, product.pID, product.pName
FROM Customer 
JOIN `Order` ON Customer.cID = `Order`.cID
JOIN OrderDetail ON `Order`.oID = OrderDetail.oID
JOIN product ON orderdetail.pID = product.pID;


SELECT cName
FROM Customer
LEFT JOIN `order` ON Customer.cID = `order`.cID
WHERE `order`.oID IS NULL;

SELECT o.oID, o.oDate, SUM(od.odQTY * p.pPrice) AS TotalPrice
FROM `order` o
JOIN orderdetail od ON o.oID = od.oID
JOIN product p ON od.pID = p.pID
GROUP BY o.oID, o.oDate
