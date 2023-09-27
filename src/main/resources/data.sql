-- Insert authors
INSERT INTO author (first_name, last_name, birth_date, bio) VALUES
    ('John', 'Doe', '1980-05-15', 'A prolific author with many bestsellers.'),
    ('Jane', 'Smith', '1975-09-22', 'Award-winning novelist known for her compelling stories.'),
    ('David', 'Brown', '1990-02-10', 'Up-and-coming author with a unique writing style.');

-- Insert publishers
INSERT INTO publisher (name, address, phone_number) VALUES
    ('Big Publishing House', '123 Main St, Cityville', '+1 (555) 123-4567'),
    ('Small Press', '456 Elm St, Townsville', '+1 (555) 987-6543'),
    ('New Horizon Publishers', '789 Oak St, Villagetown', '+1 (555) 876-5432');

INSERT INTO book_category (name) VALUES ('Mystery'),
    ('Adventure stories'), ('Crime'),
    ('Historical fiction'), ('Horror'),
    ('Humour and Satire'),
    ('Poetry'),
    ('Thrillers'),
    ('War');

-- Insert books
INSERT INTO book (title, isbn, publication_date, price, publisher_id, book_category_id) VALUES
    ('The Mystery of the Lost Key', '978-123456789', '2022-03-15', 19.99, 1, 1),
    ('A Tale of Two Cities', '978-014043701', '1859-01-01', 14.99, 2, 2),
    ('The Secret Garden', '978-006440188', '1911-11-01', 12.99, 2, 3),
    ('The Art of Programming', '978-020163361', '1997-04-01', 29.99, 3, 4);

INSERT INTO book_author (author_id, book_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert customers
INSERT INTO customer (first_name, last_name, email, address, phone_number) VALUES
    ('Alice', 'Johnson', 'alice@example.com', '567 Pine St, Suburbia', '+1 (555) 111-2222'),
    ('Bob', 'Smith', 'bob@example.com', '789 Oak St, Villagetown', '+1 (555) 333-4444'),
    ('Charlie', 'Brown', 'charlie@example.com', '123 Elm St, Downtown', '+1 (555) 555-6666');

-- Insert orders
INSERT INTO order_customer (customer_id, order_date, total_amount) VALUES
    (1, '2022-04-10 14:30:00', 39.98),
    (2, '2022-05-05 11:45:00', 44.97),
    (3, '2022-06-20 09:15:00', 19.99);

-- Insert order items
INSERT INTO order_item (order_customer_id, book_id, quantity, price) VALUES
    (1, 1, 2, 39.98),
    (2, 2, 3, 44.97),
    (3, 4, 1, 19.99);