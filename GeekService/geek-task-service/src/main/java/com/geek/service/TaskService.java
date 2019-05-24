package com.geek.service;



import com.geek.entity.UserTask;
import common.util.Response;

public interface TaskService {

    Response findByUserId(String userId);

    Response getAllTask();

    Response addTask(UserTask task);

    Response findTaskByTaskId(String taskId);

}
