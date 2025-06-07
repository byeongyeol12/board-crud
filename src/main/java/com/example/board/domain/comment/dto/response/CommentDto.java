package com.example.board.domain.comment.dto.response;

import java.time.Instant;
import java.util.UUID;

public record CommentDto (
        UUID id,
        UUID userId,
        UUID postId,
        String content,
        Instant createdAt
){}
