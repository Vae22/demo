package com.example.demo.thread.unsafe;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liminghao.
 * @date 2022/7/3
 * @time 22:55
 */
public class ListTest {
    public static void main(String[] args) {

        // 一般方法，用集合工具类把 ArrayList 转换成线程安全的类
//        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // 写入时复制
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
