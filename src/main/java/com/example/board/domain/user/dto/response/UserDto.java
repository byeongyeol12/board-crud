package com.example.board.domain.user.dto.response;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
        UUID id,
        String nickname,
        String email,
        Instant createdAt
) {}
