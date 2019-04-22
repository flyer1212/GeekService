package com.geek.service.impl;

import com.geek.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();

    @Async  // 会单独开启一个子线程，异步执行的
    @Override
    public Future<String> doTask1() throws InterruptedException {
        System.out.println("任务一开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一结束，耗时： " + (end- start) +"毫秒");
        return new AsyncResult<>("任务一结束");
    }

    @Async
    @Override
    public Future<String> doTask2() throws InterruptedException {
        System.out.println("任务2开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务2结束，耗时： " + (end- start) +"毫秒");
        return new AsyncResult<>("任务2结束");
    }

    @Async
    @Override
    public Future<String> doTask3() throws InterruptedException {
        System.out.println("任务3开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务3结束，耗时： " + (end- start) +"毫秒");
        return new AsyncResult<>("任务3结束");
    }
}
