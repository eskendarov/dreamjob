CREATE TABLE users (
    id       SERIAL PRIMARY KEY,
    name     varchar        NOT NULL,
    email    varchar UNIQUE NOT NULL,
    password varchar        NOT NULL
);