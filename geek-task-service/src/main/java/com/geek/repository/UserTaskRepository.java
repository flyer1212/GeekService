package com.geek.repository;

import com.geek.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, String> {

    @Query("select t from UserTask t where t.userId = :userId")
    List<UserTask> findByUserId(@Param("userId") String userId);

    @Query("select t from UserTask t where t.taskId = :taskId")
    List<UserTask> findByTaskId(@Param("taskId") String taskId);

}
