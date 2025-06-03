package com.example.board.domain.post.service;


import com.example.board.domain.post.dto.request.PostCreateRequest;
import com.example.board.domain.post.dto.response.PostDto;
import com.example.board.domain.post.entity.Post;
import com.example.board.domain.post.mapper.PostMapper;
import com.example.board.domain.post.repository.PostRepository;
import com.example.board.domain.user.entity.User;
import com.example.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostDto Create(PostCreateRequest request, UUID userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Post post = new Post(request.title(), request.content(), user);
        Post saved = postRepository.save(post);

        return postMapper.toDto(saved);
    }


}
