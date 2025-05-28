package com.example.board.domain.user.repository;

import com.example.board.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    // 이메일을 가진 사용자가 존재하는지 여부
    boolean existsByEmail(String email);

    // id가 일치하고 삭제되지 않은 유저
    Optional<User> findByIdAndIsDeletedFalse(UUID id);

    // 삭제되지 않은 모든 유저
    List<User> findAllByIsDeletedFalse();

    // 이메일이 일치되고 삭제되지 않은 유저
    Optional<User> findByEmailAndIsDeletedFalse(String email);

    boolean existsByNickname(String nickname);
}
