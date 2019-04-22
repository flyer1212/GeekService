package com.geek.service.impl;

import com.geek.entity.Task;
import com.geek.mapper.TaskMapper;
import com.geek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> getAllTask() {
        return taskMapper.getAllTask();
    }

    @Override
    public int addTask(Task task) {
        return taskMapper.addTask(task);
    }
}
