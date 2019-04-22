package com.geek.service;

import com.geek.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
    int addTask(Task task);

}
