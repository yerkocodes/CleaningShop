CREATE DATABASE IF NOT EXISTS cleaningProducts;
USE cleaningProducts;

-- CATEGORY TABLE 
CREATE TABLE IF NOT EXISTS category (
  id_category INT AUTO_INCREMENT PRIMARY KEY,
  name_category VARCHAR(50)
);

-- PRODUCT TABLE
CREATE TABLE product (
  id_product INT AUTO_INCREMENT PRIMARY KEY,
  name_product VARCHAR(75),
  price_product INT,
  description_product VARCHAR(200),
  id_category INT,
  FOREIGN KEY (id_category) REFERENCES category(id_category)
);

INSERT INTO category (id_category, name_category) VALUE (1, "Detergente líquido");

SELECT * FROM product;

INSERT INTO category(id_category, name_category)
VALUE (2, "Detergente en polvo");

SELECT * FROM product;

INSERT INTO product(name_product, price_product, description_product, id_category)
VALUE ("Omo", 3500, "Quita manchas", 1);

INSERT INTO product(name_product, price_product, description_product, id_category)
VALUE ("Ariel", 4400, "Quita manchas", 2);

