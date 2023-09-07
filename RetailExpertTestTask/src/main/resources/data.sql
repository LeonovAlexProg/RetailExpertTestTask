--Customers
INSERT INTO customers (id, address, name)
VALUES (1, 'test address 1', 'Vinzavod');
INSERT INTO customers (id, address, name)
VALUES (2, 'test address 2', 'Hlebzavod');
INSERT INTO customers (id, address, name)
VALUES (3, 'test address 3', 'Liftzavod');
INSERT INTO customers (id, address, name)
VALUES (4, 'test address 4', 'Mashinzavod');

--Products
INSERT INTO products (id, code, name, category, brand)
VALUES (1, 0001, 'vinograd', 'food', 'Rene_de_Shatilyon');
INSERT INTO products (id, code, name, category, brand)
VALUES (2, 0002, 'muka', 'food', 'Zloy_Fermer');
INSERT INTO products (id, code, name, category, brand)
VALUES (3, 0003, 'steel', 'material', 'Full_Metal_Alchemist');

--Default Prices
INSERT INTO prices (id, chain_name, price, prod_id)
VALUES (1, 'vinmag', 500, 1);
INSERT INTO prices (id, chain_name, price, prod_id)
VALUES (2, 'alcomarket', 300, 1);
INSERT INTO prices (id, chain_name, price, prod_id)
VALUES (3, 'dobriy_pekar', 50, 2);
INSERT INTO prices (id, chain_name, price, prod_id)
VALUES (4, 'zloy_pekar', 30, 2);
INSERT INTO prices (id, chain_name, price, prod_id)
VALUES (5, 'metal_torg', 50000, 3);
