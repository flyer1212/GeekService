package com.geek.mapper;

import com.geek.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> getAllTask();
    int addTask(Task task);
}
