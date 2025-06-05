package com.example.board.domain.post.controller;


import com.example.board.domain.post.dto.request.PostCreateRequest;
import com.example.board.domain.post.dto.request.PostUpdateRequest;
import com.example.board.domain.post.dto.response.PostDto;
import com.example.board.domain.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> create (
            @RequestBody @Valid PostCreateRequest request,
            @RequestHeader("header-id") UUID userId){
        log.info("글 생성 요청: title={}, content={}", request.title(), request.content());

        PostDto created = postService.create(request, userId);
        return ResponseEntity.ok(created);
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        log.info("글 목록 요청: ");
        List<PostDto> posts = postService.findAll();
        return ResponseEntity.ok(posts);

    }


    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> findById(@PathVariable UUID postId){
        log.info("글 상세 조회 요청: postId={}", postId);
        PostDto post = postService.findById(postId);
        return ResponseEntity.ok(post);
    }


    @PatchMapping("/{postId}")
    public ResponseEntity<PostDto> update(@RequestBody @Valid PostUpdateRequest request,
                                          @RequestHeader("header-id") UUID userId,
                                          @PathVariable UUID postId){
        log.info("글 수정 요청: title={}, content={}", request.title(), request.content());
        PostDto update = postService.update(userId, postId, request);
        return ResponseEntity.ok(update);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDto> softDelete(@PathVariable UUID postId,
                                              @RequestHeader("header-id") UUID userId){
        log.info("글 논리 삭제 요청");
        PostDto delete = postService.softDelete(postId, userId);
        return ResponseEntity.ok(delete);
    }


    @DeleteMapping("/{postId}/hard")
    public ResponseEntity<PostDto> hardDelete(@PathVariable UUID postId,
                                              @RequestHeader("header-id") UUID userId){
        log.info("글 물리 삭제 요청");
        PostDto delete = postService.hardDelete(postId, userId);
        return ResponseEntity.ok(delete);
    }

}
