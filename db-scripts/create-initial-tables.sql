/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;

USE order_taking_api;

CREATE TABLE category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
);

CREATE TABLE product_category (
     id INT NOT NULL AUTO_INCREMENT,
     product_id INT NOT NULL,
     category_id INT NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT FOREIGN KEY (product_id) REFERENCES product(id),
     CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE order_list (
    id INT NOT NULL AUTO_INCREMENT,
    date_time_installation TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE order_customer (
    order_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    street VARCHAR(150) NOT NULL,
    street_additional VARCHAR(255),
    zip VARCHAR(9) NOT NULL,
    city VARCHAR(50) NOT NULL,
    country CHAR(2) NOT NULL,
    PRIMARY KEY (order_id),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES order_list(id)
);

CREATE TABLE order_product_category (
    id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_category_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES order_list(id),
    FOREIGN KEY (product_category_id) REFERENCES product_category(id)
);

CREATE TABLE agent (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    city VARCHAR(50) NOT NULL,
    country CHAR(2) NOT NULL,
    availability VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

/*!40014 SET FOREIGN_KEY_CHECKS = 1 */;
