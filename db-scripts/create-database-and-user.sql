CREATE DATABASE IF NOT EXISTS order_taking_api;
CREATE USER 'order_taking_api'@'%' IDENTIFIED BY 'order_taking_api';
GRANT ALL PRIVILEGES ON order_taking_api.* to 'order_taking_api'@'%';
FLUSH PRIVILEGES;