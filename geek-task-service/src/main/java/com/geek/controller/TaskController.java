package com.geek.controller;


import com.geek.entity.UserTask;
import com.geek.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping
    public ResponseEntity getAllTask() {
        return ok(taskService.getAllTask());
    }

    @PostMapping
    public ResponseEntity addTask(@RequestBody UserTask userTask) {
        return ok(taskService.addTask(userTask));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity findByTaskId(@PathVariable String taskId) {
        return ok(taskService.findTaskByTaskId(taskId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity findByUserId(@PathVariable String userId) {
        return ok(taskService.findByUserId(userId));
    }
}
