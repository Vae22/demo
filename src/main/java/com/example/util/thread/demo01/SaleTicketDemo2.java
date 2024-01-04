package com.example.util.thread.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liminghao.
 * @date 2022/7/2
 * @time 23:38
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {

        // 并发: 多线程操作同一个资源类
        Ticket2 ticket = new Ticket2();

        // @FunctionalInterface 函数式接口
        // jdk1.8 lambad表达式 (参数)->{ 代码 }
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"C").start();


    }

}

// 资源类 OOP, 传统的方式是实现 Runnable接口，耦合性太强，不建议使用
class Ticket2 {
    // 属性、方法
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {

        lock.lock(); // 加锁

        try {
            // 业务代码
            if (number > 0) {
                int i = number--;
                System.out.println(Thread.currentThread().getName()+"卖出了第"+i+"张票,剩余:" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 解锁
        }
    }
}
