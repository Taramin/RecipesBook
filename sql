USE PRODUCTS_DATABASE;

DROP TABLE IF EXISTS  authors;
DROP TABLE IF EXISTS  cooking_ways;
DROP TABLE IF EXISTS  product_groups;
DROP TABLE IF EXISTS  products;
DROP TABLE IF EXISTS  providers;
DROP TABLE IF EXISTS recipies;
DROP TABLE IF EXISTS providers;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS ingresients_lists;

CREATE TABLE authors(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  surname VARCHAR(64) NOT NULL,
  country VARCHAR(64) NOT NULL,
  year SMALLINT NOT NULL
);


CREATE TABLE cooking_ways(
  id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(64) NOT NULL
);


CREATE TABLE product_groups(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL
  );


CREATE TABLE products(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  product_group_id INT NOT NULL,
  CONSTRAINT prGr FOREIGN KEY (product_group_id) REFERENCES product_groups (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE providers(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  phone_number VARCHAR(64) NOT NULL,
  address VARCHAR(64) NOT NULL
);


CREATE TABLE recipies(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(1024) NOT NULL,
  author_id INT NOT NULL,
  ingresients_list_id INT NOT NULL,
  CONSTRAINT authRec FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT recIngList FOREIGN KEY (ingresients_list_id) REFERENCES ingredients_lists(id) ON DELETE CASCADE ON UPDATE CASCADE
  --  FOREIGN KEY (ingresients_list_id) REFERENCE ingredients_lists(id)
);


CREATE TABLE ingredients(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  weight INT NOT NULL,
  calories_number FLOAT NOT NULL,
  cooking_way_id INT NOT NULL,
  product_id INT NOT NULL,
  price_list_id INT NOT NULL,

  CONSTRAINT cookWayIng FOREIGN KEY (cooking_way_id) REFERENCES cooking_ways (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT prodIng FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE price_lists(
  id INT PRIMARY KEY AUTO_INCREMENT,
  date DATE NOT NULL,
  price FLOAT NOT NULL,
  provider_id INT NOT NULL,
  ingredient_id INT NOT NULL,
   CONSTRAINT provPrList FOREIGN KEY (provider_id) REFERENCES providers (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT priceIng FOREIGN KEY (ingredient_id) REFERENCES ingredients (id) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE ingredients_lists(
  id INT PRIMARY KEY AUTO_INCREMENT,
  recipe_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  CONSTRAINT ingList FOREIGN KEY (ingredient_id) REFERENCES ingredients (id) ON DELETE CASCADE ON UPDATE CASCADE
);


SELECT * FROM authors;
SELECT * FROM cooking_ways;
SELECT * FROM product_groups;
SELECT * FROM products;
SELECT * FROM providers;
SELECT * FROM recipies;
SELECT * FROM price_lists;
SELECT * FROM ingredients;

--------------------------------------------
   INSERT INTO
authors(id, name, surname, country, year)
VALUES
('1','Darya','Taramin', 'Belarus', '2021');

   INSERT INTO
authors(id, name, surname, country, year)
VALUES
('2','Julia','Moroschuk', 'Russia', '2022');

   INSERT INTO
authors(id, name, surname, country, year)
VALUES
('3','Diana','Makarenko', 'Poland', '2020');
--------------------------------------------
  INSERT INTO
cooking_ways(id, name)
VALUES
('1','boiling');

  INSERT INTO
cooking_ways(id, name)
VALUES
('2','frying');

  INSERT INTO
cooking_ways(id, name)
VALUES
('3','steam');

  INSERT INTO
cooking_ways(id, name)
VALUES
('4','bake');

  INSERT INTO
cooking_ways(id, name)
VALUES
('5','cut');
--------------------------------------------

  INSERT INTO
product_groups(id, name)
VALUES
('1','dairy products');


  INSERT INTO
product_groups(id, name)
VALUES
('2','meat products');


  INSERT INTO
product_groups(id, name)
VALUES
('3','vegetables');


  INSERT INTO
product_groups(id, name)
VALUES
('4','fruits');


  INSERT INTO
product_groups(id, name)
VALUES
('5','cereals');

--------------------------------------------
  INSERT INTO
products(id, name, product_group_id)
VALUES
('1','milk', '1');

  INSERT INTO
products(id, name, product_group_id)
VALUES
('2','cheese', '1');

  INSERT INTO
products(id, name, product_group_id)
VALUES
('3','chicken', '2');

  INSERT INTO
products(id, name, product_group_id)
VALUES
('4','pork', '2');

  INSERT INTO
products(id, name, product_group_id)
VALUES
('5','tomato', '3');

  INSERT INTO
products(id, name, product_group_id)
VALUES
('6','cucumber', '3');

--------------------------------------------

  INSERT INTO
providers(id, name, phone_number, address)
VALUES
('1','Bread','375295578784','Gikalo, 44');

INSERT INTO
providers(id, name, phone_number, address)
VALUES
('2','Rom','375296828901','Uruche, 12');

INSERT INTO
providers(id, name, phone_number, address)
VALUES
('3','Bob','375291994584','Suharevo, 3');

--------------------------------------------

INSERT INTO
  recipies (id, name, description, author_id, ingresients_list_id)
VALUES
  ('1', 'cheese', 'boil milk. keep on cold.', '1', '1');

  INSERT INTO
  recipies (id, name, description, author_id, ingresients_list_id)
VALUES
  ('2', 'steak', 'fry pork. keep on cold.', '2', '2');


INSERT INTO
  recipies (id, name, description, author_id, ingresients_list_id)
VALUES
  ('3', 'caprese', 'cut tomato and cheese. eat.', '1', '3');


  --------------------------------------------

  INSERT INTO
price_lists(id, date, price, provider_id, ingredient_id)
VALUES
('1','25.09.2021','55','1','1');

  INSERT INTO
price_lists(id, date, price, provider_id, ingredient_id)
VALUES
('2','23.09.2021','45','2','1');

  INSERT INTO
price_lists(id, date, price, provider_id, ingredient_id)
VALUES
('3','25.09.2021','30','1','2');

  INSERT INTO
price_lists(id, date, price, provider_id, ingredient_id)
VALUES
('4','24.09.2021','50','2','3');

---------------------------------------------

  INSERT INTO
ingredients(id, name, weight, calories_number, cooking_way_id, product_id)
VALUES
('1','boiled milk','1000', '45', '1', '1');


  INSERT INTO
ingredients_lists(id, recipe_id, ingredient_id)
VALUES
('1','1','1');


