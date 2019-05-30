package com.geek.service;

import com.geek.entity.UserSignedTask;

import common.util.Response;

public interface SignedTaskService {

    Response getAllSignedTask();

    Response findSignedTaskByUserIdAndTaskId(String userId, String taskId);

    Response findSignedUserByTaskId(String taskId);

    Response addSignedTask(UserSignedTask task);

}
