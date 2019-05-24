package com.geek.service.impl;

import com.geek.entity.UserSignedTask;
import com.geek.repository.UserSignedRepository;
import com.geek.service.SignedTaskService;
import common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignedTaskServiceImpl implements SignedTaskService {


    @Autowired
    private UserSignedRepository userSignedRepository;

    @Override
    public Response getAllSignedTask() {
        return new Response(1, "SUCCESS", userSignedRepository.findAll());
    }

    @Override
    public Response findSignedTaskByUserIdAndTaskId(String userId, String taskId) {
        UserSignedTask userSignedTask = userSignedRepository.findSignedByUserAndTaskId(userId, taskId);
        // 甚至一个taskId 的人数
        if (userSignedTask == null) {
            userSignedTask = new UserSignedTask();
            userSignedTask.setSignedPeopleNum(userSignedRepository.countSignedTaskByTaskId(taskId));
            return new Response(0, "Not Signed In", userSignedTask);
        }
        userSignedTask.setSignedPeopleNum(userSignedRepository.countSignedTaskByTaskId(taskId));
        return new Response(1, "Success", userSignedTask);
    }

    @Override
    public Response addSignedTask(UserSignedTask task) {
        return new Response(1, "Success", userSignedRepository.save(task));
    }


}
