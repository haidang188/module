CREATE DATABASE phone_store;
USE phone_store;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
full_name VARCHAR(100),
email VARCHAR(100) UNIQUE,
password VARCHAR(255),
phone VARCHAR(20),
role ENUM('ADMIN','USER') DEFAULT 'USER'
);


CREATE TABLE categories (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100)
);


CREATE TABLE brands (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100)
);


CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
model VARCHAR(100) UNIQUE,
category_id INT,
brand_id INT,
description TEXT,
version VARCHAR(255),
quantity INT DEFAULT 0,
status BOOLEAN DEFAULT TRUE,

FOREIGN KEY (category_id) REFERENCES categories(id),
FOREIGN KEY (brand_id) REFERENCES brands(id)
);


CREATE TABLE product_variants (
id INT AUTO_INCREMENT PRIMARY KEY,
product_id INT,
ram VARCHAR(50),
storage VARCHAR(50),
price DECIMAL(12,2),
stock INT,

FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE product_images (
id INT AUTO_INCREMENT PRIMARY KEY,
product_id INT,
image_url VARCHAR(500),
is_primary BOOLEAN DEFAULT FALSE,

FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE carts (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT UNIQUE,

FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE cart_items (
cart_id INT,
variant_id INT,
quantity INT,
PRIMARY KEY (cart_id, variant_id),
FOREIGN KEY (cart_id) REFERENCES carts(id),
FOREIGN KEY (variant_id) REFERENCES product_variants(id)
);


CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
total DECIMAL(12,2),
status ENUM('PENDING','DONE','CANCEL'),
address VARCHAR(255),
phone VARCHAR(20),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE order_items (
id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
variant_id INT,
product_name VARCHAR(255),
price DECIMAL(12,2),
quantity INT,

FOREIGN KEY (order_id) REFERENCES orders(id)
);

USE phone_store;

INSERT INTO categories (name) VALUES ('Điện thoại');

INSERT INTO brands (name) VALUES
                              ('Apple'),
                              ('Samsung'),
                              ('Oppo'),
                              ('Vivo'),
                              ('Xiaomi'),
                              ('Redmi');

INSERT INTO products (name, model, category_id, brand_id, description, version, quantity) VALUES
('iPhone 17 Pro Max', '17PRM', 1, 1, 'Flagship Apple', 'V1.0', 15),
('iPhone 17', '17', 1, 1, 'iPhone tiêu chuẩn', 'V1.0', 25),
('iPhone 16 Pro Max', '16PRM', 1, 1, 'iPhone đời trước', 'V1.0', 13),

('Samsung S25 Ultra', 'S25U', 1, 2, 'Flagship Samsung', 'V1.0', 16),
('Samsung S24', 'S24', 1, 2, 'Samsung cao cấp', 'V1.0', 20),

('Oppo X7', 'OPPOX7', 1, 3, 'Oppo cao cấp', 'V1.0', 15),
('Oppo R11', 'OPPOR11', 1, 3, 'Oppo tầm trung', 'V1.0', 20),
('Oppo A98', 'OPPOA98', 1, 3, 'Oppo giá rẻ', 'V1.0', 25),

('Vivo X100', 'VIVOX100', 1, 4, 'Vivo flagship', 'V1.0', 10),
('Vivo V30', 'VIVOV30', 1, 4, 'Vivo tầm trung', 'V1.0', 12),
('Vivo Y100', 'VIVOY100', 1, 4, 'Vivo giá rẻ', 'V1.0', 18),

('Xiaomi 14', 'MI14', 1, 5, 'Xiaomi flagship', 'V1.0', 10),
('Xiaomi 13T', 'MI13T', 1, 5, 'Xiaomi cận cao cấp', 'V1.0', 12),
('Xiaomi Note 13', 'MINOTE13', 1, 5, 'Xiaomi giá rẻ', 'V1.0', 15),

('Redmi Note 13 Pro', 'RMN13P', 1, 6, 'Redmi mạnh', 'V1.0', 21),
('Redmi Note 12', 'RMN12', 1, 6, 'Redmi phổ thông', 'V1.0', 25),
('Redmi 12', 'RM12', 1, 6, 'Redmi giá rẻ', 'V1.0', 31);

-- Product Images
-- 17PRM
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882302/iphone-17-pro-max_3_ouxcrm.jpg', TRUE
FROM products WHERE model='17PRM';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882302/iphone-17-pro-max_1_3_lx4vrp.jpg', FALSE
FROM products WHERE model='17PRM';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882302/iphone-17-pro-max-1_4_ccww0s.jpg', FALSE
FROM products WHERE model='17PRM';

-- 17
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882293/anh-iphone-17-26_wf3z6p.jpg', TRUE
FROM products WHERE model='17';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882293/anh-iphone-17-21_zx9o8k.jpg', FALSE
FROM products WHERE model='17';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882293/anh-iphone-17-14_cl7ssf.jpg', FALSE
FROM products WHERE model='17';

-- 16PRM
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882272/iphone-16-promax-77352886398983454954858_bhmpo6.jpg', TRUE
FROM products WHERE model='16PRM';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882271/%E1%BB%8BPhone_16_Pro_TCBC_1_omac5i.jpg', FALSE
FROM products WHERE model='16PRM';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882200/iPhone_16_Pro_-_TCBC_1_sk7ky6.jpg', FALSE
FROM products WHERE model='16PRM';

-- S25U
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882311/600x600__samsung-galaxy-s26-ultra-silver-shadow-thumb-600x600-1_iotswl.jpg', TRUE
FROM products WHERE model='S25U';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882311/Samsung-Galaxy-S26-Ultra-1004_a46zsy.jpg', FALSE
FROM products WHERE model='S25U';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882311/e3220260226104600_ou2kn8.png', FALSE
FROM products WHERE model='S25U';

-- S24
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882320/samsung-galaxy-a73-1-600x600_tlnjci.jpg', TRUE
FROM products WHERE model='S24';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882319/cach-chup-man-hinh-dien-thoai-samsung-a23-1_wyzsge.jpg', FALSE
FROM products WHERE model='S24';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777882320/samsung-galaxy-s25-fe-blue-thumbai-600x600_nu1qok.jpg', FALSE
FROM products WHERE model='S24';

-- OPPOX7
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883826/oppo-a6-pro-pink-1-638947499513490214-750x500_xkzrxm.jpg', TRUE
FROM products WHERE model='OPPOX7';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883826/oppo-a6-pro-pink-5-638947499456312901-750x500_e23mdq.jpg', FALSE
FROM products WHERE model='OPPOX7';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883826/oppo-a6-pro-pink-4-638947499465454417-750x500_px2pne.jpg', FALSE
FROM products WHERE model='OPPOX7';

-- OPPOR11
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883826/oppo-find-n6-titan-xanh-1-639095540535148052-750x500_dbrn0o.jpg', TRUE
FROM products WHERE model='OPPOR11';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883826/oppo-find-n6-titan-xanh-2-639095540544272522-750x500_sz3kps.jpg', FALSE
FROM products WHERE model='OPPOR11';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883827/oppo-find-n6-titan-xanh-6-639095540573760870-750x500_gsohri.jpg', FALSE
FROM products WHERE model='OPPOR11';

-- OPPOA98
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883827/oppo-find-x9-den-1-638978475802727678-750x500_x1iz2u.jpg', TRUE
FROM products WHERE model='OPPOA98';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883827/oppo-find-x9-den-4-638978475777910695-750x500_qlktdh.jpg', FALSE
FROM products WHERE model='OPPOA98';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883828/oppo-reno15-xanh-4-639034669545206193-750x500_xlfjtp.jpg', FALSE
FROM products WHERE model='OPPOA98';

-- VIVOX100
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883853/vivo-v40-5g-cam-hong-1-638682157901110213-750x500_dx1ysz.jpg', TRUE
FROM products WHERE model='VIVOX100';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883853/vivo-v40-5g-cam-hong-6-638682157938420509-750x500_ckwrnm.jpg', FALSE
FROM products WHERE model='VIVOX100';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883853/vivo-v40-5g-cam-hong-4-638682157921097073-750x500_ospq4u.jpg', FALSE
FROM products WHERE model='VIVOX100';

-- VIVOV30
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883854/vivo-v70-fe-tim-1-639101156012995340-750x500_kbchzb.jpg', TRUE
FROM products WHERE model='VIVOV30';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883854/vivo-v60-xam-4-638925165888534998-750x500_gwqxyi.jpg', FALSE
FROM products WHERE model='VIVOV30';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883854/vivo-v60-xam-11-638925165829503445-750x500_uzqsdx.jpg', FALSE
FROM products WHERE model='VIVOV30';

-- VIVOY100
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883854/vivo-v70-fe-tim-5-639101156042228886-750x500_xwufby.jpg', TRUE
FROM products WHERE model='VIVOY100';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883855/vivo-v70-vang-hong-5-639100356143512545-750x500_eh3tob.jpg', FALSE
FROM products WHERE model='VIVOY100';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883855/vivo-v70-vang-hong-6-639100356151213272-750x500_yljg1w.jpg', FALSE
FROM products WHERE model='VIVOY100';

-- MI14
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883867/xiaomi-15t-pro-5g-den-1-639050202393912375-750x500_k9h1vp.jpg', TRUE
FROM products WHERE model='MI14';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883868/xiaomi-15t-pro-5g-den-5-639050202422972908-750x500_tmlmxl.jpg', FALSE
FROM products WHERE model='MI14';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883868/xiaomi-15t-pro-5g-den-4-639050202414494550-750x500_ixkcnq.jpg', FALSE
FROM products WHERE model='MI14';

-- MI13T
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883868/xiaomi-17-den-1-639088219685898384-750x500_omqqbx.jpg', TRUE
FROM products WHERE model='MI13T';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883868/xiaomi-17-den-2-639088219692746013-750x500_aydytc.jpg', FALSE
FROM products WHERE model='MI13T';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883868/xiaomi-15t-pro-5g-den-5-639050202422972908-750x500_tmlmxl.jpg', FALSE
FROM products WHERE model='MI13T';

-- MINOTE13
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883869/xiaomi-17-ultra-black-1-639088343322428022-750x500_djaswo.jpg', TRUE
FROM products WHERE model='MINOTE13';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883869/xiaomi-17-ultra-black-2-639088343329577669-750x500_oda7cu.jpg', FALSE
FROM products WHERE model='MINOTE13';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883869/xiaomi-17-ultra-black-3-639088343335124647-750x500_gdmh3r.jpg', FALSE
FROM products WHERE model='MINOTE13';

-- RMN13P
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-15-pro-bac-1-638947522640043773-750x500_ozsado.jpg', TRUE
FROM products WHERE model='RMN13P';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-15-pro-bac-4-638947522590735097-750x500_blsd7x.jpg', FALSE
FROM products WHERE model='RMN13P';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883828/oppo-reno15-xanh-5-639034669555705821-750x500_ytsxag.jpg', FALSE
FROM products WHERE model='RMN13P';

-- RMN12
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-15-xam-1-638947564991846229-750x500_vnbldk.jpg', TRUE
FROM products WHERE model='RMN12';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-15-xam-5-638947564929470826-750x500_taazfy.jpg', FALSE
FROM products WHERE model='RMN12';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-15-xam-6-638947564921938487-750x500_dqjmew.jpg', FALSE
FROM products WHERE model='RMN12';

-- RM12
INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-c100-tim-1-639110642184785918-750x500_yxv38s.jpg', TRUE
FROM products WHERE model='RM12';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883840/realme-c100-tim-4-639110642205650487-750x500_nbxhcq.jpg', FALSE
FROM products WHERE model='RM12';

INSERT INTO product_images (product_id, image_url, is_primary)
SELECT id, 'https://res.cloudinary.com/dazpnizx8/image/upload/v1777883841/realme-c100-tim-6-639110642235391952-750x500_wfgbch.jpg', FALSE
FROM products WHERE model='RM12';

-- Product Variants
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 30000000, 10 FROM products WHERE model='17PRM';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '512GB', 34000000, 5 FROM products WHERE model='17PRM';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 22000000, 15 FROM products WHERE model='17';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '256GB', 25000000, 10 FROM products WHERE model='17';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 27000000, 8 FROM products WHERE model='16PRM';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '512GB', 30000000, 5 FROM products WHERE model='16PRM';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 28000000, 10 FROM products WHERE model='S25U';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '512GB', 32000000, 6 FROM products WHERE model='S25U';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 20000000, 12 FROM products WHERE model='S24';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '512GB', 23000000, 8 FROM products WHERE model='S24';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 15000000, 15 FROM products WHERE model='OPPOX7';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '128GB', 9000000, 20 FROM products WHERE model='OPPOR11';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 7000000, 25 FROM products WHERE model='OPPOA98';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 18000000, 10 FROM products WHERE model='VIVOX100';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 13000000, 12 FROM products WHERE model='VIVOV30';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '128GB', 8000000, 18 FROM products WHERE model='VIVOY100';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 17000000, 10 FROM products WHERE model='MI14';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 14000000, 12 FROM products WHERE model='MI13T';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '128GB', 9000000, 15 FROM products WHERE model='MINOTE13';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 8000000, 20 FROM products WHERE model='RMN13P';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 4000000, 30 FROM products WHERE model='RM12';

-- 17PRM - Variant 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '512GB', 38000000, 3 FROM products WHERE model='17PRM';

-- 17 - Variant 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 26000000, 8 FROM products WHERE model='17';

-- 16PRM - Variant 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '512GB', 35000000, 3 FROM products WHERE model='16PRM';

-- S25U - Variant 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '16GB', '512GB', 35000000, 4 FROM products WHERE model='S25U';

-- S24 - Variant 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 25000000, 6 FROM products WHERE model='S24';

-- OPPOX7 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '512GB', 18000000, 10 FROM products WHERE model='OPPOX7';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 16000000, 8 FROM products WHERE model='OPPOX7';

-- OPPOR11 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '256GB', 10000000, 15 FROM products WHERE model='OPPOR11';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 11000000, 12 FROM products WHERE model='OPPOR11';

-- OPPOA98 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '128GB', 8000000, 18 FROM products WHERE model='OPPOA98';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 9000000, 10 FROM products WHERE model='OPPOA98';

-- VIVOX100 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 16000000, 8 FROM products WHERE model='VIVOX100';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '512GB', 20000000, 5 FROM products WHERE model='VIVOX100';

-- VIVOV30 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 12000000, 15 FROM products WHERE model='VIVOV30';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 14000000, 10 FROM products WHERE model='VIVOV30';

-- VIVOY100 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 7000000, 20 FROM products WHERE model='VIVOY100';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 9000000, 12 FROM products WHERE model='VIVOY100';

-- MI14 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 15000000, 12 FROM products WHERE model='MI14';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '512GB', 19000000, 6 FROM products WHERE model='MI14';

-- MI13T - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 12000000, 15 FROM products WHERE model='MI13T';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '12GB', '256GB', 16000000, 8 FROM products WHERE model='MI13T';

-- MINOTE13 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 8000000, 18 FROM products WHERE model='MINOTE13';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 10000000, 12 FROM products WHERE model='MINOTE13';

-- RMN13P - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 7000000, 25 FROM products WHERE model='RMN13P';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '8GB', '256GB', 9000000, 15 FROM products WHERE model='RMN13P';

-- RMN12 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '4GB', '128GB', 5000000, 30 FROM products WHERE model='RMN12';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '256GB', 7000000, 20 FROM products WHERE model='RMN12';

-- RM12 - Variant 2, 3
INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '6GB', '128GB', 5000000, 25 FROM products WHERE model='RM12';

INSERT INTO product_variants (product_id, ram, storage, price, stock)
SELECT id, '4GB', '256GB', 5500000, 20 FROM products WHERE model='RM12';

-- Admin User
INSERT INTO users (full_name, email, password, phone, role)
VALUES (
           'Admin',
           'admin@gmail.com',
           '123456',
           '0123456789',
           'ADMIN'
       );