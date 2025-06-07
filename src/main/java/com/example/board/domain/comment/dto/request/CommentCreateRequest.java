package com.example.board.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CommentCreateRequest(
        @NotNull(message = "게시글 ID는 필수 입력 항목입니다.")
        UUID postId,

        @NotNull(message = "사용자 ID는 필수 입력 항목입니다.")
        UUID userId,

        @NotBlank(message = "댓글 내용은 필수 입력 항목입니다.")
        String content

) {}
