package com.geek.mapper;

import com.geek.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByName(String name);
    User getUserByQqNumber(String qqNumber);
    int addUser(User user);
}
