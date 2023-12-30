CREATE TABLE candidates (
    id            serial PRIMARY KEY,
    name          varchar NOT NULL,
    description   varchar NOT NULL,
    creation_date timestamp
);
