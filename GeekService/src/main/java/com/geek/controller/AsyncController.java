package com.geek.controller;

import com.geek.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/async")
    public String asyncTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();
        // 判断是否完成
        while (true){
            if(task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        return "全部执行完成， 总耗时："+ (end - start) + "毫秒";
    }
}
