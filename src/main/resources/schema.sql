CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       nickname VARCHAR(255),
                       is_deleted BOOLEAN,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);

CREATE TABLE posts (
                       id UUID PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       content TEXT NOT NULL,
                       is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
                       user_id UUID NOT NULL,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

