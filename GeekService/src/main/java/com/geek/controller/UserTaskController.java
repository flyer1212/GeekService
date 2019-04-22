package com.geek.controller;

import com.geek.entity.ResponseResult;
import com.geek.entity.UserTask;
import com.geek.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usertask")
public class UserTaskController {

    @Autowired
    UserTaskService userTaskService;

    @GetMapping("/test")
    public void testUserTask(){
        System.out.println("goods=-----");
    }

    @GetMapping(value = "/all")
    public ResponseResult<UserTask> getAllUserTask() {
        List<UserTask> userTasks = userTaskService.getAllUserTask();
        ResponseResult<UserTask> taskResponse =
                new ResponseResult<>(true, "success", userTasks);
        return taskResponse;
    }

}
