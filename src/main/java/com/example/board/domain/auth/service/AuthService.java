package com.example.board.domain.auth.service;

import com.example.board.domain.auth.dto.request.UserLoginRequest;
import com.example.board.domain.user.dto.response.UserDto;
import com.example.board.domain.user.entity.User;
import com.example.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public UserDto login(UserLoginRequest request){
        User user = userRepository.findByEmailAndIsDeletedFalse(request.email())
                .orElseThrow(() -> new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다"));
        if (!user.getPassword().equals(request.password())){
            throw new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다");
        }
        return new UserDto(user.getId(), user.getNickname(), user.getEmail(), user.getCreatedAt());
    }
}
