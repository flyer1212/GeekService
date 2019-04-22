package com.geek.service.impl;

import com.geek.entity.User;
import com.geek.mapper.UserMapper;
import com.geek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String  userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public User getUserByQqNumber(String qqNumber) {
        return userMapper.getUserByQqNumber(qqNumber);
    }

    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }
}
