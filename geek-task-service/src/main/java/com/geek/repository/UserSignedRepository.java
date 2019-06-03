package com.geek.repository;

import com.geek.entity.UserSignedTask;
import com.geek.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户报名
 */
@Repository
public interface UserSignedRepository extends JpaRepository<UserSignedTask, String> {


    // 用户已经报名的
    @Query("select t from UserSignedTask t where t.userId = :userId and t.taskId = :taskId")
    UserSignedTask findSignedByUserAndTaskId(@Param("userId") String userId, @Param("taskId") String taskId);


    // 统计某一个任务报名的人数
    @Query("select count(t) from UserSignedTask t where t.taskId = :taskId")
    Integer countSignedTaskByTaskId(@Param("taskId") String taskId);


    // 查询某个用户报名的所有任务
    @Query("select t from UserSignedTask t where t.userId = :userId")
    List<UserSignedTask> findSignedByUserId(@Param("userId") String userId);

    // 查询一个任务报名的所有人的信息
    @Query("select t from UserSignedTask t where t.taskId = :taskId")
    List<UserSignedTask> findSignedByTaskId(@Param("taskId") String taskId);

}
