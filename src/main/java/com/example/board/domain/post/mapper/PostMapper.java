package com.example.board.domain.post.mapper;


import com.example.board.domain.post.dto.response.PostDto;
import com.example.board.domain.post.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto toDto(Post post);

    List<PostDto> toDtos(List<Post> posts);
}
