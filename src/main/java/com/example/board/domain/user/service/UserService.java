package com.example.board.domain.user.service;

import com.example.board.domain.user.dto.request.UserRequest;
import com.example.board.domain.user.dto.request.UserUpdateRequest;
import com.example.board.domain.user.dto.response.UserDto;
import com.example.board.domain.user.entity.User;
import com.example.board.domain.user.mapper.UserMapper;
import com.example.board.domain.user.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Builder
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
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


    public UserDto find(UUID userId){
        UserDto userDto = userRepository.findByIdAndIsDeletedFalse(userId)
                .map(userMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다"));
                return userDto;
    }


    public List<UserDto> findAll(UUID id){
        List<UserDto> userDtos = userRepository.findAllByIsDeletedFalse().stream().map(userMapper::toDto).toList();

        return userDtos;

    }

    @Transactional
    public UserDto update(UUID userId, UUID headerId, UserUpdateRequest userUpdateRequest){

        String newNickname = userUpdateRequest.nickname();

        if(userRepository.existsByNickname(newNickname)){
            throw new IllegalArgumentException("이미 사용중인 닉네임입니다");
        }

        User user = userRepository.findByIdAndIsDeletedFalse(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 유저를 찾을 수 없습니다"));

        if(!userId.equals(headerId)){
            throw new IllegalArgumentException("본인만 수정 가능합니다");
        }

        user.update(newNickname);
        return userMapper.toDto(user);
    }


    @Transactional
    public void softDelete(UUID userId, UUID headerId){

        if(!userId.equals(headerId)){
            throw new IllegalArgumentException("본인만 삭제할 수 있습니다");
        }

        User user = userRepository.findByIdAndIsDeletedFalse(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다"));

        user.softDelete();
    }


    public void hardDelete(UUID userId, UUID headerId){

        if (!userId.equals(headerId)) {
            throw new IllegalArgumentException("본인만 삭제할 수 있습니다.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        userRepository.delete(user);
    }



}
