package com.geek.repository;

import com.geek.entity.UserCommentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommentRepository extends JpaRepository<UserCommentTask, String> {
}
