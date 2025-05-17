package com.example.board.domain.user.dto.response;

import java.time.Instant;

public record UserDto(
        String nickname,
        String email,
        String password,
        Instant createdAt
) {}
