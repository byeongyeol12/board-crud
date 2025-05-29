CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       nickname VARCHAR(255),
                       is_deleted BOOLEAN,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);
