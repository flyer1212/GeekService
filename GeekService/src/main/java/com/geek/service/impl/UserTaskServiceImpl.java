package com.geek.service.impl;

import com.geek.entity.UserTask;
import com.geek.mapper.UserTaskMapper;
import com.geek.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    UserTaskMapper userTaskMapper;

    @Override
    public List<UserTask> getAllUserTask() {
        return userTaskMapper.getAllUserTask();
    }
}
