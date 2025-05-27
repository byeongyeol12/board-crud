package com.example.board.domain.user.service;

import com.example.board.domain.user.dto.request.UserRequest;
import com.example.board.domain.user.dto.response.UserDto;
import com.example.board.domain.user.entity.User;
import com.example.board.domain.user.mapper.UserMapper;
import com.example.board.domain.user.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Builder
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto create(UserRequest request){
        String email = request.email();
        String password = request.password();
        String nickname = request.nickname();

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다");
        }

        User user = new User(email, password, nickname);

        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto findUser(){
        return null;
    }

    public List<UserDto> findAllUser(){
        return null;
    }

    public UserDto update(){
        return null;
    }

    public void softDelete(){

    }

    public void hardDelete(){

    }



}
