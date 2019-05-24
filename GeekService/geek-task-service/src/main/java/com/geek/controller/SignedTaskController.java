package com.geek.controller;


import com.geek.entity.UserSignedTask;
import com.geek.service.SignedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/signtask")
public class SignedTaskController {


    @Autowired
    SignedTaskService signedTaskService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping
    public ResponseEntity addSignedTask(@RequestBody UserSignedTask userSignedTask) {
        return ok(signedTaskService.addSignedTask(userSignedTask));
    }

    @GetMapping("/{userId}/{taskId}")
    public ResponseEntity findSignedTaskByTaskAndUserId(@PathVariable String userId,@PathVariable String taskId) {
        return ok(signedTaskService.findSignedTaskByUserIdAndTaskId(userId,taskId));
    }

}
