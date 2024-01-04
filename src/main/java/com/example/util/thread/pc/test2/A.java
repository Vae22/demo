package com.example.util.thread.pc.test2;


/**
 * synchronized版 生产者与消费者
 * @author liminghao.
 * @date 2022/7/4
 * @time 9:59
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

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

    }
}

// 资源类
class Data{
    private Integer number = 0;

    // 生产者
    public synchronized void increment() {
        try {
            while (number != 0) {
                this.wait(); // 等待
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "生产:" + number);
            this.notify(); // 唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 消费者
    public synchronized void decrement() {
        try {
            while (number == 0) {
                this.wait(); // 等待
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "消费:" + number);
            this.notify(); // 唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
