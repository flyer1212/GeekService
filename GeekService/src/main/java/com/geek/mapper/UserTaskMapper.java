package com.geek.mapper;

import com.geek.entity.UserTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTaskMapper {

    List<UserTask> getAllUserTask();
}
