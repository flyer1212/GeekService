package com.geek.controller;

import com.geek.entity.ResponseResult;
import com.geek.entity.Task;
import com.geek.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api("Task controller")
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/test")
    @CrossOrigin(origins = "*")
    public void testTask() {
        System.out.println("goods=-----");
    }

    @ApiOperation("查询所有Task")
    @GetMapping(value = "/tasks")
    public ResponseResult<Task> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        ResponseResult<Task> taskResponse =
                new ResponseResult<>(true, "success", tasks);
        System.out.println(tasks.size() +"------size大小");
        return taskResponse;
    }

    @ApiOperation("添加task")
    @PostMapping(value = "/addTask")
    public ResponseResult<Task> addTask(@RequestBody Task task, HttpServletResponse response){
        System.out.println(task.toString() + "--------");
        int result = taskService.addTask(task);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        ResponseResult<Task> responseResult
                = new ResponseResult<>(true,"插入结果为：" +result, tasks);
        return responseResult;
    }
}
