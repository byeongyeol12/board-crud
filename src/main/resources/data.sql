INSERT INTO users (id, email, password, nickname, is_deleted, created_at, updated_at)
VALUES
    (RANDOM_UUID(), 'test1@example.com', 'password123', 'user1', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (RANDOM_UUID(), 'test2@example.com', 'password123', 'user2', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
