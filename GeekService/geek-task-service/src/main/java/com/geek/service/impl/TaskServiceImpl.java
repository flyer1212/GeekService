package com.geek.service.impl;

import com.geek.entity.UserTask;
import com.geek.repository.UserTaskRepository;
import com.geek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserTaskRepository taskRepository;

    @Override
    public List<UserTask> findByUserId(String userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public List<UserTask> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public int addTask(UserTask task) {
        return 0;
    }
}
