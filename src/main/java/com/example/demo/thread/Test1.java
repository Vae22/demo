package com.example.demo.thread;

/**
 * @author liminghao.
 * @date 2022/7/2
 * @time 22:37
 */
public class Test1 {
    public static void main(String[] args) {
        // 获取cpu的核数
        // cpu密集型， IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
