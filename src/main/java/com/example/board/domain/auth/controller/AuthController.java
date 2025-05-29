package com.example.board.domain.auth.controller;


import com.example.board.domain.auth.dto.request.UserLoginRequest;
import com.example.board.domain.auth.service.AuthService;
import com.example.board.domain.user.dto.response.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid UserLoginRequest request){
        UserDto userDto = authService.login(request);
        return ResponseEntity.ok(userDto);
    }

}
