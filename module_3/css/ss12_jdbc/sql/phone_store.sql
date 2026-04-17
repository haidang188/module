CREATE DATABASE phone_store;
USE phone_store;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
full_name VARCHAR(100),
email VARCHAR(100) NOT NULL UNIQUE,
phone VARCHAR(20),
password VARCHAR(255) NOT NULL,
address VARCHAR(255),
role ENUM('admin', 'user') DEFAULT 'user',
status ENUM('active', 'inactive') DEFAULT 'active',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE categories (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description VARCHAR(255)
);

CREATE TABLE brands (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
country VARCHAR(100)
);

CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
category_id INT,
brand_id INT,
name VARCHAR(200) NOT NULL,
model VARCHAR(100),
price DECIMAL(12,2) NOT NULL,
stock INT DEFAULT 0,
image_url VARCHAR(255),
short_description VARCHAR(255),
description TEXT,
screen_size VARCHAR(50),
ram VARCHAR(50),
storage VARCHAR(50),
battery VARCHAR(50),
color VARCHAR(50),
status ENUM('active', 'inactive') DEFAULT 'active',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

FOREIGN KEY (category_id) REFERENCES categories(id),
FOREIGN KEY (brand_id) REFERENCES brands(id)

);


CREATE TABLE cart (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT UNIQUE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE cart_items (
id INT AUTO_INCREMENT PRIMARY KEY,
cart_id INT,
product_id INT,
quantity INT NOT NULL,
price_at_time DECIMAL(12,2),

FOREIGN KEY (cart_id) REFERENCES cart(id) ON DELETE CASCADE,
FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
shipping_name VARCHAR(100),
shipping_phone VARCHAR(20),
shipping_address VARCHAR(255),
note VARCHAR(255),
total_amount DECIMAL(12,2),
payment_method ENUM('cod', 'bank'),
payment_status ENUM('pending', 'paid', 'failed') DEFAULT 'pending',
order_status ENUM('pending', 'confirmed', 'shipping', 'completed', 'cancelled') DEFAULT 'pending',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
product_id INT,
product_name VARCHAR(200),
produdct_image VARCHAR(255),
quantity INT NOT NULL,
unit_price DECIMAL(12,2),
subtotal DECIMAL(12,2),

FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE INDEX idx_products_category ON products(category_id);
CREATE INDEX idx_products_brand ON products(brand_id);
CREATE INDEX idx_orders_user ON orders(user_id);
CREATE INDEX idx_order_items_order ON order_items(order_id);
CREATE INDEX idx_cart_user ON cart(user_id);


USE phone_store;
INSERT INTO categories (id, name, description) VALUES
(1, 'Flagship', 'Dien thoai cao cap, hieu nang lon'),
(2, 'Gaming', 'Dien thoai choi game, hieu nang cao'),
(3, 'Camera Phone', 'Tap trung vao khang nang chup anh'),
(4, 'Pin Trau', 'Thoi luong pin lon, sac nhanh');

INSERT INTO brands (id, name, country) VALUES
(1, 'Apple', 'My'),
(2, 'Samsung', 'Han Quoc'),
(3, 'Xiaomi', 'Trung Quoc'),
(4, 'OPPO', 'Trung Quoc');

INSERT INTO users (id, full_name, email, phone, password, address, role, status) VALUES
(1, 'Quan tri vien', 'admin@phonestore.vn', '0909000111', '123456', 'TP. Ho Chi Minh', 'admin', 'active'),
(2, 'Khach Hang', 'khachhang@phonestore.vn', '0909000222', '123456', 'Ha Noi', 'user', 'active'),
(3, 'Nguyen Van A', 'nguyenvana@phonestore.vn', '0911222333', '123456', 'Da Nang', 'user', 'active'),
(4, 'Tran Thi B', 'tranthib@phonestore.vn', '0988777666', '123456', 'Can Tho', 'user', 'active');

INSERT INTO products (id, category_id, brand_id, name, model, price, stock, image_url, short_description, description, screen_size, ram, storage, battery, color, status) VALUES
(1, 1, 1, 'iPhone 15 128GB', 'A3090', 18990000, 25, 'assets/images/products/iphone-15.svg', 'Chip A16 Bionic, Dynamic Island, camera 48MP.', 'iPhone 15 mang thiet ke nhom cao cap, hieu nang manh va camera 48MP cho hinh anh sac net.', '6.1 inch', '6GB', '128GB', '3349mAh', 'Den', 'active'),
(2, 1, 2, 'Samsung Galaxy S24', 'SM-S921B', 17490000, 18, 'assets/images/products/galaxy-s24.svg', 'Man hinh 120Hz, AI camera, pin 4.000mAh.', 'Samsung Galaxy S24 co AI thong minh, hieu nang on dinh va trai nghiem man hinh dep.', '6.2 inch', '8GB', '256GB', '4000mAh', 'Xam', 'active'),
(3, 2, 3, 'Xiaomi 14', '24031PN0DC', 15990000, 30, 'assets/images/products/xiaomi-14.svg', 'Leica camera, Snapdragon 8 Gen 3, sac nhanh.', 'Xiaomi 14 hop tac voi Leica, toc do sac nhanh va cau hinh cao cap phuc vu gaming.', '6.36 inch', '12GB', '256GB', '4610mAh', 'Trang', 'active'),
(4, 3, 4, 'OPPO Reno 12', 'CPH2625', 9490000, 40, 'assets/images/products/oppo-reno-12.svg', 'Thiet ke mong nhe, selfie dep, sac 80W.', 'OPPO Reno 12 co camera selfie dep, ngoai hinh mong nhe va sac nhanh tien loi.', '6.7 inch', '12GB', '256GB', '5000mAh', 'Tim', 'active'),
(5, 1, 1, 'iPhone 14 256GB', 'A2882', 19990000, 16, 'assets/images/products/iphone-15.svg', 'Man hinh Super Retina XDR, camera kep, pin ben bi.', 'iPhone 14 phu hop nguoi dung can camera on, pin ben va he sinh thai iOS.', '6.1 inch', '6GB', '256GB', '3279mAh', 'Den', 'active'),
(6, 4, 2, 'Samsung Galaxy A55', 'SM-A556E', 9790000, 22, 'assets/images/products/galaxy-s24.svg', 'Khung kim loai, camera OIS, pin 5.000mAh.', 'Galaxy A55 la lua chon can bang giua hieu nang, camera va thoi luong pin.', '6.6 inch', '8GB', '128GB', '5000mAh', 'Xanh', 'active'),
(7, 2, 3, 'Xiaomi Redmi Note 13 Pro', '23117RA68G', 7690000, 35, 'assets/images/products/xiaomi-14.svg', 'Man hinh AMOLED 120Hz, camera 200MP.', 'Redmi Note 13 Pro noi bat voi camera 200MP, man hinh AMOLED va gia thanh tot.', '6.67 inch', '8GB', '256GB', '5100mAh', 'Xanh la', 'active'),
(8, 4, 4, 'OPPO A79', 'CPH2551', 6290000, 50, 'assets/images/products/oppo-reno-12.svg', 'Sac nhanh 33W, thiet ke tre trung, loa kep.', 'OPPO A79 phu hop hoc sinh sinh vien voi pin lon va sac nhanh 33W.', '6.72 inch', '8GB', '128GB', '5000mAh', 'Den', 'active'),
(9, 1, 1, 'iPhone 13 128GB', 'A2633', 13490000, 20, 'assets/images/products/iphone-15.svg', 'Hieu nang on dinh, camera chat luong, iOS moi.', 'iPhone 13 van la dong may manh, ben va on dinh trong phan khuc flagship cu.', '6.1 inch', '4GB', '128GB', '3240mAh', 'Trang', 'active'),
(10, 1, 2, 'Samsung Galaxy Z Flip5', 'SM-F731B', 21990000, 12, 'assets/images/products/galaxy-s24.svg', 'Thiet ke gap doc dao, man hinh phu linh hoat.', 'Galaxy Z Flip5 mang trair nghiem gap doc dao va phu hop nguoi dung thich ca tinh.', '6.7 inch', '8GB', '256GB', '3700mAh', 'Vang', 'active'),
(11, 2, 3, 'Xiaomi 13T', '2306EPN60G', 11990000, 27, 'assets/images/products/xiaomi-14.svg', 'Camera Leica, man hinh dep, pin lon.', 'Xiaomi 13T can bang giua camera, hieu nang va gia ban hap dan.', '6.67 inch', '12GB', '256GB', '5000mAh', 'Den', 'active'),
(12, 3, 4, 'OPPO Find N3 Flip', 'CPH2519', 18990000, 10, 'assets/images/products/oppo-reno-12.svg', 'Dien thoai gap, camera chan dung tot.', 'Find N3 Flip la may gap cao cap voi camera chat luong va thiet ke sang trong.', '6.8 inch', '12GB', '512GB', '4300mAh', 'Tim', 'active');
