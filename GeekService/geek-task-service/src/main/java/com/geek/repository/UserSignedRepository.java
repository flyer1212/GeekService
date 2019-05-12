package com.geek.repository;

import com.geek.entity.UserSignedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSignedRepository extends JpaRepository<UserSignedTask, String> {
}
