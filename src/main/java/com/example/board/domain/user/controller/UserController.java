package com.example.board.domain.user.controller;

import com.example.board.domain.user.dto.ValidationSequence;
import com.example.board.domain.user.dto.request.UserRequest;
import com.example.board.domain.user.dto.request.UserUpdateRequest;
import com.example.board.domain.user.dto.response.UserDto;
import com.example.board.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(
            @Validated(ValidationSequence.class) @RequestBody UserRequest userRequest){
            log.info("사용자 생성 요청: email={}, nickname={}", userRequest.email(), userRequest.nickname());
            UserDto UserDto = userService.create(userRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(UserDto);
    }


    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> find(@PathVariable UUID userId){
        UserDto UserDto = userService.find(userId);
        return ResponseEntity.ok(UserDto);
    }


    @PatchMapping(path = "/{userId}")
    public ResponseEntity<UserDto> update(@RequestHeader("header-id") UUID headerId,
                                          @PathVariable UUID userId,
                                          @Valid @RequestBody UserUpdateRequest userUpdateRequest){
        log.info("사용자 닉네임 변경 요청: userId={}, nickname={}", userId, userUpdateRequest.nickname());
        UserDto userDto = userService.update(headerId, userId, userUpdateRequest);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(userDto);

    }


    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> softDelete (@RequestHeader("header-id") UUID headerId,
                                               @PathVariable UUID userId){
        log.info("사용자 논리 삭제 요청: userId={}, nickname={}", userId);
        userService.softDelete(headerId,userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


    @DeleteMapping(path = "/{pathId}/userId")
    public ResponseEntity<Void> hardDelete (@RequestHeader("header-id") UUID headerId,
                                            @PathVariable UUID userId) {
        log.info("사용자 물리 삭제 요청: userId={}, nickname={}", userId);
        userService.hardDelete(userId, headerId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
