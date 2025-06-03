package com.example.board.domain.post.dto.response;

import java.time.Instant;
import java.util.UUID;

public record PostDto (
        UUID id,
        String title,
        String content,
        UUID userId,
        Instant createdAt
){}
