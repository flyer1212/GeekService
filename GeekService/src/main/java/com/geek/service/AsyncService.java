package com.geek.service;

import java.util.concurrent.Future;

public interface AsyncService {
    Future<String> doTask1() throws InterruptedException;
    Future<String> doTask2() throws InterruptedException;
    Future<String> doTask3() throws InterruptedException;
}
