-- USERS (5명)
INSERT INTO users (id, email, password, nickname, is_deleted, created_at, updated_at) VALUES
('11111111-1111-1111-1111-111111111111', 'alice@example.com', 'password123', 'Alice', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('22222222-2222-2222-2222-222222222222', 'bob@example.com', 'password123', 'Bob', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('33333333-3333-3333-3333-333333333333', 'carol@example.com', 'password123', 'Carol', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('44444444-4444-4444-4444-444444444444', 'dave@example.com', 'password123', 'Dave', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('55555555-5555-5555-5555-555555555555', 'eve@example.com', 'password123', 'Eve', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS (5개, 작성자 다르게 분산)
INSERT INTO posts (id, title, content, user_id, created_at, updated_at) VALUES
('a1a1a1a1-a1a1-a1a1-a1a1-a1a1a1a1a1a1', '첫 번째 글', '이것은 첫 번째 테스트 게시물입니다.', '11111111-1111-1111-1111-111111111111', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('b2b2b2b2-b2b2-b2b2-b2b2-b2b2b2b2b2b2', '두 번째 글', '이것은 두 번째 테스트 게시물입니다.', '22222222-2222-2222-2222-222222222222', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('c3c3c3c3-c3c3-c3c3-c3c3-c3c3c3c3c3c3', '세 번째 글', '이것은 세 번째 테스트 게시물입니다.', '33333333-3333-3333-3333-333333333333', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('d4d4d4d4-d4d4-d4d4-d4d4-d4d4d4d4d4d4', '네 번째 글', '이것은 네 번째 테스트 게시물입니다.', '44444444-4444-4444-4444-444444444444', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('e5e5e5e5-e5e5-e5e5-e5e5-e5e5e5e5e5e5', '다섯 번째 글', '이것은 다섯 번째 테스트 게시물입니다.', '55555555-5555-5555-5555-555555555555', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);