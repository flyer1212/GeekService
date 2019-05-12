package com.geek.controller;

import com.geek.entity.UserTask;
import com.geek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/hello")
    public List<UserTask> hello() {
        return taskService.getAllTask();
    }

    @GetMapping("/{userId}")
    public List<UserTask> findByUserId(@PathVariable String userId) {
        return taskService.findByUserId(userId);
    }


}
