package com.geek.service;



import com.geek.entity.UserTask;
import common.util.Response;
import org.apache.catalina.User;

import java.util.List;

public interface TaskService {

    Response findByUserId(String userId);

    Response getAllTask();

    Response addTask(UserTask task);

}
