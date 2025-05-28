package com.example.board.domain.user.dto;

import jakarta.validation.GroupSequence;

@GroupSequence({
        ValidationSequence.NotBlankGroup.class
})
public interface ValidationSequence {

    public interface NotBlankGroup {

    }
}
