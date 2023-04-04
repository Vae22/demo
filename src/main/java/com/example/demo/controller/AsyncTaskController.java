//package com.example.demo.controller;
//
//import java.util.concurrent.Future;
//
//import com.example.demo.common.Result;
//import com.example.demo.task.AsyncTask;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//public class AsyncTaskController {
//
//    @Autowired
//    private AsyncTask task;
//
//    @GetMapping("async_task")
//    public Result<?> exeTask() throws InterruptedException{
//
//        long begin = System.currentTimeMillis();
////异步任务
////		task.task1();
////		task.task2();
////		task.task3();
//
////异步任务，有返回结果
//        Future<String> task4 = task.task4();
//        Future<String> task5 = task.task5();
//        Future<String> task6 = task.task6();
////无限循环，效率比while(true)快，因为while(true)每次循环要判断循环条件
//        for(;;){
//            if (task4.isDone() && task5.isDone() && task6.isDone()) {
//                break;
//            }
//        }
//
//        long end = System.currentTimeMillis();
//
//        long total = end-begin;
//        System.out.println("执行总耗时="+total);
//        return Result.success(total);
//    }
//}
