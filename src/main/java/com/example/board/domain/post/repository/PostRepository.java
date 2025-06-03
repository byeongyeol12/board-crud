package com.example.board.domain.post.repository;

import com.example.board.domain.post.entity.Post;
import com.example.board.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByIsDeletedFalseOrderByCreatedAtDesc();


    UUID user(User user);
}
