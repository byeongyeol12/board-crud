package com.example.board.domain.comment.entity;

import com.example.board.domain.base.BaseUpdatableEntity;
import com.example.board.domain.post.entity.Post;
import com.example.board.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseUpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;


    public Comment(User user, Post post, String content){
        this.user = user;
        this.post = post;
        this.content = content;
    }

    public void updateContent(String content){
        this.content = content;
    }

    public void softDelete(){
        this.isDeleted = true;
    }

    public UUID getPostId(){
        return this.post.getId();
    }

}
