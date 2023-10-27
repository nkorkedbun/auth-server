CREATE TYPE user_role AS ENUM ('USER', 'ADMIN');

CREATE TABLE users (
    id serial PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role user_role NOT NULL
);