package com.example.util.thread.demo01;

/**
 * 基本的卖票例子
 * 真正的多线程开发，公司中的开发
 * 线程就是一个单独的资源类，没有任何附属的操作！
 * 1、属性、方法
 *
 * @author liminghao.
 * @date 2022/7/2
 * @time 22:53
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        // 并发: 多线程操作同一个资源类
        Ticket ticket = new Ticket();

        // 匿名内部类的方式,比较繁琐,不建议使用
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

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
class Ticket {
    // 属性、方法
    private int number = 30;

    // 卖票的方式
    // synchronized 本质: 队列，锁
    public synchronized void sale() {
        while (number > 0) {
            int i = number--;
            System.out.println(Thread.currentThread().getName()+"卖出了第"+i+"张票,剩余:" + number);
        }
    }
}
