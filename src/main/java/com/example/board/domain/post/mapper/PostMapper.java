package com.example.board.domain.post.mapper;


import com.example.board.domain.post.dto.response.PostDto;
import com.example.board.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "user.id", target = "userId")
    PostDto toDto(Post post);

    List<PostDto> toDtos(List<Post> posts);
}
