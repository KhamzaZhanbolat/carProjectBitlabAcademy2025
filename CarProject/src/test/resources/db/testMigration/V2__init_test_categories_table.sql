CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO categories (name) VALUES ('Люкс');
INSERT INTO categories (name) VALUES ('Эконом');
INSERT INTO categories (name) VALUES ('Бизнес');
INSERT INTO categories (name) VALUES ('Спорт');