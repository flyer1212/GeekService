package com.geek.service.impl;


import com.geek.Dto.User;
import com.geek.Dto.UserSignedInfo;
import com.geek.entity.UserSignedTask;
import com.geek.repository.UserSignedRepository;
import com.geek.service.SignedTaskService;
import common.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Service
@Slf4j
public class SignedTaskServiceImpl implements SignedTaskService {


    final String USER_INFO_SERVICE = "http://geek-user-service:18001/user/ids";


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

    /**
     * 查询所有报名某一个task 的消息
     *
     * @param taskId
     * @return
     */
    @Override
    public Response findSignedUserByTaskId(String taskId) {
        List<UserSignedTask> userSignedTasks = userSignedRepository.findSignedByTaskId(taskId);
        // 通过userId 查询 user name sex special phone
        List<String> userIds = userSignedTasks.stream().map(u -> u.getUserId()).collect(Collectors.toList());
        log.info("UerId size : " + userIds.size() + userIds.toString());

        List<User> users = getsignedUserInfo(userIds);
        log.info("USER INFO  : " + users.toString());
        // 保存所有已经报名人的消息
        List<UserSignedInfo> signedInfos = new ArrayList<>();
        for (int i = 0; i < userSignedTasks.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (userSignedTasks.get(i).getUserId().equals(users.get(j).getUserId())) {
                    signedInfos.add(new UserSignedInfo(userSignedTasks.get(i).getSubmitTime(),
                            users.get(j).getUserName(), users.get(j).getSex(), users.get(j).getMajor(),
                            users.get(j).getQqNumber(), userSignedTasks.get(i).getReason()));
                }
            }
        }
        return new Response(1, "Success", signedInfos);
    }

    @Override
    public Response addSignedTask(UserSignedTask task) {
        return new Response(1, "Success", userSignedRepository.save(task));
    }


    private List<User> getsignedUserInfo(List<String> userIds) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(userIds, httpHeaders);
        ResponseEntity<Response<List<User>>> signedUserInfo = restTemplate.exchange(
                USER_INFO_SERVICE,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Response<List<User>>>() {
                });
        return signedUserInfo.getBody().getData();
    }

}
