package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author liminghao.
 * @date 2021/12/4
 * @time 23:02
 */
@Service
public class AsyncService {

    //告诉Spring只是一个异步的方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理。。。");
    }

}
