CREATE DATABASE IF NOT EXISTS order_taking_api;
CREATE USER 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON order_taking_api.* to 'root'@'%';
FLUSH PRIVILEGES;