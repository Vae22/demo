package com.example.demo.thread.pc.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock版  生产者、消费者
 * @author liminghao.
 * @date 2022/7/4
 * @time 10:13
 */
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"D").start();
    }
}

// 资源类
class Data2{
    private Integer number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // 生产者
    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await(); // 等待
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产:"+number);
            condition.signalAll(); // 唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 消费者
    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await(); // 等待
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"消费:"+number);
            condition.signalAll(); // 唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
