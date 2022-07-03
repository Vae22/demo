package com.example.demo.thread.pc;

import io.swagger.models.auth.In;

/**
 * Synchronized版 生产者、消费者
 * @author liminghao.
 * @date 2022/7/3
 * @time 20:37
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment(); // 生产
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement(); // 消费
            }
        },"B").start();

    }
}


// 资源类 控制等待、唤醒操作
class Data{
    private Integer number = 0; // 总数量

    public synchronized void increment() {
        try {
            if (number != 0) {
                this.wait(); // 等待
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产:"+number);
            // 唤醒
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void decrement() {
        try {
            if (number == 0) {
                this.wait(); // 等待
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"消费:"+number);
            // 唤醒
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
