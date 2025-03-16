CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    type_engine VARCHAR(255),
    engine VARCHAR(255),
    transmission VARCHAR(255),
    price VARCHAR(255),
    color VARCHAR(255),
    description TEXT,
    description_price TEXT,
    category_id BIGINT,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);