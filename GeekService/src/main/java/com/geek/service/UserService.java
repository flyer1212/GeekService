package com.geek.service;

import com.geek.entity.User;

public interface UserService {

    User getUserByName(String userName);
    User getUserByQqNumber(String qqNumber);
    int addUser(User user);
}
