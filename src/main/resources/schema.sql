CREATE TABLE Author (
    author_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    bio TEXT,
    PRIMARY KEY (author_id)
);

CREATE TABLE Publisher (
    publisher_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(20),
    PRIMARY KEY (publisher_id)
);

CREATE TABLE Book (
    book_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(13),
    publication_date DATE,
    price DECIMAL(10, 2),
    publisher_id INT NOT NULL,
    author_id INT NOT NULL,
    FOREIGN KEY (publisher_id) REFERENCES Publisher(publisher_id),
    FOREIGN KEY (author_id) REFERENCES Author(author_id),
    PRIMARY KEY (book_id)
);

CREATE TABLE Category (
    category_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE BookCategory (
    book_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE Customer (
    customer_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(40),
    address VARCHAR(140),
    phone_number VARCHAR(20) NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE `Order` (
    order_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    customer_id INT NOT NULL,
    order_date TIMESTAMP,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    PRIMARY KEY (order_id)
);

CREATE TABLE OrderItem (
    order_item_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    order_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id),
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    PRIMARY KEY (order_item_id)
);
