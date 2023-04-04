package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@Service
public class ScheduledService {

    @Autowired
    private UserService userService;

    //在一个特定的时间执行这个方法

    //cron 表达式
    //秒 分 时 日 月 周几

    /**
     * 30 15 10 ** ? 每天10点15分30 执行一次
     * 30 0/5 10,18 * * ? 每天10点和18点，每隔五分钟执行一次
     *
     *
     * 00 0/5
     *
     */
//    @Scheduled(cron = "0/3 * * * * ?")
//    public void hello() {
//        System.out.println("hello,每三秒执行一次");
//    }


//    @Async("myExecutor")
//    @Scheduled(cron = "0/20 * * * * ?")
//    public void test1() {
//        userService.findAllUser();
////        try {
////            Thread.sleep(2000);
////            System.out.println("test1 睡眠2s");
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println("test1 每20秒执行一次");
//    }

//    @Async("myExecutor")
//    @Scheduled(cron = "0/20 * * * * ?")
//    public void test2() {
//        userService.getUserInfo(1);
////        try {
////            Thread.sleep(3000);
////            System.out.println("test2 睡眠3s");
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println("test2 每20秒执行一次");
//    }


}
