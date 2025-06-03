package com.example.board.domain.post.service;


import com.example.board.domain.post.dto.request.PostCreateRequest;
import com.example.board.domain.post.dto.request.PostUpdateRequest;
import com.example.board.domain.post.dto.response.PostDto;
import com.example.board.domain.post.entity.Post;
import com.example.board.domain.post.mapper.PostMapper;
import com.example.board.domain.post.repository.PostRepository;
import com.example.board.domain.user.entity.User;
import com.example.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostDto create(PostCreateRequest request, UUID userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Post post = new Post(request.title(), request.content(), user);
        Post saved = postRepository.save(post);

        return postMapper.toDto(saved);
    }


    public List<PostDto> findAll(){
        List<Post> posts = postRepository.findByIsDeletedFalseOrderByCreatedAtDesc();
        return postMapper.toDtos(posts);
    }

    // 특정 게시물 조회
    public PostDto findById(UUID postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다"));

        return postMapper.toDto(post);
    }

    public PostDto update(UUID userId, UUID postId, PostUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다"));

        if (!post.getUser().getId().equals(userId)){
            throw new IllegalArgumentException("수정 권한이 없습니다");
        }

        post.update(request.title(), request.content());

        Post saved = postRepository.save(post);

        return postMapper.toDto(saved);
    }

    public PostDto softDelete(UUID postId, UUID userId){
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("게시글을 찾을 수 없습니다"));
        if(!post.getUser().getId().equals(userId)){
            throw new IllegalArgumentException("삭제 권한이 없습니다");
        }
        post.softDelete();
        Post deleted = postRepository.save(post);

        return postMapper.toDto(deleted);
    }

    public PostDto hardDelete(UUID postId, UUID userId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다"));
        if(!post.getUser().getId().equals(userId)){
            throw new IllegalArgumentException("삭제 권한이 없습니다");
        }
        postRepository.delete(post);
        return postMapper.toDto(post);
    }

}
