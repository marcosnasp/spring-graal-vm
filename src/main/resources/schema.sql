CREATE TABLE author (
    author_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    bio TEXT
);

CREATE TABLE publisher (
    publisher_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(20)
);

CREATE TABLE book_category (
    book_category_id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);

CREATE TABLE book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(13),
    publication_date DATE,
    price DECIMAL(10, 2),
    publisher_id INTEGER REFERENCES publisher(publisher_id),
    book_category_id INTEGER REFERENCES book_category(book_category_id)
);

CREATE TABLE book_author (
    book_id INTEGER REFERENCES book(book_id),
    author_id INTEGER REFERENCES Author(author_id),
    PRIMARY KEY (book_id, author_id)
);

CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(40),
    address VARCHAR(140),
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE order_costumer (
    order_costumer_id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES Customer(customer_id),
    order_date TIMESTAMP,
    total_amount DECIMAL(10, 2)
);

CREATE TABLE order_item (
    order_item_id SERIAL PRIMARY KEY,
    order_costumer_id INTEGER REFERENCES order_costumer(order_costumer_id),
    book_id INTEGER REFERENCES book(book_id),
    quantity INTEGER,
    price DECIMAL(10, 2)
);
