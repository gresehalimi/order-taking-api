USE order_taking_api;

INSERT INTO category SET id = 1, name = '250 Mbps';
INSERT INTO category SET id = 2, name = '1 Gbps';
INSERT INTO category SET id = 3, name = '90 channels';
INSERT INTO category SET id = 4, name = '140 channels';
INSERT INTO category SET id = 5, name = 'Free on net calls';
INSERT INTO category SET id = 6, name = 'Unlimited';
INSERT INTO category SET id = 7, name = 'Pre paid';
INSERT INTO category SET id = 8, name = 'Post paid';

INSERT INTO product SET id = 1, name = 'Internet';
INSERT INTO product SET id = 2, name = 'Television';
INSERT INTO product SET id = 3, name = 'Telephony';
INSERT INTO product SET id = 4, name = 'Mobile';

INSERT INTO product_category SET id = 1, product_id = 1, category_id = 1;
INSERT INTO product_category SET id = 2, product_id = 1, category_id = 2;
INSERT INTO product_category SET id = 3, product_id = 2, category_id = 3;
INSERT INTO product_category SET id = 4, product_id = 2, category_id = 4;
INSERT INTO product_category SET id = 5, product_id = 3, category_id = 5;
INSERT INTO product_category SET id = 6, product_id = 3, category_id = 6;
INSERT INTO product_category SET id = 7, product_id = 4, category_id = 7;
INSERT INTO product_category SET id = 8, product_id = 4, category_id = 8;

INSERT INTO agent SET id = 1, name = 'agent-1', email = 'agent_1@melita.com', country = 'AL', city = 'Tirana', availability = 'AVAILABLE';
INSERT INTO agent SET id = 2, name = 'agent-2', email = 'agent_2@melita.com', country = 'AL', city = 'Durres', availability = 'NOT_AVAILABLE';
INSERT INTO agent SET id = 3, name = 'agent-3', email = 'agent_3@melita.com', country = 'AL', city = 'Durres', availability = 'AVAILABLE';

INSERT INTO order_list set id = 1, date_time_installation = NOW() + INTERVAL 1 WEEK;
INSERT INTO order_list set id = 2, date_time_installation = NOW() + INTERVAL 1 DAY;
INSERT INTO order_list set id = 3, date_time_installation = NOW() + INTERVAL 1 DAY;

INSERT INTO order_customer SET order_id = 1, name = 'customer_1', email = 'customer_1@example.com', phone = '+12345678', street = 'foo street', street_additional = 'foo additional', zip = '10001', city = 'Tirana', country = 'AL';
INSERT INTO order_customer SET order_id = 2, name = 'customer_2', email = 'customer_2@example.com', phone = '+23456789', street = 'foo street 2', street_additional = 'foo additional 2', zip = '10001', city = 'Tirana', country = 'AL';
INSERT INTO order_customer SET order_id = 3, name = 'customer_3', email = 'customer_3@example.com', phone = '+34567890', street = 'foo street 3', street_additional = 'foo additional 3', zip = '10001', city = 'Tirana', country = 'AL';

INSERT INTO order_product_category SET id = 1, order_id = 1, product_category_id = 1;
INSERT INTO order_product_category SET id = 2, order_id = 1, product_category_id = 3;
INSERT INTO order_product_category SET id = 3, order_id = 2, product_category_id = 2;
INSERT INTO order_product_category SET id = 4, order_id = 2, product_category_id = 5;


