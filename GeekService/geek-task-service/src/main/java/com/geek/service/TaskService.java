package com.geek.service;



import com.geek.entity.UserTask;
import org.apache.catalina.User;

import java.util.List;

public interface TaskService {

    List<UserTask> findByUserId(String userId);

    List<UserTask> getAllTask();
    int addTask(UserTask task);

}
