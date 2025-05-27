package com.example.board.domain.user.mapper;

import com.example.board.domain.user.dto.response.UserDto;
import com.example.board.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDtos(List<User> users);
}
