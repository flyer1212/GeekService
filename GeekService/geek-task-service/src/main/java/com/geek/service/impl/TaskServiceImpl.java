package com.geek.service.impl;

import com.geek.entity.UserTask;
import com.geek.repository.UserTaskRepository;
import com.geek.service.TaskService;
import common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserTaskRepository taskRepository;

    @Override
    public Response findByUserId(String userId) {
        return new Response(1, "SUCCESS", taskRepository.findByUserId(userId));
    }

    @Override
    public Response getAllTask() {
        return new Response(1, "SUCCESS", taskRepository.findAll());
    }

    @Override
    public Response addTask(UserTask task) {
        return new Response(1, "Success", taskRepository.save(task));
    }
}
