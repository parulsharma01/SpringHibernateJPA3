USE mydb;

CREATE TABLE author (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE address (
    id   INTEGER AUTO_INCREMENT,
    street_number   INTEGER,
    location VARCHAR(20),
    state VARCHAR(20),
    PRIMARY KEY (id)
);
--/* many to many ---many authors have many addresses
CREATE TABLE authors_addresses(
    author_id int,
    address_id int,
    FOREIGN KEY (author_id)
    REFERENCES author(id),
    FOREIGN KEY (address_id)
    REFERENCES address(id)
);
--    many to one table -- many books have one author
CREATE TABLE books (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    author_id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id)
    REFERENCES author(id)
);